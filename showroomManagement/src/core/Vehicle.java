package core;

import java.time.LocalDate;



public class Vehicle {
	private String chasisNo;
	private Colors vehicleClr;
	private int basePrice;
	private LocalDate manufactureDate;
	private String company;
	private boolean available;
	public Vehicle(String chasisNo, Colors vehicleClr, int basePrice, LocalDate manufactureDate, String company,
			boolean available) {
		super();
		this.chasisNo = chasisNo;
		this.vehicleClr = vehicleClr;
		this.basePrice = basePrice;
		this.manufactureDate = manufactureDate;
		this.company = company;
		this.available = available;
	}
	public Vehicle(String chasisNo) {
		super();
		this.chasisNo = chasisNo;
	}
	public String getChasisNo() {
		return chasisNo;
	}
	public void setChasisNo(String chasisNo) {
		this.chasisNo = chasisNo;
	}
	public Colors getVehicleClr() {
		return vehicleClr;
	}
	public void setVehicleClr(Colors vehicleClr) {
		this.vehicleClr = vehicleClr;
	}
	public int getBasePrice() {
		return basePrice;
	}
	public void setBasePrice(int basePrice) {
		this.basePrice = basePrice;
	}
	public LocalDate getManufactureDate() {
		return manufactureDate;
	}
	public void setManufactureDate(LocalDate manufactureDate) {
		this.manufactureDate = manufactureDate;
	}
	public String getCompany() {
		return company;
	}
	public void setCompany(String company) {
		this.company = company;
	}
	public boolean isAvailable() {
		return available;
	}
	public void setAvailable(boolean available) {
		this.available = available;
	}

}
