package com.app.pojos;



public class Order {
    private int orderId;
    private int petId;
    private int quantity;
    private Status status;
    
    public Order(Pet orderedPet, int quantity2) {
        this.petId = orderedPet.getPetId();
        this.quantity = quantity2;
        this.status = Status.PLACED;
    }

	
	public int getOrderId() {
		return orderId;
	}
	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}
	public int getPetId() {
		return petId;
	}
	public void setPetId(int petId) {
		this.petId = petId;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public Status getStatus() {
		return status;
	}
	public void setStatus(Status status) {
		this.status = status;
	}
	public Order(int orderId, int petId, int quantity, Status status) {
		super();
		this.orderId = orderId;
		this.petId = petId;
		this.quantity = quantity;
		this.status = status;
	}
	

}
