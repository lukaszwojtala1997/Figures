package com.example.figures;

import static java.lang.Math.PI;

public class Circle extends Figure{
    private double srednica;

    public Circle(float wymiar){
        srednica = Math.round(2 * wymiar *100.0)/100.0;
        this.nazwa = "circle";
        this.pole = Math.round(liczeniePola(wymiar)*100.0)/100.0;
    }

    @Override
    public double liczeniePola(float wymiar) {
        double pole;
        pole = PI* wymiar * wymiar;
        return pole;
    }

    public double getSrednica() {
        return srednica;
    }
}
