// Imports
import java.util.ArrayList;

/*
 * @author https://github.com/amattu2
 * @version 0.01
 * @date 11/21/2019
 */

public class Employee extends Ticket {
	// Class Variables
	private static double ticketBasePrice = 10.50;
	private static double ticketAfter6Bump = 3.5;
	private static double ticketIMAXBump = 3.0;
	private static double ticket3DBump = 2.5;
	private static double taxAmount = 0.096;
	private ArrayList<Ticket> tickets = new ArrayList<Ticket>();

	/*
	 * @author https://github.com/amattu2
	 * @desc Default constructor method
	 * @date 11/30/2019
	 * @param NONE
	 */
	public Employee() {}

	/*
	 * @author https://github.com/amattu2
	 * @desc Constructor method
	 * @date 11/30/2019
	 * @param String Name (Movie Name)
	 * @param Integer Day Time (1-24)
	 * @param Integer Month Day (1-31)
	 * @param String Movie Type (IMAX, 3D, None)
	 * @param String Ticket Type (Adult, Child, Employee, MoviePass)
	 * @param String Rating (G, PG13, PG, NR, R)
	 * @param Integer ID (?)
	 */
	public Employee(String Name, int Time, int Day, String MovieType, String TicketType, String Rating, int ID, ArrayList<Ticket> Tickets) {
		// Set Variables
		super();
		this.setName(Name);
		this.setRating(Rating);
		this.setDay(Day);
		this.setTime(Time);
		this.setMovieType(MovieType);
		this.setTicketType("Employee");
		this.setId(ID);
		this.tickets = Tickets;
	}

	/*
	 * @author https://github.com/amattu2
	 * @desc Return the number of movies a individual has watched today
	 * @date 12/3/2019
	 * @param Integer ID, Integer Day Number
	 */
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
	 * @desc Calculates a ticket price based on the time of day, type, and tax
	 * @date 11/30/2019
	 * @param None
	 */
	public double calculateTicketPrice() {
		// Variables
		double total = ticketBasePrice;
		int movieCount = this.numMoviesToday(getId(), getDay());

		// Checks
		if (this.getTime() >= 18) { total += ticketAfter6Bump; }
		if (this.getMovieType().toLowerCase().equals("imax")) { total += ticketIMAXBump; }
		if (this.getMovieType().toLowerCase().equals("3d")) { total += ticket3DBump; }

		// Return
		return movieCount <= 2 ? 0.00 : (total / 2) + (total * taxAmount);
	}
}
