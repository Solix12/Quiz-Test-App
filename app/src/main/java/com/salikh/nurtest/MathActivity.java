package com.salikh.nurtest;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.SeekBar;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.blogspot.atifsoftwares.animatoolib.Animatoo;

import java.util.ArrayList;

import io.github.muddz.styleabletoast.StyleableToast;

public class MathActivity extends AppCompatActivity {

    private final ArrayList<QuestionData> data = new ArrayList<>();
    private SeekBar seekBar;
    private TextView currentView, totalView, questionView, checkText;
    private ImageView finishButton;
    private LinearLayout checkButton;
    private RadioGroup answerGroup;
    private RadioButton variantA;
    private RadioButton variantB;
    private RadioButton variantC;
    private boolean isAnswered = false;
    private boolean isFinished = false;
    private boolean isA = false;
    private boolean isB = false;
    private boolean isC = false;
    private QuestionManager manager;
    private int lessonType;

    private boolean isResultStarted = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_math);
        startEverything();
    }

    private void startEverything() {
        Animatoo.animateZoom(MathActivity.this);
        loadViews();
        setStateViews();
        setListener();
        choseLesson();
        manager = new QuestionManager(data);
        startQuiz();
    }

    @Override
    protected void onResume() {
        super.onResume();
        if (isResultStarted) {
            startEverything();
            isResultStarted = false;
        }
    }

    private void choseLesson() {
        Bundle bundle = getIntent().getExtras();

        this.lessonType = bundle.getInt(StartActivity.KEY_LESSON);

        if (lessonType == 1) {
            loadDataMath();
        } else if (lessonType == 2) {
            loadDataFizika();
        } else if (lessonType == 3) {
            loadDataMath();
        }
    }

    private void loadDataFizika() {

        data.add(new QuestionData(
                "Tutashayotgan va qaytgan nurlar orasidagi burchak 50 gradus bolsa , nur qanday burchak osdida tushmoqda ?",
                "25",
                "35",
                "40",
                "25"));

        data.add(new QuestionData(
                "Agar ko'zgu 15 gradus burchakga burulsa , kozgudan qaytgan nur necha gradusga buruladi ?",
                "30",
                "30",
                "60",
                "45"));

        data.add(new QuestionData(
                "Qaytgan nur bilan yassi ko'zgu orasidagi burchak 22 gradus bolsa , tushish burchagi qanday ?",
                "58",
                "93",
                "65",
                "58"));

        data.add(new QuestionData(
                "6 marta kattalashtiradigan lupaning optik kuchini toping ?",
                "20",
                "25",
                "15",
                "20"));

        data.add(new QuestionData(
                "Harbiy reaktiv samolyot 10 s da tezligini 450 dan 900 km/h gacha oshirdi. Tezlanishini aniqlang(m/s) ?",
                "12.5",
                "45",
                "12.5",
                "120"));

        data.add(new QuestionData(
                "Jisim s=5t-0.25*t*t  qonun boyicha harakatlanmoqda. Uning dastlabki 4 sekundda necha metr yo'l otgan ?",
                "28",
                "20",
                "28",
                "5"));

        data.add(new QuestionData(
                "Tinch turgan avtomobil 2 m/s tezlanish bilan harakatlanib, 121 m masofani o'tishi uchun qancha vaqt sarflaydi ?",
                "11",
                "11",
                "16",
                "30"));
    }

    private void loadDataMath() {

        data.add(new QuestionData(
                "abc, bca, cab uch xonali sonlarning yig`indisi 555 bo`lsa, a+b+c yig`indi nechaga teng?",
                "5",
                "3",
                "5",
                "1"));

        data.add(new QuestionData(
                "x butun son bo`lsa, 2x+1 dan keyin keladigan ilk ikkita ketma−ket sonlarning yig`indisi nechaga teng?",
                "4x+5",
                "4x+3",
                "4x+5",
                "4x+1"));

        data.add(new QuestionData(
                "Uch xonali natural son bilan ikki xonali natural sonning yig`indisi eng kamida nechaga teng bo`ladi? ",
                "110",
                "1090",
                "120",
                "110"));

        data.add(new QuestionData(
                "x<0<y bo`lsa, |2x−y|+|2y−x| ifoda nimaga teng?",
                "3y−3x",
                "3y−3x",
                "x−y ",
                "3x+y"));

        data.add(new QuestionData(
                "Tenglama a ning qanday qiymatida yechimga ega emas? 6x−a−6=(a+2)(x+2)",
                "4",
                "2",
                "6",
                "4"));

        data.add(new QuestionData(
                " a,b,c,d butun sonlar va a>b>c>1, d<0 bo`lsa, quyidagilardan qaysi biri xato?",
                "((b*d)/(c+a)) > 0",
                "((a+c)/a) > 1",
                "((b*d)/(c+a)) > 0",
                "((a−d) /b) > 1 "));

        data.add(new QuestionData(
                " √3 + √a − √3 − √a = 2 bo`lsa, a nechaga teng?",
                "4",
                "2",
                "6",
                "4"));

    }

    private void startQuiz() {

        questionView.setText(manager.getQuestion());
        variantA.setText(manager.getVariantA());
        variantB.setText(manager.getVariantB());
        variantC.setText(manager.getVariantC());

        currentView.setText(String.valueOf(manager.getCurrentLevel()));
        totalView.setText(String.valueOf(manager.getTotal()));

        seekBar.setProgress(manager.getCurrentLevel() * 100 / manager.getTotal());

    }

    private void clearView() {
        variantA.setBackgroundResource(R.drawable.variant);
        variantB.setBackgroundResource(R.drawable.variant);
        variantC.setBackgroundResource(R.drawable.variant);

        variantA.setEnabled(true);
        variantB.setEnabled(true);
        variantC.setEnabled(true);

        answerGroup.clearCheck();

        variantA.setTextColor(Color.parseColor("#8DA1B5"));
        variantB.setTextColor(Color.parseColor("#8DA1B5"));
        variantC.setTextColor(Color.parseColor("#8DA1B5"));


    }

    private void setListener() {

        checkButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                boolean hasPressed = variantA.isChecked() || variantB.isChecked() || variantC.isChecked();

                if (isFinished) {
                    int tureCount = manager.getTotalTrue();
                    int falseCount = manager.getTotalFalse();
                    Bundle bundle = new Bundle();
                    bundle.putStringArrayList("mistakes", manager.getMistakes());
                    bundle.putInt(StartActivity.KEY_LESSON, lessonType);
                    bundle.putInt(ResultActivity.KEY_TRUE_ANS, tureCount);
                    bundle.putInt(ResultActivity.KEY_FALSE_ANS, falseCount);
                    Intent intent = new Intent(MathActivity.this, ResultActivity.class);
                    Animatoo.animateZoom(MathActivity.this);
                    intent.putExtras(bundle);
                    isResultStarted = true;
                    startActivity(intent);

                    finish();

                } else {
                    if (hasPressed) {

                        if (isAnswered) {

                            if (manager.hasQuestion()) {
                                clearView();
                                startQuiz();
                                checkText.setText("Check");
                            } else {
                                isFinished = true;
                                checkText.setText("Result");
                            }
                            isAnswered = false;

                        } else {
                            RadioButton button = findViewById(answerGroup.getCheckedRadioButtonId());
                            String answer = button.getText().toString();
                            boolean isTrue = manager.checkAnswer(answer);

                            if (isTrue) {
                                button.setBackgroundResource(R.drawable.ture_answer);
                            } else {
                                button.setBackgroundResource(R.drawable.false_answer);
                            }

                            variantA.setEnabled(variantA.isChecked());
                            variantC.setEnabled(variantC.isChecked());
                            variantB.setEnabled(variantB.isChecked());

                            checkText.setText("Next");

                            isAnswered = true;
                        }

                    } else {
                        StyleableToast.makeText(MathActivity.this, "Belgilang", R.style.salihkToast).show();
                    }
                }


            }
        });

        variantA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                isA = true;
                isABC();
            }
        });

        variantB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                isB = true;
                isABC();
            }
        });

        variantC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                isC = true;
                isABC();
            }
        });

        finishButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MathActivity.this, StartActivity.class);
                Animatoo.animateZoom(MathActivity.this);
                startActivity(intent);
                finish();
            }
        });

    }

    private void isABC() {
        if (isA) {
            variantA.setTextColor(Color.WHITE);
            variantB.setTextColor(Color.parseColor("#8DA1B5"));
            variantC.setTextColor(Color.parseColor("#8DA1B5"));
            isA = false;
        } else if (isB) {
            variantA.setTextColor(Color.parseColor("#8DA1B5"));
            variantB.setTextColor(Color.WHITE);
            variantC.setTextColor(Color.parseColor("#8DA1B5"));
            isB = false;
        } else if (isC) {
            variantA.setTextColor(Color.parseColor("#8DA1B5"));
            variantB.setTextColor(Color.parseColor("#8DA1B5"));
            variantC.setTextColor(Color.WHITE);
            isC = false;
        }
    }

    private void loadViews() {
        seekBar = findViewById(R.id.seekbar_view);
        currentView = findViewById(R.id.current_view);
        totalView = findViewById(R.id.total_view);
        finishButton = findViewById(R.id.finish_btn);
        questionView = findViewById(R.id.question_text);
        checkButton = findViewById(R.id.check_view);
        checkText = findViewById(R.id.check_text);

        answerGroup = findViewById(R.id.question_group);

        variantA = findViewById(R.id.variantA);
        variantB = findViewById(R.id.variantB);
        variantC = findViewById(R.id.variantC);
    }

    private void setStateViews() {
        seekBar.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                return true;
            }
        });
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Intent intent = new Intent(MathActivity.this, StartActivity.class);
        Animatoo.animateZoom(MathActivity.this);
        startActivity(intent);
    }

}