package com.example.lab1;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = findViewById(R.id.textView);
    }

    public void onClickChangeColor(View view) {
        textView.setTextColor(Color.rgb(new Random().nextInt(365),new Random().nextInt(365),new Random().nextInt(365)));
        Toast.makeText(this,"Hello", Toast.LENGTH_SHORT).show();
    }
}