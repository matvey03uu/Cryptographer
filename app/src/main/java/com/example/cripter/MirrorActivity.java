package com.example.cripter;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;import android.os.Bundle;
import android.view.View;import android.widget.EditText;
import android.widget.TextView;
public class MirrorActivity extends AppCompatActivity {
    @Override    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_mirror);
    }    public void onBack(View view) {
            Intent intent = new Intent(this, ChoiceActivity.class);
            startActivity(intent);
    }    public void enCript(View view) {
            TextView textView = findViewById(R.id.output);
            EditText text = findViewById(R.id.text);
            String codedWord = new StringBuilder(text.getText()).reverse().toString();
            textView.setText(codedWord.toString());
    }    public void deCript(View view) {
            TextView textView = findViewById(R.id.output);
            EditText text = findViewById(R.id.text);
            String codedWord = new StringBuilder(text.getText()).reverse().toString();
            textView.setText(codedWord.toString());
    }}