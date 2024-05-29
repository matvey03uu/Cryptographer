package com.example.cripter;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.ToggleButton;


public class MorseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_morse);
    }
    public void onBack(View view) {
        Intent intent = new Intent(this, ChoiceActivity.class);
        startActivity(intent);
    }
    static final char[] alp = { 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l',
            'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x',
            'y', 'z', 'а', 'б', 'в', 'г', 'д', 'е', 'ё', 'ж', 'з', 'и', 'к', 'л',
            'м', 'н', 'о', 'п', 'р', 'с', 'т', 'у', 'ф', 'х', 'ц', 'ч',
            'ш', 'щ', 'ъ', 'ы', 'ь', 'э', 'ю', '1', '2', '3', '4', '5', '6', '7', '8', '9', '0',
            ',', '.', '?' };

    static final String[] morse = { ".-", "-...", "-.-.", "-..", ".", "..-.", "--.", "....", "..",
            ".---", "-.-", ".-..", "--", "-.", "---", ".---.", "--.-", ".-.",
            "...", "-", "..-", "...-", ".--", "-..-", "-.--", "--..", ".-", "-...", ".--", "--.", "-..", ".", "...-", "--..", "..",
            ".---", "-.-", ".-..", "--", "-.", "---", ".---.", ".-.",
            "...", "-", "..-", "..-.", "....", "-.-.", "---.", "----", "--.-", "--.--", "-.--", "-..-", "..-..", "..--", ".-.-", ".----",
            "..---", "...--", "....-", ".....", "-....", "--...", "---..", "----.", "-----",
            "--..--", ".-.-.-", "..--.." };
    static final String[] morse_r = { ".-", "-...", ".--", "--.", "-..", ".", "...-", "--..", "..",
            ".---", "-.-", ".-..", "--", "-.", "---", ".---.", ".-.",
            "...", "-", "..-", "..-.", "....", "-.-.", "---.", "----", "--.-", "--.--", "-.--", "-..-", "..-..", "..--", ".-.-",
            };
    public static String engToMorse(String s) {
        s = s.toLowerCase();
        char[] chars = s.toCharArray();
        String str = "";
        for (int i = 0; i < chars.length; i++){
            for (int j = 0; j < alp.length; j++){
                if (alp[j] == chars[i]){
                    str = str + morse[j] + " ";
                    break;
                }
            }
        }
        return str;
    }
    public static String MorseToEng(String s) {
        String[] letters = s.split(" ");
        String str = "";
        for (int i = 0; i < letters.length; i++){
            for (int j = 0; j < morse.length; j++){
                if (morse[j].equals(letters[i])){
                    str = str + alp[j];
                    break;
                }
            }
        }
        return str;
    }
    public void enCript(View view) {
        TextView textView = findViewById(R.id.output);
        EditText text = findViewById(R.id.text);

        textView.setText(engToMorse(text.getText().toString()));
    }


    public void deCript(View view) {
        TextView textView = findViewById(R.id.output);
        EditText text = findViewById(R.id.text);

        textView.setText(MorseToEng(text.getText().toString()));
    }
    public void Sound(View view) throws InterruptedException {
        MediaPlayer mPlayer_dash;
        MediaPlayer mPlayer_dot;
        TextView textView = findViewById(R.id.output);
        mPlayer_dash= MediaPlayer.create(this, R.raw.morse_dash);
        mPlayer_dot= MediaPlayer.create(this, R.raw.morse_dash);
        String s = textView.getText().toString();
        s = s.toLowerCase();
        String[] letters = s.split(" ");
        for (int i = 0; i < letters.length; i++) {
            String[] data = letters[i].split("");
            for (int j = 0; j < letters[i].length(); j++){
                if (data[j].equals("-")) {
                    mPlayer_dash.start();
                    Thread.sleep(200);
                } else if (data[j].equals(".")) {
                    mPlayer_dot.start();
                    Thread.sleep(200);
                }
            } Thread.sleep(200);
        }
    }
}