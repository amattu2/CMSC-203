
// Imports
import java.util.Scanner;

// Classes
public class Project1 {
	// Variables
	static String college_name = "Montgomery College, Rockville";
	static String class_name = "CMSC 201";
	static String class_instructor = "Alla Webb";
	static String project_author = "Alec Mattu";
	static String project_name = "Project 1";
	static String project_desc = "A simple Java based loan payment amount calculator";
	static String project_due = "09/15/2019";
	
	// Main Function
	public static void main(String[] args) {
		// Project Header
		outputHeader();
		
		// Variables
		Scanner scanner = new Scanner(System.in);
		double loanAmount = 0;
		double interestAmount = 0;
		int paymentAmount = 0;
		
		// Inputs
		do {
			// Message
			System.out.print("Please enter a loan amount: ");
			
			// Checks
			if (scanner.hasNextDouble()) {
				loanAmount = scanner.nextDouble();
			} else { scanner.next(); continue; }
		} while (loanAmount <= 0);
		do {
			// Message
			System.out.print("Please enter an interest rate [Eg. 3.5]: ");
			
			// Checks
			if (scanner.hasNextDouble()) {
				interestAmount = scanner.nextDouble();
				interestAmount = interestAmount / 100;
			} else { scanner.next(); continue; }
		} while (interestAmount <= 0);
		do {
			// Message
			System.out.print("Please enter the desired amount of payments (Months): ");
			
			// Checks
			if (scanner.hasNextInt()) {
				paymentAmount = scanner.nextInt();
			} else { scanner.next(); continue; }
		} while (paymentAmount <= 0);
		
		// Calculate Monthly Payment
		double monthlyPayment = loanAmount * ((interestAmount/12) / (1 - Math.pow((1 + (double)(interestAmount/12)), paymentAmount * -1)));

		// Output
		System.out.println("<----->");
		System.out.println("You will pay off the loan of $" + loanAmount +" after "+ paymentAmount +" payments. With a monthly payment of $"+ monthlyPayment);
	}
	
	// Header Function
	private static void outputHeader() {
		System.out.println("<<------------------------------------->>");
		System.out.println("Welcome to " + project_name);
		System.out.println("College: " + college_name);
		System.out.println("Class: " + class_name);
		System.out.println("Instructor: " + class_instructor);
		System.out.println("Author: " + project_author);
		System.out.println("Description: " + project_desc);
		System.out.println("Due Date: " + project_due);
		System.out.println("<<------------------------------------->>");
	}
}
