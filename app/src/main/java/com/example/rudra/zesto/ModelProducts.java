package com.example.rudra.zesto;

public class ModelProducts {
	
	private String productName;
	private int quant;
	private int productPrice;

	
    public ModelProducts(String productName, int quant, int productPrice)
    {
    	this.productName  = productName;
    	this.quant  = quant;
    	this.productPrice = productPrice;

    }
	
	public String getProductName() {
		
		return productName;
	}
   
    public int getProductNum() {
		
		return quant;
	}
	
    public int getProductPrice() {
		
		return productPrice;
	}
		
}
