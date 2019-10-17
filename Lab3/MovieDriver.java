// Imports
import java.util.Scanner;

// Movie Driver Class (Handle I/O)
public class MovieDriver {
	// Class Variables
	static String college_name = "Montgomery College";
	static String class_name = "CMSC 201";
	static String class_instructor = "";
	static String project_author = "";
	static String project_name = "Lab 3";
	static String project_desc = "A simple driver to handle the class Movie I/O functions";
	static String project_due = "N/A";
	static Scanner scanner = new Scanner(System.in);
	static int projectRun = 0;

	public static void main(String[] args) {
		// Checks
		if (projectRun == 0) {
			outputHeader();
			projectRun = 1;
		}

		// Variables
		int cont = 2;

		// Initial input
		collectMovie();

		// Continue Prompt
		do {
			// Message
			System.out.println(">>> Would you like to continue? [1/0]: ");

			// Checks
			if (scanner.hasNextInt()) {
				cont = scanner.nextInt();
				if (cont == 1) {
					cont = 2;
					collectMovie();
				}
			} else { scanner.nextLine(); continue; }
		} while (cont != 0 && cont != 1);
	}

	private static void collectMovie() {
		// Variables
		Movie movie = new Movie();
		String title = "";
		String rating = "";
		int tickets = 0;

		// Get Movie Title
		do {
			// Message
			System.out.println(">>> Enter the name of the movie: ");

			// Checks
			if (scanner.hasNext()) {
				title = scanner.next();
				movie.setTitle(title);
				scanner.nextLine();
			} else { scanner.next(); continue; }
		} while (title == "");

		// Get Movie Rating
		do {
			// Message
			System.out.println(">>> Enter the rating of the movie [Eg. PG13]: ");

			// Checks
			if (scanner.hasNext()) {
				rating = scanner.next();
				movie.setRating(rating);
				scanner.nextLine();
			} else { scanner.next(); continue; }
		} while (rating == "");

		// Get Movie Tickets
		do {
			// Message
			System.out.println(">>> Enter the number of tickets sold for the movie: ");

			// Checks
			if (scanner.hasNextInt()) {
				tickets = scanner.nextInt();
				scanner.nextLine();
				movie.setSoldTickets(tickets);
			} else { scanner.next(); continue; }
		} while (tickets < 0);

		// Output Result
		System.out.println(">>> " + movie.toString());
	}

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
