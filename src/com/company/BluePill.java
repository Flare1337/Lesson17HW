package com.company;

import java.io.*;

public class BluePill {
    public static void main(String[] args) {
        BluePill bluePill = new BluePill();

        String message = "Hello, world!";
        Contact Annie = new Contact("Annie", "Smith", "+3512123123", 1999);
        Contact John = new Contact("John", "Reyes", "+3502123111", 1990);
        Contact Michael = new Contact("Michael", "Cox", "+3512883125", 1985);
        Contact Christie = new Contact("Christie", "Bell", "+3992123127", 2005);
        Contact Andrew = new Contact("Andrew", "Smith", "+3512993123", 1999);
        Contact Rachael = new Contact("Rachel", "Rivera", "+3512684125", 1986);
        Contact Tim = new Contact("Tim", "Henson", "+3531867234", 1995);
        Contact Steve = new Contact("George", "Orwell", "+3565423123", 1984);
        Contact Daniel = new Contact("Daniel", "Miller", "+3592368123", 1980);
        Contact Keith = new Contact("Keith", "Brann", "+3512152350", 1992);

        Contact[] contacts = new Contact[10];

        contacts[0] = Annie;
        contacts[1] = John;
        contacts[2] = Michael;
        contacts[3] = Christie;
        contacts[4] = Andrew;
        contacts[5] = Rachael;
        contacts[6] = Tim;
        contacts[7] = Steve;
        contacts[8] = Daniel;
        contacts[9] = Keith;

        try {
            bluePill.writeDataToFile(message, File.FILE_FOR_TEXT);
            bluePill.putThousandNumbersToFile(File.FILE_FOR_NUMBERS);
            CommaAdder.addCommasBetweenIntegers(File.FILE_FOR_NUMBERS);
            bluePill.writeContactsToFile(contacts, File.FILE_FOR_CONTACTS_ONLY);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void writeContactsToFile(Contact[] contacts, String fileName) throws IOException {
        try (PrintWriter writer = new PrintWriter(new FileOutputStream(fileName))) {
            var count = 0;
            for (Contact contact : contacts) {
                writer.println(contact.getFirstName() + " | " + contact.getLastName() + " | " +
                        contact.getPhoneNumber() + " | " + contact.getBirthday());
                ++count;
                if (count == 10) {
                    break;
                }
            }
        }
    }

    public void writeDataToFile(String message, String fileName) throws IOException {
        try (PrintWriter writer = new PrintWriter(new FileOutputStream(fileName))) {
            writer.println(message);
        }
    }

    public void putThousandNumbersToFile(String fileName) throws IOException {
        int number = 0;
        try (PrintWriter writer = new PrintWriter(new FileOutputStream(fileName))) {
            for (int count = 0; count < 1000; count++) {
                number = (int) (Math.random() * (1150 + 1)) - 500;
                writer.write(number);
                writer.write(" ");
            }
        }
    }
}
