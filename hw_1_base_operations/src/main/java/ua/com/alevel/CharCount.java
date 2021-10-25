package ua.com.alevel;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class CharCount {

    public void sortAndCountChars() {
        Scanner scan = new Scanner(System.in);
        System.out.print("Enter the string : ");
        String input = scan.nextLine();
        String letter;
        int[] quantity = new int[input.length()];
        HashMap<String, Integer> map = new HashMap<>();
        for (int i = 0; i < input.length(); i++) {
            if (Character.isLetter(input.charAt(i))) {
                letter = String.valueOf(input.charAt(i));
                for (int j = 0; j < input.length(); j++) {
                    if (letter.equals(String.valueOf(input.charAt(j)))) {
                        quantity[j]++;
                    }
                }
                map.put(letter, quantity[i]);
            }
        }
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            System.out.println(entry.getKey() + " - " + entry.getValue());
        }
    }
}