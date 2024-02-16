package com.app.pojoscom.app.service;


import java.util.ArrayList;
import java.util.List;

import com.app.pojos.Pet;

public class PetService {
    private List<Pet> pets;

    public PetService() {
        this.pets = new ArrayList<>();
    }

    public void addNewPet(Pet pet) {
        pets.add(pet);
        System.out.println("New pet added successfully: " + pet);
    }

    public void updatePetDetails(int petId, String newName, double newUnitPrice, int newStocks) {
        for (Pet pet : pets) {
            if (pet.getPetId() == petId) {
                pet.setName(newName);
                pet.setUnitPrice(newUnitPrice);
                pet.setStocks(newStocks);
                System.out.println("Pet details updated successfully: " + pet);
                return;
            }
        }
        System.out.println("Pet with ID " + petId + " not found.");
    }

    public Pet getPetById(int petId) {
        for (Pet pet : pets) {
            if (pet.getPetId() == petId) {
                return pet;
            }
        }
        System.out.println("Pet with ID " + petId + " not found.");
        return null;
    }

    public List<Pet> getAllPets() {
        return new ArrayList<>(pets); // Return a copy to avoid modification of the original list
    }

    public void displayAllPets() {
        if (pets.isEmpty()) {
            System.out.println("No pets available.");
            return;
        }
        System.out.println("All Available Pets:");
        for (Pet pet : pets) {
            System.out.println(pet);
        }
    }

    public void updatePetDetails(int petId, String newName, String newCategory, double newUnitPrice, int newStocks) {
        for (Pet pet : pets) {
            if (pet.getPetId() == petId) {
                pet.setName(newName);
                pet.setCategory(newCategory);
                pet.setUnitPrice(newUnitPrice);
                pet.setStocks(newStocks);
                System.out.println("Pet details updated successfully: " + pet);
                return;
            }
        }
        System.out.println("Pet with ID " + petId + " not found.");
    }
}
