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
                = new ColorDrawable(Color.parseColor("#DA0F00"));
        actionBar.setBackgroundDrawable(colorDrawable);
        Button countButton = findViewById(R.id.countButton);
        EditText enterN = findViewById(R.id.enterN);
        TextView result3 = findViewById(R.id.resout3);
        Button readButton = findViewById(R.id.button6);

        countButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    double n = Double.parseDouble(enterN.getText().toString());
                    if (n >= 19) {
                        result3.setText("Число занадто велике");
                    } else if (n < 1) {
                        result3.setText("Так наче не файно робити n меньше 1");
                    } else {
                        double f = 1;
                        double temp;
                        for (double a = 1; a <= n; a += 0.25) {
                            temp = 1;
                            for (double b = 1; b <= n; b++) {
                                if ((Math.pow(a, 4)) - (Math.pow(b, 4)) != 0) {
                                    temp *= ((Math.pow(a, 4)) + (Math.pow(b, 4))) / ((Math.pow(a, 4)) - (Math.pow(b, 4)));
                                }
                            }

                            f *= temp;

                        }
                        result3.setText(String.format("%.5f", f));
                    }
                } catch (NumberFormatException e) {
                    result3.setText("Введіть коректнe число");
                }

            }

        });
        readButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String txt = "3";
                try {
                    File file = new File("example.txt");
                    FileOutputStream fileOutput = openFileOutput(file.getName(), MODE_PRIVATE);
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
