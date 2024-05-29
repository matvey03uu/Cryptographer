package com.example.cripter;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;


public class VisionActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vision);
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
        char msg[] = text.getText().toString().toCharArray();
        char key[] = shift.getText().toString().toCharArray();
        int msgLen = msg.length, i, j;
        char newKey[] = new char[msgLen];
        char encryptedMsg[] = new char[msgLen];
        System.out.println(msg);
        System.out.println(newKey);
        for (i = 0, j = 0; i < msgLen; ++i, ++j) {
            if (j == key.length)
                j = 0;
            newKey[i] = key[j];
        }
        for (i = 0; i < msgLen; ++i) {
            encryptedMsg[i] = (char) (((msg[i] + newKey[i]) % 26) + 'A');
        } textView.setText(String.valueOf(encryptedMsg));
    }
    public void deCript(View view) {
        TextView textView = findViewById(R.id.output);
        EditText text = findViewById(R.id.text);
        EditText shift = findViewById(R.id.shift);
        char msg[] = text.getText().toString().toCharArray();
        char key[] = shift.getText().toString().toCharArray();
        int msgLen = msg.length, i, j;
        char newKey[] = new char[msgLen];
        char decryptedMsg[] = new char[msgLen];
        System.out.println(msg);
        System.out.println(newKey);
        for (i = 0, j = 0; i < msgLen; ++i, ++j) {
            if (j == key.length)
                j = 0;
            newKey[i] = key[j];
        }
        for(i = 0; i < msgLen; ++i){
            decryptedMsg[i] = (char)((((msg[i] - newKey[i]) + 26) % 26) + 'A');
        }textView.setText(String.valueOf(decryptedMsg));
    }
}