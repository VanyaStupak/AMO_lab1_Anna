package com.example.amo_lab1;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

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

public class ThirdTaskActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third_task);
        ActionBar actionBar = getSupportActionBar();
        ColorDrawable colorDrawable
                = new ColorDrawable(Color.parseColor("#0321CA"));
        actionBar.setBackgroundDrawable(colorDrawable);
        Button countButton = findViewById(R.id.countButton);
        EditText enterN = findViewById(R.id.enterN);
        TextView result3 = findViewById(R.id.resout3);
        Button readButton = findViewById(R.id.button6);

        countButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    int N = Integer.parseInt(enterN.getText().toString());
                    double [] a = new double[N+1];
                    double [] b = new double[N+1];
                    a[0] = 0.0;
                    b[0] = 0.0;
                    if(N < 1) {
                        result3.setText("Значення n має бути більшим або дорівнювати 1");
                    }else {
                        for (int k = 1; k < a.length; k++) {
                            a[k] = k * 10.0;
                            b[k] = k * 5.0;
                        }
                        double multiplication = 1;
                        double sum = 0;
                        for (int i = 1; i <= N; i++) {
                            multiplication *= Math.pow(a[i], 3) - Math.pow(b[i], 3);
                            sum += Math.pow(a[i], 3) + Math.pow(b[i], 3);
                        }

                        result3.setText(String.format("%.2f", multiplication + sum));
                    }
                } catch (NumberFormatException e) {
                    result3.setText("Введіть коректні числа");
                }

            }
        });
        readButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String txt = "3";
                try {
                    File file = new File("example.txt");FileOutputStream fileOutput = openFileOutput(file.getName(), MODE_PRIVATE);
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
                    enterN.setText(buffer.readLine());
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
