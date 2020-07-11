package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class SegundoActivity extends AppCompatActivity {
    int ments2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_segundo);

        Bundle extras = getIntent().getExtras();
        int message = extras.getInt("ments");
        TextView text = findViewById(R.id.tvMent2);

        ments2 = message;
        text.setText(Integer.toString(message));
        //suma=extras.getInt("suma");
    }
}