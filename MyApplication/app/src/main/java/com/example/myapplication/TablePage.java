package com.example.myapplication;

import java.util.ArrayList;

public class TablePage {
    public static final int ElementCount = 7;
    public ArrayList<TableDay> days;

    public TablePage() {
        days = new ArrayList<>();
    }

    public void initializeSchedule(String[] disciplineNamings, String[] teachers) {
        Predmet[] predmets = initializePairs(disciplineNamings, teachers);

        TableDay monday = new TableDay(true);
        monday.addPair(new MainActivity(2, predmets[0]));
        monday.addPair(new MainActivity(3, predmets[1]));
        monday.addPair(new MainActivity(4, predmets[2]));
        monday.addPair(new MainActivity(5, predmets[3]));
        days.add(monday);

        TableDay tuesday = new TableDay();
        tuesday.addPair(new MainActivity(1, predmets[4]));
        tuesday.addPair(new MainActivity(2, predmets[5]));
        tuesday.addPair(new MainActivity(3, predmets[6]));
        tuesday.addPair(new MainActivity(4, predmets[7]));
        days.add(tuesday);

        TableDay wednesday = new TableDay(true);
        wednesday.addPair(new MainActivity(1, predmets[8]));
        wednesday.addPair(new MainActivity(2, predmets[1], predmets[3]));
        wednesday.addPair(new MainActivity(3, predmets[9]));
        days.add(wednesday);

        TableDay thursday = new TableDay(true);
        thursday.addPair(new MainActivity(2, predmets[8], Pair.OnlyDenominator));
        thursday.addPair(new MainActivity(3, predmets[10]));
        thursday.addPair(new MainActivity(4, predmets[6]));
        thursday.addPair(new MainActivity(5, predmets[11]));
        days.add(thursday);

        TableDay friday = new TableDay(true);
        friday.addPair(new MainActivity(1, predmets[5]));
        friday.addPair(new MainActivity(2, predmets[12]));
        friday.addPair(new MainActivity(3, predmets[10], predmets[7]));
        friday.addPair(new MainActivity(4, predmets[9], Pair.OnlyNumerator));
        days.add(friday);
    }

    private Predmet[] initializePairs(String[] disciplines, String[] teachers) {
        if (disciplines.length != teachers.length)
            throw new IllegalArgumentException("Массивы не совпадают");

        int length = disciplines.length;
        Predmet[] array = new Predmet[length];

        for (int i = 0; i < length; i++)
            array[i] = (new Predmet(disciplines[i], teachers[i]));

        return array;
    }
}

