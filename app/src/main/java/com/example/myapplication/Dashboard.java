package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Dashboard extends AppCompatActivity {
    public CardView card1, card2,card3,card4,card5,card6;
    public Intent i1, i2, i3, i4,i5,i6;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        card1 = (CardView) findViewById(R.id.cardView1);
        card2 = (CardView) findViewById(R.id.cardView2);
        card3 = (CardView) findViewById(R.id.cardView3);
        card4 = (CardView) findViewById(R.id.cardView4);
        card5 = (CardView) findViewById(R.id.cardView5);
        card6 = (CardView) findViewById(R.id.cardView6);

        card1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                i1 = new Intent(Dashboard.this, CalendarEvent.class);
                startActivity(i1);
            }
        });
        card2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                i2 = new Intent(Dashboard.this, List.class);
                startActivity(i2);
            }
        });
        card3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                i3 = new Intent(Dashboard.this, ImageUpload.class);
                startActivity(i3);
            }
        });
        card4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                i4 = new Intent(Dashboard.this, ImageRetrieve.class);
                startActivity(i4);
            }
        });
        card5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                i5 = new Intent(Dashboard.this, MainActivity.class);
                startActivity(i5);
            }
        });
        card6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                i6 = new Intent(Dashboard.this, CallButton.class);
                startActivity(i6);
            }
        });


    }
}