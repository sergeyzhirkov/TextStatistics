package com.sergeyzhirkov.textstatistics;

import com.sergeyzhirkov.textstatistics.io.FilesReader;
import com.sergeyzhirkov.textstatistics.logic.DataCollection;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    private static String fileName = "file.txt";
    private static boolean correctInput = false;

    public static void main(String[] args) {
        DataCollection dataCollection = null;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Программа для подсчёта символов и слов в тексте");
        System.out.println("Укажите источник данных и формат вывода");
        inputWelcome();
        try {
            while (!correctInput) {
                String inputString = scanner.nextLine();
                if (inputString.equals("0")) {
                    System.exit(0);
                }
                if (inputString.equals("1")) {
                    dataCollection = new DataCollection(new FilesReader(fileName).arrayStringsFromFile());
                    correctInput = true;
                }
                if (inputString.equals("2")) {
                    System.out.println("Введите текст с клавиатуры в консоль (одна строка) и нажмите ENTER");
                    ArrayList<String> arrayList = new ArrayList<>();
                    arrayList.add(scanner.nextLine());
                    dataCollection = new DataCollection(arrayList);
                    correctInput = true;
                }
                if (!correctInput) {
                    System.out.println("Ввод не корректен! попробуйте снова ->");
                    inputWelcome();
                }
            }

            correctInput = false;
            outputWelcome();
            while (!correctInput) {
                String inputString = scanner.nextLine();
                if (inputString.equals("0")) {
                    System.exit(0);
                }
                if (inputString.equals("2") || inputString.equals("3")) {
                    System.out.println(dataCollection.getStatistics().toString());
                    correctInput = true;
                }
                if (inputString.equals("1") || inputString.equals("3")) {
                    System.setOut(new PrintStream(new FileOutputStream("Statistics.txt")));
                    System.out.println(dataCollection.getStatistics().toString());
                    correctInput = true;
                }

                if (!correctInput) {
                    System.out.println("Ввод не корректен! попробуйте снова ->");
                    outputWelcome();
                }
            }
        } catch (IOException e) {
            System.out.println("Файл file.txt не найден! Создайте его в папке проекта и перезапустите программу.");
        }

        scanner.close();
    }

    public static void inputWelcome() {
        System.out.println("Введите цифру для выбора источника данных:");
        System.out.println("0 - завершить программу");
        System.out.println("1 - ввод данных из файла \"file.txt\", находящегося в корневой папке проекта");
        System.out.println("2 - ввод строки с клавиатуры");
    }

    public static void outputWelcome() {
        System.out.println("Введите цифру для выбора источника вывода данных:");
        System.out.println("0 - завершить программу без вывода");
        System.out.println("1 - вывод данных в файл \"Statistics.txt\", находящийся в корневой папке проекта");
        System.out.println("2 - вывод данных на консоль");
        System.out.println("3 - вывод данных на консоль и в файл");
    }
}
