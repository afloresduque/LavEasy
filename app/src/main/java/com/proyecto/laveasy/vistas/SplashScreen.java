package com.proyecto.laveasy.vistas;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.os.Handler;

import androidx.appcompat.app.AppCompatActivity;

import com.proyecto.laveasy.R;

public class SplashScreen extends AppCompatActivity {

    @SuppressLint("SourceLockedOrientationActivity")
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        setContentView(R.layout.activity_splash_screen);

        /**
         * Lanzamos un objeto Runnable que lanzará la clase de la pantalla principal tras
         * un periodo de retraso establecido
         */
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(SplashScreen.this, Principal.class);
                startActivity(intent);

            }
        },4000);
    }
}

