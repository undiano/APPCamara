package com.example.cur97.mainactivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import java.io.File;
import java.io.FileOutputStream;

public class MainActivity extends AppCompatActivity {
    static final int REQUEST_IMAGE_CAPTURE = 1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button b = findViewById(R.id.boto);

        b.setOnClickListener(new View.OnClickListener() {
                                 @Override
                                 public void onClick(View v) {
                                     Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                                     if (takePictureIntent.resolveActivity(getPackageManager()) != null) {
                                         startActivityForResult(takePictureIntent, REQUEST_IMAGE_CAPTURE);
                                     }
                                 }
                             }
        );
    }
        @Override
        protected void onActivityResult(int requestCode, int resultCode, Intent data) {
            if (requestCode == REQUEST_IMAGE_CAPTURE && resultCode == RESULT_OK) {
                Bundle extras = data.getExtras();
                Bitmap imageBitmap = (Bitmap) extras.get("data");
                ImageView iv = findViewById(R.id.foto);
                iv.setImageBitmap(imageBitmap);

                String prefix;
               /* try {
                    //File image = File.createTempFile(prefix:"IMG",sufix:".jpg",directory:null);
                    FileOutputStream out = new FileOutputStream(IMAGE_FILENAME, MODE_APPEND);
                    imageBitmap.compress(Bitmap.CompressFormat.JPEG, quality:100, out);
                    Log.v(tag: "FILE_OK",msg:"Arxiu OK");
                }catch (Exception e){
                    Log.v(tag:"FILE_ERROR")
                }*/
            }
        }
    }



