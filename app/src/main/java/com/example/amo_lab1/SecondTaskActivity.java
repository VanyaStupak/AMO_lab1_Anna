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
    private EditText enterI, enterX, enterC, enterD, enterH, enterP, enterQ, enterV;
    private Button readButton3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second_task);
        result2 = findViewById(R.id.resout2);
        enterI = findViewById(R.id.enterI);
        enterC = findViewById(R.id.enterC);
        enterD = findViewById(R.id.enterD);
        enterH = findViewById(R.id.enterH);
        enterP = findViewById(R.id.enterP);
        enterQ = findViewById(R.id.enterQ);
        enterV = findViewById(R.id.enterV);
        enterX = findViewById(R.id.enterX);

        readButton3 = findViewById(R.id.input1);
        Button count2 = findViewById(R.id.count2);
        ActionBar actionBar = getSupportActionBar();
        ColorDrawable colorDrawable
                = new ColorDrawable(Color.parseColor("#DA0F00"));
        actionBar.setBackgroundDrawable(colorDrawable);
        count2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    double I = Double.parseDouble(enterI.getText().toString());
                    double C = Double.parseDouble(enterC.getText().toString());
                    double D = Double.parseDouble(enterD.getText().toString());
                    double H = Double.parseDouble(enterH.getText().toString());
                    double P = Double.parseDouble(enterP.getText().toString());
                    double Q = Double.parseDouble(enterQ.getText().toString());
                    double V = Double.parseDouble(enterV.getText().toString());
                    double X = Double.parseDouble(enterX.getText().toString());
                    if (I % 3 == 0) {
                        if ((V + X) <= 0 || (C + H) <= 0) {
                            result2.setText("Помилка, ділення на 0 або вираз під коренем < 0");
                        } else {
                            double res1 = ((Math.pow(Q, I) * D) / (Math.sqrt(V + X))) + ((Math.pow(P, I) * D) / (Math.sqrt(C + H)));
                            result2.setText(String.format("%.5f", res1));


                        }
                    } else if ((Math.pow(Q, I) + X) <= 0 || (Math.pow(P, I) + H) <= 0) {

                        result2.setText("Помилка, ділення на 0 або вираз під коренем < 0");
                    } else {
                        double res2 = ((V * D) / Math.sqrt(Math.pow(Q, I) + X)) + (C * D / Math.sqrt(Math.pow(P, I) + H));
                        result2.setText(String.format("%.5f", res2));
                    }
                } catch (NumberFormatException e) {
                    TextView result2 = (TextView) findViewById(R.id.resout2);
                    result2.setText("Введіть коректні числа");

                }
            }


        });
        readButton3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String txt = "3\n36.6\n-4\n100\n29\n-34\n7.5\n43";
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
                    enterC.setText(buffer.readLine());
                    enterD.setText(buffer.readLine());
                    enterH.setText(buffer.readLine());
                    enterP.setText(buffer.readLine());
                    enterQ.setText(buffer.readLine());
                    enterV.setText(buffer.readLine());
                    enterX.setText(buffer.readLine());

                    fileInput.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        });
    }

}