package com.app.tester;


import com.app.exception.AuthenticationException;
import com.app.exception.AuthorizationException;
import com.app.exception.OutOfStockException;
import com.app.pojos.Order;
import com.app.pojos.Pet;
import com.app.pojoscom.app.service.OrderService;
import com.app.pojoscom.app.service.PetService;

import java.util.List;
import java.util.Scanner;

public class CustomerMenu {
    private  PetService petService;
    private  OrderService orderService;
    private  String loginId;
    private  String password;

    public CustomerMenu(PetService petService, OrderService orderService, String loginId, String password) {
        this.petService = petService;
        this.orderService = orderService;
        this.loginId = loginId;
        this.password = password;
    }

	public CustomerMenu() {
		super();
	}

	public void displayMenu() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome, Customer!");
        System.out.print("Enter your login ID: ");
        String enteredLoginId = scanner.nextLine();
        System.out.print("Enter your password: ");
        String enteredPassword = scanner.nextLine();

        if (!enteredLoginId.equals(loginId) || !enteredPassword.equals(password)) {
            System.out.println("Invalid login credentials.");
            return;
        }

        while (true) {
            System.out.println("\nCustomer Menu:");
            System.out.println("1. Browse Pets");
            System.out.println("2. Order a Pet");
            System.out.println("3. Check Order Status");
            System.out.println("4. Exit");

            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    browsePets();
                    break;
                case 2:
                    orderPet(scanner);
                    break;
                case 3:
                    checkOrderStatus(scanner);
                    break;
                case 4:
                    System.out.println("Exiting Customer Menu...");
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private void browsePets() {
        List<Pet> availablePets = petService.getAllPets();
        if (availablePets.isEmpty()) {
            System.out.println("No pets available.");
        } else {
            System.out.println("Available Pets:");
            for (Pet pet : availablePets) {
                System.out.println(pet);
            }
        }
    }

    private void orderPet(Scanner scanner) {
        System.out.print("Enter the ID of the pet you want to order: ");
        int petId = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        System.out.print("Enter the quantity: ");
        int quantity = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        try {
            Pet orderedPet = petService.getPetById(petId);
            if (orderedPet != null) {
                Order order = new Order(orderedPet, quantity);
                orderService.placeOrder(order);
            }
        } catch (OutOfStockException e) {
            System.out.println(e.getMessage());
        }
    }

    private void checkOrderStatus(Scanner scanner) {
        System.out.print("Enter your order ID: ");
        int orderId = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        Order order = orderService.getOrderById(orderId);
        if (order != null) {
            System.out.println("Order Details:");
            System.out.println(order);
        } else {
            System.out.println("Order with ID " + orderId + " not found.");
        }
    }
}
