package com.example.toggle;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    ImageView img1,img2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        img1 = findViewById(R.id.img1);
        img2 = findViewById(R.id.img2);

        img1.setOnClickListener(this::onClick);
        img2.setOnClickListener(this::onClick);

    }

    private void onClick(View view) {
        if (view.getId()==R.id.img1){
            img1.setVisibility(View.GONE);
            img2.setVisibility(View.VISIBLE);
        }
        else {
            img2.setVisibility(View.GONE);
            img1.setVisibility(View.VISIBLE);
        }
    }
}