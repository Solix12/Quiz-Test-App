package com.salikh.nurtest;

import android.content.Intent;
import android.os.Bundle;
import android.view.Window;

import androidx.appcompat.app.AppCompatActivity;

import com.blogspot.atifsoftwares.animatoolib.Animatoo;

public class InfoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);
        Animatoo.animateZoom(InfoActivity.this);
        getWindow().setNavigationBarColor(getResources().getColor(R.color.white));
        Window window = this.getWindow();
        window.setStatusBarColor(this.getResources().getColor(R.color.white));

    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Intent intent = new Intent(InfoActivity.this, StartActivity.class);
        Animatoo.animateZoom(InfoActivity.this);
        startActivity(intent);
    }
}
