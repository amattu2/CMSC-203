/*
 * @author https://github.com/amattu2
 * @version 0.01
 * @date 11/21/2019
 */

// Imports
import java.io.File;
import java.io.FileNotFoundException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

// Class
public class MovieTicketManager implements MovieTicketManagerInterface {
	private ArrayList<Ticket> tickets = new ArrayList<Ticket>();
	private java.text.NumberFormat format;

	/*
	 * @author https://github.com/amattu2
	 * @desc Constructor method
	 * @date 11/21/2019
	 * @param NONE
	 */
	public MovieTicketManager() {}

	/*
	 * @author https://github.com/amattu2
	 * @desc Add a individual to the list of movies, returns the ticket price
	 * @date 11/30/2019
	 * @param String Movie, String Rating, Integer d, Integer t, String f, String type, Integer ID
	 */
	@Override
	public double addTicket(String movieN, String rating, int day, int time, String f, String type, int id) {
		// Variables
		Ticket ticket = null;
		double total = 0;

		// Checks
		if (type.toLowerCase().equals("adult")) {
			ticket = new Adult(movieN, time, day, f, type, rating, id);
			total = ticket.calculateTicketPrice();
		} else if (type.toLowerCase().equals("child")) {
			ticket = new Child(movieN, time, day, f, type, rating, id);
			total = ticket.calculateTicketPrice();
		} else if (type.toLowerCase().equals("employee")) {
			ticket = new Employee(movieN, time, day, f, type, rating, id, tickets);
			total = ticket.calculateTicketPrice();
		} else if (type.toLowerCase().equals("moviepass")) {
			ticket = new MoviePass(movieN, time, day, f, type, rating, id, tickets);
			total = ticket.calculateTicketPrice();
		}

		// Return
		tickets.add(ticket);
		return (new BigDecimal(total).setScale(2, BigDecimal.ROUND_HALF_UP)).doubleValue();
	}


	/*
	 * @author https://github.com/amattu2
	 * @desc Return the number of visits a individual has
	 * @date 11/30/2019
	 * @param Integer ID
	 */
	@Override
	public int numVisits(int id) {
		// Variables
		int visits = 0;

		// Loops
		for (int i = 0; i < tickets.size(); i++) {
			// Variables
			Ticket ticket = tickets.get(i);

			// Checks
			if (ticket.getId() == id) { visits++; }
		}

		// Return
		return visits;
	}

	/*
	 * @author https://github.com/amattu2
	 * @desc Return  the number of times a individual has watched a movie
	 * @date 11/30/2019
	 * @param Integer ID, String Movie
	 */
	@Override
	public int numThisMovie(int id, String movie) {
		// Variables
		int visits = 0;

		// Loops
		for (int i = 0; i < tickets.size(); i++) {
			// Variables
			Ticket ticket = tickets.get(i);

			// Checks
			if (ticket.getId() == id && ticket.getName().toLowerCase().equals(movie.toLowerCase())) { visits++; }
		}

		// Return
		return visits;
	}

	/*
	 * @author https://github.com/amattu2
	 * @desc Return the number of movies a individual has watched today
	 * @date 12/30/2019
	 * @param Integer ID, Integer Day Number
	 */
	@Override
	public int numMoviesToday(int id, int day) {
		// Variables
		int visits = 0;

		// Loops
		for (int i = 0; i < tickets.size(); i++) {
			// Variables
			Ticket ticket = tickets.get(i);

			// Checks
			if (ticket.getId() == id && ticket.getDay() == day) { visits++; }
		}

		// Return
		return visits;
	}

	/*
	 * @author https://github.com/amattu2
	 * @desc Returns the total number of sales for the specified month
	 * @date 11/30/2019
	 * @param NONE
	 */
	@Override
	public double totalSalesMonth() {
		// Variables
		double total = 0;

		// Loops
		for (int i = 0; i < tickets.size(); i++) {
			// Variables
			Ticket ticket = tickets.get(i);
			total += ticket.calculateTicketPrice();
		}

		// Return
		return (new BigDecimal(total).setScale(2, BigDecimal.ROUND_HALF_UP)).doubleValue();
	}

	/*
	 * @author https://github.com/amattu2
	 * @desc Generate a monthly sales report
	 * @date 11/21/2019
	 * @param NONE
	 */
	@Override
	public String monthlySalesReport() {
		// Variables
		String report;

		// Build Report
		report = "Monthly Sales Report\n";
		report += "\n";
		report += "Sales\n";
		report += "Total ADULT Ticket Sales: x"+ this.getTicketSalesCount("adult") +" $" + this.getTotalTicketSales("adult") + "\n";
		report += "Total CHILD Ticket Sales: x"+ this.getTicketSalesCount("child") +" $" + this.getTotalTicketSales("child") + "\n";
		report += "Total EMPLOYEE Ticket Sales: x"+ this.getTicketSalesCount("EMPLOYEE") +" $" + this.getTotalTicketSales("EMPLOYEE") + "\n";
		report += "Total MOVIEPASS Ticket Sales: x"+ this.getTicketSalesCount("MOVIEPASS") +" $" + this.getTotalTicketSales("MOVIEPASS") + "\n";

		// Return
		return report;
	}

