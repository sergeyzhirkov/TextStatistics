package com.sergeyzhirkov.textstatistics.data;

public class Statistics {
    private int symbols;
    private int words;
    private int symbolsWithoutGaps;

    public Statistics(int symbols, int symbolsWithoutGaps, int words) {
        this.symbols = symbols;
        this.words = words;
        this.symbolsWithoutGaps = symbolsWithoutGaps;
    }

    public void addStatistics(Statistics statistics) {
        this.symbols = this.symbols + statistics.symbols;
        this.symbolsWithoutGaps = this.symbolsWithoutGaps + statistics.symbolsWithoutGaps;
        this.words = this.words + statistics.words;
    }

    @Override
    public String toString() {
        return "Результат:" + "\n" +
                "count symbols = " + symbols + "\n" +
                "count symbols without gaps = " + symbolsWithoutGaps + "\n" +
                "count words = " + words;
    }
}
