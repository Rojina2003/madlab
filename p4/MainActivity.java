package com.example.sharedpreference;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
public class MainActivity extends AppCompatActivity {
    SharedPreferences sp;
    SharedPreferences.Editor editor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);

        sp = getSharedPreferences("UserData", MODE_PRIVATE);
        editor = sp.edit();

        setContentView(R.layout.activity_main);
        EditText name=findViewById(R.id.name);
        EditText Phno=findViewById(R.id.phNo);
        EditText Pass=findViewById(R.id.pass);
        EditText ConPass=findViewById(R.id.ConPass);
        Button btn1=findViewById(R.id.btn1);

        btn1.setOnClickListener(v -> {
            String n = name.getText().toString().trim();
            String p = Phno.getText().toString().trim();
            String pass = Pass.getText().toString().trim();
            String cpass = ConPass.getText().toString().trim();

            if (n.isEmpty()) {
                name.setError("Enter your name");
                name.requestFocus();
                return;
            }

            if (p.isEmpty()) {
                Phno.setError("Enter phone number");
                Phno.requestFocus();
                return;
            }

            if (!p.matches("[0-9]{10}")) {
                Phno.setError("Enter a valid 10-digit phone number");
                Phno.requestFocus();
                return;
            }

            if (pass.length() < 6) {
                Pass.setError("Password must be at least 6 characters");
                Pass.requestFocus();
                return;
            }

            if (cpass.isEmpty()) {
                ConPass.setError("Confirm your password");
                ConPass.requestFocus();
                return;
            }

            if (!pass.equals(cpass)) {
                ConPass.setError("Passwords do not match");
                ConPass.requestFocus();
                return;
            }

            editor.putString("Name", n);
            editor.putString("Phone", p);
            editor.putString("Password", pass);
            editor.putString("ConfirmPassword", cpass);
            editor.apply();
            Toast.makeText(MainActivity.this, "Registered Successfully", Toast.LENGTH_SHORT).show();

            Intent intent=new Intent(MainActivity.this, MainActivity2.class);
            intent.putExtra("Name",n);
            intent.putExtra("Phone",p);
            intent.putExtra("Password",pass);
            intent.putExtra("ConfirmPassword",cpass);

            startActivity(intent);
        });
    }
}