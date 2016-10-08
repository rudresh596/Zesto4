package com.example.rudra.zesto;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class McTab3 extends Fragment {

    static TextView text;
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.activity_mc_tab3, container, false);
        text = (TextView)v.findViewById(R.id.displayName);
        text.setVisibility(View.GONE);
        return v;
    }

    public static void updateInfo(int num){

        text.setText("Hello"+ num);
        text.setVisibility(View.VISIBLE);
    }
}
