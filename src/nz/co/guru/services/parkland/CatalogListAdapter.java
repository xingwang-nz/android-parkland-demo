package nz.co.guru.services.parkland;

import java.util.List;

import nz.co.guru.services.parkland.model.CatalogGroup;
import nz.co.guru.services.parkland.model.ProductItem;
import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class CatalogListAdapter extends BaseExpandableListAdapter {

    private final Context context;

    private final List<CatalogGroup> groups;

    public CatalogListAdapter(final Context context, final List<CatalogGroup> groups) {
        this.context = context;
        this.groups = groups;
    }

    @Override
    public int getGroupCount() {
        return groups.size();
    }

    @Override
    public int getChildrenCount(final int groupPosition) {
        return groups.get(groupPosition).getProducts().size();
    }

    @Override
    public Object getGroup(final int groupPosition) {
        return groups.get(groupPosition);
    }

    @Override
    public Object getChild(final int groupPosition, final int childPosition) {
        return groups.get(groupPosition).getProducts().get(childPosition);
    }

    @Override
    public long getGroupId(final int groupPosition) {
        return groupPosition;
    }

    @Override
    public long getChildId(final int groupPosition, final int childPosition) {
        return ((ProductItem) this.getChild(groupPosition, childPosition)).getId();
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    @Override
    public View getGroupView(final int groupPosition, final boolean isExpanded, View convertView, final ViewGroup parent) {

        if (convertView == null) {
            final LayoutInflater infalInflater = (LayoutInflater) this.context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = infalInflater.inflate(R.layout.list_catalog_group, null);
        }

        final CatalogGroup catalogGroup = (CatalogGroup) getGroup(groupPosition);

        final ImageView imageView = (ImageView) convertView.findViewById(R.id.catalogGroupImage);
        imageView.setImageDrawable(context.getResources().getDrawable(catalogGroup.getImageResourceId()));

        final TextView catalogNameField = (TextView) convertView.findViewById(R.id.catalogGroupNameField);
        catalogNameField.setText(catalogGroup.getName());

        // final ImageView expandIcon = (ImageView) convertView.findViewById(R.id.expandCollapseImage);
        // expandIcon.setImageResource(R.drawable.collapse);
        // expandIcon.setTag(R.drawable.collapse);

        return convertView;
    }

    @Override
    public View getChildView(final int groupPosition, final int childPosition, final boolean isLastChild, View convertView, final ViewGroup parent) {
        final ProductItem productItem = (ProductItem) getChild(groupPosition, childPosition);

        if (convertView == null) {
            final LayoutInflater infalInflater = (LayoutInflater) this.context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = infalInflater.inflate(R.layout.list_catalog_item, null);
        }

        final TextView productNameView = (TextView) convertView.findViewById(R.id.catalogItemName);
        productNameView.setText(productItem.getDescription());

        final TextView catalogItemOtherInfo = (TextView) convertView.findViewById(R.id.catalogItemOtherInfo);
        catalogItemOtherInfo.setText(productItem.getProductItemOtherInfo());

        if (productItem.isSpecial()) {
            final int color = Color.parseColor("#ff4500");
            // productNameView.setTextColor(color);
            // catalogItemOtherInfo.setTextColor(color);
        }

        final TextView catalogItemCounts = (TextView) convertView.findViewById(R.id.catalogItemCounts);

        if (productItem.getQuantity() > 0) {
            catalogItemCounts.setText(String.valueOf(productItem.getQuantity()));
        }
        else {
            catalogItemCounts.setText("");
        }

        return convertView;
    }

    @Override
    public boolean isChildSelectable(final int groupPosition, final int childPosition) {
        return true;
    }

}
