package com.example.rudra.zesto;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;
import android.widget.ToggleButton;

public class McTab2 extends Fragment implements View.OnClickListener{


    EditText editText1,editText2,editText3;
    ToggleButton button,button2,  button3;
    static int chsn = 200;
    static int chinb = 250;
    static int ches = 250;

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.activity_mc_tab2, container, false);

        editText1 = (EditText)v.findViewById(R.id.et_menu1);
        editText2 = (EditText)v.findViewById(R.id.et_menu2);
        editText3 = (EditText)v.findViewById(R.id.et_menu3);

        button = (ToggleButton)v.findViewById(R.id.submit_menu1);
        button.setOnClickListener(this);

        button2 = (ToggleButton)v.findViewById(R.id.submit_menu2);
        button2.setOnClickListener(this);

        button3 = (ToggleButton)v.findViewById(R.id.submit_menu3);
        button3.setOnClickListener(this);

        return v;
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()){



        }
    }


}

