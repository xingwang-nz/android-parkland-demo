package nz.co.guru.services.parkland.search;

import android.view.View;
import android.view.ViewGroup;

public class ViewGroupUtils {

    public static ViewGroup getParent(final View view) {
        return (ViewGroup) view.getParent();
    }

    public static void removeView(final View view) {
        final ViewGroup parent = getParent(view);
        if (parent != null) {
            parent.removeView(view);
        }
    }

    public static void replaceView(final View currentView, final View newView) {
        final ViewGroup parent = getParent(currentView);
        if (parent == null) {
            return;
        }
        final int index = parent.indexOfChild(currentView);
        removeView(currentView);
        removeView(newView);
        parent.addView(newView, index);
    }
}
