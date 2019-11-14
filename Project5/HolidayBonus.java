/*
 * @author https://github.com/amattu2
 * @version 0.01
 * @date 10/13/2019
 */
public class HolidayBonus {
	/*
	 * @author https://github.com/amattu2
	 * @version 0.01
	 *
	 * Calculate the holiday bonus for specified store
	 * @param double[][] Array
	 * @param double high
	 * @param double low
	 * @param double other
	 */
	public static double[] calculateHolidayBonus(double[][] a, double h, double l, double o) {
		// Variables
		double result[] = new double[a.length];
		double lowest = -1;
		int lowestIndex = -1;
		double highest = -1;
		int highestIndex = -1;

		// Loops
		for (int r = 0; r < a.length; r++) {
			// Variables
			double total = 0;

			// Loops
			for (int c = 0; c < a[r].length; c++) {
				total += a[r][c];
			}

			// Checks
			if (lowest == -1 || total < lowest) {
				lowest = total;
				lowestIndex = r;
			}
			if (highest == -1 || highest < total) {
				highest = total;
				highestIndex = r;
			}
		}
		for (int r = 0; r < a.length; r++) {
			if (r == lowestIndex) {
				result[r] = l;
				continue;
			}
			if (r == highestIndex) {
				result[r] = h;
				continue;
			}

			// Default
			result[r] = o;
		}

		// Return
		return result;
	}

	/*
	 * @author https://github.com/amattu2
	 * @version 0.01
	 *
	 * Calculate the total holiday bonus amount
	 * @param double[][] Array
	 * @param double high
	 * @param double low
	 * @param double other
	 */
	public static double calculateTotalHolidayBonus(double[][] a, double h, double l, double o) {
		// Variables
		double total = 0;
		double bonus[] = HolidayBonus.calculateHolidayBonus(a, h, l, 0);

		// Loop
		for (int i = 0; i < bonus.length; i++) {
			total += bonus[i];
		}

		// Return
		return total;
	}
}
