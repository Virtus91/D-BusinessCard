package com.example.d_businesscard;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button buttonStd = findViewById(R.id.buttonStd);
        Button buttonEStd = findViewById(R.id.buttonEStd);
        Button buttonAlt = findViewById(R.id.buttonAlt);
        Button buttonWhat = findViewById(R.id.buttonWhat);
        Button buttonInfo = findViewById(R.id.buttonInfo);

        buttonStd.setOnClickListener(this);
        buttonEStd.setOnClickListener(this);
        buttonAlt.setOnClickListener(this);
        buttonWhat.setOnClickListener(this);
        buttonInfo.setOnClickListener(this);

    }

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    @Override
    public void onClick(View v) {
        Intent intent;
        switch (v.getId()) {
            case R.id.buttonStd:
                intent = new Intent(MainActivity.this, SendStandardText.class);
                startActivity(intent);
                break;
            case R.id.buttonEStd:
                intent = new Intent(MainActivity.this, EditStandardText.class);
                startActivity(intent);
                break;
            case R.id.buttonAlt:
                intent = new Intent(MainActivity.this, SendAlternativeText.class);
                startActivity(intent);
                break;
            case R.id.buttonWhat:
                intent = new Intent(MainActivity.this, CurrantlyDisplayedText.class);
                startActivity(intent);
                break;
            case R.id.buttonInfo:
                intent = new Intent (MainActivity.this, Info.class);
                startActivity(intent);
        }
    }
}