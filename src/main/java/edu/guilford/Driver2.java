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
        System.out.println(axel.getFirstName() + "'s randomly generated password is: " + axel.getPassword());

        AES aes = new AES();

        //// Use the AES encryption algorithm to setKey and encrypt the password from
        //// AES.java
        aes.setKey("ThisisASecretKey");
        String strToEncrypt = axel.getPassword();
        String encryptedPassword = aes.encrypt(strToEncrypt, "ThisisASecretKey");
        System.out.println(axel.getFirstName() + "'s encrypted password is: " + encryptedPassword);

        // decrypt the password using the AES class
        String strToDecrypt = encryptedPassword;
        String decryptedPassword = aes.decrypt(strToDecrypt, "ThisisASecretKey");
        System.out.println(axel.getFirstName() + "'s decrypted password is: " + decryptedPassword +
                "\n");

        User2 bob = new User2();
        Scanner scan2 = new Scanner(System.in);
        System.out.println("What is your first name?");
        String firstName2 = scan2.nextLine();
        bob.setFirstName(firstName2);

        System.out.println("What is your last name?");
        String lastName2 = scan2.nextLine();
        bob.setLastName(lastName2);

        System.out.println("What is your favorite color?");
        String color2 = scan2.nextLine();
        bob.setColor(color2);

        System.out.println("What is your favorite number?");
        int number2 = scan2.nextInt();
        bob.setNumber(number2);

        bob.generatePassword(firstName2, lastName2, color2, number2);
        System.out.println(bob.getFirstName() + "'s randomly generated password is: " + bob.getPassword());

        aes.setKey("ThisisASecretKey");
        String strToEncrypt2 = bob.getPassword();
        String encryptedPassword2 = aes.encrypt(strToEncrypt2, "ThisisASecretKey");
        System.out.println(bob.getFirstName() + "'s encrypted password is: " + encryptedPassword2);

        // decrypt the password using the AES class
        String strToDecrypt2 = encryptedPassword2;
        String decryptedPassword2 = aes.decrypt(strToDecrypt2, "ThisisASecretKey");
        System.out.println(bob.getFirstName() + "'s decrypted password is: " + decryptedPassword2 +
                "\n");

    }

}
