package com.chrisdahms.networkexample4;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

///////////////////////////////////////////////////////////////////////////////////////////////////
public class MainActivity extends AppCompatActivity implements AsyncInterface {

    // member variables ///////////////////////////////////////////////////////////////////////////
    private static final String TAG = "MainActivity";

    AsyncTaskExtended asyncTaskExtended = new AsyncTaskExtended();

    Button btnGetWebsite;
    TextView tvResult;

    ///////////////////////////////////////////////////////////////////////////////////////////////
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        asyncTaskExtended.asyncInterface = this;

        btnGetWebsite = (Button)findViewById(R.id.btnGetWebsite);
        btnGetWebsite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                asyncTaskExtended.execute("http://xxx");
            }
        });

        tvResult = (TextView)findViewById(R.id.tvResult);
    }

    ///////////////////////////////////////////////////////////////////////////////////////////////
    @Override
    public void onPostExecute(String data) {
        tvResult.setText(data);
    }

}





