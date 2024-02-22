package com.controlescolar;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean exit = false;
        int option = 0;
        System.out.println("Welcome to the MySQL CRUD menu!");
        System.out.println("What would you like to do?");
        while(!exit){
            option = sc.nextInt();
            switch (option) {
                case 1:
                    createCareer();
                    break;
                case 2:
                    updateCareer();
                    break;
                case 3:
                    readCareer();
                    break;
                case 4:
                    deleteCareer();
                    break;
                case 5:
                    System.out.println("Goodbye!");
                    exit = true;
                    break;
                default:
                    System.out.println("Please select an existing option.");
                    break;
            }
        }
    }
}