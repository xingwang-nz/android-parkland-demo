package nz.co.guru.services.parkland.search;

import nz.co.guru.services.parkland.R;
import nz.co.guru.services.parkland.model.CatalogGroup;
import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class CatalogGroupSpinnerAdapter extends ArrayAdapter<CatalogGroup> {

    private Context context;

    // Your custom values for the spinner (User)
    private CatalogGroup[] catalogGroups;

    private LayoutInflater inflater;

    public CatalogGroupSpinnerAdapter(final Context context, final LayoutInflater inflater, final int textViewResourceId, final CatalogGroup[] catalogGroups) {
        super(context, textViewResourceId, catalogGroups);
        this.context = context;
        this.inflater = inflater;
        this.catalogGroups = catalogGroups;
    }

    @Override
    public CatalogGroup getItem(final int position) {
        return catalogGroups[position];
    }

    @Override
    public long getItemId(final int position) {
        return position;
    }

    @Override
    public int getCount() {
        return catalogGroups.length;
    }

    public View getCustomView(final int position, final View convertView, final ViewGroup parent) {
        // Inflating the layout for the custom Spinner
        final View layout = inflater.inflate(R.layout.spinner_catalog_group, parent, false);

        final TextView groupName = (TextView) layout.findViewById(R.id.catalogGroupNameField);
        groupName.setText(catalogGroups[position].getName());

        // Setting the color of the text
        groupName.setTextColor(Color.rgb(75, 180, 225));

        final ImageView img = (ImageView) layout.findViewById(R.id.catalogGroupImage);

        if (position > 0) {
            img.setImageDrawable(context.getResources().getDrawable(catalogGroups[position].getImageResourceId()));
        }
        else {
            img.setVisibility(View.GONE);
        }

        return layout;

    }

    @Override
    public View getDropDownView(final int position, final View convertView, final ViewGroup parent) {
        return getCustomView(position, convertView, parent);
    }

    // It gets a View that displays the data at the specified position
    @Override
    public View getView(final int position, final View convertView, final ViewGroup parent) {
        return getCustomView(position, convertView, parent);
    }
}
