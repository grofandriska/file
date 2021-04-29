package hu.nive.ujratervezes.io.phonebook;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;

public class Phonebook {
    public void exportPhonebook(Map<String, String> contacts, String output) {
        try {
            if (contacts == null) {
                throw new IllegalArgumentException();
            }
            File file = new File(output);

            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file));
            for (Map.Entry<String, String> entry : contacts.entrySet()) {
                bufferedWriter.write(entry.getKey() + ": " + entry.getValue());
                bufferedWriter.newLine();
            }
            bufferedWriter.flush();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (NullPointerException e) {
            throw new IllegalArgumentException();
        }
    }
}