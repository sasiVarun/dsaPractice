package library;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import org.apache.commons.lang3.RandomStringUtils;


public class Utility {
	
	
	//Function to generate random UUID
	public static String getUUID(){
		return java.util.UUID.randomUUID().toString();
	}
	
	//Function to generate random number based on maximum limit input
	public static int getRandomNumber(int max) {
		Random randomGenerator = new Random();
		int randomInt = randomGenerator.nextInt(max);
		return randomInt;	
	}
	
	//Function to generate random name
	public static Map<String, String> generateRandomName() {
		Map<String, String> name = new HashMap<String, String>();
		name.put("firstname", RandomStringUtils.randomAlphabetic(4, 10).toLowerCase());
		name.put("lastname", RandomStringUtils.randomAlphabetic(4, 10).toLowerCase());
		name.put("middlename", RandomStringUtils.randomAlphabetic(1,1).toUpperCase());
		return name;
	}
	
	//Function to retrieve random address based on State input
	public static Map<String, String> getRandomAddress(String inputState) {
		String addressLine = null;
		try {
			
			String filename = "/resources/address/address-data-" + inputState + ".csv";
			Path addressFile = Paths.get(Utility.class.getResource(filename).toURI());
			List<String> addressLines = Files.readAllLines(addressFile);
			int randomLine = (int) getRandomNumber(1,addressLines.size() - 1);
			addressLine = addressLines.get(randomLine);
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		String address[] = addressLine.split(",");
		Map<String, String> randomAddress = new HashMap<String, String>();
		randomAddress.put("addressline1", address[0]);
		randomAddress.put("addressline2", address[1]);
		randomAddress.put("city", address[2]);
		randomAddress.put("state", address[3]);
		randomAddress.put("zip", address[4]);
		
		return randomAddress;
	}

	//Function to generate random number based on minimum and maximum limit inputs
	public static long getRandomNumber(long min, long max) {
		return (long)Math.floor(Math.random() * (max - min + 1)) + min;
	}
	
	//Function to generate random License Number based on State input	
	public static String getStateLicenseNumber(String state) {	
		long random6digits = getRandomNumber(100000,999999);
		long random8digits = getRandomNumber(10000000,99999999);
		long random9digits = getRandomNumber(100000000,999999999);
		
		String finalFormat;
		
		switch(state) {
			
		case "ME":
		case "RI":
			finalFormat = String.valueOf(random6digits);
			break;
		case "CA":
			finalFormat = RandomStringUtils.randomAlphabetic(1).toUpperCase()
			+ String.valueOf(random6digits);
			break;
		case "PA":
		case "UT":
			finalFormat = String.valueOf(random8digits);
			break;
		case "TX":
		case "OH":
			finalFormat = RandomStringUtils.randomAlphabetic(2).toUpperCase()
			+ String.valueOf(random6digits);
			break;
		case "IN":
			finalFormat = RandomStringUtils.randomAlphabetic(1).toUpperCase()
			+ String.valueOf(random9digits);
			break;
		case "OK":
			finalFormat = "K" + String.valueOf(random9digits);
			break;
		default:
			finalFormat = String.valueOf(random9digits);
		}
		return finalFormat;
	}
	
	//Function to get current date
	public static Map<String, Integer> getCurrentDate() {
        int year = Calendar.getInstance().get(Calendar.YEAR);
        int month = Calendar.getInstance().get(Calendar.MONTH);
        int day = Calendar.getInstance().get(Calendar.DAY_OF_MONTH);
        
        Map<String, Integer> todayDate = new HashMap<String, Integer>();
        todayDate.put("year", year);
        todayDate.put("month", month);
        todayDate.put("day", day);
           
        return todayDate;   
	}

    public static Map<String, Integer> incrementCurrentDate (Integer day, Integer month, Integer year) {
        Calendar c = Calendar. getInstance();
        c.add (Calendar.DAY_OF_MONTH, day);
        c.add (Calendar.MONTH, month);
        c.add (Calendar.YEAR, year);
        
        Integer newDay = c.get (Calendar.DAY_OF_MONTH);
        Integer newMonth = c. get (Calendar.MONTH);
        Integer newYear = c.get (Calendar. YEAR) ;
        
        Map<String, Integer> newDate = new HashMap<String, Integer> ();
        newDate.put ("year", newYear);
        newDate.put ("month", newMonth);
        newDate.put ("day", newDay) ;

        return newDate;

    }

	public static Map<String, Integer> dateofBirth(int dobYear, int dobMonth, int dobDay) {
	
        LocalDate now = LocalDate.now() ;
        LocalDate dob = now.minusYears (dobYear).minusMonths(dobMonth).minusDays(dobDay) ;

        int year = dob.getYear();
        int month = dob.getMonthValue()-1; 
        int day = dob.getDayOfMonth() ;

        Map<String, Integer> dobDate = new HashMap<String, Integer> ();
        dobDate.put ("year", year); 
        dobDate.put ("month", month);
        dobDate. put ("day", day);

        return dobDate;
	}
  
	public static String mobileNumberFormat (String contactNumber) {
	
        long random7Digits = getRandomNumber (1000000, 9999999);
        String finalFormat;

        switch (contactNumber) {

        case "homeNumber":
        finalFormat = "214" + String.valueOf(random7Digits);
        break;

        case "cellNumber":
        finalFormat = "814" + String.valueOf(random7Digits);
        break;

        // Default 10 Digit Mobile Number

        default:
        finalFormat = String.valueOf(random7Digits) + getRandomNumber (100,999);

        }

        return finalFormat;
	}

	public static String getStates () {

	     List<String> states = null;
	
	     try{
	     String fileName="/datacreation/resources/stateList/states.csv";
	     Path stateFile = Paths.get (Utility.class.getResource(fileName).toURI());
	     states = Files.readAllLines(stateFile);
	     } 
	     catch (Exception e) 
	     {
	     e.printStackTrace();
	     }
	
	     return states.toString();
	}

    
	
	
//	public static void main(String[] args) {
//		System.out.println("LicenseNumber:" + getStateLicenseNumber("OH"));
//	}
}
