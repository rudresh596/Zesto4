package com.example.rudra.zesto;

import java.util.ArrayList;

/**
 * Created by Rudra on 06-06-2016.
 */
public class onDataSetListener {
     String item;
     int nos,price;
    public ArrayList<ModelProducts> myProducts = new ArrayList<ModelProducts>();
     onDataSetListener(String item,int nos, int price){
         this.item = item;
         this.nos =nos;
         this.price = price;
    }


    public String getItem() {
        return item;
    }

    public int getNos() {
        return nos;
    }

    public int getPrice() {
        return price;
    }
}
