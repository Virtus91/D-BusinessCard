package com.example.d_businesscard;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.text.InputFilter;
import android.view.View;


public class SendAlternativeTextCd1 extends AppCompatActivity {

    private TextInputLayout textinputline1;
    private TextInputLayout textinputline2;
    private TextInputLayout textinputline3;
    private TextInputLayout textinputline4;
    private TextInputLayout textinputline5;

    private TextInputEditText textinputline1Ed;
    private TextInputEditText textinputline2Ed;
    private TextInputEditText textinputline3Ed;
    private TextInputEditText textinputline4Ed;
    private TextInputEditText textinputline5Ed;

    private String background_color_s;
    private String font_line1;
    private String font_line2;
    private String font_line3;
    private String font_line4;
    private String font_line5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_send_alternative_text_cd1);

        textinputline1 = findViewById(R.id.text_input_line1);
        textinputline2 = findViewById(R.id.text_input_line2);
        textinputline3 = findViewById(R.id.text_input_line3);
        textinputline4 = findViewById(R.id.text_input_line4);
        textinputline5 = findViewById(R.id.text_input_line5);

        textinputline1Ed = findViewById(R.id.text_input_line1Ed);
        textinputline2Ed = findViewById(R.id.text_input_line2Ed);
        textinputline3Ed = findViewById(R.id.text_input_line3Ed);
        textinputline4Ed = findViewById(R.id.text_input_line4Ed);
        textinputline5Ed = findViewById(R.id.text_input_line5Ed);

        background_color_s = getIntent().getStringExtra("background_color_s");
        font_line1 = getIntent().getStringExtra("font_line1");
        font_line2 = getIntent().getStringExtra("font_line2");
        font_line3 = getIntent().getStringExtra("font_line3");
        font_line4 = getIntent().getStringExtra("font_line4");
        font_line5 = getIntent().getStringExtra("font_line5");

        textinputline1.setCounterMaxLength(line_lenght(font_line1));
        textinputline1Ed.setFilters(new InputFilter[] { new InputFilter.LengthFilter(line_lenght(font_line1)) });

        textinputline2.setCounterMaxLength(line_lenght(font_line2));
        textinputline2Ed.setFilters(new InputFilter[] { new InputFilter.LengthFilter(line_lenght(font_line2)) });

        textinputline3.setCounterMaxLength(line_lenght(font_line3));
        textinputline3Ed.setFilters(new InputFilter[] { new InputFilter.LengthFilter(line_lenght(font_line3)) });

        textinputline4.setCounterMaxLength(line_lenght(font_line4));
        textinputline4Ed.setFilters(new InputFilter[] { new InputFilter.LengthFilter(line_lenght(font_line4)) });

        textinputline5.setCounterMaxLength(line_lenght(font_line5));
        textinputline5Ed.setFilters(new InputFilter[] { new InputFilter.LengthFilter(line_lenght(font_line5)) });



    }



    public int line_lenght (String font) {
        int len = 0;
        switch (font) {
            case "12":
                len = 40;
                break;
            case "16":
                len = 26;
                break;
            case "20":
                len = 20;
                break;
            case "24":
                len = 17;
        }
        return len;
    }


    public void ConfirmInputwtcd(View view) {
        Intent intent;
        intent = new Intent(this, SendAlternativeTextCd2.class);
        intent.putExtra("text_line1", textinputline1.getEditText().getText().toString());
        intent.putExtra("text_line2", textinputline2.getEditText().getText().toString());
        intent.putExtra("text_line3", textinputline3.getEditText().getText().toString());
        intent.putExtra("text_line4", textinputline4.getEditText().getText().toString());
        intent.putExtra("text_line5", textinputline5.getEditText().getText().toString());
        intent.putExtra("background_color_s", background_color_s);
        intent.putExtra("font_line1", font_line1);
        intent.putExtra("font_line2", font_line2);
        intent.putExtra("font_line3", font_line3);
        intent.putExtra("font_line4", font_line4);
        intent.putExtra("font_line5", font_line5);
        startActivity(intent);
    }


    public void Clear(View view) {
        textinputline1Ed.setText("");
        textinputline2Ed.setText("");
        textinputline3Ed.setText("");
        textinputline4Ed.setText("");
        textinputline5Ed.setText("");
    }
}

