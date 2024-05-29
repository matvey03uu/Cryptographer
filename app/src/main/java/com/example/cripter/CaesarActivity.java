package com.example.cripter;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;


public class CaesarActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_caesar);
    }
    public void onBack(View view) {
        Intent intent = new Intent(this, ChoiceActivity.class);
        startActivity(intent);
    }
    public void enCript(View view) {
        TextView textView = findViewById(R.id.output);
        EditText text = findViewById(R.id.text);
        EditText shift = findViewById(R.id.shift);
        StringBuilder strBox = new StringBuilder(text.getText().length());
        char tmp;
        for (int i = 0; i < text.getText().length(); i++) {
            tmp = text.getText().charAt(i);
            if (Character.isLetter(text.getText().charAt(i))) {
                tmp = (char) (tmp + Integer.parseInt(shift.getText().toString()) % 33);
                if (tmp > 'я'){
                    tmp = (char) (tmp % 'я' + 'а' - 1);
                }else if (tmp < 'а'){
                    tmp = (char) (tmp + 33);
                }
            } strBox.append(tmp);
        }
        textView.setText(strBox.toString());
    }
    public void deCript(View view) {
        TextView textView = findViewById(R.id.output);
        EditText text = findViewById(R.id.text);
        EditText shift = findViewById(R.id.shift);
        StringBuilder strBox = new StringBuilder(text.getText().length());
        char tmp;
        for (int i = 0; i < text.getText().length(); i++) {
            tmp = text.getText().charAt(i);
            if (Character.isLetter(text.getText().charAt(i))) {
                tmp = (char)(tmp - Integer.parseInt(shift.getText().toString()) % 33);
                if (tmp > 'я')
                    tmp = (char)(tmp % 'я' + 'а' - 1);
                else if (tmp < 'а')
                    tmp = (char)(tmp + 33);
            }
            strBox.append(tmp);
        }
        textView.setText(strBox.toString());
    }
}