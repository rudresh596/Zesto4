package com.example.rudra.zesto;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import android.widget.ToggleButton;
import java.util.LinkedList;


public class kfcTab2 extends Fragment implements View.OnClickListener{

    EditText editText1,editText2,editText3,editText4,editText5,editText6,editText7,editText8,editText9;
    ToggleButton button,button2,  button3,button4,button5,  button6,button7,button8,  button9;
    Button confirm, cancel;
    int mark1 =2,mark2=2,mark3=2,mark4=2,mark5=2,mark6=2,mark7=2,mark8=2,mark9=2;
     LinkedList<ModelProducts> myProduct= new LinkedList<>();
    static LinkedList<ModelProducts> copyProduct = new LinkedList<>();



    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.kfctab_2, container, false);

        confirm = (Button)v.findViewById(R.id.conf);

        confirm.setOnClickListener(this);




        editText1 = (EditText)v.findViewById(R.id.et_menu1);
        editText2 = (EditText)v.findViewById(R.id.et_menu2);
        editText3 = (EditText)v.findViewById(R.id.et_menu3);
        editText4 = (EditText)v.findViewById(R.id.et_menu4);
        editText5 = (EditText)v.findViewById(R.id.et_menu5);
        editText6 = (EditText)v.findViewById(R.id.et_menu6);
        editText7 = (EditText)v.findViewById(R.id.et_menu7);
        editText8 = (EditText)v.findViewById(R.id.et_menu8);
        editText9 = (EditText)v.findViewById(R.id.et_menu9);

        button = (ToggleButton)v.findViewById(R.id.submit_menu1);
        button.setOnClickListener(this);

        button2 = (ToggleButton)v.findViewById(R.id.submit_menu2);
        button2.setOnClickListener(this);

        button3 = (ToggleButton)v.findViewById(R.id.submit_menu3);
        button3.setOnClickListener(this);

        button4 = (ToggleButton)v.findViewById(R.id.submit_menu4);
        button4.setOnClickListener(this);

        button5 = (ToggleButton)v.findViewById(R.id.submit_menu5);
        button5.setOnClickListener(this);

        button6 = (ToggleButton)v.findViewById(R.id.submit_menu6);
        button6.setOnClickListener(this);

        button7 = (ToggleButton)v.findViewById(R.id.submit_menu7);
        button7.setOnClickListener(this);

        button8 = (ToggleButton)v.findViewById(R.id.submit_menu8);
        button8.setOnClickListener(this);

        button9 = (ToggleButton)v.findViewById(R.id.submit_menu9);
        button9.setOnClickListener(this);

        for(int j=0;j<20;j++){
            ModelProducts prod = new ModelProducts("Chicken Snacker",0,0);
            myProduct.add(j,prod);
        }
        return v;
    }

    @Override
    public void onClick(View v) {
         ModelProducts products = null;
        switch (v.getId()) {
            case R.id.submit_menu1:
                confirm.setVisibility(View.VISIBLE);

                if(mark1 % 2 == 0) {
                    mark1+=1;
                    products = new ModelProducts("Chicken Snacker", Integer.parseInt(editText1.getText().toString()), 200);
                    myProduct.remove(0);
                    myProduct.add(0, products);
                    Toast.makeText(getContext(),"Added",Toast.LENGTH_LONG).show();

                }else {
                    mark1 += 1;
                    myProduct.remove(0);
                    ModelProducts prod = new ModelProducts("Chicken Snacker",0,0);
                    myProduct.add(0,prod);
                    Toast.makeText(getContext(), "Removed", Toast.LENGTH_LONG).show();
                }

                break;
            case R.id.submit_menu2:
                if(mark2 %2 == 0) {
                    mark2++;
                    products = new ModelProducts("Chicken In Box", Integer.parseInt(editText2.getText().toString()), 250);
                    myProduct.remove(1);
                    myProduct.add(1, products);
                    Toast.makeText(getContext(),"Added",Toast.LENGTH_LONG).show();
                }else{
                    mark2++;
                    myProduct.remove(1);
                    ModelProducts prod = new ModelProducts("Chicken Snacker",0,0);
                    myProduct.add(1, prod);
                    Toast.makeText(getContext(), "Removed", Toast.LENGTH_LONG).show();
                }

                break;

            case R.id.submit_menu3:
                if(mark3 %2 == 0) {
                    mark3++;
                    products = new ModelProducts("Chezza", Integer.parseInt(editText3.getText().toString()), 100);
                    myProduct.remove(2);
                    myProduct.add(2, products);
                    Toast.makeText(getContext(),"Added",Toast.LENGTH_LONG).show();
                }else{
                    mark3++;
                    myProduct.remove(2);
                    ModelProducts prod = new ModelProducts("Chicken Snacker",0,0);
                    myProduct.add(2, prod);
                    Toast.makeText(getContext(), "Removed", Toast.LENGTH_LONG).show();
                }
                break;

            case R.id.submit_menu4:
                if(mark4 %2 == 0) {
                    mark4++;
                    products = new ModelProducts("Hot N Saucy", Integer.parseInt(editText4.getText().toString()), 300);
                    myProduct.remove(3);
                    myProduct.add(3, products);
                    Toast.makeText(getContext(),"Added",Toast.LENGTH_LONG).show();
                }else{
                    mark4++;
                    myProduct.remove(3);
                    ModelProducts prod = new ModelProducts("Chicken Snacker",0,0);
                    myProduct.add(3, prod);
                    Toast.makeText(getContext(), "Removed", Toast.LENGTH_LONG).show();
                }
                 break;
            case R.id.submit_menu5:
                if(mark5 %2 == 0) {
                    mark5++;
                    products = new ModelProducts("Hot Wings", Integer.parseInt(editText5.getText().toString()), 360);
                    myProduct.remove(4);
                    myProduct.add(4, products);
                    Toast.makeText(getContext(),"Added",Toast.LENGTH_LONG).show();
                }else{
                    mark5++;
                    myProduct.remove(4);
                    ModelProducts prod = new ModelProducts("Chicken Snacker",0,0);
                    myProduct.add(4, prod);
                    Toast.makeText(getContext(), "Removed", Toast.LENGTH_LONG).show();
                }
                break;

            case R.id.submit_menu6:
                if(mark6 %2 == 0) {
                    mark6++;
                    products = new ModelProducts("Meal Box", Integer.parseInt(editText6.getText().toString()), 300);
                    myProduct.remove(5);
                    myProduct.add(5, products);
                    Toast.makeText(getContext(),"Added",Toast.LENGTH_LONG).show();
                }else{
                    mark6++;
                    myProduct.remove(5);
                    ModelProducts prod = new ModelProducts("Chicken Snacker",0,0);
                    myProduct.add(5, prod);
                    Toast.makeText(getContext(), "Removed", Toast.LENGTH_LONG).show();
                }
                break;

            case R.id.submit_menu7:
                if(mark7 %2 == 0) {
                    mark7++;
                    products = new ModelProducts("Rice Bowlz", Integer.parseInt(editText7.getText().toString()), 390);
                    myProduct.remove(6);
                    myProduct.add(6, products);
                    Toast.makeText(getContext(),"Added",Toast.LENGTH_LONG).show();
                }else{
                    mark7++;
                    myProduct.remove(6);
                    ModelProducts prod = new ModelProducts("Chicken Snacker",0,0);
                    myProduct.add(6, prod);
                    Toast.makeText(getContext(), "Removed", Toast.LENGTH_LONG).show();
                }
                break;

            case R.id.submit_menu8:
                if(mark8 %2 == 0) {
                    mark8++;
                    products = new ModelProducts("Veg Bowlz", Integer.parseInt(editText8.getText().toString()), 300);
                    myProduct.remove(7);
                    myProduct.add(7, products);
                    Toast.makeText(getContext(),"Added",Toast.LENGTH_LONG).show();
                }else{
                    mark8++;
                    myProduct.remove(7);
                    ModelProducts prod = new ModelProducts("Chicken Snacker",0,0);
                    myProduct.add(7, prod);
                    Toast.makeText(getContext(), "Removed", Toast.LENGTH_LONG).show();
                }
                break;

            case R.id.submit_menu9:
                if(mark9 %2 == 0) {
                    mark6++;
                    products = new ModelProducts("Hot N Crispy", Integer.parseInt(editText9.getText().toString()), 300);
                    myProduct.remove(8);
                    myProduct.add(8, products);
                    Toast.makeText(getContext(),"Added",Toast.LENGTH_LONG).show();
                }else{
                    mark9++;
                    myProduct.remove(8);
                    ModelProducts prod = new ModelProducts("Chicken Snacker",0,0);
                    myProduct.add(8, prod);
                    Toast.makeText(getContext(), "Removed", Toast.LENGTH_LONG).show();
                }
                break;
            case R.id.conf:
                    copyProduct.clear();
                    copyProduct.addAll(myProduct);
                    if(copyProduct.size() == 0) {
                        Toast.makeText(getContext(), "Please Add your items", Toast.LENGTH_LONG).show();
                    }else {
                        Toast.makeText(getContext(), "Done!! swipe to Orders", Toast.LENGTH_LONG).show();
                    }

                    break;


            default:
               // myProduct.clear();
        }

        }



    public static LinkedList dispatch(){
        return copyProduct;

    }

    }




