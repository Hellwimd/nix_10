package ua.com.alevel.controller;

import ua.com.alevel.entity.Elephant;
import ua.com.alevel.service.ElephantServiceImpl;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ElephantController {

    private final ElephantServiceImpl elephantServiceImpl = new ElephantServiceImpl();
    private Scanner scanner = new Scanner(System.in);

    public ElephantController() {
        System.out.println("Available options:");
        runNavigation();
        run();
    }

    public void run() {
        try {
            scanner = new Scanner(System.in);
            int position;
            while ((position = scanner.nextInt()) != 0) {
                crud(position);
            }
        } catch (InputMismatchException ex) {
            run();
        }
    }

    private void runNavigation() {
        System.out.println();
        System.out.println(" - if you want to create Elephant, please enter 1");
        System.out.println(" - if you want to update Elephant, please enter 2");
        System.out.println(" - if you want to delete Elephant, please enter 3");
        System.out.println(" - if you want to findById Elephant, please enter 4");
        System.out.println(" - if you want to findAll Elephants, please enter 5");
        System.out.println(" - if you want to exit, please enter 0");
        System.out.println();
    }

    private void crud(int position) {
        switch (position) {
            case 1:
                create();
                break;
            case 2:
                update();
                break;
            case 3:
                delete();
                break;
            case 4:
                findById();
                break;
            case 5:
                findAll();
                break;
            case 0:
                System.exit(0);
                break;

        }
        System.out.println("*********************************************");
        System.out.println("Choose an option, or enter 0 for exit program");
    }

    private void create() {
        try {
            System.out.println("Please, enter Elephant name");
            scanner = new Scanner(System.in);
            String elephantName = scanner.nextLine();
            System.out.println("Please, enter Elephant weight");
            int elephantWeight = scanner.nextInt();
            System.out.println("Please, enter Elephant age");
            int elephantAge = scanner.nextInt();

            Elephant elephant = new Elephant();
            elephant.setAge(elephantAge);
            elephant.setName(elephantName);
            elephant.setWeight(elephantWeight);

            elephantServiceImpl.create(elephant);
        } catch (InputMismatchException ex) {
            System.out.println("invalid value, please try again");
        }
    }

    private void update() {
        try {
            System.out.println("Please, enter Elephant id to update");
            Long id = scanner.nextLong();
            System.out.println("Please, enter new Elephant name");
            scanner = new Scanner(System.in);
            String name = scanner.nextLine();
            System.out.println("Please, enter new Elephant weight");
            int weight = scanner.nextInt();
            System.out.println("Please, enter new Elephant age");
            int age = scanner.nextInt();

            Elephant elephant = new Elephant();
            elephant.setId(id);
            elephant.setName(name);
            elephant.setWeight(weight);
            elephant.setAge(age);

            elephantServiceImpl.update(elephant);
        } catch (InputMismatchException ex) {
            System.out.println("invalid value, please try again");
        }

    }

    private void delete() {
        System.out.println("Please, enter id");
        Long id = scanner.nextLong();

        elephantServiceImpl.delete(id);
        System.out.println("Elephant at " + id + " id successfully deleted");
    }

    private void findById() {
        System.out.println("Please, enter Elephant id");
        Long id = scanner.nextLong();

        Elephant elephant = elephantServiceImpl.findById(id);
        System.out.println("Elephant = " + elephant);
    }

    private void findAll() {
        Elephant[] elephants = elephantServiceImpl.findAll();
        if (elephants != null && elephants.length != 0) {
            for (Elephant elephant : elephants) {
                System.out.println(elephant);
            }
        } else {
            System.out.println("Elephants not found");
        }
    }
}
