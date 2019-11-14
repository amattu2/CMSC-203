import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;

/*
 * @author https://github.com/amattu2
 * @version 0.01
 * @date 11/13/2019
 */
public class TwoDimRaggedArrayUtility {
	/*
	 * @author https://github.com/amattu2
	 * @version 0.01
	 *
	 * Returns the average of elements in the array
	 * @param double[] Array
	 */
	static double getAverage(double[][] a) {
		// Variables
		int count = 0;
		double total = 0;

		// Loops (Rows => Columns)
		for (int r = 0; r < a.length; r++) {
			for (int c = 0; c < a[r].length; c++) {
				total += a[r][c];
				count++;
			}
		}

		return total / count;
	}

	/*
	 * @author https://github.com/amattu2
	 * @version 0.01
	 *
	 * Calculate the column total in array
	 * @param double[][] Array
	 * @param int clumn
	 */
	static double getColumnTotal(double[][] a, int c) {
		// Variables
		double total = 0;

		// Loops (Rows => Column[c])
		for (int r = 0; r < a.length; r++) {
			// Checks
			if (a[r].length <= c || c < 0) { continue; }

			// Variables
			total += a[r][a[r].length == 1 && c == 1 ? c-1 : c];
		}

		// Return
		return total;
	}

	/*
	 * @author https://github.com/amattu2
	 * @version 0.01
	 *
	 * Calculate highest element in array
	 * @param double[][] Array
	 */
	static double getHighestInArray(double[][] a) {
		// Variables
		double highest = 0;

		// Loops (Rows => Columns)
		for (int r = 0; r < a.length; r++) {
			for (int c = 0; c < a[r].length; c++) {
				// Variables
				double value = a[r][c];

				// Checks
				if (value > highest) { highest = value; }
			}
		}

		// Return
		return highest;
	}

	/*
	 * @author https://github.com/amattu2
	 * @version 0.01
	 *
	 * Returns the value of the highest value in a array
	 * @param double[][] Array
	 * @param int Column
	 */
	static double getHighestInColumn(double[][] a, int c) {
		// Variables
		double highest = 0;

		// Loops (Row => Column[c]) {
		for (int r = 0; r < a.length; r++) {
			// Checks
			if (a[r].length <= c || c < 0) { continue; }
			if (a[r][c] > highest) { highest = a[r][c]; }
		}

		// Return
		return highest;
	}

	/*
	 * @author https://github.com/amattu2
	 * @version 0.01
	 *
	 * Returns the row index of the highest value in a array
	 * @param double[][] Array
	 * @param int Column
	 */
	static int getHighestInColumnIndex(double[][] a, int c) {
		// Variables
		double highest = 0;
		int index = 0;

		// Loops (Row => Column[c]) {
		for (int r = 0; r < a.length; r++) {
			// Checks
			if (a[r].length <= c || c < 0) { continue; }
			if (a[r][c] > highest) {
				highest = a[r][c];
				index = r;
			}
		}

		// Return
		return index;
	}

	/*
	 * @author https://github.com/amattu2
	 * @version 0.01
	 *
	 * Get highest element in specified row
	 * @param double[][] Array
	 * @param int Row
	 */
	static double getHighestInRow(double[][] a, int r) {
		// Checks
		if (a.length < r || r < 0) { return 0; }

		// Variables
		double highest = 0;

		// Loops
		for (int i = 0; i < a[r].length; i++) {
			// Checks
			if (a[r][i] > highest) { highest = a[r][i]; }
		}

		// Return
		return highest;
	}

	/*
	 * @author https://github.com/amattu2
	 * @version 0.01
	 *
	 * Get the index of the highest element in specified row
	 * @param double[][] Array
	 * @param int Row
	 */
	static int getHighestInRowIndex(double[][] a, int r) {
		// Checks
		if (a.length < r || r < 0) { return 0; }

		// Variables
		double highest = 0;
		int index = 0;

		// Loops
		for (int i = 0; i < a[r].length; i++) {
			// Checks
			if (a[r][i] > highest) {
				highest = a[r][i];
				index = i;
			}
		}

		// Return
		return index;
	}

	/*
	 * @author https://github.com/amattu2
	 * @version 0.01
	 *
	 * Get lowest element in array
	 * @param double[][] Array
	 */
	static double getLowestInArray(double[][] a) {
		// Variables
		double lowest = 0;

		// Loops (Row => Column)
		for (int r = 0; r < a.length; r++) {
			for (int c = 0; c < a[r].length; c++) {
				if (lowest == 0 || a[r][c] < lowest) { lowest = a[r][c]; }
			}
		}

		// Return
		return lowest;
	}

