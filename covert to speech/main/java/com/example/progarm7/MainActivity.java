package com.example.progarm7;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.view.View;
import android.widget.EditText;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {
    TextToSpeech tts;
    EditText ed;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ed = findViewById(R.id.editText);
        tts = new TextToSpeech(getApplicationContext(), new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int i) {
                if(i!=TextToSpeech.ERROR)
                    tts.setLanguage(Locale.ENGLISH);
            }
        });
    }
    public void convert(View view){
        String toSpeak = ed.getText().toString();
        tts.speak(toSpeak,TextToSpeech.QUEUE_FLUSH,null);
    }
}
