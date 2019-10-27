import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;


public class ManagementCompanyTestSTUDENT {
	// Variables
	ManagementCompany mgmt;
	
	@Before
	public void setUp() throws Exception {
		// Variables
		mgmt = new ManagementCompany("MGMT Company 1", "ABC123", 6);
		
		// Add properties
		mgmt.addProperty("Property 1", "Potomac", 600, "JC Tucker0", 2, 1, 2, 2);
		mgmt.addProperty("Property 2", "Rockville", 700, "JC Tucker1", 4, 1, 2, 2);
		mgmt.addProperty("Property 3", "Rockville", 800, "JC Tucker2", 6, 1, 2, 2);			
	}

	@After
	public void tearDown() {
		mgmt = null;  
	}

	@Test
	public void testAddPropertyDefaultPlot() {
		assertEquals(mgmt.addProperty("Property 1", "Potomac", 888, "JC Tucker3"), 3); // 4 arguemnt
		assertEquals(mgmt.addProperty("Property 1", "Potomac", 999, "JC Tucker4", 2, 1, 2, 2), 4); // 8 argument
		assertEquals(mgmt.addProperty("Property 1", "Potomac", 111, "JC Tucker5"), -1); // out of bounds (6th one)	
	}
 
	@Test
	public void testMaxPropertyRent() {
		String info = mgmt.maxRentPropInfo();
		assertTrue(info.contains("800"));
	}

	@Test
	public void testTotalRent() {
		assertEquals(mgmt.totalRent(), 2100, 0);
	}

 }
