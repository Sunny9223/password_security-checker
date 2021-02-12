package com.company;

import java.util.Random;
import java.util.Scanner;

public class password_generator {
    public static void main(String[] args) {
        choose();
    }
    static void choose(){
        int length;
        System.out.print("Enter the length of the password:");
        Scanner sc = new Scanner(System.in);
        length = sc.nextInt();
        pass(length);
    }
    static void pass(int len){
        String small_letter = "abcdefghijklmnopqrstuvwxyz";
        String letter = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String symbol = "!@#$%^&*()_+-@{}|:?><-=[];',./";
        String number = "1234567890";
        System.out.print("Do you want to add symbols in the password?(y for yes and n for no): ");
        Scanner sc = new Scanner(System.in);
        String choose = sc.next();
        String values = null;
        switch (choose){
            case "n":
            case "N":
                values = small_letter + letter + number;
                break;
            case "y":
            case "Y":
                values = small_letter + letter + symbol + number;
                break;
            default:
                System.out.println("Enter a valid choice");
        }
        System.out.println("Generating a new password...");
        Random rand_num = new Random();
        char[] password = new char[len];
        for (int i = 0; i < len; i++) {
            password[i] = values.charAt(rand_num.nextInt(values.length()));
        }
        System.out.println(password);
        System.out.print("Do you want to regenerate a password?(y for yes and n for no):");
        String check = sc.next();
        switch (check){
            case "Y":
            case "y":
                choose();
            case "N":
            case "n":
            System.exit(0);
        }
    }
}
