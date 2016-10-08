package com.example.rudra.zesto;

import android.content.Context;
import android.os.AsyncTask;
import android.support.v4.app.Fragment;
import android.support.v4.content.res.TypedArrayUtils;
import android.support.v7.app.AppCompatActivity;
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


public class Background extends AsyncTask<String,Void,String> {

    Context ctx;

    Background(Context ctx)
    {
        this.ctx = ctx;

    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
    }

    @Override
    protected String doInBackground(String... params){
        String REG_URL = "http://zesto.96.lt/Register.php";

        String method = params[0];

        if(method.equals("register"))
        {
            String Name = params[1];
            String Email= params[2];
            String Phone = params[3];
            String Password = params[4];
            String Confirm = params[5];



            try {
                URL url = new URL(REG_URL);
                HttpURLConnection httpURLConnection = (HttpURLConnection)url.openConnection();
                httpURLConnection.setRequestMethod("POST");
                //httpURLConnection.connect();
                httpURLConnection.setDoOutput(true);
                OutputStream OS = httpURLConnection.getOutputStream();
                BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(OS,"UTF-8"));
                String data = URLEncoder.encode("NAME","UTF-8")+"="+URLEncoder.encode(Name,"UTF-8")+"&"+
                URLEncoder.encode("EMAIL","UTF-8")+"="+URLEncoder.encode(Email,"UTF-8")+"&"+
                URLEncoder.encode("PHONE","UTF-8")+"="+URLEncoder.encode(Phone,"UTF-8")+"&"+
                URLEncoder.encode("PASSWORD","UTF-8")+"="+URLEncoder.encode(Password,"UTF-8")+"&"+
                URLEncoder.encode("CONFIRM","UTF-8")+"="+URLEncoder.encode(Confirm,"UTF-8");
                bufferedWriter.write(data);
                bufferedWriter.flush();
                bufferedWriter.close();
                OS.close();

                InputStream IS = httpURLConnection.getInputStream();
                IS.close();
                return "Registration Success...";

                }catch (MalformedURLException e){
                e.printStackTrace();
            }catch (IOException e){
                e.printStackTrace();
            }

        }

        return null;
    }

        @Override
        protected void onProgressUpdate(Void... values) {
            super.onProgressUpdate(values);
        }

        @Override
        protected void onPostExecute(String result) {
            Toast.makeText(ctx,result,Toast.LENGTH_LONG).show();
        }
}
