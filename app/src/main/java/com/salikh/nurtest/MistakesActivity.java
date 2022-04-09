package com.salikh.nurtest;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class MistakesActivity extends AppCompatActivity {

    private final ArrayList<String> list = new ArrayList<>();
    private TextView mistacke;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mistakes);


        loadViews();
        setDataToView();
        listLoad();

    }

    private void listLoad() {
        Bundle bundle = getIntent().getExtras();
        list.addAll(bundle.getStringArrayList("mistakes"));
    }

    private void setDataToView() {
        Log.d("1", "setDataToView: " + list.toString());
        mistacke.setText(list.toString());
    }

    private void loadViews() {
        mistacke = findViewById(R.id.mistakes_text);
    }


}