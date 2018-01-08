package com.example.alexbykov.recyclerviewtestselection;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;

import com.example.alexbykov.recyclerviewtestselection.NoMaskP.NoMask;

public class MainActivity extends AppCompatActivity {


    private EditText etPhone;
    private EditText etCode;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etPhone = findViewById(R.id.et_phone);

        NoMask.with(this)
                .formatPhone(etPhone)
                .build();

    }
}
