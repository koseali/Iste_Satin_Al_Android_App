package com.example.iste_satin_al;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

public class Splash_Screen extends AppCompatActivity {
    private TextView txtyazi;
    private ImageView imglogo;
    private static  int GECIS_SURESI = 3000;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //getActionBar().hide(); // action saklamak için
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash__screen);
        txtyazi = findViewById(R.id.txtgiris);
        imglogo= findViewById(R.id.imglogo);

        Animation animation = AnimationUtils.loadAnimation(this,R.anim.animation);
        txtyazi.startAnimation(animation);
        imglogo.startAnimation(animation);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent gecis = new Intent(Splash_Screen.this,MainActivity.class);
                startActivity(gecis);
                finish();
            }
        }, GECIS_SURESI);

    }

}
