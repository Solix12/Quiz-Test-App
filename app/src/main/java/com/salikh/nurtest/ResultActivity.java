package com.salikh.nurtest;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.blogspot.atifsoftwares.animatoolib.Animatoo;

public class ResultActivity extends AppCompatActivity {

    public static final String KEY_TRUE_ANS = "tureAns";
    public static final String KEY_FALSE_ANS = "falseANS";
    private ImageView homeView, restartView, moreView;
    private TextView trueAnswer, falseAnswer;
    private int lessonType;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        Animatoo.animateZoom(ResultActivity.this);
        getWindow().setNavigationBarColor(getResources().getColor(R.color.white));
        Window window = this.getWindow();
        window.setStatusBarColor(this.getResources().getColor(R.color.white));
        loadViews();
        setListeners();
        setDataToViews();

    }

    private void setDataToViews() {
        Bundle bundle = getIntent().getExtras();

        int tureAns = bundle.getInt(KEY_TRUE_ANS);
        int falseAns = bundle.getInt(KEY_FALSE_ANS);


        this.lessonType = bundle.getInt(StartActivity.KEY_LESSON);

        trueAnswer.setText(String.valueOf(tureAns));
        falseAnswer.setText(String.valueOf(falseAns));
    }

    private void setListeners() {
        homeView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ResultActivity.this, StartActivity.class);
                startActivity(intent);
                finish();
            }
        });

        restartView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(ResultActivity.this, MathActivity.class);

                Bundle bundle = new Bundle();
                bundle.putInt(StartActivity.KEY_LESSON, lessonType);

                intent.putExtras(bundle);

                Animatoo.animateZoom(ResultActivity.this);
                startActivity(intent);
                finish();
            }
        });

        moreView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Bundle bundle = getIntent().getExtras();
                bundle.putStringArrayList("mistakes", bundle.getStringArrayList("mistakes"));
                Intent intent = new Intent(ResultActivity.this, MistakesActivity.class);
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });

    }

    private void loadViews() {

        falseAnswer = findViewById(R.id.false_answer_text);
        trueAnswer = findViewById(R.id.true_answer_text);
        homeView = findViewById(R.id.home_btn);
        restartView = findViewById(R.id.restar_btn);
        moreView = findViewById(R.id.more_btn);

    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Intent intent = new Intent(ResultActivity.this, StartActivity.class);
        Animatoo.animateZoom(ResultActivity.this);
        startActivity(intent);
    }
}