package project2;

// Imports
import java.util.Random;

/**
 * A simple Ticket class, represents a driver ticket object
 * @author https://github.com/amattu2
 * @version 0.01
 */
public class Ticket {
	// Variables
	private Random rand = new Random();
	private String name;
	private String type;
	private int speed;
	private int limit;
	private int number = rand.nextInt(99999);
	private boolean schoolZ;
	private boolean workZ;
	private boolean mustAppear = false;
	private double fine;

	// Main Function (Name, Speed, Speed Limit)
	/**
	 * Constructor that takes data as input and sets them.
	 * @param n the Licensed Driver Name
	 * @param s the Vehicle motion speed
	 * @param sl the Road speed limit
	 */
	public Ticket(String n, int s, int sl) {
		this.name = n;
		this.speed = s;
		this.limit = sl;
	}

	// Main Function (Name, Speed, Speed Limit, SchoolZone, WorkZone)
	/**
	 * Constructor that takes data as input and sets them.
	 * @param n the Licensed Driver Name
	 * @param s the Vehicle motion speed
	 * @param sl the Road speed limit
	 * @param sz School zone
	 * @param wz Work zone
	 */
	public Ticket(String n, int s, int sl, boolean sz, boolean wz) {
		this.name = n;
		this.speed = s;
		this.limit = sl;
		this.schoolZ = sz;
		this.workZ = wz;
	}

	// Calculate Fine
	/**
	 * Calculate a Ticket fine amount
	 * Automatically sets Ticket Type
	 * @return (Double) ticket fine amount
	 */
	public double calculateFine() {
		// Variables
		int speedDiff = this.speed - this.limit;

		// Checks
		if (this.speed <= this.limit) {
			this.fine = 0.0;
		}
		if (speedDiff >= 1 && speedDiff <= 10) {
			this.fine = 140;
			this.fine = this.fine + (this.workZ ? 250 : 0) + (this.schoolZ ? 200 : 0);
		}
		if (speedDiff >= 11 && speedDiff <= 20) {
			this.fine = 195;
			this.fine = this.fine + (this.workZ ? 350 : 0) + (this.schoolZ ? 300 : 0);
		}
		if (speedDiff >= 21 && speedDiff <= 30) {
			this.fine = 450;
		}
		if (speedDiff >= 31 && speedDiff <= 40) {
			this.fine = 495;
			this.mustAppear = true;
		}
		if (speedDiff >= 41) {
			this.fine = 600;
			this.mustAppear = true;
		}

		return this.fine;
	}

	// Get Driver Name
	/**
	 * Get Ticket Driver Name
	 * @return (String) Driver Name
	 */
	public String getName() {
		return this.name;
	}

	// Get Driver Speed
	/**
	 * Get Vehicle motion speed
	 * @return (Int) Vehicle Speed
	 */
	public int getSpeed() {
		return this.speed;
	}

	// Get Ticket Speed Limit
	/**
	 * Get Road Speed Limit
	 * @return (Int) Road Speed Limit
	 */
	public int getSpeedLimit() {
		return this.limit;
	}

	// Get Ticket Type
	/**
	 * Get Ticket Type
	 * @return (String) Ticket Type
	 * [Payable, Must Appear]
	 */
	public String getTicketType() {
		// Variables
		String tt = "";

		// Checks
		if (this.mustAppear = false) {
			tt = "PAYABLE";
		} else {
			tt = "MUST APPEAR";
		}

		return tt;
	}

	// Determine Ticket Type [Duplicate of getTicketType]
	/**
	 * Alias for Ticket.getTicketType()
	 * @return (String) Ticket Type
	 */
	public String determineTicketType() {
		return this.getTicketType();
	}

	// Get Ticket Zone [School]
	/**
	 * Get Ticket School zone
	 * @return (Boolean) School Zone
	 */
	public boolean isSchoolZone() {
		return this.schoolZ;
	}

	// Get Ticket Zone [Work]
	/**
	 * Get Ticket Work zone
	 * @return (Boolean) Work Zone
	 */
	public boolean isWorkZone() {
		return this.workZ;
	}

	// Get Ticket Number
	/**
	 * Get Ticket Number
	 * @return (Int) Ticket Number
	 */
	public int getTicketNum() {
		return this.number;
	}

	// Set Driver Name
	/**
	 * Set Driver Name
	 * @param n Driver Name
	 */
	public void setName(String n) {
		this.name = n;
	}

	// Set Ticket Zone [School]
	/**
	 * Set School Zone
	 * @param (Boolean) z School Zone
	 */
	public void setSchoolZone(Boolean z) {
		this.schoolZ = z;
	}

	// Set Ticket Zone [Work]
	/**
	 * Set Work Zone
	 * @param (Boolean) z Work Zone
	 */
	public void setWorkZone(Boolean z) {
		this.workZ = z;
	}

	// Set Ticket Speed
	/**
	 * Set Vehicle speed
	 * @param (Int) s Vehicle Speed
	 */
	public void setSpeed(int s) {
		this.speed = s;
	}

	// Set Speed Limit
	/**
	 * Set Road Speed Limit
	 * @param l (Int) Speed Limit
	 */
	public void setSpeedLimit(int l) {
		this.limit = l;
	}

	// Set Ticket Number
	/**
	 * Set Ticket Number
	 * @param n (Int) Number
	 */
	public void setTicketNum(int n) {
		this.number = n;
	}

	// Return Ticket String
	/**
	 * Converts Ticket object to a string
	 * @format {Name} [Speed: {speed} mph] [Limit: {limit} mph] [#{ticket_number}] [{ticket_type}]
	 */
	public String toString() {
		// Variables
		String str;

		str = this.name + " [Speed: " + this.speed + "mph]" + " [Limit: " + this.limit + "] [#" + this.number + "]" + "[Type: " + this.getTicketType() + "]";

		return str;
	}

	// Return Ticket Notice
	/**
	 * Print & Return MVA/DMV Notice
	 * @return notice
	 */
	public String printNotice() {
		// Variables
		String notice;

		// Build notice
		notice = "Department of Motor Vehicles\n";
		notice += "Automated Traffic Enforcement\n";
		notice += "\n\n";
		notice += "Dear " + this.name + ",\n";
		notice += "\n";
		notice += "Please pay the following speeding fine of $" + String.format(java.util.Locale.US,  "%.2f", this.calculateFine()) + " to the DMV within 10 days of\n";
		notice += "receiving this notice to avoid a driver's license suspension. You are being fined\n";
		notice += "for going " + this.speed + " MPH in a " + this.limit + " MPH " + (this.schoolZ && !this.workZ ? "school zone" : this.workZ && !this.schoolZ ? "work zone" : this.workZ && this.schoolZ ? " school & work zone" : "zone") + ".\n";
		notice += "\n";
		notice += "Ticket Type: " + this.getTicketType() + "\n";
		notice += "Ticket Number: "+ this.getTicketNum() +"\n";
		notice += "\n";
		notice += "Returned checks are subject to a returned check fee of $35.00.\n";
		notice += "\n";
		notice += "Sincerely,\n";
		notice += "https://github.com/amattu2\n";

		System.out.println(notice);
		return notice;
	}
}