	/*
	 * @author https://github.com/amattu2
	 * @version 0.01
	 *
	 * Get lowest element in specified column
	 * @param double[][] Array
	 * @param int Column
	 */
	static double getLowestInColumn(double[][] a, int c) {
		// Variables
		double lowest = 0;

		// Loops
		for (int r = 0; r < a.length; r++) {
			// Checks
			if (a[r].length <= c || c < 0) { continue; }
			if (lowest == 0 || a[r][c] < lowest) { lowest = a[r][c]; }
		}


		// Return
		return lowest;
	}

	/*
	 * @author https://github.com/amattu2
	 * @version 0.01
	 *
	 * Get index of lowest element in specified column
	 * @param double[][] Array
	 * @param int Column
	 */
	static int getLowestInColumnIndex(double[][] a, int c) {
		// Variables
		double lowest = 0;
		int index = 0;

		// Loops
		for (int r = 0; r < a.length; r++) {
			// Checks
			if (a[r].length <= c || c < 0) { continue; }
			if (lowest == 0 || a[r][c] < lowest) {
				lowest = a[r][c];
				index = r;
			}
		}


		// Return
		return index;
	}

	/*
	 * @author https://github.com/amattu2
	 * @version 0.01
	 *
	 * Get lowest element in a specified row
	 * @param double[][] Array
	 * @param int Row
	 */
	static double getLowestInRow(double[][] a, int r) {
		// Checks
		if (a.length < r || r < 0) { return 0; }

		// Variables
		double lowest = 0;

		// Loops
		for (int i = 0; i < a[r].length; i++) {
			if (lowest == 0 || a[r][i] < lowest) { lowest = a[r][i]; }
		}

		// Return
		return lowest;
	}

	/*
	 * @author https://github.com/amattu2
	 * @version 0.01
	 *
	 * Get index of lowest element in specified row
	 * @param double[][] Array
	 * @param int Row
	 */
	static int getLowestInRowIndex(double[][] a, int r) {
		// Checks
		if (a.length < r || r < 0) { return 0; }

		// Variables
		double lowest = 0;
		int index = 0;

		// Loops
		for (int i = 0; i < a[r].length; i++) {
			if (lowest == 0 || a[r][i] < lowest) {
				lowest = a[r][i];
				index = i;
			}
		}

		// Return
		return index;
	}

	/*
	 * @author https://github.com/amattu2
	 * @version 0.01
	 *
	 * Get total of specified row
	 * @param double[][] Array
	 * @param int Row
	 */
	static double getRowTotal(double[][] a, int r) {
		// Variables
		double total = 0;

		// Loops
		for (int i = 0; i < a[r].length; i++) {
			total += a[r][i];
		}

		// Return
		return total;
	}

	/*
	 * @author https://github.com/amattu2
	 * @version 0.01
	 *
	 * Get total of specified array
	 * @param double[][] Array
	 */
	static double getTotal(double[][] a) {
		// Variables
		double total = 0;

		// Loops
		for (int r = 0; r < a.length; r++) {
			for (int c = 0; c < a[r].length; c++) {
				total += a[r][c];
			}
		}

		// Return
		return total;
	}

	/*
	 * @author https://github.com/amattu2
	 * @version 0.01
	 *
	 * Read elements from file into a array
	 * @param File file
	 */
	static double[][] readFile(File f) throws FileNotFoundException {
		// Variables
		double a[][] = null;
		Scanner scanner1, scanner2;
		int rows = 0;
		int currentRow = 0;
		scanner1 = new Scanner(f);

		// Count Rows
		while (scanner1.hasNextLine()) { rows++; scanner1.nextLine(); }
		scanner1.close();

		// Initialize Rows
		a = new double[rows][];
		scanner2 = new Scanner(f);

		// Fetch Row Data
		while (scanner2.hasNextLine()) {
			// Variables
			String line = scanner2.nextLine();
			String columns[] = line.trim().split(" ");
			a[currentRow] = new double[columns.length];

			// Loop (Row => Column Values)
			for (int i = 0; i < columns.length; i++) {
				a[currentRow][i] = Double.parseDouble(columns[i]);
			}
			currentRow++;
		}

		// Close scanner
		scanner2.close();

		return a;
	}

	/*
	 * @author https://github.com/amattu2
	 * @version 0.01
	 *
	 * Writes a array into a file
	 * @param double[][] Array
	 * @param File file
	 */
	static void writeToFile(double[][] a, File f) throws IOException {
		// Variables
		FileWriter file = new FileWriter(f);

		// Loops
		for (int r = 0; r < a.length; r++) {
			for (int c = 0; c < a[r].length; c++) {
				file.write(a[r][c] + " ");
			}
			file.write("\n");
		}

		// Close
		file.close();
	}
}
