package com.example.sharedpreference;

import android.os.Bundle;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main2);

        TextView usernames = findViewById(R.id.intname);
        TextView mobile = findViewById(R.id.intphn);
        TextView password = findViewById(R.id.intpass);

        String name = getIntent().getStringExtra("Name");
        String phn = getIntent().getStringExtra("Phone");
        String passd = getIntent().getStringExtra("Password");

        usernames.setText("Name: " + name);
        mobile.setText("Mobile: " + phn);
        password.setText("Password: " + passd);
    }
}