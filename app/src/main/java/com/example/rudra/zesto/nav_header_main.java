package com.example.rudra.zesto;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class nav_header_main extends AppCompatActivity implements View.OnClickListener {
    TextView Click;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nav_header_main);

       // Click = (TextView)findViewById(R.id.prof_username);
     //   Click.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        //startActivity(new Intent(nav_header_main.this,Orders.class));
    }
}