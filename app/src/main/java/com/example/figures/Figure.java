package com.example.figures;

public abstract class Figure {
    float wymiar;
    String nazwa;
    double pole;

    public float getWymiar(){
        return wymiar;
    }


    public abstract double liczeniePola(float wymiar);
}
