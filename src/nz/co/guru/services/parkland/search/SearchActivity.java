package nz.co.guru.services.parkland.search;

import java.util.Collections;
import java.util.List;

import nz.co.guru.services.parkland.OrderCartActivity;
import nz.co.guru.services.parkland.ProductDetailsActivity;
import nz.co.guru.services.parkland.ProductListListAdapter;
import nz.co.guru.services.parkland.ProductOrderManager;
import nz.co.guru.services.parkland.R;
import nz.co.guru.services.parkland.model.CatalogGroup;
import nz.co.guru.services.parkland.model.ProductItem;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;
import android.widget.Toast;

public class SearchActivity extends Activity implements OnEditorActionListener {

    private Button filterButton;

    private CatalogGroup selectedCatalogGroup;

    private ProductFieldFilter productFieldFilter = ProductFieldFilter.ALL;

    /**
     * product field filter
     */
    private AlertDialog filterDialog;

    private EditText searchView;

    private ListView searchResultListView;

    private ProductListListAdapter productListAdapter;

    private Button viewOrderButton;

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.search);

        // final ActionBar actionBar = getActionBar();
        // actionBar.setHomeButtonEnabled(true);

        // build catalog group dropdownlist to replace default action bar view
        final int titleId = Resources.getSystem().getIdentifier("action_bar_title", "id", "android");
        final View titleView = findViewById(titleId);

        // attach listener to this spinnerView for handling spinner selection change
        final Spinner spinnerView = initCatalogGroupSpinner();

        // replace actionbar title view with spinner view
        ViewGroupUtils.replaceView(titleView, spinnerView);

        buildFilterDailog();

        // build filter button
        filterButton = (Button) findViewById(R.id.searchFilterButton);
        filterButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(final View v) {
                filterDialog.show();
            }
        });

        searchView = (EditText) findViewById(R.id.productSearchText);

        searchView.addTextChangedListener(new TextWatcher() {

            @Override
            public void onTextChanged(final CharSequence s, final int start, final int before, final int count) {
            }

            @Override
            public void beforeTextChanged(final CharSequence s, final int start, final int count, final int after) {
            }

            @Override
            public void afterTextChanged(final Editable s) {
                performSearch();
            }
        });

        searchResultListView = (ListView) findViewById(R.id.searchResultListView);
        searchResultListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(final AdapterView<?> parent, final View view, final int position, final long id) {

                final ProductItem productItem = (ProductItem) searchResultListView.getItemAtPosition(position);

                final Intent productDetailsIntent = new Intent(getBaseContext(), ProductDetailsActivity.class);
                productDetailsIntent.putExtra(ProductOrderManager.SELECTED_PRODUCT_ITEM, productItem);
                startActivity(productDetailsIntent);
            }

        });

        viewOrderButton = (Button) findViewById(R.id.viewOrderButton);
        viewOrderButton.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(final View v) {
                viewOrders();
            }
        });

        searchView.setText("");
        performSearch();

        notifyOrdersChange();
    }

    private void viewOrders() {

        if (ProductOrderManager.hasOrders()) {
            final Intent intent = new Intent(getBaseContext(), OrderCartActivity.class);
            startActivityForResult(intent, PLACE_ORDER_REQ);
        }
        else {
            Toast.makeText(this, "Please select and add product to the order first.", Toast.LENGTH_LONG).show();
        }
    }

    private static final int PLACE_ORDER_REQ = 0;

    @Override
    public void onActivityResult(final int requestCode, final int resultCode, final Intent data) {
        if (requestCode == PLACE_ORDER_REQ) {
            if (resultCode == RESULT_OK) {
                Toast.makeText(getBaseContext(), data.getData().toString(), Toast.LENGTH_SHORT).show();
                // orders have been submited, reset all products
                ProductOrderManager.clearOrders();
                notifyOrdersChange();
            }

        }
    }

    private void performSearch() {
        final String searchText = searchView.getText().toString();

        final List<ProductItem> result = searchText != null || searchText.length() > 0 ? ProductOrderManager.searchProduct(selectedCatalogGroup,
                productFieldFilter, searchText) : Collections.<ProductItem> emptyList();
        productListAdapter = new ProductListListAdapter(this, result, getLayoutInflater());
        searchResultListView.setAdapter(productListAdapter);
        productListAdapter.notifyDataSetChanged();

    }

    @Override
    public void onRestart() {
        super.onRestart();
        notifyOrdersChange();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        notifyOrdersChange();
    }

    private void notifyOrdersChange() {
        viewOrderButton.setEnabled(ProductOrderManager.hasOrders());
        if (productListAdapter != null) {
            productListAdapter.notifyDataSetChanged();
        }

    }

    @Override
    public boolean onEditorAction(final TextView v, final int actionId, final KeyEvent event) {
        return false;
    }

    @Override
    public void onBackPressed() {
        setResult(Activity.RESULT_CANCELED);
        finish();
    }

    private void buildFilterDailog() {
        final AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Select a product field as filter");

        final ProductFieldFilter[] filterFields = ProductFieldFilter.values();
        final String[] fields = new String[filterFields.length];

        for (int i = 0; i < filterFields.length; i++) {
            fields[i] = filterFields[i].toString();
        }

        builder.setSingleChoiceItems(fields, -1, new DialogInterface.OnClickListener() {

            @Override
            public void onClick(final DialogInterface dialog, final int which) {
                productFieldFilter = filterFields[which];
                filterDialog.hide();
                searchView.setHint(productFieldFilter.toString());
                performSearch();
            }
        });

        filterDialog = builder.create();
    }

    /**
     * create a dropdown list to display in action bar
     */
    private Spinner initCatalogGroupSpinner() {
        final List<CatalogGroup> catalogGroupList = ProductOrderManager.getCatalogGroups();

        final CatalogGroup[] groups = new CatalogGroup[catalogGroupList.size() + 1];
        final CatalogGroup first = new CatalogGroup(-1, "All Brands", -1);

        groups[0] = first;
        for (int i = 0; i < catalogGroupList.size(); i++) {
            groups[i + 1] = catalogGroupList.get(i);
        }

        final Context context = getApplicationContext();

        final Spinner catalogGroupSpinner = new Spinner(context);

        catalogGroupSpinner.setAdapter(new CatalogGroupSpinnerAdapter(context, getLayoutInflater(), android.R.layout.simple_spinner_item, groups));

        catalogGroupSpinner.setOnItemSelectedListener(new OnItemSelectedListener() {

            @Override
            public void onItemSelected(final AdapterView<?> parent, final View view, final int position, final long id) {
                selectedCatalogGroup = groups[position];
                performSearch();
            }

            @Override
            public void onNothingSelected(final AdapterView<?> parent) {
            }
        });

        return catalogGroupSpinner;
    }

}
