package com.example.figures;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Statistics extends AppCompatActivity {

    TextView daneKwadrat;
    TextView daneKolo;
    TextView daneTrojkat;
    float[] trojkat;
    float[] kolo;
    float[] kwadrat;
    Button przycisk;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_statistics);
        daneKwadrat = (TextView) findViewById(R.id.kwadrat);
        daneKolo = (TextView) findViewById(R.id.kolo);
        daneTrojkat = (TextView) findViewById(R.id.trojkat);
        przycisk = (Button) findViewById(R.id.przycisk);

        Intent intent = getIntent();
        trojkat = intent.getFloatArrayExtra("daneTrojkat");
        kwadrat = intent.getFloatArrayExtra("daneKwadrat");
        kolo = intent.getFloatArrayExtra("daneKolo");
        String stringTrojkat = "Triangle " + "          " + (int) (trojkat[0]) + "                   " + Math.round(trojkat[2] * 100) / 100.0;
        daneTrojkat.setText(stringTrojkat);
        String stringKolo = "Circle " + "              " + (int) (kolo[0]) + "                  " + Math.round(kolo[2] * 100) / 100.0;
        daneKolo.setText(stringKolo);
        String stringKwadrat = "Square " + "           " + (int) (kwadrat[0]) + "                  " + Math.round(kwadrat[2] * 100) / 100.0;
        daneKwadrat.setText(stringKwadrat);
        przycisk.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent intent3 = new Intent(Statistics.this, MainActivity.class);
                intent3.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent3);
            }
        });
    }
}