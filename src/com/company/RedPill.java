package com.company;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class RedPill {
    public static void main(String[] args) {
        try {
            RedPill redPill = new RedPill();
            redPill.readNumbersFromFileAndFindAverage(File.FILE_FOR_NUMBERS);
            CommaAdder.addCommasBetweenIntegers(File.FILE_FOR_NUMBERS);
            redPill.displaySortedContacts(redPill.sortContacts(redPill.readContactsFromFile(File.FILE_FOR_CONTACTS_ONLY)));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public int readNumbersFromFileAndFindAverage(String fileName) throws IOException {
        List<Integer> integers = new ArrayList<>();
        var num = 0;
        var count = 0;
        try (Scanner scanner = new Scanner(new FileInputStream(fileName))) {
            while (scanner.hasNextInt()) {
                ++count;
                if (count > 99) {
                    break;
                }
                if ((num = scanner.nextInt()) > 0) {
                    integers.add(num);
                }
            }
        }
        var sum = 0;
        var result = 0;
        for (Integer integer : integers) {
            sum += integer;
        }
        result = sum / integers.size();
        return result;
    }

    public ArrayList<String> readContactsFromFile(String fileName) throws IOException {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(fileName)))) {
            String line = "";
            ArrayList<String> contacts = new ArrayList<>();
           while ((line = reader.readLine()) != null) {
                contacts.add(line);
           }
           return contacts;
        }
    }

    // Тут я сделал ставку на то что весь файл состоит из строк с контактами, если разбить же одну такую строку то
    // индекс 3 будет годом рождения т.к. 4-й элемент. Надеюсь понятно написал
    public ArrayList<String> sortContacts(ArrayList<String> contacts) {
        for (int outer = contacts.size() - 1; outer > 1; outer--) {
            for (int inner = 0; inner < outer; inner++) {
                if (Integer.parseInt(contacts.get(inner).split(" \\| ")[3])
                        < Integer.parseInt(contacts.get(inner + 1).split(" \\| ")[3])) {
                    Collections.swap(contacts, inner, inner + 1);
                }
            }
        }
        return contacts;
    }

    public void displaySortedContacts(ArrayList<String> contacts) {
        var counter = 0;
        for (String contact : contacts) {
            counter++;
            System.out.println(contact);
            if (counter == 5) {
                break;
            }
        }
    }
}
