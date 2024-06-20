package com.example.myapplication2;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.widget.ImageView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.io.InputStream;

public class FullImageView extends AppCompatActivity {
    ImageView full_image;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_full_image_view);

        full_image = findViewById(R.id.full_image);
        String imageUriStr = getIntent().getStringExtra("image");
        Uri imageUri = Uri.parse(imageUriStr);
        try {
            InputStream imageStream = getContentResolver().openInputStream(imageUri);
            Bitmap selectedItem = BitmapFactory.decodeStream(imageStream);
            full_image.setImageBitmap(selectedItem);

        }catch (Exception e){
            e.printStackTrace();
        }

    }
}