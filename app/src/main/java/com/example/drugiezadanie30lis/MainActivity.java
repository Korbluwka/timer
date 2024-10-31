package com.example.drugiezadanie30lis;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Button buttonGracz1;
    Button buttonGracz2;
    Gracz gracz1;
    Gracz gracz2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buttonGracz1 = findViewById(R.id.buttonGracz1);
        buttonGracz2 = findViewById(R.id.buttonGracz2);

        gracz1 = new Gracz(true,buttonGracz1);
        gracz1.startTimer();
        gracz2 = new Gracz(false, buttonGracz2);

        buttonGracz1.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        if(gracz1.czyDziala){
                            gracz1.stopTimer();
                            gracz2.startTimer();
                        }
                    }
                }
        );
        buttonGracz2.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        if(gracz2.czyDziala){
                            gracz2.stopTimer();
                            gracz1.startTimer();
                        }
                    }
                }
        );
    }
}