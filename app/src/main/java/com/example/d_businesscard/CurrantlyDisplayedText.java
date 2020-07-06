package com.example.d_businesscard;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class CurrantlyDisplayedText extends AppCompatActivity {

    private String background_color_s;

    private String font_line1;
    private String font_line2;
    private String font_line3;
    private String font_line4;
    private String font_line5;

    private String text_line1;
    private String text_line2;
    private String text_line3;
    private String text_line4;
    private String text_line5;

    private DatabaseReference mDatabase;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_currantly_displayed_text);

        mDatabase = FirebaseDatabase.getInstance().getReference();
        mDatabase.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                background_color_s = dataSnapshot.child("background_color").getValue().toString();
                font_line1 = dataSnapshot.child("font_line1").getValue().toString();
                font_line2 = dataSnapshot.child("font_line2").getValue().toString();
                font_line3 = dataSnapshot.child("font_line3").getValue().toString();
                font_line4 = dataSnapshot.child("font_line4").getValue().toString();
                font_line5 = dataSnapshot.child("font_line5").getValue().toString();
                text_line1 = dataSnapshot.child("text_line1").getValue().toString();
                text_line2 = dataSnapshot.child("text_line2").getValue().toString();
                text_line3 = dataSnapshot.child("text_line3").getValue().toString();
                text_line4 = dataSnapshot.child("text_line4").getValue().toString();
                text_line5 = dataSnapshot.child("text_line5").getValue().toString();

                TextView td_bc = (TextView) findViewById(R.id.td_bc);
                td_bc.setText("Selected background color: " + background_color_s);

                TextView td_l1 = (TextView) findViewById(R.id. td_l1);
                td_l1.setText(("Line 1: (font " + font_line1 + " ) " + text_line1));

                TextView td_l2 = (TextView) findViewById(R.id. td_l2);
                td_l2.setText(("Line 2: (font " + font_line2 + " ) " + text_line2));

                TextView td_l3 = (TextView) findViewById(R.id. td_l3);
                td_l3.setText(("Line 3: (font " + font_line3 + " ) " + text_line3));

                TextView td_l4 = (TextView) findViewById(R.id. td_l4);
                td_l4.setText(("Line 4: (font " + font_line4 + " ) " + text_line4));

                TextView td_l5 = (TextView) findViewById(R.id. td_l5);
                td_l5.setText(("Line 5: (font " + font_line5 + " ) " + text_line5));
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

    }
}
