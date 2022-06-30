package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.app.Dialog;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class CallButton extends AppCompatActivity {

    String phoneNo = "102";
    // EditText phoneNo;
    FloatingActionButton callbtn;
    static int PERMISSION_CODE = 100;
    Dialog dialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_call_button);
        //phoneNo = findViewById(R.id.editTextPhone);
        callbtn = findViewById(R.id.callbtn);
        dialog = new Dialog(CallButton.this);
        dialog.setContentView(R.layout.custom_dialogue);
        dialog.getWindow().setBackgroundDrawable(getDrawable(R.drawable.background));
        dialog.getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT,ViewGroup.LayoutParams.WRAP_CONTENT);
        dialog.setCancelable(false);

        if(ContextCompat.checkSelfPermission(CallButton.this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED){

            ActivityCompat.requestPermissions(CallButton.this,new String[]{Manifest.permission.CALL_PHONE},PERMISSION_CODE);
        }

        Button yes = dialog.findViewById(R.id.btn_yes);
        Button no = dialog.findViewById(R.id.btn_no);

        yes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Toast.makeText(CallButton.this,"Calling now",Toast.LENGTH_SHORT).show();
                dialog.dismiss();
                String phoneno = phoneNo;
                Intent i = new Intent(Intent.ACTION_CALL);
                i.setData(Uri.parse("tel:"+phoneno));
                startActivity(i);
            }
        });

        no.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(CallButton.this, "Call cancelled", Toast.LENGTH_SHORT).show();
                dialog.dismiss();
            }
        });



        callbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.show();
            }
        });
    }
}