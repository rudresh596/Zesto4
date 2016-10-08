package com.example.rudra.zesto;

import android.app.Application;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;

import java.util.ArrayList;

public class Controller extends Application {
	
	private ArrayList<ModelProducts> myProducts = new ArrayList<ModelProducts>();
	private  ModelCart myCart = new ModelCart();
	

	public ModelProducts getProducts(int pPosition) {
		return myProducts.get(pPosition);
	}
	
	public void setProducts(ModelProducts Products) {
		myProducts.add(Products);
	}	
	
	public ModelCart getCart() {
		return myCart;
	}
 
   public int getProductsArraylistSize() {
		return myProducts.size();
	}
   
}
