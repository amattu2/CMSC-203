/*
 * @author github.com/amattu
 * @version 0.01
 * @date 10/17/2019
 */
public class Property {
	// Class Variables
	private String Name = "";
	private String City = "";
	private String Owner = "";
	private double RentAmount = 0;
	private Plot Plot;

	/*
	 * Basic constructor, no arguments
	 */
	public Property() {
		this.Plot = new Plot();
	}

	/*
	 * Constructor with Name, City, Rent, Owner
	 * @param String name
	 * @param String city
	 * @param Double rent
	 * @param String owner
	 */
	public Property(String N, String C, double R, String O) {
		this.Name = N;
		this.City = C;
		this.RentAmount = R;
		this.Owner = O;
		this.Plot = new Plot();
	}

	/*
	 * Constructor with Name, City, Rent, Owner, X, Y, Width, Depth
	 * @param String name
	 * @param String city
	 * @param Double rent
	 * @param String owner
	 * @param Int X
	 * @param Int Y
	 * @param Int Width
	 * @param Int Depth
	 */
	public Property(String N, String C, double R, String O, int X, int Y, int W, int D) {
		this.Name = N;
		this.City = C;
		this.RentAmount = R;
		this.Owner = O;
		this.Plot = new Plot(X, Y, W, D);
	}

	/*
	 * Constructor to duplicate a property
	 */
	public Property(Property P) {
		this.Name = P.getPropertyName();
		this.City = P.getCity();
		this.RentAmount = P.getRentAmount();
		this.Owner = P.getOwner();
		this.Plot = P.getPlot();
	}

	/*
	 * Get property city
	 */
	public String getCity() { return this.City; }

	/*
	 * Get property owner
	 */
	public String getOwner() { return this.Owner; }

	/*
	 * Get property plot
	 */
	public Plot getPlot() { return this.Plot; }

	/*
	 * Get property name
	 */
	public String getPropertyName() { return this.Name; }

	/*
	 * Get property rent
	 */
	public double getRentAmount() { return this.RentAmount; }

	/*
	 * Set property city
	 */
	public void setCity(String S) { this.City = S; }

	/*
	 * Set property owner
	 */
	public void setOwner(String O) { this.Owner = O; }

	/*
	 * Set property name
	 */
	public void setPropertyName(String N) { this.Name = N; }

	/*
	 * Set property rent amount
	 */
	public void setRentAmount(double R) { this.RentAmount = R; }

	/*
	 * Stringify Property
	 */
	public String toString() {
		// Variables
		String r = "";

		// Append
		r += "Property Name: " + this.getPropertyName();
		r += "\n" + "Located in " + this.getCity();
		r += "\n" + "Belonging to: " + this.getOwner();
		r += "\n" + "Rent Amount: " + this.getRentAmount();
		r += " ";

		// Return
		return r;
	}
}
