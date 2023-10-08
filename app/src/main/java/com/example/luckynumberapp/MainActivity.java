package com.example.luckynumberapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Random;
import java.util.stream.LongStream;

public class MainActivity extends AppCompatActivity {

    Button button;
    EditText nameField;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button = findViewById(R.id.button);
        nameField = findViewById(R.id.editTextText);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = nameField.getText().toString();

                if (name.isEmpty()) {
                    Toast.makeText(MainActivity.this, "名前を入力してください", Toast.LENGTH_SHORT).show();
                } else {
                    Intent intent = new Intent(MainActivity.this, MainActivity2.class);
                    Random random = new Random();
                    int randomNumber = random.nextInt(100);
                    intent.putExtra("random", randomNumber);
                    intent.putExtra("name", nameField.getText().toString());
                    startActivity(intent);
                }
            }
        });

    }
}