import static org.junit.Assert.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TwoDimRaggedArrayUtilitySTUDENTTest {
	// Variables
	private double[][] dataSet1 = {{5,5,8}, {6,7,8}};
	private double[][] dataSet2 = {{7,4}, {5,-8}, {8,5,3}, {11,7,2}};

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
		dataSet1 = null;
		dataSet2 = null;
	}

	/**
	 * Test getTotal method
	 * Returns the total of all the elements in the two dimensional array
	 */
	@Test
	public void testGetTotalSTUDENT() {
		assertEquals(39.0, TwoDimRaggedArrayUtility.getTotal(dataSet1), .001);
		assertEquals(44.0, TwoDimRaggedArrayUtility.getTotal(dataSet2), .001);
	}

	/**
	 * Test getAverage method
	 * Returns the average of all the elements in the two dimensional array
	 */
	@Test
	public void testGetAverageSTUDENT() {
		assertEquals(6.5, TwoDimRaggedArrayUtility.getAverage(dataSet1), .001);
		assertEquals(4.4, TwoDimRaggedArrayUtility.getAverage(dataSet2), .001);
	}

	
	/**
	 * Test getRowTotal method
	 * Returns the total of all the elements of the row.
	 * Row 0 refers to the first row in the two dimensional array
	 */
	@Test
	public void testGetRowTotalSTUDENT() {
		assertEquals(21, TwoDimRaggedArrayUtility.getRowTotal(dataSet1, 1), .001);
		assertEquals(-3, TwoDimRaggedArrayUtility.getRowTotal(dataSet2, 1), .001);
	}
	

	/**
	 * Test getColumnTotal method
	 * Returns the total of all the elements in the column. If a row in the two dimensional array
	 * doesn't have this column index, it is not an error, it doesn't participate in this method.
	 * Column 0 refers to the first column in the two dimensional array
	 */
	@Test
	public void testGetColumnTotalSTUDENT() {
		assertEquals(11.0, TwoDimRaggedArrayUtility.getColumnTotal(dataSet1, 0), .001);
		assertEquals(5.0, TwoDimRaggedArrayUtility.getColumnTotal(dataSet2, 2), .001);
	}
	

	/**
	 * Test getHighestInRow method
	 * Returns the largest of all the elements in the row.
	 * Row 0 refers to the first row in the two dimensional array
	 */
	@Test
	public void testGetHighestInRowSTUDENT() {
		assertEquals(8, TwoDimRaggedArrayUtility.getHighestInRow(dataSet1,0), .001);
		assertEquals(8, TwoDimRaggedArrayUtility.getHighestInRow(dataSet2,2), .001);		
	}

	/**
	 * Test getHighestInRowIndex method
	 * Returns the index of the largest of all the elements in the row.
	 * Row 0 refers to the first row in the two dimensional array
	 */
	@Test
	public void testGetHighestInRowIndexSTUDENT() {
		assertEquals(2, TwoDimRaggedArrayUtility.getHighestInRowIndex(dataSet1,0));
		assertEquals(0, TwoDimRaggedArrayUtility.getHighestInRowIndex(dataSet2,2));		
	}
	
	
	/**
	 * Test getLowestInColumn method
	 * Returns the smallest of all the elements in the column. If a row in the two dimensional array
	 * doesn't have this column index, it is not an error, it doesn't participate in this method.
	 * Column 0 refers to the first column in the two dimensional array
	 */

	@Test
	public void testGetLowestInColumnSTUDENT() {		
		assertEquals(0, TwoDimRaggedArrayUtility.getLowestInRowIndex(dataSet1, 0));
		assertEquals(2, TwoDimRaggedArrayUtility.getLowestInRowIndex(dataSet2, 2));
	}

	/**
	 * Test getLowestInColumnIndex method
	 * Returns the index of the smallest of all the elements in the column. If a row in the two dimensional array
	 * doesn't have this column index, it is not an error, it doesn't participate in this method.
	 * Column 0 refers to the first column in the two dimensional array
	 */

	@Test
	public void testGetLowestInColumnIndexSTUDENT() {
		assertEquals(6, TwoDimRaggedArrayUtility.getLowestInRow(dataSet1, 1), .001);
		assertEquals(-8, TwoDimRaggedArrayUtility.getLowestInRow(dataSet2, 1), .001);		
	}
	

	/**
	 * Test getLowestInArray method
	 * Returns the smallest of all the elements in the two dimensional array.
	 */
	@Test
	public void testGetLowestInArraySTUDENT() {
		assertEquals(0, TwoDimRaggedArrayUtility.getLowestInRowIndex(dataSet1,1),.001);
		assertEquals(1, TwoDimRaggedArrayUtility.getLowestInRowIndex(dataSet2,0),.001);		
	}
	
	
	
}