	/*
	 * @author https://github.com/amattu2
	 * @desc Returns a ArrayList of tickets pertaining to the 3D movie type
	 * @date 11/30/2019
	 * @param NONE
	 */
	@Override
	public ArrayList<String> get3DTickets() {
		// Variables
		ArrayList<String> ticketList = new ArrayList<String>();
		ArrayList<Ticket> sortedList = this.sortTickets(1);

		// Loops
		for (int i = 0; i < sortedList.size(); i++) {
			// Variables
			Ticket ticket = sortedList.get(i);

			// Checks
			if (ticket.getMovieType().toLowerCase().equals("3d")) { ticketList.add("Day: " + ticket.getDay() + " " + ticket.toString()); }
		}

		// Return
		return ticketList;
	}

	/*
	 * @author https://github.com/amattu2
	 * @desc Returns a ArrayList of all the tickets to the MoviePass ticket type
	 * @date 11/30/2019
	 * @param NONE
	 */
	@Override
	public ArrayList<String> getMoviePassTickets() {
		// Variables
		ArrayList<String> ticketList = new ArrayList<String>();
		ArrayList<Ticket> sortedList = this.sortTickets(2);

		// Loops
		for (int i = 0; i < sortedList.size(); i++) {
			// Variables
			Ticket ticket = sortedList.get(i);

			// Checks
			if (ticket.getTicketType().toLowerCase().equals("moviepass")) { ticketList.add("Day: " + ticket.getDay() + " " + ticket.toString()); }
		}

		// Return
		return ticketList;
	}

	/*
	 * @author https://github.com/amattu2
	 * @desc Returns a ArrayList of all the ticket strings sorted chronologically
	 * @date 11/21/2019
	 * @param
	 */
	@Override
	public ArrayList<String> getAllTickets() {
		// Variables
		ArrayList<String> ticketList = new ArrayList<String>();
		ArrayList<Ticket> sortedTickets = this.sortTickets(1);

		// Loops
		for (int i = 0; i < sortedTickets.size(); i++) {
			ticketList.add("Day: " + sortedTickets.get(i).getDay() + " " + sortedTickets.get(i).toString());
		}

		// Return
		return ticketList;
	}

	/*
	 * @author https://github.com/amattu2
	 * @desc Returns a sorted ArrayList of all the tickets
	 * @date 11/21/2019
	 * @param
	 */
	public ArrayList<Ticket> sortTickets(int SortBy) {
		// Variables
		ArrayList<Ticket> ticketList = new ArrayList<Ticket>();

		// Loops
		for (int i = 0; i < tickets.size(); i++) {
			ticketList.add(tickets.get(i));
		}

		// Checks
		if (SortBy == 1) {
			Collections.sort(ticketList, new Comparator<Ticket>() {
				@Override
				public int compare(Ticket t1, Ticket t2) {
					return t1.getDay() - t2.getDay();
				}
			});
		} else {
			Collections.sort(ticketList, new Comparator<Ticket>() {
				@Override
				public int compare(Ticket t1, Ticket t2) {
					return t1.getId() - t2.getId();
				}
			});
		}

		// Return
		return ticketList;
	}

	/*
	 * @author https://github.com/amattu2
	 * @desc Parse a file of movie sales
	 * @date 12/3/2019
	 * @param File file
	 */
	/*
	 * File format
	 * Name : Rating : Month Day : Day Hour : Movie Type : Ticket Type : ID
	 */
	@Override
	public void readFile(File file) throws FileNotFoundException {
		// Variables
		Scanner scanner = new Scanner(file);

		// Fetch Row Data
		while (scanner.hasNextLine()) {
			// Variables
			String line = scanner.nextLine();
			String columns[] = line.trim().split(":");
			String name = columns[0];
			String rating = columns[1];
			int day = Integer.parseInt(columns[2]);
			int hour = Integer.parseInt(columns[3]);
			String movietype = columns[4];
			String tickettype = columns[5];
			int id = Integer.parseInt(columns[6]);

			// Add Ticket
			this.addTicket(name, rating, day, hour, movietype, tickettype, id);
		}

		// Return / Close
		scanner.close();
	}

	/*
	 * @author https://github.com/amattu2
	 * @desc Returns the total number of sales for specified type
	 * @date 12/3/2019
	 * @param NONE
	 */
	private int getTicketSalesCount(String type) {
		// Variables
		int total = 0;

		// Loops
		for (int i = 0; i < tickets.size(); i++) {
			// Variables
			Ticket ticket = tickets.get(i);

			// Checks
			if (ticket.getTicketType().toLowerCase().equals(type.toLowerCase())) { total++; }
		}

		// Return
		return total;
	}

	/*
	 * @author https://github.com/amattu2
	 * @desc Returns the total amount in sales for specified type
	 * @date 12/3/2019
	 * @param NONE
	 */
	private double getTotalTicketSales(String type) {
		// Variables
		double total = 0;

		// Loops
		for (int i = 0; i < tickets.size(); i++) {
			// Variables
			Ticket ticket = tickets.get(i);

			// Checks
			if (ticket.getTicketType().toLowerCase().equals(type.toLowerCase())) { total += ticket.calculateTicketPrice(); }
		}

		// Return
		return (new BigDecimal(total).setScale(2, BigDecimal.ROUND_HALF_UP)).doubleValue();
	}
}
