package com.islamiclifestyle.testproject;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView tvDisplay;
    private EditText edWeight, edFut, edInche;
    private Button btn1, btn2;

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvDisplay = findViewById(R.id.tvDisplay);
        edWeight = findViewById(R.id.edWeight);
        edFut = findViewById(R.id.edFut);
        edInche = findViewById(R.id.edInche);
        btn1 = findViewById(R.id.btn1);
        btn2 = findViewById(R.id.btn2);

        btn1.setOnClickListener(v -> {

            try {
                // getText to string all editText
                String sWeight = edWeight.getText().toString();
                String sFut = edFut.getText().toString();
                String sInche = edInche.getText().toString();

                // string to float
                float ssWeight = Float.parseFloat(sWeight);
                float ssFut = Float.parseFloat(sFut);
                float ssInche = Float.parseFloat(sInche);

                float height = (float) (ssFut * 0.3048f * ssInche * 0.0254f);
                float bmi = (ssWeight/height/height);

                tvDisplay.setText("bmi- " + bmi);

            }catch (Exception e){
                Log.d("onButtonClick", "onClick: "+e.getMessage());
            }

        });


        btn2.setOnClickListener(v -> {
            edWeight.setText("");
            edFut.setText("");
            edInche.setText("");
            tvDisplay.setText("");
        });


    }
}