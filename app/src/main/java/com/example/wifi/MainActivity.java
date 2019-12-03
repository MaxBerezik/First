package com.example.wifi;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.os.Bundle;

import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {

    TextView result;

    Handler timerHandler = new Handler();
    Runnable timerRunnable = new Runnable()
    {
        @Override public void run()
        {
            checkConnection ();

            if (checkConnection ( )) {
                result.setText ("WIFI ЕСТЬ");
            } else {
                result.setText ("WIFI НЕТУ");
            }

            timerHandler.postDelayed(this, 500);
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate (savedInstanceState);
        setContentView (R.layout.activity_main);
        result = (TextView) findViewById (R.id.TVresult);

        timerHandler.postDelayed(timerRunnable, 0);

    }
        public boolean checkConnection () {
            ConnectivityManager cm = (ConnectivityManager) getSystemService (Context.CONNECTIVITY_SERVICE);
            NetworkInfo netInfo = cm.getActiveNetworkInfo ( );
            return netInfo != null && netInfo.isConnectedOrConnecting ( );
        }


    }


