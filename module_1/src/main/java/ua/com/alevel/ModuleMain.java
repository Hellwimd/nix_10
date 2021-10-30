package ua.com.alevel;

import ua.com.alevel.level_1.AreaOfTriangle;
import ua.com.alevel.level_1.ChessHorseMove;
import ua.com.alevel.level_1.UniqueSymbols;
import ua.com.alevel.level_2.BinaryTree;
import ua.com.alevel.level_2.Bracket;

import java.awt.*;
import java.util.Scanner;

public class ModuleMain {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Choose level (1-2) or 0 to exit from the program: ");
        String level = scanner.nextLine();
        switch (level) {
            case "1": {
                System.out.print("Enter the number of the task (1-3) or 0 to change the level: ");
                String task = scanner.nextLine();
                switch (task) {
                    case "1":
                        System.out.println("Enter string with numbers. Example: 112333 = 3: ");
                        String userInput = scanner.nextLine();
                        System.out.println(UniqueSymbols.getUniqueSymbolsCount(userInput));
                        main(new String[]{""});
                        break;
                    case "2":
                        ChessHorseMove.checkHorseMovementValidity();
                        main(new String[]{""});
                        break;
                    case "3":
                        int Ax, Ay, Bx, By, Cx, Cy;
                        System.out.println("Square of triangle");
                        System.out.println("Coordinates of point A:");
                        System.out.print("Enter x: ");
                        Ax = Integer.parseInt(scanner.nextLine());
                        System.out.print("Enter y: ");
                        Ay = Integer.parseInt(scanner.nextLine());
                        System.out.println("Coordinates of point B:");
                        System.out.print("Enter x: ");
                        Bx = Integer.parseInt(scanner.nextLine());
                        System.out.print("Enter y: ");
                        By = Integer.parseInt(scanner.nextLine());
                        System.out.println("Coordinates of point C:");
                        System.out.print("Enter x: ");
                        Cx = Integer.parseInt(scanner.nextLine());
                        System.out.print("Enter y: ");
                        Cy = Integer.parseInt(scanner.nextLine());

                        Point pointA = new Point(Ax, Ay);
                        Point pointB = new Point(Bx, By);
                        Point pointC = new Point(Cx, Cy);

                        if (AreaOfTriangle.calculateTriangle(pointA, pointB, pointC)) {
                            System.out.println("Triangle is valid.");
                        } else {
                            System.out.println("Triangle is not exist. Please, try again.");
                            return;
                        }
                        System.out.println("Square of the triangle: " + AreaOfTriangle.calcSquare(pointA, pointB, pointC));
                        main(new String[]{""});
                        break;
                    case "0":
                        main(new String[]{""});
                        break;
                }
                break;
            }
            case "2": {
                System.out.print("Enter the number of the task (1-2) or 0 to change the level: ");
                String task = scanner.nextLine();
                switch (task) {
                    case "1":
                        String typeBrackets = Bracket.CheckBracketsValidity.getTypeBrackets();
                        System.out.printf("Введите строку содержащую скобки следующих типов:%n%s", typeBrackets);
                        String userInput;
                        do {
                            userInput = scanner.nextLine();
                            if (Bracket.CheckBracketsValidity.isValidString(userInput)) {
                                System.out.println(Bracket.CheckBracketsValidity.isLegalBrackets(userInput));
                            } else if (!userInput.equals("0")) {
                                System.out.println("Введенная строка не корректна!");
                            }
                        } while (!userInput.equals("0"));
                        main(new String[]{""});
                        break;
                    case "2":
                        BinaryTree binaryTree = new BinaryTree();
                        binaryTree.outputConsole();
                        main(new String[]{""});
                        break;
                    case "0":
                        main(new String[]{""});
                        break;
                }
                break;
            }
            case "0": {
                System.exit(0);
                break;
            }
        }
    }
}