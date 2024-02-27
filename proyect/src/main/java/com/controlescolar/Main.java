package com.controlescolar;

import java.util.Scanner;
import modelo.Queries;
import java.sql.Connection;


public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Connection conexion = Queries.createConnection();
        boolean exit = false;
        int option = 0;
        System.out.println("Welcome to the MySQL CRUD menu!");
        while(!exit){
            System.out.println("What would you like to do?");
            System.out.println("1.- Create new career.");
            System.out.println("2.- Update existing career.");
            System.out.println("3.- Show all careers.");
            System.out.println("4.- Show a career.");
            System.out.println("5.- Delete a career.");
            System.out.println("6.- Exit.");
            option = sc.nextInt();
            switch (option) {
                case 1:
                    System.out.println("Insert a new career:");
                    sc.nextLine();
                    String rpt1 = sc.nextLine();
                    Queries.insertData(conexion, Queries.clientTable, rpt1);
                    break;
                case 2:
                    System.out.println("Insert the id of the carreer to update:");
                    sc.nextLine();
                    String id = sc.nextLine();
                    System.out.println("Insert the new name of the career:");
                    String carrera = sc.nextLine();
                    Queries.updateData(conexion, Queries.clientTable, id, carrera);
                    break;
                case 3:
                    Queries.getCarreras(conexion, Queries.clientTable);
                    break;
                case 5:
                    System.out.println("What career do you want to delete?");
                    sc.nextLine();
                    Queries.deleteRecord(conexion, Queries.clientTable, sc.nextLine());
                    break;
                case 4:
                    System.out.println("Insert career to check if it exists:");
                    sc.nextLine();
                    carrera = sc.nextLine();
                    Queries.getCarrera(conexion, Queries.clientTable, carrera);
                    break;
                case 6:
                    System.out.println("Goodbye!");
                    exit = true;
                    break;
                default:
                    System.out.println("Please select an existing option.");
                    break;
            }
        }
        sc.close();
        Queries.closeConnection(conexion);
    }
}