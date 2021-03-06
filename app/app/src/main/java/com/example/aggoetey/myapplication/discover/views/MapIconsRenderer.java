package com.example.aggoetey.myapplication.discover.views;

import android.content.Context;
import android.graphics.Color;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.maps.android.clustering.ClusterManager;
import com.google.maps.android.clustering.view.DefaultClusterRenderer;

import com.example.aggoetey.myapplication.R;
import com.example.aggoetey.myapplication.discover.wrappers.RestaurantMapItem;


/**
 * Class to render custom markers on map instead of the default ones
 */
public class MapIconsRenderer extends DefaultClusterRenderer<RestaurantMapItem> {

    private static final int ICON_COLOR = Color.rgb(211, 47, 47);

    public MapIconsRenderer(Context context, GoogleMap map, ClusterManager<RestaurantMapItem> clusterManager) {
        super(context, map, clusterManager);
    }

    @Override
    protected void onBeforeClusterItemRendered(RestaurantMapItem item, MarkerOptions markerOptions) {
        markerOptions.icon(BitmapDescriptorFactory.fromResource(R.drawable.pin));
        markerOptions.snippet(item.getSnippet());
        markerOptions.title(item.getTitle());
        super.onBeforeClusterItemRendered(item, markerOptions);
    }

    @Override
    protected int getColor(int clusterSize) {
        return ICON_COLOR;
    }



}
