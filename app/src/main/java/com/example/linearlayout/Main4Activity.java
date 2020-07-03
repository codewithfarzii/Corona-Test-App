package com.example.linearlayout;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Main4Activity extends AppCompatActivity {
    public static int TIME_OUT=3000;
    Animation topAnim,bottomAnim;
    ImageView image;
    TextView logo1,logo2,slogan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        // splash screen
        setContentView(R.layout.activity_main4);

        Handler handler=new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent i=new Intent(Main4Activity.this,MainActivity.class) ;
                startActivity(i);
                finish();
            }
        },TIME_OUT);

        //animation
        topAnim= AnimationUtils.loadAnimation(this,R.anim.top_animation);
        bottomAnim= AnimationUtils.loadAnimation(this,R.anim.bottom_animation);

        //hooks
        image = findViewById(R.id.imageLogo);
        logo1 = findViewById(R.id.logo1);
        logo2 = findViewById(R.id.logo2);
        slogan = findViewById(R.id.slogan);

        image.setAnimation(topAnim);
        logo1.setAnimation(bottomAnim);
        logo2.setAnimation(bottomAnim);
        slogan.setAnimation(bottomAnim);

    }
}
