package com.example.d_businesscard;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class SendAlternativeTextCd2 extends AppCompatActivity {

    Button ButtonSend;
    private DatabaseReference mDatabase;

    private int counter;
    private String text_line1;
    private String text_line2;
    private String text_line3;
    private String text_line4;
    private String text_line5;

    private String background_color_s;

    private String font_line1;
    private String font_line2;
    private String font_line3;
    private String font_line4;
    private String font_line5;

    private int font_line1Int;
    private int font_line2Int;
    private int font_line3Int;
    private int font_line4Int;
    private int font_line5Int;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_send_alternative_text_cd2);

        mDatabase = FirebaseDatabase.getInstance().getReference();

        load_save_counter();

        text_line1 = getIntent().getStringExtra("text_line1");
        text_line2 = getIntent().getStringExtra("text_line2");
        text_line3 = getIntent().getStringExtra("text_line3");
        text_line4 = getIntent().getStringExtra("text_line4");
        text_line5 = getIntent().getStringExtra("text_line5");

        background_color_s = getIntent().getStringExtra("background_color_s");

        font_line1 = getIntent().getStringExtra("font_line1");
        font_line2 = getIntent().getStringExtra("font_line2");
        font_line3 = getIntent().getStringExtra("font_line3");
        font_line4 = getIntent().getStringExtra("font_line4");
        font_line5 = getIntent().getStringExtra("font_line5");

        TextView text0 = (TextView) findViewById(R.id.textViewIdt1);
        text0.setText("Background color: " + background_color_s);

        TextView text1 = (TextView) findViewById(R.id.textViewId12);
        text1.setText("Line 1: (font " + font_line1 + " ) " + text_line1);

        TextView text2 = (TextView) findViewById(R.id.textViewId13);
        text2.setText("Line 2: (font " + font_line2 + " ) " + text_line2);

        TextView text3 = (TextView) findViewById(R.id.textViewId14);
        text3.setText("Line 3: (font " + font_line3 + " ) " + text_line3);

        TextView text4 = (TextView) findViewById(R.id.textViewId15);
        text4.setText("Line 4: (font " + font_line4 + " ) " + text_line4);

        TextView text5 = (TextView) findViewById(R.id.textViewId16);
        text5.setText("Line 5: (font " + font_line5 + " ) " + text_line5);

        ButtonSend = (Button)findViewById(R.id.ButtonSend);
        ButtonSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                font_line1Int = Integer.parseInt(font_line1);
                font_line2Int = Integer.parseInt(font_line2);
                font_line3Int = Integer.parseInt(font_line3);
                font_line4Int = Integer.parseInt(font_line4);
                font_line5Int = Integer.parseInt(font_line5);

                mDatabase.child("counter").setValue(counter);
                mDatabase.child("background_color").setValue(background_color_s);
                mDatabase.child("font_line1").setValue(font_line1Int);
                mDatabase.child("font_line2").setValue(font_line2Int);
                mDatabase.child("font_line3").setValue(font_line3Int);
                mDatabase.child("font_line4").setValue(font_line4Int);
                mDatabase.child("font_line5").setValue(font_line5Int);
                mDatabase.child("text_line1").setValue(text_line1);
                mDatabase.child("text_line2").setValue(text_line2);
                mDatabase.child("text_line3").setValue(text_line3);
                mDatabase.child("text_line4").setValue(text_line4);
                mDatabase.child("text_line5").setValue(text_line5);

                Toast.makeText(SendAlternativeTextCd2.this, "Message sent", Toast.LENGTH_SHORT).show();

                Intent intent;
                intent = new Intent(SendAlternativeTextCd2.this, MainActivity.class);
                startActivity(intent);
            }
        });

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
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

