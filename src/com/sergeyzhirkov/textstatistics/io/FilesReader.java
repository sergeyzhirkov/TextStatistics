package com.sergeyzhirkov.textstatistics.io;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class FilesReader {
    private String filename;

    public FilesReader(String filename) {
        this.filename = filename;
    }

    public ArrayList<String> arrayStringsFromFile() throws IOException {
        ArrayList<String> result = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            while (reader.ready()) {
                result.add(reader.readLine());
            }
        }
        return result;
    }
}
