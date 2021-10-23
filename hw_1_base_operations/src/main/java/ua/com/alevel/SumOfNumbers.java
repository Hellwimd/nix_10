package ua.com.alevel;

import java.util.Scanner;

public class SumOfNumbers {

        public void calculateSumOfNumbers (){
            System.out.println("Enter any characters with numbers: ");
            Scanner sc = new Scanner (System.in);
            int sum = 0;
            String s = sc.nextLine();
            for (int i=0; i<s.length(); i++) {
                char temp = s.charAt(i);
                if (Character.isDigit(temp)) {
                    int b = Integer.parseInt(String.valueOf(temp));
                    sum = sum+b;
                }
            }
            System.out.println("Sum of Numbers is: " + sum);
        }
    }