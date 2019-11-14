import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class HolidayBonusSTUDENTTest {
	private double[][] dataSet1 = {{5,4,3},{8,9},{7,8}};
	private double[][] dataSet2 = {{-1, 9, 8},{5},{8,1},{1,5,2}};

	@Before
	public void setUp() throws Exception {
	}
	
	@After
	public void tearDown() throws Exception {
	}


	/**
	 * Test calculateHolidayBonus method with a high of 5000, low of 1000 and 2000 as other
	 */

	@Test
	public void testCalculateHolidayBonusSTUDENTA() {
		try {
			double[] result = HolidayBonus.calculateHolidayBonus(dataSet1, 5000, 1000, 2000);
			assertEquals(2000.0, result[0], .001);
		} catch (Exception e) {
			fail("This should not have caused an Exception");
		} 
	}
	

	/**
	 * Test calculateHolidayBonus method with a high of 1000, low of 250 and 500 as other
	 */

	@Test
	public void testCalculateHolidayBonusSTUDENTB() {
		try {
			double[] result = HolidayBonus.calculateHolidayBonus(dataSet1,1000, 250, 500);
			assertEquals(1000.0, result[1], .001);
		} catch (Exception e) {
			fail("This should not have caused an Exception");
		} 	
	}

	/**
	 * Test calculateTotalHolidayBonus method with a high of 5000, low of 1000 and 2000 as other
	 */
	@Test
	public void testCalculateTotalHolidayBonusA() {
		assertEquals(8000.0, HolidayBonus.calculateTotalHolidayBonus(dataSet1, 5000, 1000, 2000), .001);
	}
	
	/** 
	 * Test calculateTotalHolidayBonus method with a high of 1000, low of 250 and 500 as other
	 */
	@Test
	public void testCalculateTotalHolidayBonusB() {
		assertEquals(1750.0, HolidayBonus.calculateTotalHolidayBonus(dataSet1, 1000, 250, 500), .001);
	}

}
