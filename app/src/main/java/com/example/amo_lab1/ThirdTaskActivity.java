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
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class ThirdTaskActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third_task);
        ActionBar actionBar = getSupportActionBar();
        ColorDrawable colorDrawable
                = new ColorDrawable(Color.parseColor("#E10DC5"));
        actionBar.setBackgroundDrawable(colorDrawable);
        Button countButton = findViewById(R.id.countButton);
        EditText enterN = findViewById(R.id.enterN);
        TextView result3 = findViewById(R.id.resout3);
        Button readButton = findViewById(R.id.button6);
        TextView arrays = findViewById(R.id.arraystext);

        countButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    int n = Integer.parseInt(String.valueOf(enterN.getText()));
                    List<Integer> a = new ArrayList<>();
                    List<Integer> c = new ArrayList<>();
                    List<Integer> g = new ArrayList<>();

                    Random random = new Random();

                    for (int i = 0; i < n; i++) {
                        a.add(random.nextInt(10 - (-10) + 1) + (-10));
                        c.add(random.nextInt(10 - (-10) + 1) + (-10));
                        g.add(random.nextInt(10 - (-10) + 1) + (-10));
                    }
                    int f = 0;
                    arrays.setText("a = " + String.valueOf(a) +"\n" +"c = " + String.valueOf(c) + "\n" + "g = " + String.valueOf(g));
                    for (int i = 0; i < n; i++) {
                        f += Math.pow(a.get(i), 2) + (56 * c.get(i) * f * g.get(i));
                    }
                    result3.setText(String.valueOf(f));
                } catch (NumberFormatException e) {
                    result3.setText("Введіть коректнe число");
                }
            }
        });
        readButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String txt = "10";
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
