package com.example.figures;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    String cecha, pole, wymiar;
    float[] daneTrojkat;
    float[] daneKolo;
    float[] daneKwadrat;
    LinearLayout linearLayout;
    private View temp;
    ArrayList<Figure> figura = new ArrayList<Figure>();



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        figureGenerator();
    }
    public void figureGenerator()
    {
        LinearLayout linearLayour = (LinearLayout) findViewById(R.id.LinearLayout1);
        figura = generator();                         //generowanie figur
        int ilosc = figura.size();

        for (int i = 0; i < ilosc; i++) {
            if (figura.get(i).nazwa.equals("square")) {
                Square kwadrat = (Square) figura.get(i);
                LayoutInflater inflater = getLayoutInflater();
                View layout = inflater.inflate(R.layout.linear, linearLayour, false);
                registerForContextMenu(layout);
                //    linearLayout.addView(layout);

                cecha = "Diagonal:\r\n" + Double.toString(kwadrat.getPrzekatna());
                pole = Double.toString(kwadrat.pole);
                wymiar = Double.toString(kwadrat.getWymiar());


                TextView text = (TextView) layout.findViewById(R.id.textView);
                text.setText(pole);
                TextView text2 = (TextView) layout.findViewById(R.id.textView2);
                text2.setText(cecha);
                ImageView image = (ImageView) layout.findViewById(R.id.imageView2);
                image.setImageResource(R.drawable.kwadrat);
                linearLayour.addView(layout);
            } else if (figura.get(i).nazwa.equals("circle")) {
                Circle kolo = (Circle) figura.get(i);
                LayoutInflater inflater = getLayoutInflater();
                View layout = inflater.inflate(R.layout.linear, linearLayour, false);
                registerForContextMenu(layout);
                //    linearLayout.addView(layout);
                cecha = "Diameter:\r\n" + Double.toString(kolo.getSrednica());
                pole = Double.toString(kolo.pole);
                wymiar = Double.toString(kolo.getWymiar());


                TextView text = (TextView) layout.findViewById(R.id.textView);
                text.setText(pole);
                TextView text2 = (TextView) layout.findViewById(R.id.textView2);
                text2.setText(cecha);
                ImageView img = (ImageView) layout.findViewById(R.id.imageView2);
                img.setImageResource(R.drawable.kolo);
                linearLayour.addView(layout);
            } else {
                Triangle trojkat = (Triangle) figura.get(i);
                LayoutInflater inflater = getLayoutInflater();
                View layout = inflater.inflate(R.layout.linear, linearLayour, false);
                registerForContextMenu(layout);
                //    linearLayout.addView(layout);
                cecha = "Height:\r\n" + Double.toString(trojkat.getWysokosc());
                pole = Double.toString(trojkat.pole);
                wymiar = Double.toString(trojkat.getWymiar());


                TextView text = (TextView) layout.findViewById(R.id.textView);
                text.setText(pole);
                TextView text2 = (TextView) layout.findViewById(R.id.textView2);
                text2.setText(cecha);
                ImageView img = (ImageView) layout.findViewById(R.id.imageView2);
                img.setImageResource(R.drawable.trojkat);
                linearLayour.addView(layout);
            }
        }
    }

    public ArrayList<Figure> generator() {
        Intent intent = getIntent();
        int liczba1 = intent.getIntExtra("liczba1", 5);
        int liczba2 = intent.getIntExtra("liczba2", 1);
        int liczba3 = intent.getIntExtra("liczba3", 10);

        Random generator = new Random();
        float[][] losowanie = new float[liczba1][2];
        daneTrojkat = new float[3];
        daneKolo = new float[3];
        daneKwadrat = new float[3];

        for (int i = 0; i < liczba1; i = i+1) {
            losowanie[i][0] = generator.nextInt(3);
            losowanie[i][1] = (generator.nextFloat()*(liczba3-liczba2))+liczba2;;
        }
        ArrayList<Figure> figura = new ArrayList<>(liczba1);                   //tablica figur
        for (int i = 0; i < liczba1; i++) {
            if (losowanie[i][0] == 0) {
                figura.add(new Square(losowanie[i][1]));
                daneKwadrat[0] += 1;
                daneKwadrat[1] += figura.get(i).wymiar;
                daneKwadrat[2] += figura.get(i).pole;
            } else if (losowanie[i][0] == 1) {
                figura.add(new Circle(losowanie[i][1]));
                daneKolo[0] += 1;
                daneKolo[1] += figura.get(i).wymiar;
                daneKolo[2] += figura.get(i).pole;
            } else {
                figura.add(new Triangle(losowanie[i][1]));
                daneTrojkat[0] += 1;
                daneTrojkat[1] += figura.get(i).wymiar;
                daneTrojkat[2] += figura.get(i).pole;
            }
        }
        return figura;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.example_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.item1:
                Toast.makeText(this, "Statistics", Toast.LENGTH_SHORT).show();
                Intent intent2 = new Intent(this, Statistics.class);
                intent2.putExtra("daneTrojkat", daneTrojkat);
                intent2.putExtra("daneKwadrat", daneKwadrat);
                intent2.putExtra("daneKolo", daneKolo);
                this.startActivity(intent2);
                return true;
            case R.id.item2:
                Toast.makeText(this, "Author", Toast.LENGTH_SHORT).show();
                Intent intent4 = new Intent(this, Author.class);
                this.startActivity(intent4);
                return true;
            case R.id.item3:
                Toast.makeText(this, "Options", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(this, Options.class);
                this.startActivity(intent);
                return true;
            case R.id.item4:
                daneKolo[0] = 0;
                daneKolo[1] = 0;
                daneKolo[2] = 0;
                daneKwadrat[0] = 0;
                daneKwadrat[1] = 0;
                daneKwadrat[2] = 0;
                daneTrojkat[0] = 0;
                daneTrojkat[1] = 0;
                daneTrojkat[2] = 0;
                LinearLayout linearLayout1 = findViewById(R.id.LinearLayout1);
                figura.clear();
                linearLayout1.removeAllViews();
                figureGenerator();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.example2, menu);
        temp = v;
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {

        switch (item.getItemId()) {
            case R.id.delete:
                LinearLayout linearLayout2 = findViewById(R.id.LinearLayout1);
                int a = linearLayout2.indexOfChild(temp);

                linearLayout2.removeView(temp);
                figura.remove(a);

                return true;

            default:
                return true;
        }
    }

}