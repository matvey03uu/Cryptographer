package com.example.cripter;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class ChoiceActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choice);
    }
    public void onClick(View view) {
        Intent intent = new Intent(this, CaesarActivity.class);
        startActivity(intent);
    }
    public void onClick2(View view) {
        Intent intent = new Intent(this, MorseActivity.class);
        startActivity(intent);
    }
    public void onClick3(View view) {
        Intent intent = new Intent(this, MirrorActivity.class);
        startActivity(intent);
    }
    public void onClick4(View view) {
        Intent intent = new Intent(this, VisionActivity.class);
        startActivity(intent);
    }
    public void onClick5(View view) {
        Intent intent = new Intent(this, AESActivity.class);
        startActivity(intent);
    }
    public void onBack(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}