package task_string_practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) {
        Main main = new Main();
       // main.getString();
        main.getPalindromeString();
    }

    private void getString() {
        String s1 = "";
        String s2 = "";

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            s1 = reader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }

        for (int i = 0; i < s1.length(); i++) {
            if (i % 2 == 0)
                s2 = s2 + s1.charAt(i);
        }
        System.out.println(s2);
    }

    private void getPalindromeString() {
        String s1 = "";
        String s2 = "";
        int i = 0;
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            s1 = reader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }

        s1 = s1.replace(" ", "");
        s1 = s1.trim();

        s2 = new StringBuilder(s1).reverse().toString();
        if (s1.equals(s2))
            System.out.println(true);
        else System.out.println(false);
    }
}
