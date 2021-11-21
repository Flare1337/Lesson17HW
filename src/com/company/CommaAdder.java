package com.company;

import java.io.*;
import java.util.Scanner;

public class CommaAdder {
    public static void addCommasBetweenIntegers(String fileName) throws IOException {
        try (Scanner reader = new Scanner(new FileInputStream(fileName));
             PrintWriter writer = new PrintWriter(new FileOutputStream(fileName))) {
            char whiteSpace = ' ';
            while (reader.hasNext()) {
                char[] chars = reader.nextLine().toCharArray();
                for (char symbol : chars) {
                    if (Character.isDigit(symbol)) {
                        writer.write(symbol);
                    }
                    if (symbol == whiteSpace) {
                        writer.write(", ");
                    }
                }
            }
        }
    }
}
