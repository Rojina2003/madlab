package com.example.calculator1;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    float CVal1,Cval2;
    boolean add,sub,mult,div;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        TextView text = findViewById(R.id.text);
        EditText hint = findViewById(R.id.edit1);
        Button bt1 = findViewById(R.id.btn1);
        Button bt2 = findViewById(R.id.btn2);
        Button bt3 = findViewById(R.id.btn3);
        Button bt4 = findViewById(R.id.btn4);
        Button bt5 = findViewById(R.id.btn5);
        Button bt6 = findViewById(R.id.btn6);
        Button bt7 = findViewById(R.id.btn7);
        Button bt8 = findViewById(R.id.btn8);
        Button bt9 = findViewById(R.id.btn9);
        Button bt0 = findViewById(R.id.btn0);
        Button btDot = findViewById(R.id.btnDot);
        Button btDiv = findViewById(R.id.btnDiv);
        Button btAdd = findViewById(R.id.btnAdd);
        Button btMinus = findViewById(R.id.btnMinus);
        Button btMult = findViewById(R.id.btnMult);
        Button btC = findViewById(R.id.btnC);
        Button btEqual = findViewById(R.id.btnEqual);

        bt0.setOnClickListener(v -> hint.append("0"));
        bt1.setOnClickListener(view -> hint.append("1"));
        bt2.setOnClickListener(view -> hint.append("2"));
        bt3.setOnClickListener(view -> hint.append("3"));
        bt4.setOnClickListener(view -> hint.append("4"));
        bt5.setOnClickListener(view -> hint.append("5"));
        bt6.setOnClickListener(view -> hint.append("6"));
        bt7.setOnClickListener(view -> hint.append("7"));
        bt8.setOnClickListener(view -> hint.append("8"));
        bt9.setOnClickListener(view -> hint.append("9"));
        btDot.setOnClickListener(view -> hint.append("."));

        btC.setOnClickListener(view -> hint.setText(""));

        btAdd.setOnClickListener(view ->{
            CVal1 = Float.parseFloat(hint.getText().toString());
            add=true;
            hint.setText("");
        });

        btMinus.setOnClickListener(view -> {
            CVal1 = Float.parseFloat(hint.getText().toString());
            sub=true;
            hint.setText("");
        });

        btMult.setOnClickListener(view -> {
            CVal1 = Float.parseFloat(hint.getText().toString());
            mult=true;
            hint.setText("");
        });

        btDiv.setOnClickListener(view -> {
            CVal1 = Float.parseFloat(hint.getText().toString());
            div=true;
            hint.setText("");
        });

        btEqual.setOnClickListener(view -> {
            Cval2 = Float.parseFloat(hint.getText().toString());

            if (add) {
                text.setText(String.valueOf(CVal1 + Cval2));
                add = false;
            } else if (sub) {
                text.setText(String.valueOf(CVal1-Cval2));
                sub=false;
            } else if (mult) {
                text.setText(String.valueOf(CVal1*Cval2));
                mult=false;
            }  else if (div) {
                if (Cval2 != 0) {
                    text.setText(String.valueOf(CVal1 / Cval2));
                } else {
                    text.setText("Error");
                }
                div = false;
            }

        });
    }
}