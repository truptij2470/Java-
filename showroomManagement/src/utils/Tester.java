package utils;
import java.util.*;

import core.*;
import customexceptions.VehicleCustomExcetions;


public class Tester {
public static void main (String ss[]) throws VehicleCustomExcetions {
	try(Scanner sc = new Scanner(System.in)){
		List<Vehicle>vehiclearray = new ArrayList<>();
		boolean exit  = true;
		while(exit) { 
			System.out.println("enter your choice : \n1.Add a vehicle \n2.Display All \n3.Get Specific Vehicle details \n4.Apply discount \n0.Exit");
			switch(sc.nextInt()) {
			case 1: 
				System.out.println("Enter vehicle details :  chasisNo,  vehicleClr,  basePrice,  manufactureDate, company");
				Vehicle vehicle = CutomerValidations.vehicleCheckValidation(sc.next(),sc.next(),sc.nextInt(),sc.next(),sc.next(),vehiclearray);
				System.out.println("Vehicle successfully added to the shiwroom.......");
				break;
			case 2: 
				System.out.println("all vehicles are listed below;");
				for(Vehicle v:vehiclearray) {
					System.out.println(v);
					break;
					
					
					
		
				}
				}
			}
		}
		
}}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	


