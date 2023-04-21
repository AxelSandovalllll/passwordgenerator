package edu.guilford;

import java.util.Scanner;

public class Driver {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        System.out.println("Enter your first name: ");
        String firstName = scan.nextLine();

        System.out.println("Enter your last name: ");
        String lastName = scan.nextLine();

        System.out.println("Enter your email: ");
        String email = scan.nextLine();

        System.out.println("What is your favorite color? ");
        String color = scan.nextLine();

        System.out.println("What is your favorite number? ");
        int number = scan.nextInt();

        String password = null;

        User axel = new User(firstName, lastName, email, number, color, password);

        System.out.println(axel.generatePassword(firstName, lastName, number));

    }

}
