package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.myapplication.databinding.ActivityImageRetrieveBinding;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.storage.FileDownloadTask;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

import java.io.File;
import java.io.IOException;

public class ImageRetrieve extends AppCompatActivity {
    ActivityImageRetrieveBinding binding;
    StorageReference storageReference;
    ProgressDialog progressDialog;
    TextInputLayout name;
    TextInputLayout Lname;
    TextInputLayout number;
    TextInputLayout Date;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityImageRetrieveBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                progressDialog = new ProgressDialog(ImageRetrieve.this);
                progressDialog.setMessage("Fetching Image...");
                progressDialog.setCancelable(false);
                progressDialog.show();

                //String imageID =findViewById(R.id.editTextTextPersonName).toString().trim();
                name=findViewById(R.id.username);
                Lname=findViewById(R.id.username2);
                number=findViewById(R.id.number);
                Date=findViewById(R.id.date);
                final String user = name.getEditText().getText().toString().trim();
                final String lname = Lname.getEditText().getText().toString().trim();
                final String no = number.getEditText().getText().toString().trim();
                final String date = Date.getEditText().getText().toString().trim();
                storageReference = FirebaseStorage.getInstance().getReference("images/"+user+lname+"_"+no+"_"+date+".jpg");
                try{
                    File localfile = File.createTempFile("tempfile",".jpg");
                    storageReference.getFile(localfile).addOnSuccessListener(new OnSuccessListener<FileDownloadTask.TaskSnapshot>() {
                        @Override
                        public void onSuccess(FileDownloadTask.TaskSnapshot taskSnapshot) {
                            if(progressDialog.isShowing()){
                                progressDialog.dismiss();
                            }

                            Bitmap bitmap = BitmapFactory.decodeFile(localfile.getAbsolutePath());


                            binding.imageView.setImageBitmap(bitmap);
                        }
                    }).addOnFailureListener(new OnFailureListener() {
                        @Override
                        public void onFailure(@NonNull Exception e) {
                            if(progressDialog.isShowing()){
                                progressDialog.dismiss();
                            }
                            Toast.makeText(ImageRetrieve.this,user,Toast.LENGTH_SHORT).show();
                            //Toast.makeText(MainActivity.this,localfile.getAbsolutePath(),Toast.LENGTH_SHORT).show();
                            Toast.makeText(ImageRetrieve.this,"failed to retrieve",Toast.LENGTH_SHORT).show();
                        }
                    });

                }catch (IOException e){
                    e.printStackTrace();
                }

            }
        });





    }
}