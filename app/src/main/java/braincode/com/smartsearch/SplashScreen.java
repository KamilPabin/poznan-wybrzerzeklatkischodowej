package braincode.com.smartsearch;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;

/**
 * Created by Little on 2017-03-25.
 */

public class SplashScreen extends AppCompatActivity{

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        View decorView = getWindow().getDecorView();
        int uiOptions = View.SYSTEM_UI_FLAG_FULLSCREEN;
        decorView.setSystemUiVisibility(uiOptions);
        getSupportActionBar().hide();

        setContentView(R.layout.splash_screen_layout);

        TextView T1 = (TextView) findViewById(R.id.T1);
        Animation anim1 = AnimationUtils.loadAnimation(this, R.anim.text1_move);
        T1.startAnimation(anim1);

        TextView T2 = (TextView) findViewById(R.id.T2);
        Animation anim2 = AnimationUtils.loadAnimation(this,R.anim.text2_move);
        T2.startAnimation(anim2);


        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                        startActivity(intent);
                    }
                }, 4000);
            }
        });
    }
}
