package com.example.sharedpreference;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private TextView textView;
    private SharedPreferences sharedPreferences;
    private int counter = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = findViewById(R.id.text_view);
        sharedPreferences = getSharedPreferences("com.example.sharedpreference.PREFERENCE_FILE_KEY", MODE_PRIVATE); //핸들을 가져오는 액티비티
    }

    @Override
    protected void onResume() {
        super.onResume();
        counter = sharedPreferences.getInt("COUNTER", counter);
        textView.setText("Counter : " + counter);
    }

    @Override
    protected void onPause() {
        super.onPause();
        counter++;
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putInt("COUNTER", counter);
        editor.commit();
    }
}