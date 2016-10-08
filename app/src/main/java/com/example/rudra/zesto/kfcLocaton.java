package com.example.rudra.zesto;

import android.Manifest;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.os.Build;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.AbsListView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

import java.io.IOException;
import java.util.List;


public class kfcLocaton extends FragmentActivity {
    private GoogleMap mMap;
    private Marker customMarker;
    private LatLng Indiranager;
    private LatLng Egipura;
    private LatLng Thobarhalli;
    private LatLng Ecity;
    private LatLng minak;
    private LatLng HSR;
    private LatLng BTM;
    private LatLng Jpnagar;
    private LatLng Bom;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kfc_locaton);

        Indiranager = new LatLng(12.978464, 77.640696);
        Egipura = new LatLng(12.936915, 77.640726);
        Thobarhalli = new LatLng(12.956629,77.704682);
        Ecity = new LatLng(12.849848,77.654486);
        minak =  new LatLng(12.878925,77.595588);
        HSR =  new LatLng(12.910914,77.638074);
        BTM =  new LatLng(12.921099,77.620238);
        Jpnagar =  new LatLng(12.915482,77.585901);
        Bom =  new LatLng(12.823746,77.685215);


        setUpMapIfNeeded();
    }

    private void setUpMapIfNeeded() {
        // Do a null check to confirm that we have not already instantiated the
        // map.
        if (mMap == null) {
            // Try to obtain the map from the SupportMapFragment.
            mMap = ((SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map)).getMap();
            // Check if we were successful in obtaining the map.
            if (mMap != null) {
                setUpMap();
            }
        }
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            return;
        }
        mMap.setMyLocationEnabled(true);
    }

    private void setUpMap() {

        View marker = ((LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE)).inflate(R.layout.custom_marker, null);

        //numTxt.setText("27");

        customMarker = mMap.addMarker(new MarkerOptions()
                .position(Indiranager)
                .title("KFC")
                .snippet("#1/1A, CMH Road,Stage 1, Indiranager, Bangalore-38")
                .icon(BitmapDescriptorFactory.fromBitmap(createDrawableFromView(this, marker))));

        customMarker = mMap.addMarker(new MarkerOptions()
                .position(Egipura)
                .title("KFC")
                .snippet("#13, Intermediate Ring Road ,Koramangala, Bangalore-95")
                .icon(BitmapDescriptorFactory.fromBitmap(createDrawableFromView(this, marker))));

        customMarker = mMap.addMarker(new MarkerOptions()
                .position(Thobarhalli)
                .title("KFC")
                .snippet("#6, Near Kundalahalli Gate ,Arthur Hobli, Bangalore-37")
                .icon(BitmapDescriptorFactory.fromBitmap(createDrawableFromView(this, marker))));

        customMarker = mMap.addMarker(new MarkerOptions()
                .position(Ecity)
                .title("KFC")
                .snippet("#56, Opp to Wipro gate 5 Electronics City Phase -1, Bangalore-00")
                .icon(BitmapDescriptorFactory.fromBitmap(createDrawableFromView(this, marker))));

        customMarker = mMap.addMarker(new MarkerOptions()
                .position(minak)
                .title("KFC")
                .snippet("Royal Meenakshi Mall,Bannerghatta Main Road, Hulimavu, Bengaluru")
                .icon(BitmapDescriptorFactory.fromBitmap(createDrawableFromView(this, marker))));

        customMarker = mMap.addMarker(new MarkerOptions()
                .position(HSR)
                .title("KFC")
                .snippet("#30, HSR Layout, Sector 4, , Bangalore-60")
                .icon(BitmapDescriptorFactory.fromBitmap(createDrawableFromView(this, marker))));

        customMarker = mMap.addMarker(new MarkerOptions()
                .position(BTM)
                .title("KFC")
                .snippet("#15,Commercial Plaza Market Square Mall,Madiwala, Bangalore")
                .icon(BitmapDescriptorFactory.fromBitmap(createDrawableFromView(this, marker))));

        customMarker = mMap.addMarker(new MarkerOptions()
                .position(Jpnagar)
                .title("KFC")
                .snippet("#948,2nd Phase,J P Nagar, Bangalore")
                .icon(BitmapDescriptorFactory.fromBitmap(createDrawableFromView(this, marker))));

        customMarker = mMap.addMarker(new MarkerOptions()
                .position(Bom)
                .title("KFC")
                .snippet("Bommasandra,Opp. SKF India, Bangalore")
                .icon(BitmapDescriptorFactory.fromBitmap(createDrawableFromView(this, marker))));


        final View mapView = getSupportFragmentManager().findFragmentById(R.id.map).getView();
        if (mapView.getViewTreeObserver().isAlive()) {
            mapView.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
                @SuppressLint("NewApi")
                // We check which build version we are using.
                @Override
                public void onGlobalLayout() {
                    LatLngBounds bounds = new LatLngBounds.Builder().include(Bom).build();
                    if (Build.VERSION.SDK_INT < Build.VERSION_CODES.JELLY_BEAN) {
                        mapView.getViewTreeObserver().removeGlobalOnLayoutListener(this);
                    } else {
                        mapView.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                    }
                    mMap.moveCamera(CameraUpdateFactory.newLatLngBounds(bounds, 50));
                }
            });
        }
    }

    // Convert a view to bitmap
    public static Bitmap createDrawableFromView(Context context, View view) {
        DisplayMetrics displayMetrics = new DisplayMetrics();
        ((Activity) context).getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        view.setLayoutParams(new AbsListView.LayoutParams(AbsListView.LayoutParams.WRAP_CONTENT, AbsListView.LayoutParams.WRAP_CONTENT));
        view.measure(displayMetrics.widthPixels, displayMetrics.heightPixels);
        view.layout(0, 0, displayMetrics.widthPixels, displayMetrics.heightPixels);
        view.buildDrawingCache();
        Bitmap bitmap = Bitmap.createBitmap(view.getMeasuredWidth(), view.getMeasuredHeight(), Bitmap.Config.ARGB_8888);

        Canvas canvas = new Canvas(bitmap);
        view.draw(canvas);

        return bitmap;
    }
}