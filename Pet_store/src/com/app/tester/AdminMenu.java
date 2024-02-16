package com.app.tester;



import java.util.Scanner;

import com.app.pojos.Pet;
import com.app.pojoscom.app.service.PetService;

public class AdminMenu {
    private PetService petService;

    public AdminMenu(PetService petService) {
        this.petService = petService;
    }

    public AdminMenu() {
		// TODO Auto-generated constructor stub
	}

	public void displayMenu() {
        Scanner scanner = new Scanner(System.in);
        boolean exit = false;
        while (!exit) {
            System.out.println("\nAdmin Menu:");
            System.out.println("1. Add new Pet");
            System.out.println("2. Update Pet details");
            System.out.println("3. Display all available pets");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    addNewPet(scanner);
                    break;
                case 2:
                    updatePetDetails(scanner);
                    break;
                case 3:
                    petService.displayAllPets();
                    break;
                case 4:
                    exit = true;
                    System.out.println("Exiting Admin Menu...");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private void addNewPet(Scanner scanner) {
        System.out.println("Enter Pet details:");
        System.out.print("Pet ID: ");
        int petId = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        System.out.print("Name: ");
        String name = scanner.nextLine();
        System.out.print("Category: ");
        String category = scanner.nextLine();
        System.out.print("Unit Price: ");
        double unitPrice = scanner.nextDouble();
        scanner.nextLine(); // Consume newline
        System.out.print("Stocks: ");
        int stocks = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        Pet newPet = new Pet(petId, name, category, unitPrice, stocks);
        petService.addNewPet(newPet);
    }

    private void updatePetDetails(Scanner scanner) {
        System.out.print("Enter Pet ID to update details: ");
        int petId = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        Pet existingPet = petService.getPetById(petId);
        if (existingPet != null) {
            System.out.println("Enter new details for Pet with ID " + petId + ":");
            System.out.print("Name: ");
            String newName = scanner.nextLine();
            System.out.print("Category: ");
            String newCategory = scanner.nextLine();
            System.out.print("Unit Price: ");
            double newUnitPrice = scanner.nextDouble();
            scanner.nextLine(); // Consume newline
            System.out.print("Stocks: ");
            int newStocks = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            petService.updatePetDetails(petId, newName, newCategory, newUnitPrice, newStocks);
        }
    }
}
