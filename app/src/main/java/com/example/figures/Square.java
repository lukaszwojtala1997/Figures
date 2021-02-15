package com.example.figures;

import static java.lang.Math.sqrt;

public class Square extends Figure{
    private double przekatna;

    public Square(float wymiar){
        przekatna = Math.round(wymiar * sqrt(2)*100.0)/100.0;
        this.nazwa = "square";
        this.pole = Math.round(liczeniePola(wymiar)*100.0)/100.0;
    }
    @Override
    public double liczeniePola(float wymiar) {
        return wymiar * wymiar;
    }

    public double getPrzekatna() {
        return przekatna;
    }
}
