package com.example.amo_lab1;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class SecondTaskActivity extends AppCompatActivity {
    private TextView result2;
    private EditText enterI, enterX, enterC, enterD, enterH, enterP, enterQ, enterV;
    private Button readButton3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second_task);
        result2 = findViewById(R.id.resout2);
        Button count2 = findViewById(R.id.count2);
        ActionBar actionBar = getSupportActionBar();
        ColorDrawable colorDrawable
                = new ColorDrawable(Color.parseColor("#E10DC5"));
        actionBar.setBackgroundDrawable(colorDrawable);
        count2.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View view) {
                double a = 57.567;
                double b = -11.675;
                double c = -34.114;
                double d = Math.pow(b,2) - 4 * a * c;
                double x1 = (-b + Math.sqrt(d)) / (2 * a);
                double x2 = (-b - Math.sqrt(d)) / (2 * a);
                result2.setText("x1 = " + String.format("%.5f",x1) + "\n" + " x2 = " + String.format("%.5f",x2));

            }
        });

    }

}