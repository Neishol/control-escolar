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
            option = sc.nextInt();
            switch (option) {
                case 1:
                    System.out.println("Ingrese la carrera nueva");
                    sc.nextLine();
                    String rpt1 = sc.nextLine();
                    Queries.insertData(conexion, Queries.clientTable, rpt1);
                    break;
                case 2:
                    // Queries.updateData(conexion, Queries.clientTable, sc.nextInt(), sc.nextLine());
                    break;
                case 3:
                    Queries.getCarreras(conexion, Queries.clientTable);
                    break;
                case 4:
                    Queries.deleteRecord(conexion, Queries.clientTable, sc.nextLine());
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
        sc.close();
        Queries.closeConnection(conexion);
    }
}