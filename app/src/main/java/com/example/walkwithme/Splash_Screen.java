package com.example.walkwithme;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.annotation.GlideModule;
import com.bumptech.glide.module.AppGlideModule;

public class Splash_Screen extends AppCompatActivity {

    private boolean doubleBacktoExitPressedOnce = false;
    private static final int DOUBLE_BACK_PRESS_INTERVAL = 4000;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_splash_screen);

        ImageView splash_home   =   findViewById(R.id.splash_screen_logo);
        Glide.with(this).load(R.drawable.walk_me).into(splash_home);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(Splash_Screen.this, PAGE2.class);
                startActivity(intent);
                finish();
            }
        },DOUBLE_BACK_PRESS_INTERVAL);
    }

    @Override
    public void onBackPressed(){
        if(doubleBacktoExitPressedOnce){
            super.onBackPressed();
            return;
        }
        this.doubleBacktoExitPressedOnce = true;
        Toast.makeText(this,"Press again to Exit",Toast.LENGTH_SHORT).show();

        new Handler(Looper.getMainLooper()).postDelayed(new Runnable() {
            @Override
            public void run() {
                doubleBacktoExitPressedOnce = false;
            }
        },DOUBLE_BACK_PRESS_INTERVAL);
    }
}