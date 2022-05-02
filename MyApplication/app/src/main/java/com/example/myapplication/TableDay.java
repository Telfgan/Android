package com.example.myapplication;

import java.util.ArrayList;

public class TableDay {
    public ArrayList<MainActivity> pairs;
    public boolean Filial = false;

    public TableDay() {
        pairs = new ArrayList<>(6);
    }

    public TableDay(boolean isOnNahimovskyFilial) {
        this();
        Filial = isOnNahimovskyFilial;
    }

    public void addPair(MainActivity viewModel) {
        for (MainActivity pair : pairs) {
            if(pair.pairNumber == viewModel.pairNumber)
                throw new IllegalArgumentException("Две пары не могут идти в одно время.");
        }

        pairs.add(viewModel);
    }
}

