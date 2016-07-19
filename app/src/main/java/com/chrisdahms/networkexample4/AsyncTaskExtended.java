package com.chrisdahms.networkexample4;

import android.os.AsyncTask;
import android.util.Log;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

///////////////////////////////////////////////////////////////////////////////////////////////
public class AsyncTaskExtended extends AsyncTask<String, String, String> {

    // member variables ///////////////////////////////////////////////////////////////////////////
    private static final String TAG = "AsyncTaskExtended";
    public AsyncInterface asyncInterface = null;

    ///////////////////////////////////////////////////////////////////////////////////////////////
    @Override
    protected String doInBackground(String... strUrls) {
        InputStream inputStream = null;
        String webPageText = "";

        try {
            URL url = new URL(strUrls[0]);
            HttpURLConnection httpURLConnection = (HttpURLConnection)url.openConnection();
            httpURLConnection.setReadTimeout(10000);
            httpURLConnection.setConnectTimeout(15000);
            httpURLConnection.setRequestMethod("GET");
            httpURLConnection.setDoInput(true);
            httpURLConnection.connect();
            inputStream = httpURLConnection.getInputStream();
            Reader reader = new InputStreamReader(inputStream, "UTF-8");
            char[] buffer = new char[500];
            reader.read(buffer);
            webPageText = new String(buffer);
        } catch (IOException e) {
            Log.d(TAG, "IOException", e);
        }
        return webPageText;
    }

    ///////////////////////////////////////////////////////////////////////////////////////////////
    @Override
    protected void onPostExecute(String result) {
        asyncInterface.onPostExecute(result);
    }

}







