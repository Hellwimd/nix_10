package ua.com.alevel;

import ua.com.alevel.library.ReverseLibrary;

import java.util.Scanner;

public class ReverseStringsMain {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Select your task from 1 to 3: ");
        int taskNumber = scanner.nextInt();

        switch (taskNumber) {
            case 1 -> {
                System.out.println("This task reverse your whole string");
                System.out.println("Enter your string:");
                scanner = new Scanner(System.in);
                String userString = scanner.nextLine();
                String result = ReverseLibrary.reverse(userString);
                System.out.println("Result: " + result);
                main(new String[]{""});
            }
            case 2 -> {
                System.out.println("This task reverse your substring");
                System.out.println("Enter your string:");
                scanner = new Scanner(System.in);
                String userString = scanner.nextLine();
                System.out.println("Enter substring:");
                scanner = new Scanner(System.in);
                String userSubstring = scanner.nextLine();

                String result = ReverseLibrary.reverseSubstring(userString, userSubstring);

                System.out.println("Result: " + result);
                main(new String[]{""});
            }
            case 3 -> {
                System.out.println("This task reverse your string by first and last index");
                System.out.println("Enter your string:");
                scanner = new Scanner(System.in);
                String userString = scanner.nextLine();
                System.out.println("Enter first index:");
                scanner = new Scanner(System.in);
                int firstIndex = scanner.nextInt();
                System.out.println("Enter last index:");
                scanner = new Scanner(System.in);
                int lastIndex = scanner.nextInt();

                String resultString = ReverseLibrary.reverseByFirstAndLastIndexes(userString, firstIndex, lastIndex);

                System.out.println("Result: " + resultString);
                main(new String[]{""});
            }
            default -> {
                System.out.println("Please, select correct task number");
                main(new String[]{""});
            }
        }
    }
}