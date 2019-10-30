package co.grandcircus;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

public class CountriesTextFile {

	public static void createOurFile() {
		String fileName = "countries.txt";

		Path path = Paths.get("resources", fileName);

		if (Files.notExists(path)) {
			try {
				Files.createFile(path);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				System.out.println("Something went terribly wrong!");
			}
		} else {

		}

	}
	
	public static void writeToFile(Country c) {
		String fileName = "countries.txt";

		Path path = Paths.get("resources", fileName);

		File file = path.toFile();
		PrintWriter output = null;

		try {
			output = new PrintWriter(new FileOutputStream(file, true));
			output.println(c);
			output.close();
		} catch (FileNotFoundException e) {
			System.out.println("Hey, contact customer service!");
		} finally {
			output.close();
		}
	}
	
	public static ArrayList<Country> readFromFile() {
		String fileName = "countries.txt";
		ArrayList<Country> countries = new ArrayList<>();
		Path path = Paths.get("resources", fileName);
		File file = path.toFile();
		try {
			BufferedReader br = new BufferedReader(new FileReader(file));

			String line = br.readLine();
			while (line != null) {
				// 1.
				String[] studentValues = line.split(" ");
				// 2.
				Country s = new Country(studentValues[0], (studentValues[1]));
				// 3.
				countries.add(s);
				line = br.readLine();
			}

			br.close();
		} catch (FileNotFoundException e) {

			System.out.println("Something went wrong with your file...");
		} catch (IOException e) {

			System.out.println("Something went wrong while reading from the file...");
		}
		return countries;
	}
	
	public static void createDir() {
		// Create a string representing the name of the folder
		// that we want to create or verify that it already exists
		String dirPath = "resources";

		// This next line will turn the string reference above
		// into a path to use with the other file methods
		Path folder = Paths.get(dirPath);

		// This Files.notExists() method is checking to make sure that
		// the folder is not already there, otherwise it will create a new folder
		if (Files.notExists(folder)) {
			try {
				Files.createDirectories(folder);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				System.out.println("Somethig went wrong with the folder creation");
			}
		} else {
		}
	}
	
	public static void updateFile(Country c) {
		String fileName = "countries.txt";

		Path path = Paths.get("resources", fileName);

		File file = path.toFile();
		PrintWriter output = null;

		try {
			output = new PrintWriter(new FileOutputStream(file, false));
			output.println(c);
			output.close();
		} catch (FileNotFoundException e) {
			System.out.println("Hey, contact customer service!");
		} finally {
			output.close();
		}
	}
}
