package com.example.explicitintent;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main2);
        Bundle bundle= getIntent().getExtras();
        if(bundle!=null)
        {
            String imgindex=bundle.getString("ImageIndex");
            SetImage(imgindex);
        }
    }
    private void SetImage(String imgindex){
        ImageView imageView = (ImageView) findViewById(R.id.img1);
        switch (imgindex)
        {
            case"1":
            imageView.setImageResource(R.drawable.img1);
            break;
            case"2":
                imageView.setImageResource(R.drawable.img2);
                break;
            case"3":
                imageView.setImageResource(R.drawable.img3);
                break;
            case"4":
                imageView.setImageResource(R.drawable.img4);
                break;
            default:Toast.makeText(this,"image is not visible",Toast.LENGTH_SHORT).show();

        }
    }
}