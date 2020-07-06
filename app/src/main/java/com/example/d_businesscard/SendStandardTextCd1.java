package com.example.d_businesscard;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.InputFilter;
import android.view.View;
import android.widget.Spinner;

import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

public class SendStandardTextCd1 extends AppCompatActivity {

    public static final String EMPTY = "";

    private TextInputLayout textinputline1Std;
    private TextInputLayout textinputline2Std;
    private TextInputLayout textinputline3Std;
    private TextInputLayout textinputline4Std;
    private TextInputLayout textinputline5Std;

    private TextInputEditText textinputline1Std_ED;
    private TextInputEditText textinputline2Std_ED;
    private TextInputEditText textinputline3Std_ED;
    private TextInputEditText textinputline4Std_ED;
    private TextInputEditText textinputline5Std_ED;

    private String font_Std_line1;
    private String font_Std_line2;
    private String font_Std_line3;
    private String font_Std_line4;
    private String font_Std_line5;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_send_standard_text_cd1);

        load_fonts();

        textinputline1Std = findViewById(R.id.text_input_line1Std);
        textinputline2Std = findViewById(R.id.text_input_line2Std);
        textinputline3Std = findViewById(R.id.text_input_line3Std);
        textinputline4Std = findViewById(R.id.text_input_line4Std);
        textinputline5Std = findViewById(R.id.text_input_line5Std);

        textinputline1Std_ED = findViewById(R.id.text_input_line1Std_ED);
        textinputline2Std_ED = findViewById(R.id.text_input_line2Std_ED);
        textinputline3Std_ED = findViewById(R.id.text_input_line3Std_ED);
        textinputline4Std_ED = findViewById(R.id.text_input_line4Std_ED);
        textinputline5Std_ED = findViewById(R.id.text_input_line5Std_ED);

        textinputline1Std.setCounterMaxLength(line_lenght(font_Std_line1));
        textinputline1Std_ED.setFilters(new InputFilter[] { new InputFilter.LengthFilter(line_lenght(font_Std_line1)) });

        textinputline2Std.setCounterMaxLength(line_lenght(font_Std_line2));
        textinputline2Std_ED.setFilters(new InputFilter[] { new InputFilter.LengthFilter(line_lenght(font_Std_line2)) });

        textinputline3Std.setCounterMaxLength(line_lenght(font_Std_line3));
        textinputline3Std_ED.setFilters(new InputFilter[] { new InputFilter.LengthFilter(line_lenght(font_Std_line3)) });

        textinputline4Std.setCounterMaxLength(line_lenght(font_Std_line4));
        textinputline4Std_ED.setFilters(new InputFilter[] { new InputFilter.LengthFilter(line_lenght(font_Std_line4)) });

        textinputline5Std.setCounterMaxLength(line_lenght(font_Std_line5));
        textinputline5Std_ED.setFilters(new InputFilter[] { new InputFilter.LengthFilter(line_lenght(font_Std_line5)) });

        load();

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

    private void load_fonts() {
        SharedPreferences sharedPreferences = getSharedPreferences("MyData", MODE_PRIVATE);
        font_Std_line1 = sharedPreferences.getString("font_Std_line1", "12");
        font_Std_line2 = sharedPreferences.getString("font_Std_line2", "12");
        font_Std_line3 = sharedPreferences.getString("font_Std_line3", "12");
        font_Std_line4 = sharedPreferences.getString("font_Std_line4", "12");
        font_Std_line5 = sharedPreferences.getString("font_Std_line5", "12");
    }

    private void load() {
        SharedPreferences sharedPreferences = getSharedPreferences("MyData", MODE_PRIVATE);

        String text_line1Std = sharedPreferences.getString("text_line1Std",EMPTY);
        String text_line2Std = sharedPreferences.getString("text_line2Std",EMPTY);
        String text_line3Std = sharedPreferences.getString("text_line3Std",EMPTY);
        String text_line4Std = sharedPreferences.getString("text_line4Std",EMPTY);
        String text_line5Std = sharedPreferences.getString("text_line5Std",EMPTY);

        textinputline1Std_ED.setText(text_line1Std);
        textinputline2Std_ED.setText(text_line2Std);
        textinputline3Std_ED.setText(text_line3Std);
        textinputline4Std_ED.setText(text_line4Std);
        textinputline5Std_ED.setText(text_line5Std);

    }

    public void ConfirmInputStd(View view) {
        save();
        Intent intent;
        intent = new Intent(this, SendStandardTextCd2.class);
        startActivity(intent);

    }

    private void save() {
        SharedPreferences sharedPreferences = getSharedPreferences("MyData",MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("text_line1Std", textinputline1Std_ED.getText().toString());
        editor.putString("text_line2Std", textinputline2Std_ED.getText().toString());
        editor.putString("text_line3Std", textinputline3Std_ED.getText().toString());
        editor.putString("text_line4Std", textinputline4Std_ED.getText().toString());
        editor.putString("text_line5Std", textinputline5Std_ED.getText().toString());
        editor.commit();
    }

    public void ClearStd(View view) {
        textinputline1Std_ED.setText("");
        textinputline2Std_ED.setText("");
        textinputline3Std_ED.setText("");
        textinputline4Std_ED.setText("");
        textinputline5Std_ED.setText("");
    }



}
