package com.app.tester;

import com.app.exception.AuthenticationException;
import com.app.pojoscom.app.service.AuthService;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        CustomerMenu customerMenu = new CustomerMenu();
        AdminMenu adminMenu = new AdminMenu();
        AuthService authService = new AuthService();

        while (true) {
            System.out.println("Welcome to Pet Store Application!");
            System.out.println("1. Customer");
            System.out.println("2. Admin");
            System.out.println("3. Exit");

            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    customerMenu.displayMenu();
                    break;
                case 2:
                    // Admin login
                    System.out.print("Enter admin username: ");
                    String adminUsername = scanner.next();
                    System.out.print("Enter admin password: ");
                    String adminPassword = scanner.next();

                    try {
                        authService.login(adminUsername, adminPassword);
                        adminMenu.displayMenu();
                    } catch (AuthenticationException e) {
                        System.out.println("Admin login failed: " + e.getMessage());
                    }
                    break;
                case 3:
                    System.out.println("Exiting...");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
