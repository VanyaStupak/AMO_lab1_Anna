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
    private EditText enterA, enterC;
    private File example;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first_task);
        result = findViewById(R.id.resout);
        enterA = findViewById(R.id.enterA);
        enterC = findViewById(R.id.enterC);
        Button count = findViewById(R.id.count);
        Button readButton = findViewById(R.id.button4);
        ActionBar actionBar = getSupportActionBar();
        ColorDrawable colorDrawable
                = new ColorDrawable(Color.parseColor("#E10DC5"));
        actionBar.setBackgroundDrawable(colorDrawable);

        count.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    double A = Double.parseDouble(enterA.getText().toString());
                    double C = Double.parseDouble(enterC.getText().toString());
                    double sqrt = Math.sqrt(A+C);
                    double res = sqrt + 1/(A+C);
                    if (A+C == 0) {
                        result.setText("Помилка, ділення на 0");
                    } else if (A+C < 0) {
                        result.setText("Помилка, число під коренем менше 0");
                    } else {
                        result.setText(String.format("%.5f", res));
                    }
                } catch (NumberFormatException e) {
                    TextView result = (TextView) findViewById(R.id.resout);
                    result.setText("Введіть коректні числа");
                }

            }
        });
        readButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String txt = "12.5\n-9";
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
                    enterC.setText(buffer.readLine());

                    fileInput.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        });
    }


}