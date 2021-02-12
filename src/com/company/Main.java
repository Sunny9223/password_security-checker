package com.company;
import java.util.Scanner;
class Main {

    public static void main(String[] args) {

        String inputPassword;
        Scanner input = new Scanner(System.in);

        System.out.print("Password: ");
        inputPassword = input.next();
        String name = PassCheck(inputPassword);
        System.out.println(name);
        System.out.println();
        if (name.equals("Not Enough Numbers in Password!") || name.equals("Not Enough Capital Letters in Password!") || name.equals("Not Enough special characters in Password!") || name.equals("Password is Too Short!")) {
            System.out.print("Do you want to generate a new password?(y for yes and n for no:)");
            String choice = input.next();
            switch (choice) {
                case "y", "Y" -> {
                    password_generator obj = new password_generator();
                    obj.choose();
                }
                case "n", "N" -> System.exit(0);
                default -> System.out.println("Error!");
            }
        } else if (name.equals("Valid Password")) {
            System.out.println("Your password is secured. You can make it more secure by using leet mode. Do you want to try leet mode?");
            String take = input.next();
            switch (take) {
                case "Y":
                case "y":
                    //valid code
                    leetConverter(inputPassword);
                case "N":
                case "n":
                    System.exit(0);
            }
        }

        main(args);

    }

    public static void leetConverter(String name) {
        System.out.println("Converting your password...");
        name = name.replace("s", "$");
        name = name.replace("a", "@");
        name = name.replace("b", "13");
        name = name.replace("e", "3");
        name = name.replace("o", "0");
        name = name.replace("i", "1");
        name = name.replace("I", "|");
        System.out.println("Your converted password is " + name);
    }

    public static String PassCheck(String Password) {

        String result = "Valid Password";
        int length = 0;
        int numCount = 0;
        int capCount = 0;
        int specialCharacters = 0;

        for (int x = 0; x < Password.length(); x++) {
            if ((Password.charAt(x) >= 47 && Password.charAt(x) <= 58) || (Password.charAt(x) >= 58 && Password.charAt(x) <= 65) || (Password.charAt(x) >= 33 && Password.charAt(x) <= 46) || (Password.charAt(x) >= 64 && Password.charAt(x) <= 91) ||
                    (Password.charAt(x) >= 97 && Password.charAt(x) <= 122)) {
                //Keep the Password
            } else {
                result = "Password Contains Invalid Character!";
            }

            if ((Password.charAt(x) > 47 && Password.charAt(x) < 58)) {
                numCount++;
            }

            if ((Password.charAt(x) > 64 && Password.charAt(x) < 91)) {
                capCount++;
            }
            if (Password.charAt(x) > 32 && Password.charAt(x) < 47) {
                specialCharacters++;
            }
            if (Password.charAt(x) > 58 && Password.charAt(x) <= 64) {
                specialCharacters++;
            }
            length = (x + 1);
        }
        if (numCount < 2) {
            result = "Not Enough Numbers in Password!";
        }
        if (capCount < 1) {
            result = "Not Enough Capital Letters in Password!";
        }
        if (specialCharacters < 1) {
            result = "Not Enough special characters in Password!";
        }
        if (length < 8) {
            result = "Password is Too Short!";
        }
        return (result);
    }
}