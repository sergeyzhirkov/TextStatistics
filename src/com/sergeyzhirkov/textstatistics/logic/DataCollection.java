package com.sergeyzhirkov.textstatistics.logic;

import com.sergeyzhirkov.textstatistics.data.Statistics;

import java.util.ArrayList;

public class DataCollection {
    private ArrayList<String> arrayString;

    public DataCollection(ArrayList<String> arrayString) {
        this.arrayString = arrayString;
    }

    public Statistics getStatistics() {
        Statistics statistics = new Statistics(0, 0, 0);
        for (String s : arrayString
                ) {
            Text text = new Text(s);
            statistics.addStatistics(text.textStatistics());
        }
        return statistics;
    }
}
