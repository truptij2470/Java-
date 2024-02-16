package com.app.pojoscom.app.service;


import java.util.List;

import com.app.exception.OutOfStockException;
import com.app.pojos.Order;
import com.app.pojos.Pet;

public class OrderService {
    private List<Pet> availablePets;

    public OrderService(List<Pet> availablePets) {
        this.availablePets = availablePets;
    }

    public void placeOrder(Order order) throws OutOfStockException {
        int petId = order.getPetId();
        int quantity = order.getQuantity();

        Pet orderedPet = null;
        for (Pet pet : availablePets) {
            if (((Pet) pet).getPetId() == petId) {
                orderedPet = pet;
                break;
            }
        }

        if (orderedPet == null) {
            throw new OutOfStockException("Pet with ID " + petId + " not found.");
        }

        if (orderedPet.getStocks() < quantity) {
            throw new OutOfStockException("Insufficient stocks for pet " + orderedPet.getName());
        }

        // Update stocks
        orderedPet.setStocks(orderedPet.getStocks() - quantity);

        // Place order logic goes here
        System.out.println("Order placed successfully.");
    }


public Order getOrderById(int orderId) {
    for (Pet pet : availablePets) {
        for (Order order : pet.getOrders()) {
            if (order.getOrderId() == orderId) {
                return order;
            }
        }
    }
    System.out.println("Order with ID " + orderId + " not found.");
    return null;
}
	

}
