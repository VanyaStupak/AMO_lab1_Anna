package com.example.amo_lab1;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toolbar;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class FirstTaskActivity extends AppCompatActivity {
    private TextView result;
    private EditText enterA, enterB, enterX;
    private File example;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first_task);
        result = findViewById(R.id.resout);
        enterA = findViewById(R.id.enterA);
        enterB = findViewById(R.id.enterB);
        enterX = findViewById(R.id.enterX);
        Button count = findViewById(R.id.count);
        Button readButton = findViewById(R.id.button4);
        ActionBar actionBar = getSupportActionBar();
        ColorDrawable colorDrawable
                = new ColorDrawable(Color.parseColor("#0321CA"));
        actionBar.setBackgroundDrawable(colorDrawable);

        count.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    double A = Double.parseDouble(enterA.getText().toString());
                    double B = Double.parseDouble(enterB.getText().toString());
                    double X = Double.parseDouble(enterX.getText().toString());
                    if (X == 0 ) {
                        result.setText("Помилка, ділення на 0");
                    } else {
                        result.setText(String.format("%.2f", Math.pow((A+(B/X)),3) + Math.pow((B+(A/X)),5)));
                    }
                } catch (NumberFormatException e) {
                    TextView result = (TextView) findViewById(R.id.resout);
                    result.setText("Введіть коректні  числа");
                }
            }
        });
        readButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String txt = "4\n5\n-6";
                try {
                    example = new File("example.txt");
                    FileOutputStream fileOutput = openFileOutput(example.getName(), MODE_PRIVATE);
                    fileOutput.write(txt.getBytes());
                } catch (FileNotFoundException e) {
                    throw new RuntimeException(e);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
                try {
                    FileInputStream fileInput = openFileInput("example.txt");
                    InputStreamReader reader = new InputStreamReader(fileInput);
                    BufferedReader buffer = new BufferedReader(reader);
                    enterA.setText(buffer.readLine());
                    enterB.setText(buffer.readLine());
                    enterX.setText(buffer.readLine());

                    fileInput.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        });
    }


    public void goBack(View v) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }


}