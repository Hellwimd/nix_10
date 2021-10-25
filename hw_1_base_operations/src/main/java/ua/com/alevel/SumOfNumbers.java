package ua.com.alevel;

import java.util.Scanner;

public class SumOfNumbers {

    public void calculateSumOfNumbers() {
        System.out.println("Enter any characters with numbers: ");
        Scanner scanner = new Scanner(System.in);
        int sum = 0;
        String input = scanner.nextLine();
        for (int i = 0; i < input.length(); i++) {
            char temp = input.charAt(i);
            if (Character.isDigit(temp)) {
                int digit = Integer.parseInt(String.valueOf(temp));
                sum = sum + digit;
            }
        }
        System.out.println("Sum of Numbers is: " + sum);
    }
}