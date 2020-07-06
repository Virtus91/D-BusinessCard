package com.example.d_businesscard;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;


import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.database.DatabaseReference;

public class SendStandardText extends AppCompatActivity {

    public static final String NULL = "";
    Button ButtonConfirmStd;
    private DatabaseReference mDatabase;

    private int counter;

    private String background_color_Std_s;

    private String font_Std_line1;
    private String font_Std_line2;
    private String font_Std_line3;
    private String font_Std_line4;
    private String font_Std_line5;

    private String text_line1Std;
    private String text_line2Std;
    private String text_line3Std;
    private String text_line4Std;
    private String text_line5Std;

    private int font_line1Int;
    private int font_line2Int;
    private int font_line3Int;
    private int font_line4Int;
    private int font_line5Int;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_send_standard_text);

        mDatabase = FirebaseDatabase.getInstance().getReference();
        load_save_counter();
        load();

        TextView textBC = (TextView) findViewById(R.id.tv1);
        textBC.setText("Selected background color: " + background_color_Std_s);

        TextView textL1 = (TextView) findViewById(R.id.tv2);
        textL1.setText("Line 1: (font " + font_Std_line1 + ") " + text_line1Std);

        TextView textL2 = (TextView) findViewById(R.id.tv3);
        textL2.setText("Line 2: (font " + font_Std_line2 + ") " + text_line2Std);

        TextView textL3 = (TextView) findViewById(R.id.tv4);
        textL3.setText("Line 3: (font " + font_Std_line3 + ") " + text_line3Std);

        TextView textL4 = (TextView) findViewById(R.id.tv5);
        textL4.setText("Line 4: (font " + font_Std_line4 + ") " + text_line4Std);

        TextView textL5 = (TextView) findViewById(R.id.tv6);
        textL5.setText("Line 5: (font " + font_Std_line5+ ") " + text_line5Std);



        ButtonConfirmStd = (Button)findViewById(R.id.ButtonSend);
        ButtonConfirmStd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                font_line1Int = Integer.parseInt(font_Std_line1);
                font_line2Int = Integer.parseInt(font_Std_line2);
                font_line3Int = Integer.parseInt(font_Std_line3);
                font_line4Int = Integer.parseInt(font_Std_line4);
                font_line5Int = Integer.parseInt(font_Std_line5);


                mDatabase.child("counter").setValue(counter);
                mDatabase.child("background_color").setValue(background_color_Std_s);
                mDatabase.child("font_line1").setValue(font_line1Int);
                mDatabase.child("font_line2").setValue(font_line2Int);
                mDatabase.child("font_line3").setValue(font_line3Int);
                mDatabase.child("font_line4").setValue(font_line4Int);
                mDatabase.child("font_line5").setValue(font_line5Int);
                mDatabase.child("text_line1").setValue(text_line1Std);
                mDatabase.child("text_line2").setValue(text_line2Std);
                mDatabase.child("text_line3").setValue(text_line3Std);
                mDatabase.child("text_line4").setValue(text_line4Std);
                mDatabase.child("text_line5").setValue(text_line5Std);

                Toast.makeText(SendStandardText.this, "Message sent", Toast.LENGTH_SHORT).show();


                Intent intent;
                intent = new Intent(SendStandardText.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }

    private void load() {
        SharedPreferences sharedPreferences = getSharedPreferences("MyData", MODE_PRIVATE);
        text_line1Std = sharedPreferences.getString("text_line1Std",NULL);
        text_line2Std = sharedPreferences.getString("text_line2Std",NULL);
        text_line3Std = sharedPreferences.getString("text_line3Std",NULL);
        text_line4Std = sharedPreferences.getString("text_line4Std",NULL);
        text_line5Std = sharedPreferences.getString("text_line5Std",NULL);

        font_Std_line1 = sharedPreferences.getString("font_Std_line1", NULL);
        font_Std_line2 = sharedPreferences.getString("font_Std_line2", NULL);
        font_Std_line3 = sharedPreferences.getString("font_Std_line3", NULL);
        font_Std_line4 = sharedPreferences.getString("font_Std_line4", NULL);
        font_Std_line5 = sharedPreferences.getString("font_Std_line5", NULL);

        background_color_Std_s = sharedPreferences.getString("background_color_Std_s", NULL);
    }

    void load_save_counter()
    {
        SharedPreferences sharedPreferences = getSharedPreferences("MyData",MODE_PRIVATE);
        counter = sharedPreferences.getInt("counter",0);
        counter+= 1;
        if (counter == 100)
            counter = 0;
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putInt("counter",counter);
        editor.commit();
    }
}