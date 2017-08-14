package task_03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;

public class Main {
    public static void main(String[] args) {
        String input = "";
        Main main = new Main();
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            input = reader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("Maximum number of same chars in row = " + main.numberOfSameConsecutiveChars(input));
        System.out.println("Number of different letters = " + main.numberOfDifferentLetters(input));
    }

    /**
     * Finds the maximum number of same chars in row
     *
     * @param string input text
     * @return maximum number of same chars in row
     */
    private int numberOfSameConsecutiveChars(String string) {
        if (string.length() == 0) {
            return 0;
        } else {
            int currentLength = 1;
            int maxLength = 1;
            for (int i = 1; i < string.length(); i++) {
                if (string.charAt(i) == string.charAt(i - 1)) {
                    currentLength++;
                }
                if (currentLength > maxLength) {
                    maxLength = currentLength;
                }
                if (string.charAt(i) != string.charAt(i - 1)) {
                    currentLength = 1;
                }
            }
            return maxLength;
        }
    }

    /**
     * Finds number of different letters in word
     *
     * @param string input word
     * @return number of different letters
     */
    private int numberOfDifferentLetters(String string) {
        HashSet set = new HashSet<>();
        for (int i = 0; i < string.length(); i++) {
            if (Character.isAlphabetic(string.charAt(i))) {
                set.add(string.charAt(i));
            }
        }
        return set.size();
    }
}