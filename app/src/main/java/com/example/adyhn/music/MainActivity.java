package com.example.adyhn.music;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageButton;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {

    private ImageButton next, prev, enter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Spustanie na sirku
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        this.setTheme(R.style.ThemeDark);

        next = (ImageButton) findViewById(R.id.next);
        prev = (ImageButton) findViewById(R.id.prev);
        enter = (ImageButton) findViewById(R.id.enter);


        enter.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {

                startActivity(new Intent(MainActivity.this, TimeLineActivity.class));
            }
        });


    }
}
