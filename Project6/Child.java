/*
 * @author https://github.com/amattu2
 * @version 0.01
 * @date 11/21/2019
 */

public class Child extends Ticket {
	// Class Variables
	private static double ticketBasePrice = 5.75;
	private static double ticketAfter6Bump = 5.0;
	private static double ticketIMAXBump = 2.0;
	private static double ticket3DBump = 1.5;
	private static double taxAmount = 0.096;

	/*
	 * @author https://github.com/amattu2
	 * @desc Default constructor method
	 * @date 11/30/2019
	 * @param NONE
	 */
	public Child() {}

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
	public Child(String Name, int Time, int Day, String MovieType, String TicketType, String Rating, int ID) {
		// Set Variables
		super();
		this.setName(Name);
		this.setRating(Rating);
		this.setDay(Day);
		this.setTime(Time);
		this.setMovieType(MovieType);
		this.setTicketType("Child");
		this.setId(ID);
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

		// Checks
		if (this.getTime() >= 18) { total += ticketAfter6Bump; }
		if (this.getMovieType().toLowerCase().equals("imax")) { total += ticketIMAXBump; }
		if (this.getMovieType().toLowerCase().equals("3d")) { total += ticket3DBump; }

		// Return
		return total + (total * taxAmount);
	}
}
