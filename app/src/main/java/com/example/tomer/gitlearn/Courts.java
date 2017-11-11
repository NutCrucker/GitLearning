package com.example.tomer.gitlearn;

import android.os.AsyncTask;
import android.widget.TextView;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;


public class Courts extends AsyncTask<String, String, String> {
    String Result;

    @Override
    protected String doInBackground(String... params) {
        String name = params[0];
        try {
            String check_url = "http://10.0.2.2/login.php";
            URL url = new URL(check_url);
            HttpURLConnection Check = (HttpURLConnection) url.openConnection();
            Check.setRequestMethod("POST");
            Check.setDoOutput(true);
            Check.setDoInput(true);
            OutputStream L = Check.getOutputStream();
            BufferedWriter B = new BufferedWriter(new OutputStreamWriter(L, "UTF-8"));
            String post_data = URLEncoder.encode("name", "UTF-8") + "=" + URLEncoder.encode(name, "UTF-8");
            B.write(post_data);
            B.flush();
            B.close();
            L.close();
            InputStream IPS = Check.getInputStream();
            BufferedReader C = new BufferedReader(new InputStreamReader(IPS, "iso-8859-1"));
            String result = "";
            String line = "";
            while ((line = C.readLine()) != null) {
                result = result + line;
            }
            C.close();
            IPS.close();
            Check.disconnect();
            this.Result = result;
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return Result;
    }


}

