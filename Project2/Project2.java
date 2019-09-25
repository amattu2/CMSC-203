package project2;

// Imports
import java.util.Scanner;

public class Project2 {
	// Variables
	static String college_name = "Montgomery College, Rockville";
	static String class_name = "CMSC 203";
	static String class_instructor = "Alla Webb";
	static String project_author = "Alec Mattu";
	static String project_name = "Project 2";
	static String project_desc = "A simple Java DMV ticket interaction driver";
	static String project_due = "09/30/2019";
	static Scanner scanner = new Scanner(System.in);
	static int projectRun = 0;
	
	public static void main(String args[]) {
		// Checks
		if (projectRun == 0) {
			outputHeader();
			projectRun = 1;
		}
		
		// Variables
		int cont = 2;
		
		// Initial input
		buildTicket();
		
		// Continue Prompt
		do {
			// Message
			System.out.print(">>> Would you like to enter another ticket? [1/0]: ");
			
			// Checks
			if (scanner.hasNextInt()) {
				cont = scanner.nextInt();
				if (cont == 1) {
					cont = 2;
					buildTicket();
				}
			} else { scanner.nextLine(); continue; }
		} while (cont != 0 && cont != 1);
	}
	
	// Build Ticket Function
	private static void buildTicket() {
		// Variables
		String n = null;
		int speed = 0, limit = 0, schoolZ = 0, workZ = 0;
		
		// Get Violator Name
		do {
			// Output
			System.out.print(">>> Enter the name of the violator:");
			
			// Checks
			if (scanner.hasNext()) {
				n = scanner.next();
			} else { scanner.next(); continue; }
			scanner.nextLine();
		} while (n == null || n.length() <= 0 || n.length() > 30);
		
		// Get Violator Speed
		do {
			// Output
			System.out.print(">>> Enter the travel speed of the violator (1-155mph): ");
			
			// Checks
			if (scanner.hasNextInt()) {
				speed = scanner.nextInt();
			} else { scanner.next(); continue; }
			scanner.nextLine();
		} while (speed <= 0 || speed > 155);
		
		// Get Road Speed
		do {
			// Output
			System.out.print(">>> Enter the road speed limit (1-80mph): ");
			
			// Checks
			if (scanner.hasNextInt()) {
				limit = scanner.nextInt();
			} else { scanner.next(); continue; }
		} while (limit <= 0 || limit > 80);
		
		// Get School Zone
		do {
			// Output
			System.out.print(">>> Did this violation occur in a school zone? [1/0]: ");
			
			// Checks
			if (scanner.hasNextInt()) {
				schoolZ = scanner.nextInt();
			} else { scanner.next(); continue; }
		} while (schoolZ != 0 && schoolZ != 1);
		
		// Get Work Zone
		do {
			// Output
			System.out.print(">>> Did this violation occur in a work zone? [1/0]: ");
			
			// Checks
			if (scanner.hasNextInt()) {
				workZ = scanner.nextInt();
			} else { scanner.next(); continue; }
		} while (workZ != 0 && workZ != 1);
		
		// Output Results
		System.out.println("<<------------------------------------->>");
		Ticket ticket = new Ticket(n, speed, limit, (boolean)(schoolZ == 1), (boolean)(workZ == 1));
		ticket.printNotice();
		System.out.println("<<------------------------------------->>");
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
