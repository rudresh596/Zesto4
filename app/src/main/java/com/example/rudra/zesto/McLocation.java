package com.example.rudra.zesto;

import android.Manifest;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.os.Build;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.AbsListView;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

public class McLocation extends AppCompatActivity {

    private GoogleMap mMap;
    private Marker mcdmarker;
    private LatLng KRLayout;
    private LatLng Jayanagar;
    private LatLng HSR;
    private LatLng Koramangala;
    private LatLng JNC;
    private LatLng Bellandur;
    private LatLng Whitefield;
    private LatLng Jogupalya;



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mc_location);

        KRLayout = new LatLng(12.905257,77.584150);
       Jayanagar = new LatLng(12.918198,77.586426);
        HSR = new LatLng(12.912106,77.637918);
        Koramangala = new LatLng(12.935049,77.611042);
        JNC = new LatLng(12.927923,77.627108);
        Bellandur = new LatLng(12.923495,77.685107);
        Whitefield = new LatLng(12.970174,77.749944);
        Jogupalya = new LatLng(12.972883,77.621279);



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

        View marker = ((LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE)).inflate(R.layout.mcdmarker, null);

        //numTxt.setText("27");

        mcdmarker = mMap.addMarker(new MarkerOptions()
                .position(KRLayout)
                .title("McDonalds")
                .snippet("KR Layout, JP Nagar VI Phase, Bengaluru")
                .icon(BitmapDescriptorFactory.fromBitmap(createDrawableFromView(this, marker))));

        mcdmarker = mMap.addMarker(new MarkerOptions()
                .position(Jayanagar)
                .title("McDonalds")
                .snippet("No.654/66, 11th Main Road, 4th Block, Jayanagar, Bengaluru")
                .icon(BitmapDescriptorFactory.fromBitmap(createDrawableFromView(this, marker))));

        mcdmarker = mMap.addMarker(new MarkerOptions()
                .position(HSR)
                .title("McDonalds")
                .snippet("HSR Layout No. 1, Sector 7, 14th Main Road, Near BDA Complex, Bengaluru")
                .icon(BitmapDescriptorFactory.fromBitmap(createDrawableFromView(this, marker))));

        mcdmarker = mMap.addMarker(new MarkerOptions()
                .position(Koramangala)
                .title("McDonalds")
                .snippet("21, The Forum Mall, Hosur Main Road, Koramangala, Bengaluru")
                .icon(BitmapDescriptorFactory.fromBitmap(createDrawableFromView(this, marker))));

        mcdmarker = mMap.addMarker(new MarkerOptions()
                .position(JNC)
                .title("McDonalds")
                .snippet("Unit No.10, AKS Plaza Industrial Layout, JNC Road, Koramangala, Bengaluru")
                .icon(BitmapDescriptorFactory.fromBitmap(createDrawableFromView(this, marker))));

        mcdmarker = mMap.addMarker(new MarkerOptions()
                .position(Bellandur)
                .title("McDonalds")
                .snippet("Adarsh Palm Retreat Villas, Bellandur, Bengaluru")
                .icon(BitmapDescriptorFactory.fromBitmap(createDrawableFromView(this, marker))));

        mcdmarker = mMap.addMarker(new MarkerOptions()
                .position(Whitefield)
                .title("McDonalds")
                .snippet("SH 35, Whitefield, Bengaluru")
                .icon(BitmapDescriptorFactory.fromBitmap(createDrawableFromView(this, marker))));

        mcdmarker = mMap.addMarker(new MarkerOptions()
                .position(Jogupalya)
                .title("McDonalds")
                .snippet("Old Madras Road, Someshwarpura, Jogupalya, Bengaluru")
                .icon(BitmapDescriptorFactory.fromBitmap(createDrawableFromView(this, marker))));



        final View mapView = getSupportFragmentManager().findFragmentById(R.id.map).getView();
        if (mapView.getViewTreeObserver().isAlive()) {
            mapView.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
                @SuppressLint("NewApi")
                // We check which build version we are using.
                @Override
                public void onGlobalLayout() {
                    LatLngBounds bounds = new LatLngBounds.Builder().include(HSR).build();
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