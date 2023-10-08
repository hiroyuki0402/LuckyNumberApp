package com.example.luckynumberapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity {

    TextView luckyNumber;
    Button shereButton;

    int number;
    String name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        luckyNumber = findViewById(R.id.textView7);
        shereButton = findViewById(R.id.button2);

        if (getIntent() != null) {
            int resultLuckyNumber = getIntent().getIntExtra("random", -1);
            number = resultLuckyNumber;
            String result = String.valueOf(resultLuckyNumber);


            String name = getIntent().getStringExtra("name");
            this.name = name;

            luckyNumber.setText(result);
        }

        shereButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                shareData(name, number);
            }
        });
    }

    public void shareData(String name, int randomNumber) {
        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.setType("text/plain");

        intent.putExtra(Intent.EXTRA_SUBJECT, name + "の今日のラッキーナンバー");
        intent.putExtra(Intent.EXTRA_TEXT, name + "のラッキーナンバーは" + randomNumber);

        startActivity(Intent.createChooser(intent, "共有先を選んでください"));
    }
}