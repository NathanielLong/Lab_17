package co.grandcircus;

import java.util.ArrayList;
import java.util.Scanner;

public class CountriesApp {

	public static void main(String[] args) {
		Scanner scnr = new Scanner(System.in);
		ArrayList<Country> countries = new ArrayList<>();
		char cont = 'y';
		int menuNumber = 0;
		String terminatedCountries;
		CountriesTextFile.createDir();
		CountriesTextFile.createOurFile();
		System.out.println("Welcome to the Countries Maintenance Application!");
		while (cont == 'y') {
			menuNumber = Validator.getInt(scnr,
					"1. See the list of countries \n2. Add a country \n3. Remove a country \n4. Exit \n \nEnter menu number: ", 1, 3);
			switch (menuNumber) {
			case 1:
				// Lists the current countries

				ArrayList<Country> countriesFromFile = CountriesTextFile.readFromFile();
				for (Country s : countriesFromFile) {
					System.out.println(s);
				}

				System.out.println("Would you like to continue? (y/n): ");
				cont = scnr.nextLine().charAt(0);
				break;
			case 2:
				// Adds a new country
				System.out.println("Please enter the name of the country: ");
				String name = scnr.nextLine();
				System.out.println("Please enter the population of the country: ");
				String population = scnr.nextLine();
				System.out.println(name + " has been added!");
				// Garbage Line
				scnr.nextLine();
				Country c = new Country(name, population);
				CountriesTextFile.writeToFile(c);
				System.out.println("Would you like to continue? (y/n): ");
				cont = scnr.nextLine().charAt(0);
				break;
//			case 3: 
//				//This removes a country
//				System.out.println("Which country would you like to remove: ");
//				terminatedCountries = scnr.nextLine();
//				//String[] countriesArray = (String[]) countries.toArray();
//				for(int i = 0; i < countries.size(); i++) {
//					
//				
//				//if(countriesArray.contains(terminatedCountries)) {
//				if(countries.get(i).getName().contains(terminatedCountries)) {
//					countries.remove(countries.get(i));
//					CountriesTextFile.updateFile(c);
//					System.out.println(terminatedCountries + " has been terminated...");
//				} else {
//					System.out.println("Country is not in the list!");
//				}
//				System.out.println("Would you like to continue? (y/n): ");
//				cont = scnr.nextLine().charAt(0);
//				}
//				break;
			default:
				System.out.println("Buh-Bye");
				cont = 'n';
				break;
			}
			
		}
		
	}

}
