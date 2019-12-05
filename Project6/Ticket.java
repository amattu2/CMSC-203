import java.math.BigDecimal;

/*
 * @author https://github.com/amattu2
 * @version 0.01
 * @date 11/21/2019
 */

// Class
public abstract class Ticket {
	private java.text.NumberFormat format;
	private String name = "";
	private int time = 0;
	private int day = 0;
	private int id = 0;
	private String movietype = "";
	private String tickettype = "";
	private String rating = "";

	/*
	 * @author https://github.com/amattu2
	 * @desc Default constructor method
	 * @date 11/21/2019
	 * @param NONE
	 */
	public Ticket() {}

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
	public Ticket(String Name, int Time, int Day, String MovieType, String TicketType, String Rating, int ID) {
		// Set Variables
		this.setName(Name);
		this.setRating(Rating);
		this.setDay(Day);
		this.setTime(Time);
		this.setMovieType(MovieType);
		this.setTicketType(TicketType);
		this.setId(ID);
	}

	/*
	 * @author https://github.com/amattu2
	 * @desc Calculates a ticket price based on the time of day, type, and tax
	 * @date 11/30/2019
	 * @param None
	 */
	public double calculateTicketPrice() {
		return 0;
	}

	/*
	 * @author https://github.com/amattu2
	 * @desc Sets the Ticket Movie Name
	 * @date 11/30/2019
	 * @param String Name
	 */
	public void setName(String name) {
		this.name = name;
	}

	/*
	 * @author https://github.com/amattu2
	 * @desc Sets the Ticket Rating
	 * @date 11/30/2019
	 * @param String Rating
	 */
	public void setRating(String rating) {
		this.rating = rating.toUpperCase();
	}

	/*
	 * @author https://github.com/amattu2
	 * @desc Sets the Ticket Day
	 * @date 11/30/2019
	 * @param Integer Day
	 */
	public void setDay(int day) {
		this.day = day;
	}

	/*
	 * @author https://github.com/amattu2
	 * @desc Sets the Ticket Time
	 * @date 11/30/2019
	 * @param Integer Time
	 */
	public void setTime(int time) {
		this.time = time;
	}

	/*
	 * @author https://github.com/amattu2
	 * @desc Sets the Movie Type
	 * @date 11/30/2019
	 * @param String Movie Type
	 */
	public void setMovieType(String movietype) {
		this.movietype = movietype;
	}

	/*
	 * @author https://github.com/amattu2
	 * @desc Sets the Ticket Type
	 * @date 11/30/2019
	 * @param String Ticket Type
	 */
	public void setTicketType(String tickettype) {
		this.tickettype = tickettype;
	}

	/*
	 * @author https://github.com/amattu2
	 * @desc Sets the Ticket ID
	 * @date 11/30/2019
	 * @param Integer ID Number
	 */
	public void setId(int id) {
		this.id = id;
	}

	/*
	 * @author https://github.com/amattu2
	 * @desc Gets the Ticket Name
	 * @date 11/30/2019
	 * @param None
	 */
	public String getName() {
		return this.name;
	}

	/*
	 * @author https://github.com/amattu2
	 * @desc Gets the Ticket Time
	 * @date 11/30/2019
	 * @param None
	 */
	public int getTime() {
		return this.time;
	}

	/*
	 * @author https://github.com/amattu2
	 * @desc Gets the Ticket Day
	 * @date 11/30/2019
	 * @param None
	 */
	public int getDay() {
		return this.day;
	}

	/*
	 * @author https://github.com/amattu2
	 * @desc Gets the Ticket Movie Type
	 * @date 11/30/2019
	 * @param None
	 */
	public String getMovieType() {
		return this.movietype;
	}

	/*
	 * @author https://github.com/amattu2
	 * @desc Gets the Ticket Type
	 * @date 11/30/2019
	 * @param None
	 */
	public String getTicketType() {
		return this.tickettype;
	}

	/*
	 * @author https://github.com/amattu2
	 * @desc Gets the Ticket Rating
	 * @date 11/30/2019
	 * @param None
	 */
	public String getMovierating() {
		return this.rating;
	}

	/*
	 * @author https://github.com/amattu2
	 * @desc Returns the ticket ID number
	 * @date 11/30/2019
	 * @param None
	 */
	public int getId() {
		return this.movietype.toLowerCase().equals("adult") || this.movietype.toLowerCase().equals("child") ? -1 : this.id;
	}

	/*
	 * @author https://github.com/amattu2
	 * @desc Returns the ticket ID number
	 * @date 11/30/2019
	 * @param None
	 */
	public String toString() {
		// Variables
		String stringified = "";

		// Build String
		stringified += this.name;
		stringified += " <> " + this.rating;
		stringified += " <> " + this.movietype;
		stringified += " <> " + this.tickettype;
		stringified += " <> #" + this.getId();
		stringified += " <> $" + (new BigDecimal(this.calculateTicketPrice()).setScale(2, BigDecimal.ROUND_HALF_UP)).doubleValue();

		// Return
		return stringified;
	}
}
