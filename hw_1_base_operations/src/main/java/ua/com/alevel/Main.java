package ua.com.alevel;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Select task number: ");
        Scanner scanner = new Scanner(System.in);
        int taskNumber;

        while ((taskNumber = scanner.nextInt()) != 0) {
            switch (taskNumber) {
                case 1:
                    SumOfNumbers sumOfNumbers = new SumOfNumbers();
                    sumOfNumbers.calculateSumOfNumbers();
                    System.out.println("Select task number or click on 0 for exit");

                    break;

                case 2:
                    CharCount charCount = new CharCount();
                    charCount.sortAndCountChars();
                    System.out.println("Select task number or click on 0 for exit");
                    break;

                case 3:
                    Lesson lesson = new Lesson();
                    lesson.endLesson();
                    System.out.println("Select task number or click on 0 for exit");
                    break;

                case 0:
                    System.exit(0);

                default:
                    System.out.println("Not valid task number");
            }
        }

    }
}
