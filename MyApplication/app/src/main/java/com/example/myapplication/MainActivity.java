package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Pair;

public class MainActivity  {
    public int pairNumber;
    public Predmet predmetNumber;
    public Pair modePara;
    public Predmet predmetDemo;

    public MainActivity(int pairNumber, Predmet predmetNumber, Predmet predmetDemo) {
        if(pairNumber <= 0) throw new IllegalArgumentException("Учебный день должен начинаться с 1 пары");

        this.pairNumber = pairNumber;
        this.predmetNumber = predmetNumber;
        this.predmetDemo = predmetDemo;
        modePara = Pair.Splitted;
    }

    public MainActivity(int pairNumber, Predmet pair, Pair mode) {
        this.pairNumber = pairNumber;
        modePara = mode;

        switch (mode) {
            case OnlyDenominator:
                predmetNumber = pair;
                break;
            case OnlyNumerator:
            case Both:
                predmetNumber = pair;
                break;
            default:
                throw new IllegalArgumentException("Для разделенной на числитель и знаменатель" +
                        " пары, используйте конструктор с двумя дисциплинами");
        }
    }

    public MainActivity(int pairNumber, Predmet pair) {
        this(pairNumber, pair, Pair.Both);
    }
}


