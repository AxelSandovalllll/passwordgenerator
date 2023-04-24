package edu.guilford;

public class User {
    // set attributes

    public String firstName;
    public String lastName;
    public String email;
    public int number;
    public String color;
    public String password;

    // constructor
    public User(String firstName, String lastName, String email, int number, String color, String password) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.number = number;
        this.color = color;
        this.password = password;
    }

    // getters and setters
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    // The class should have a generatePassword method that generates a password
    // (yet another attribute) that is (relatively) easy for the user to remember,
    // but hard for others to guess based on criteria that you develop
    public String generatePassword(String firstName, String lastName, String color, int number) {

        // 1. get the first letters of the firstName, makes them lowercase
        String firstLetter = firstName.substring(0, 2).toLowerCase();

        // 2.get the middle letters of lastname, uppercase, & replace "E" with "Q
        String lastLetter = lastName.substring(1, 4).toUpperCase().replace("e", "q");

        // 3. favorite number goes into password
        int randomNumber = number;

        // 4. random number between 1-100 is generated
        int rando = (int) (Math.random() * 100);

        // 5. favorite color is converted to a code
        String colorCode = color.replace("a", "69").replace("e", "efgej").replace("i", "fork").replace("o", "o00-")
                .replace("u", "210m");

        // 4. concatenate the 5 values in a random order
        String password = colorCode + rando + lastLetter + randomNumber + firstLetter;
        return password;
    }

}
