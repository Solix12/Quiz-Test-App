package com.salikh.nurtest;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import com.blogspot.atifsoftwares.animatoolib.Animatoo;

public class StartActivity extends AppCompatActivity implements View.OnClickListener {

    private static final int mathematicsLesson = 1;
    private static final int fizikaLesson = 2;
    private static final int tarixLesson = 3;
    public static String KEY_LESSON = "lesson";
    Bundle bundle = new Bundle();
    private CardView mathView, pyhzecsView, historyView;
    private LinearLayout infoButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);
        Animatoo.animateZoom(StartActivity.this);
        getWindow().setNavigationBarColor(getResources().getColor(R.color.white));

        loadVIew();

        mathView.setOnClickListener(this);
        pyhzecsView.setOnClickListener(this);
        historyView.setOnClickListener(this);
        infoButton.setOnClickListener(this);


    }

    private void loadVIew() {
        mathView = findViewById(R.id.mathematics_view);
        pyhzecsView = findViewById(R.id.physics_view);
        historyView = findViewById(R.id.history_view);
        infoButton = findViewById(R.id.info_view);
    }

    @Override
    public void onClick(View view) {

        switch (view.getId()) {

            case R.id.mathematics_view: {
                finish();
                Intent intent = new Intent(StartActivity.this, MathActivity.class);
                bundle.putInt(KEY_LESSON, mathematicsLesson);
                intent.putExtras(bundle);
                Animatoo.animateZoom(StartActivity.this);
                startActivity(intent);
                break;
            }
            case R.id.physics_view: {
                finish();
                Intent intent = new Intent(StartActivity.this, MathActivity.class);
                bundle.putInt(KEY_LESSON, fizikaLesson);
                intent.putExtras(bundle);
                Animatoo.animateZoom(StartActivity.this);
                startActivity(intent);
                break;
            }
            case R.id.info_view: {
                finish();
                Intent intent = new Intent(StartActivity.this, InfoActivity.class);
                Animatoo.animateZoom(StartActivity.this);
                startActivity(intent);
                break;
            }
            case R.id.history_view: {
                finish();
                Intent intent = new Intent(StartActivity.this, MathActivity.class);
                bundle.putInt(KEY_LESSON, tarixLesson);
                intent.putExtras(bundle);
                Animatoo.animateZoom(StartActivity.this);
                startActivity(intent);
                break;
            }
        }

    }
}