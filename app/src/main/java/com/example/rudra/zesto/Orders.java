package com.example.rudra.zesto;


import android.app.ActionBar;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.LinkedList;


public class Orders extends Fragment implements View.OnClickListener{


     TextView showCart,total;
    int Total=0;
     String CUST = "hi";
     String showString= "",noString="No Items Added...............................",totalString="";

    Button checkout,pay,cod;
    TextView summ;
     LinkedList<ModelProducts> product= new LinkedList<>();





    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.activity_orders, container, false);

        checkout = (Button) v.findViewById(R.id.check);
        checkout.setOnClickListener(this);

        showCart = (TextView)v.findViewById(R.id.displayName);
        showCart.setText(noString);
        showCart.setVisibility(View.GONE);

        total = (TextView)v.findViewById(R.id.total);
        total.setText(noString);


        summ = (TextView)v.findViewById(R.id.display);
        summ.setVisibility(View.GONE);

        pay = (Button)v.findViewById(R.id.pay);
        pay.setOnClickListener(this);
        pay.setVisibility(View.GONE);

        cod = (Button)v.findViewById(R.id.cod);
        cod.setOnClickListener(this);
        cod.setVisibility(View.GONE);


        return v;
    }

    public static void getPos(int pos){
        if(pos == 2){

        }
    }


    @Override
    public void onClick(View v) {

        switch (v.getId()){

            case R.id.check:
                product = kfcTab2.dispatch();
                if(product.size() == 0){
                    Toast.makeText(getContext(),"You have no items",Toast.LENGTH_LONG).show();
                }else {

                    for (int i=0;i<product.size();i++){
                        if(product.get(i).getProductPrice()!=0) {
                            String Name = product.get(i).getProductName();
                            int Num = product.get(i).getProductNum();
                            int Price = product.get(i).getProductPrice();
                            Total+=Price;
                            showString += Name + "       " + Price + " Rs." + "      " + Num + " Nos\n";
                        }
                    }
                    showCart.setText(showString + "\n\n\n");
                    showCart.setVisibility(View.VISIBLE);
                   // total.setText("Helo");
                    //total.setVisibility(View.VISIBLE);
                    summ.setVisibility(View.VISIBLE);
                    pay.setVisibility(View.VISIBLE);
                    cod.setVisibility(View.VISIBLE);
                    checkout.setVisibility(View.GONE);
                }
                break;

            case R.id.cod:

                    for (int i = 0; i < product.size(); i++) {
                        if (product.get(i).getProductPrice() != 0) {
                            String Item = product.get(i).getProductName();
                            String Num = String.valueOf(product.get(i).getProductNum());
                            String Price = String.valueOf(product.get(i).getProductPrice());
                            OrdersBackground order = new OrdersBackground(getContext());
                            order.execute(CUST,Item, Num, Price);
                        }

                        cod.setVisibility(View.GONE);
                        pay.setVisibility(View.GONE);


                }
             //   Toast.makeText(getContext(), "Connecting please Wait......", Toast.LENGTH_LONG).show();
                //Toast.makeText(getContext(), "Thank you. We will reach you soon", Toast.LENGTH_LONG).show();


                break;
            case R.id.pay:
                Toast.makeText(getContext(),"Connecting.. please wait...",Toast.LENGTH_LONG).show();
                break;

        }
    }
}
