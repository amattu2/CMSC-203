/**
   This program demonstrates how numeric types and operators behave in Java
*/

import java.util.Scanner;

public class NumericTypes {
	public static void main (String [] args) {
		// Variables
		Scanner scanner = new Scanner(System.in); // Scanner
		final int NUMBER = 2; // number of scores
		int score1 = 100; // first test score
		int score2 = 95; // second test score
		final int BOILING_IN_F = 212; // boiling temperature
		double fToC; // temperature in Celsius
		double average; // arithmetic average
		String output; // line of output to print out
		
		//Task #2 declare a variable to hold the user’s temperature
		int temperature; // User Temperature Variable
		
		//Task #2 prompt user to input score1
		System.out.println("Please enter score1: ");
		
		//Task #2 read score1 
		score1 = scanner.nextInt();
		
		//Task #2 prompt user to input score2
		System.out.println("Please enter score2: ");
		
		//Task #2 read score2 
		score2 = scanner.nextInt();
		
		// Find an arithmetic average
		average = score1 + score2 / NUMBER;
		output = score1 + " and " + score2 + " have an average of " + average;	
		System.out.println(output);
		
		// Convert Fahrenheit temperatures to Celsius
		fToC = (float)5/9 * (BOILING_IN_F - 32);
		output = BOILING_IN_F + " in Fahrenheit is " + fToC + " in Celsius.";
		System.out.println(output);
		
		//Task #2 prompt user to input another temperature
		System.out.println("Please enter a temperature (Fahrenheit): ");
		
		//Task #2 read the user’s temperature in Fahrenheit
		temperature = scanner.nextInt();
		
		//Task #2 convert the user’s temperature to Celsius
		fToC = (float)5/9 * (temperature - 32);
		output = "Your temperature in celsius is " + fToC;
		
		//Task #2 print the user’s temperature in Celsius
		System.out.println(output);
		
		
		System.out.println("Goodbye"); // to show that the program is ended	
	}
}

