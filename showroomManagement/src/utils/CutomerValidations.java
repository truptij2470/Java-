package utils;

import java.time.LocalDate;
import java.util.List;
import core.Colors;
import core.Vehicle;
import customexceptions.*;

public class CutomerValidations {

	public static Vehicle vehicleCheckValidation  (String chasisNo, String vehicleClr, int basePrice, String manufactureDate,
			String company, List<Vehicle> showroom) throws VehicleCustomExcetions {
		CheckFordupes(chasisNo,showroom);
		Colors color=convertStringToenum(vehicleClr);
		LocalDate dtDate =parseAndCheckDate(manufactureDate);
		boolean b = true;
		return new Vehicle(chasisNo,color,basePrice,dtDate,company,b);
	}

	public static LocalDate parseAndCheckDate(String manufactureDate) throws VehicleCustomExcetions {
             LocalDate dtDate =  LocalDate.parse(manufactureDate);		
             LocalDate checkDate = LocalDate.of(2020,1,1);
             if(dtDate.isBefore(checkDate))
            	 throw new VehicleCustomExcetions("invalid manufacture date .....");
            	 return dtDate;
	}

	public static Colors convertStringToenum(String vehicleClr) {
      Colors colors = Colors.valueOf(vehicleClr);
      return colors;
	}

	public static void CheckFordupes(String chasisNo,List<Vehicle>arr)throws VehicleCustomExcetions {
        		Vehicle vc = new Vehicle(chasisNo);
        		if(arr.contains(vc))
        			throw new VehicleCustomExcetions("dupe found vehicle cant be added....");
   
	}
	}
	
	

