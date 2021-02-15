package com.example.figures;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Options extends AppCompatActivity {

    EditText wprowadzLiczbe1, wprowadzLiczbe2, wprowadzLiczbe3;
    Button button3, button4;
    int liczba1, liczba2, liczba3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_options);
        wprowadzLiczbe1 = (EditText) findViewById(R.id.numer1);
        wprowadzLiczbe2 = (EditText) findViewById(R.id.numer2);
        wprowadzLiczbe3 = (EditText) findViewById(R.id.numer3);
        button3 = (Button) findViewById(R.id.button3);
        button4 = findViewById(R.id.button4);


        wprowadzLiczbe1.addTextChangedListener(loginTextWatcher);
        wprowadzLiczbe2.addTextChangedListener(loginTextWatcher);
        wprowadzLiczbe3.addTextChangedListener(loginTextWatcher);

        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent3 = new Intent(Options.this, MainActivity.class);
                intent3.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent3);
            }
        });
    }
    TextWatcher loginTextWatcher = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

        }

        @Override
        public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            String numer1Input = wprowadzLiczbe1.getText().toString().trim();
            String numer2Input = wprowadzLiczbe2.getText().toString().trim();
            String numer3Input = wprowadzLiczbe3.getText().toString().trim();

            button3.setEnabled(!numer1Input.isEmpty() && !numer2Input.isEmpty() && !numer3Input.isEmpty());
            button3.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {

                    liczba1 = Integer.parseInt(wprowadzLiczbe1.getText().toString());
                    liczba2 = Integer.parseInt(wprowadzLiczbe2.getText().toString());
                    liczba3 = Integer.parseInt(wprowadzLiczbe3.getText().toString());
                    Intent intent = new Intent(Options.this, MainActivity.class);
                    intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    intent.putExtra("liczba1", liczba1);
                    intent.putExtra("liczba2", liczba2);
                    intent.putExtra("liczba3", liczba3);
                    startActivity(intent);

                }
            });
        }

        @Override
        public void afterTextChanged(Editable editable) {

        }
    };
}