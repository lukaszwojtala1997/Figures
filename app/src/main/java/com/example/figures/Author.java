package com.example.figures;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Author extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_author);
    }
    public void autor_btn(View view) {
        Intent intent10 = new Intent(Author.this, MainActivity.class);
        intent10.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(intent10);
    }
}