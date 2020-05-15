package com.sergeyzhirkov.textstatistics.logic;

import com.sergeyzhirkov.textstatistics.data.Statistics;

public class Text {
    private final String text;

    public Text(String text) {
        this.text = text;
    }

    public int getWordsCount() {
        return (" " + text + " ").replaceAll("[ \\p{P}]", "  ").split("[ ]\\p{LD}+[ ]").length - 1;
    }

    public int getSymbolsCount() {
        return text.length();
    }

    public int getSymbolsWithoutGapsCount() {
        return text.replaceAll(" ", "").length();
    }

    public Statistics textStatistics() {
        return new Statistics(getSymbolsCount(), getSymbolsWithoutGapsCount(), getWordsCount());
    }

}
