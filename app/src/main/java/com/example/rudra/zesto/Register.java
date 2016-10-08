package com.example.rudra.zesto;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class Register extends FragmentActivity {

    EditText ET_Name, ET_Email, ET_Phone, ET_Password, ET_Confirm;
    String Name, Email, Phone, Password, Confirm;
    static String name;

    public static FragmentManager fragmentManager;
    EditText K_No;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
         fragmentManager = getSupportFragmentManager();
        DisplayMetrics DM = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(DM);

        int width = DM.widthPixels;
        int height = DM.heightPixels;

        getWindow().setLayout((int)(width*.8),(int)(height*.6));

        ET_Name = (EditText) findViewById(R.id.name);
        ET_Email = (EditText) findViewById(R.id.email);
        ET_Phone = (EditText)findViewById(R.id.phone);
        ET_Password = (EditText)findViewById(R.id.password);
        ET_Confirm = (EditText)findViewById(R.id.confirm);



    }

    public void userLogin(View view) {
        Toast.makeText(this, "Hello world!!", Toast.LENGTH_LONG).show();
    }

    public void userReg(View view) {
        Name = ET_Name.getText().toString();
        name = Name;
        Email = ET_Email.getText().toString();
        Phone = ET_Phone.getText().toString();
        Password = ET_Password.getText().toString();
        Confirm = ET_Confirm.getText().toString();
        final String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";


        if (Name.length() <= 5) {
            Toast.makeText(getApplicationContext(), "name should be at least 5 characters", Toast.LENGTH_LONG).show();
        } else if (Phone.length() < 10) {
            Toast.makeText(getApplicationContext(), "Phone number should be at least 10 digits", Toast.LENGTH_LONG).show();
        } else if (Password.length() < 8) {
            Toast.makeText(getApplicationContext(), "Passwords should be at least 8 characters", Toast.LENGTH_LONG).show();
        } else if (!Password.equals(Confirm)) {
            Toast.makeText(getApplicationContext(), "Passwords are not matching", Toast.LENGTH_LONG).show();
        } else if (!Email.matches(emailPattern) && Email.length() > 0) {
            Toast.makeText(getApplicationContext(), "Invalid email address", Toast.LENGTH_SHORT).show();
        } else {
            String method = "register";
            Background BackTask = new Background(this);
            BackTask.execute(method, Name, Email, Phone, Password, Confirm);
            finish();
        }
    }

    public static String getName(){
        return name;
    }
}
