package edu.guilford;

import java.util.Scanner;

public class Driver2 {
    public static void main(String[] args) {

        User2 axel = new User2();

        Scanner scan = new Scanner(System.in);

        System.out.println("Enter your first name: ");
        String firstName = scan.nextLine();
        axel.setFirstName(firstName);

        System.out.println("Enter your last name: ");
        String lastName = scan.nextLine();
        axel.setLastName(lastName);

        System.out.println("What is your favorite color? ");
        String color = scan.nextLine();
        axel.setColor(color);

        System.out.println("What is your favorite number? ");
        int number = scan.nextInt();
        axel.setNumber(number);

        axel.generatePassword(firstName, lastName, color, number);
        // print out the password
        System.out.println("Your password is: " + axel.getPassword());

        AES aes = new AES();

        //// Use the AES encryption algorithm to setKey and encrypt the password from
        //// AES.java
        aes.setKey("ThisisASecretKey");
        String strToEncrypt = axel.getPassword();
        String encryptedPassword = aes.encrypt(strToEncrypt, "ThisisASecretKey");
        System.out.println("Your encrypted password is: " + encryptedPassword);

        // decrypt the password using the AES class
        String strToDecrypt = encryptedPassword;
        String decryptedPassword = aes.decrypt(strToDecrypt, "ThisIsASecretKey");
        System.out.println("Your decrypted password is: " + decryptedPassword + "\n");

    }

}
