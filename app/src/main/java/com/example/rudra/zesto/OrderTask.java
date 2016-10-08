package com.example.rudra.zesto;

import android.content.Context;
import android.os.AsyncTask;

import java.io.BufferedWriter;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

/**
 * Created by Rudra on 09-06-2016.
 */
public class OrderTask extends AsyncTask<String,Void,String> {

    Context ctx;
    Boolean T;
    OrderTask(Context ctx,Boolean T)
    {
        this.ctx = ctx;
        this.T = T;
    }
    @Override
    protected String doInBackground(String... params) {
        String REG_URL = "http://zesto596.96.lt/regester.php";
          String CustName =  Register.getName();
          String item = "33";
          String Num ="7";
          String Price = "67";

        try{
            URL url = new URL(REG_URL);
            HttpURLConnection httpURLConnection = (HttpURLConnection)url.openConnection();
            httpURLConnection.setRequestMethod("POST");
            httpURLConnection.setDoOutput(true);
            OutputStream OS = httpURLConnection.getOutputStream();
            BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(OS,"UTF-8"));
            String data = URLEncoder.encode("CUSTOMER","UTF-8")+"="+URLEncoder.encode(CustName,"UTF-8")+"&"+
                    URLEncoder.encode("ITEM","UTF-8")+"="+URLEncoder.encode(item,"UTF-8")+"&"+
                    URLEncoder.encode("QUANTITY","UTF-8")+"="+URLEncoder.encode(Num,"UTF-8")+"&"+
                    URLEncoder.encode("PRICE","UTF-8")+"="+URLEncoder.encode(Price,"UTF-8");
            bufferedWriter.write(data);
            bufferedWriter.flush();
            bufferedWriter.close();
            OS.close();
            InputStream IS = httpURLConnection.getInputStream();
            IS.close();
            return "Registration Success...";
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }
}
