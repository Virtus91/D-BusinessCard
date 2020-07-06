package com.example.d_businesscard;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

public class SendAlternativeText extends AppCompatActivity {

    Spinner spinner_BcAlt;
    Spinner spinner_line1Alt;
    Spinner spinner_line2Alt;
    Spinner spinner_line3Alt;
    Spinner spinner_line4Alt;
    Spinner spinner_line5Alt;

    String[] backgroundColorAlt = {"light", "dark"};
    String[] fontAlt = {"12", "16", "20", "24"};

    String backgroundColorAltString;
    String fontAltLine1;
    String fontAltLine2;
    String fontAltLine3;
    String fontAltLine4;
    String fontAltLine5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_send_alternative_text);

        spinner_BcAlt = findViewById(R.id.spinner_BcAlt);
        ArrayAdapter<String> arrayAdapter_BcAlt = new ArrayAdapter<>(this,R.layout.spinner_item, backgroundColorAlt);
        spinner_BcAlt.setAdapter(arrayAdapter_BcAlt);
        spinner_BcAlt.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                backgroundColorAltString = parent.getItemAtPosition(position).toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


        spinner_line1Alt = findViewById(R.id.spinnerLine1Alt);
        ArrayAdapter<String> arrayAdapterLine1Alt = new ArrayAdapter<>(this, R.layout.spinner_item, fontAlt);
        spinner_line1Alt.setAdapter(arrayAdapterLine1Alt);
        spinner_line1Alt.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                fontAltLine1 = parent.getItemAtPosition(position).toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        spinner_line2Alt = findViewById(R.id.spinnerLine2Alt);
        ArrayAdapter<String> arrayAdapterLine2Alt = new ArrayAdapter<>(this, R.layout.spinner_item, fontAlt);
        spinner_line2Alt.setAdapter(arrayAdapterLine2Alt);
        spinner_line2Alt.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                fontAltLine2 = parent.getItemAtPosition(position).toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        spinner_line3Alt = findViewById(R.id.spinnerLine3Alt);
        ArrayAdapter<String> arrayAdapterLine3Alt = new ArrayAdapter<>(this, R.layout.spinner_item, fontAlt);
        spinner_line3Alt.setAdapter(arrayAdapterLine3Alt);
        spinner_line3Alt.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                fontAltLine3 = parent.getItemAtPosition(position).toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        spinner_line4Alt = findViewById(R.id.spinnerLine4Alt);
        ArrayAdapter<String> arrayAdapterLine4Alt = new ArrayAdapter<>(this, R.layout.spinner_item, fontAlt);
        spinner_line4Alt.setAdapter(arrayAdapterLine4Alt);
        spinner_line4Alt.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                fontAltLine4 = parent.getItemAtPosition(position).toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        spinner_line5Alt = findViewById(R.id.spinnerLine5Alt);
        ArrayAdapter<String> arrayAdapterLine5Alt = new ArrayAdapter<>(this, R.layout.spinner_item, fontAlt);
        spinner_line5Alt.setAdapter(arrayAdapterLine5Alt);
        spinner_line5Alt.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                fontAltLine5 = parent.getItemAtPosition(position).toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }

    public void Next(View view) {
        Intent intent = new Intent(this, SendAlternativeTextCd1.class);
        intent.putExtra("background_color_s", backgroundColorAltString);
        intent.putExtra("font_line1", fontAltLine1);
        intent.putExtra("font_line2", fontAltLine2);
        intent.putExtra("font_line3", fontAltLine3);
        intent.putExtra("font_line4", fontAltLine4);
        intent.putExtra("font_line5", fontAltLine5);
        startActivity(intent);
    }
}
