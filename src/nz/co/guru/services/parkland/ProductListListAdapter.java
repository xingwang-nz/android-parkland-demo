package nz.co.guru.services.parkland;

import java.util.List;

import nz.co.guru.services.parkland.model.ProductItem;
import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class ProductListListAdapter extends BaseAdapter {

    private final Activity parentActivity;

    private final List<ProductItem> products;

    private final LayoutInflater inflater;

    public ProductListListAdapter(final Activity parentActivity, final List<ProductItem> orderCart, final LayoutInflater inflater) {
        this.parentActivity = parentActivity;
        this.products = orderCart;
        this.inflater = inflater;
    }

    @Override
    public int getCount() {
        return products == null ? 0 : products.size();
    }

    @Override
    public Object getItem(final int position) {
        return products.get(position);
    }

    @Override
    public long getItemId(final int position) {
        return position;
    }

    @Override
    public View getView(final int position, View convertView, final ViewGroup parent) {
        if (convertView == null) {
            convertView = inflater.inflate(R.layout.list_catalog_item, null);
        }

        final ProductItem productItem = (ProductItem) getItem(position);

        final TextView productDescriptionView = (TextView) convertView.findViewById(R.id.catalogItemName);
        productDescriptionView.setText(productItem.getDescription());

        final TextView catalogItemOtherInfo = (TextView) convertView.findViewById(R.id.catalogItemOtherInfo);
        catalogItemOtherInfo.setText(productItem.getProductItemOtherInfo());

        final TextView catalogItemCounts = (TextView) convertView.findViewById(R.id.catalogItemCounts);

        if (productItem.getQuantity() > 0) {
            catalogItemCounts.setText(String.valueOf(productItem.getQuantity()));
        }
        else {
            catalogItemCounts.setText("");
        }

        return convertView;
    }
}
