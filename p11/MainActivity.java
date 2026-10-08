package com.example.gridview;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    GridView gridView;
    int[] images={
            R.drawable.fr1, R.drawable.fr2,
            R.drawable.fr3,R.drawable.fr4,
            R.drawable.fr5, R.drawable.fr6
    };

    String[] names={
            "Apple","Mango","Orange","Banana","Strawberry","Cherry"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        gridView=findViewById(R.id.grid);
        ImageAdapter adapter=new ImageAdapter(this,images);
        gridView.setAdapter(adapter);
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                showAlertDialog(i);
            }
        });

    }
    private void showAlertDialog(int position){
        ImageView imageView =new ImageView(this);
        imageView.setImageResource(images[position]);
        AlertDialog.Builder builder=new AlertDialog.Builder(this);
        builder.setTitle(names[position]);
        builder.setMessage("You selected"+names[position]);
        builder.setIcon(images[position]);
        builder.setPositiveButton("Ok",null);
        builder.show();
    }
}