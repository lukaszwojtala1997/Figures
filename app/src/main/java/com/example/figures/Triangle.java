package com.example.figures;

import static java.lang.Math.sqrt;

public class Triangle extends Figure{
    private double wysokosc;

    public Triangle(float wymiar){
        wysokosc = Math.round(wymiar*sqrt(3)/2*100.0)/100.0;
        this.nazwa = "trojkat";
        this.pole = Math.round(liczeniePola(wymiar)*100.0)/100.0;
    }
    @Override
    public double liczeniePola(float wymiar){
        double pole = (wysokosc*wysokosc*sqrt(3))/4;
        return pole;
    }
    public double getWysokosc() {
        return wysokosc;
    }
}
