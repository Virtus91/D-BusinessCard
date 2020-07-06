package com.example.d_businesscard;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

public class EditStandardText extends AppCompatActivity {

    Spinner spinner_Bc;
    Spinner spinner_line1Std;
    Spinner spinner_line2Std;
    Spinner spinner_line3Std;
    Spinner spinner_line4Std;
    Spinner spinner_line5Std;

    String[] backgroundColorStd = {"light", "dark"};
    String[] fontStd = {"12", "16", "20", "24"};

    String backgroundColorStdString;
    String fontStdLine1;
    String fontStdLine2;
    String fontStdLine3;
    String fontStdLine4;
    String fontStdLine5;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_standard_text);

        load_fonts();
        SharedPreferences sharedPreferences = getSharedPreferences("MyData", MODE_PRIVATE);


        spinner_Bc = findViewById( R.id.spinner_Bc);
        ArrayAdapter<String> arrayAdapter_Bc = new ArrayAdapter<>(this, R.layout.spinner_item, backgroundColorStd);
        spinner_Bc.setAdapter(arrayAdapter_Bc);
        int spinner_Bc_Value = sharedPreferences.getInt("userChoice_Bc", -1);
        if (spinner_Bc_Value != -1) {
            spinner_Bc.setSelection(spinner_Bc_Value, true);
        }
        spinner_Bc.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                backgroundColorStdString = parent.getItemAtPosition(position).toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        spinner_line1Std = findViewById(R.id.spinnerLine1Std);
        ArrayAdapter<String> arrayAdapterLine1Std = new ArrayAdapter<>(this,R.layout.spinner_item, fontStd);
        spinner_line1Std.setAdapter(arrayAdapterLine1Std);
        int spinner_line1Std_Value = sharedPreferences.getInt("userChoice_Fl1", -1);
        if (spinner_line1Std_Value != -1) {
            spinner_line1Std.setSelection(spinner_line1Std_Value, true);
        }
        spinner_line1Std.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                fontStdLine1 = parent.getItemAtPosition(position).toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        spinner_line2Std = findViewById(R. id. spinnerLine2Std);
        ArrayAdapter<String> arrayAdapterLine2Std = new ArrayAdapter<>(this, R.layout.spinner_item, fontStd);
        spinner_line2Std.setAdapter(arrayAdapterLine2Std);
        int spinner_line2Std_Value = sharedPreferences.getInt("userChoice_Fl2", -1);
        if (spinner_line2Std_Value != -1) {
            spinner_line2Std.setSelection(spinner_line2Std_Value, true);
        }
        spinner_line2Std.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                fontStdLine2 = parent.getItemAtPosition(position).toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        spinner_line3Std = findViewById(R.id. spinnerLine3Std);
        ArrayAdapter<String> arrayAdapterLine3Std = new ArrayAdapter<>(this, R.layout.spinner_item, fontStd);
        spinner_line3Std.setAdapter(arrayAdapterLine3Std);
        int spinner_line3Std_Value = sharedPreferences.getInt("userChoice_Fl3", -1);
        if (spinner_line3Std_Value != -1) {
            spinner_line3Std.setSelection(spinner_line3Std_Value, true);
        }
        spinner_line3Std.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                fontStdLine3 = parent.getItemAtPosition(position).toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        spinner_line4Std = findViewById(R.id.spinnerLine4Std);
        ArrayAdapter<String> arrayAdapterLine4Std = new ArrayAdapter<>(this, R.layout.spinner_item, fontStd);
        spinner_line4Std.setAdapter(arrayAdapterLine4Std);
        int spinner_line4Std_Value = sharedPreferences.getInt("userChoice_Fl4", -1);
        if (spinner_line4Std_Value != -1) {
            spinner_line4Std.setSelection(spinner_line4Std_Value, true);
        }
        spinner_line4Std.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                fontStdLine4 = parent.getItemAtPosition(position).toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        spinner_line5Std = findViewById(R.id.spinnerLine5Std);
        ArrayAdapter<String> arrayAdapterLine5Std = new ArrayAdapter<>(this, R.layout.spinner_item, fontStd);
        spinner_line5Std.setAdapter(arrayAdapterLine5Std);
        int spinner_line5Std_Value = sharedPreferences.getInt("userChoice_Fl5", -1);
        if (spinner_line5Std_Value != -1) {
            spinner_line5Std.setSelection(spinner_line5Std_Value, true);
        }
        spinner_line5Std.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                fontStdLine5 = parent.getItemAtPosition(position).toString();

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }

    public void BtnConfirm(View view) {
        save();
        Intent intent;
        intent = new Intent(this, SendStandardTextCd1.class);
        startActivity(intent);
    }

    private void load_fonts() {
        SharedPreferences sharedPreferences = getSharedPreferences("MyData", MODE_PRIVATE);
        backgroundColorStdString = sharedPreferences.getString("background_color_Std_s", "light");
        fontStdLine1 = sharedPreferences.getString("font_Std_line1", "12");
        fontStdLine2 = sharedPreferences.getString("font_Std_line2", "12");
        fontStdLine3 = sharedPreferences.getString("font_Std_line3", "12");
        fontStdLine4 = sharedPreferences.getString("font_Std_line4", "12");
        fontStdLine5 = sharedPreferences.getString("font_Std_line5", "12");
    }

    private void save() {
        SharedPreferences sharedPreferences = getSharedPreferences("MyData",MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("background_color_Std_s", backgroundColorStdString);
        editor.putString("font_Std_line1", fontStdLine1);
        editor.putString("font_Std_line2", fontStdLine2);
        editor.putString("font_Std_line3", fontStdLine3);
        editor.putString("font_Std_line4", fontStdLine4);
        editor.putString("font_Std_line5", fontStdLine5);

        int userChoice_Bc = spinner_Bc.getSelectedItemPosition();
        editor.putInt("userChoice_Bc", userChoice_Bc);

        int userChoice_Fl1 = spinner_line1Std.getSelectedItemPosition();
        editor.putInt("userChoice_Fl1", userChoice_Fl1);

        int userChoice_Fl2 = spinner_line2Std.getSelectedItemPosition();
        editor.putInt("userChoice_Fl2", userChoice_Fl2);

        int userChoice_Fl3 = spinner_line3Std.getSelectedItemPosition();
        editor.putInt("userChoice_Fl3", userChoice_Fl3);

        int userChoice_Fl4 = spinner_line4Std.getSelectedItemPosition();
        editor.putInt("userChoice_Fl4", userChoice_Fl4);

        int userChoice_Fl5 = spinner_line5Std.getSelectedItemPosition();
        editor.putInt("userChoice_Fl5", userChoice_Fl5);

        editor.commit();
    }
}
