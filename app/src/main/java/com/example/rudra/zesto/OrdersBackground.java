package com.example.rudra.zesto;

import android.content.Context;
import android.os.AsyncTask;
import android.widget.Toast;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;

/**
 * Created by Rudra on 20-06-2016.
 */
public class OrdersBackground extends AsyncTask<String,Void,String> {
        Context ctx;
     OrdersBackground(Context ctx){
        this.ctx = ctx;

    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
    }

    @Override
    protected String doInBackground(String... params) {
        String REG_URL = "http://zesto596.96.lt/orders.php";

        String Cust = params[0];
        String name = params[1];
        String num = params[2];
        String price = params[3];

        try{
            URL url = new URL(REG_URL);
            HttpURLConnection httpURLConnection = (HttpURLConnection)url.openConnection();
            httpURLConnection.setRequestMethod("POST");
            httpURLConnection.setDoOutput(true);
            OutputStream OS = httpURLConnection.getOutputStream();
            BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(OS,"UTF-8"));

            String data = URLEncoder.encode("CUSTOMER", "UTF-8")+"="+URLEncoder.encode(Cust,"UTF-8")+"&"+
                    URLEncoder.encode("ITEM","UTF-8")+"="+URLEncoder.encode(name,"UTF-8")+"&"+
                    URLEncoder.encode("QUANTITY","UTF-8")+"="+URLEncoder.encode(num,"UTF-8")+"&"+
                    URLEncoder.encode("PRICE","UTF-8")+"="+URLEncoder.encode(price,"UTF-8");
                    bufferedWriter.write(data);
                    bufferedWriter.flush();
                    bufferedWriter.close();
                    OS.close();
                    InputStream IS = httpURLConnection.getInputStream();
                    IS.close();
                    return "Thank you..Order Placed...";


        }catch (MalformedURLException e){
            e.printStackTrace();
        }catch (IOException e){
            e.printStackTrace();
        }
        return null;
    }

    @Override
    protected void onProgressUpdate(Void... values) {
        super.onProgressUpdate(values);
    }

    @Override
    protected void onPostExecute(String result) {
        Toast.makeText(ctx, result, Toast.LENGTH_LONG).show();
    }
}
