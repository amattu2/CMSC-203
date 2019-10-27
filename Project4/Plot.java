/*
 * @author github.com/amattu
 * @version 0.01
 * @date 10/17/2019
 */
public class Plot {
	// Class Variables
	private int PlotX = 0;
	private int PlotY = 0;
	private int PlotW = 0;
	private int PlotD = 0;

	/*
	 * Basic constructor, no arguments
	 */
	public Plot() {
		this.PlotW = 1;
		this.PlotD = 1;
	}

	/*
	 * Constructor with arguments
	 * @param X coord
	 * @param Y coord
	 * @param Width
	 * @param Depth
	 */
	public Plot(int X, int Y, int W, int D) {
		this.PlotX = X;
		this.PlotY = Y;
		this.PlotW = W;
		this.PlotD = D;
	}

	/*
	 * Get X coordinate
	 */
	public int getX() { return this.PlotX; }

	/*
	 * Get Y coordinate
	 */
	public int getY() { return this.PlotY; }

	/*
	 * Get Width
	 */
	public int getWidth() { return this.PlotW; }

	/*
	 * Get Depth
	 */
	public int getDepth() { return this.PlotD; }

	/*
	 * Set X
	 * @param Int X
	 */
	public void setX(int X) { this.PlotX = X; }

	/*
	 * Set Y
	 * @param Int Y
	 */
	public void setY(int Y) { this.PlotY = Y; }

	/*
	 * Set Width
	 */
	public void setWidth(int W) { this.PlotW = W; }

	/*
	 * Set Depth
	 */
	public void setDepth(int D) { this.PlotD = D; }

	/*
	 * Check plot overlapping
	 * @param Plot plot
	 */
	public boolean overlaps(Plot P) {
		// Variables
		int result = 0;
		int p1x1 = this.getX(); // starting x coord (left)
		int p2x1 = P.getX();
		int p1x2 = this.getX() + this.getWidth(); // ending x coord (right)
		int p1y1 = this.getY(); // starting y coord (top)
		int p2y1 = P.getY();
		int p1y2 = this.getY() + this.getDepth(); // ending y coord (bottom)

		// Checks
		if (p1x1 >= p2x1 || p2x1 <= p1x2) { result = 1; }
		if (p1y1 >= p2y1 || p2y1 <= p1y2) { result = 1; }

		// Return
		return result == 0 ? false : true;
	}

	/*
	 * Check plot container
	 */
	public boolean encompasses(Plot P) {
		// Variables
		int result = 0;
		int p1x1 = this.getX(); // starting x coord (left)
		int p2x1 = P.getX();
		int p1x2 = this.getX() + this.getWidth(); // ending x coord (right)
		int p1y1 = this.getY(); // starting y coord (top)
		int p2y1 = P.getY();
		int p1y2 = this.getY() + this.getDepth(); // ending y coord (bottom)

		// Checks
		if (p1x1 + this.getWidth() > p2x1) { result = 1; }
		if (p1y1 + this.getDepth() > p2y1) { result = 1; }
		if (p1x1 >= p2x1 || p2x1 <= p1x2) { result = 1; }
		if (p1y1 >= p2y1 || p2y1 <= p1y2) { result = 1; }

		System.out.println("Encompasses: this.X" + p1x1 + " P.X " + p2x1);

		// Return
		return result == 0 ? false : true;
	}

	/*
	 * Stringify plot
	 */
	public String toString() {
		// Variables
		String r = "";

		// Append
		r += "(X, Y): (" + this.getX() + ", " + this.getY() + ")";
		r += "\n" + "Width: " + this.getWidth();
		r += "\n" + "Depth:" + this.getDepth();

		// Return
		return r;
	}
}
