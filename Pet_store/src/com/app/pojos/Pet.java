package com.app.pojos;

public class Pet {
    private int petId;
    private String name;
    private Category category;
    private double unitPrice;
    private int stocks;
    private Order[] orders;

    public Pet(int petId2, String name2, String category2, double unitPrice2, int stocks2) {
        this.petId = petId2;
        this.name = name2;
        this.unitPrice = unitPrice2;
        this.stocks = stocks2;
        // Convert the string category to a Category enum value
        this.category = Category.valueOf(category2.toUpperCase());
    }


   

	public int getPetId() {
        return petId;
    }

    public void setPetId(int petId) {
        this.petId = petId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(double unitPrice) {
        this.unitPrice = unitPrice;
    }

    public int getStocks() {
        return stocks;
    }

    public void setStocks(int stocks) {
        this.stocks = stocks;
    }

    public Order[] getOrders() {
        return orders;
    }

    public void setOrders(Order[] orders) {
        this.orders = orders;
    }

    public void setCategory(String newCategory) {
        this.category = Category.valueOf(newCategory);
    }

    public void addOrder(Order order) {
        // Increase the size of the orders array and add the new order
        Order[] newArray = new Order[orders.length + 1];
        System.arraycopy(orders, 0, newArray, 0, orders.length);
        newArray[orders.length] = order;
        orders = newArray;
    }

    @Override
    public String toString() {
        return "Pet{" +
                "petId=" + petId +
                ", name='" + name + '\'' +
                ", category=" + category +
                ", unitPrice=" + unitPrice +
                ", stocks=" + stocks +
                '}';
    }
}
