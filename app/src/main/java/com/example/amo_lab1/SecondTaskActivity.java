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

public class SecondTaskActivity extends AppCompatActivity {
    private TextView result2;
    private EditText enterI, enterX;
    private Button readButton3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second_task);
        result2 = findViewById(R.id.resout2);
        enterI = findViewById(R.id.editTextTextPersonName2);
        enterX = findViewById(R.id.editTextTextPersonName21);

        readButton3 = findViewById(R.id.input1);
        Button count2 = findViewById(R.id.count2);
        ActionBar actionBar = getSupportActionBar();
        ColorDrawable colorDrawable
                = new ColorDrawable(Color.parseColor("#0321CA"));
        actionBar.setBackgroundDrawable(colorDrawable);
        count2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    int I = Integer.parseInt(enterI.getText().toString());
                    double X = Double.parseDouble(enterX.getText().toString());
                    if(I < 0) {
                        result2.setText("Помилка! Вираз під коренем меньше 0");
                    } else {
                        int[] C = new int[I + 1];
                        for (int k = 1; k <= C.length; k++) {
                            C[k - 1] = k * 10;
                        }

                        if (I % 2 != 0) {
                            if (X == 0) {
                                result2.setText("Помилка! Ділення на 0");
                            } else if (I < 0) {
                                result2.setText("Помилка! Вираз під коренем меньше 0");
                            } else {
                                result2.setText(String.format("%.2f", 25 * Math.pow(C[I], 2) - Math.sqrt(2 * I / 34 * Math.pow(X, 2)) + 4 * Math.sqrt(I / 45 * Math.pow(X, 2))));
                            }

                        } else {
                            if (C[I] == 0) {
                                result2.setText("Помилка! Ділення на 0");
                            } else if (I < 0) {
                                result2.setText("Помилка! Вираз під коренем меньше 0");
                            } else {
                                result2.setText(String.format("%.2f", 25 * Math.pow(X, 2) - Math.sqrt(2 * I / 34 * Math.pow(C[I], 2)) + 4 * Math.sqrt(I / 45 * Math.pow(C[I], 2))));
                            }
                        }
                    }
                } catch (NumberFormatException e) {
                    TextView result2 = (TextView) findViewById(R.id.resout2);
                    result2.setText("Введіть коректні  числа");
                }
            }


        });
        readButton3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String txt = "12\n36.6";
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
                    enterI.setText(buffer.readLine());
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