import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;


public class ManagementCompanyTest {
	
	ManagementCompany m ; 
	
	@Before
	public void setUp() throws Exception {
		
		m= new ManagementCompany("Alliance", "1235",6);
	 
		m.addProperty("Belmar", "Silver Spring", 1200.45, "John Smith",2,1,2,2);
		m.addProperty("Camden Lakeway", "Rockville", 2450, "Ann Taylor",4,1,2,2);
		m.addProperty("Hamptons", "Rockville", 1250, "Rick Steves",6,1,2,2);
		
	}

	@After
	public void tearDown() {
		m=null;
	}

 	@Test
	public void testAddPropertyWithPlot() {
 		//should create properties with 8 args
		assertEquals(m.addProperty("Mallory Square", "Wheaton", 1000, "Abbey McDonald",1,4,2,2),3,0); 
		assertEquals(m.addProperty("Lakewood", "Rockville", 3000.0, "Alex Tan",3,4,2,2),4,0); 
		assertEquals(m.addProperty("Lakewood", "Rockville", 3000, "Alex Tan",3,6,2,2),-1,0);  //exceeds the size of the array and can not be added, add property should return -1	
	}
 	
	@Test
	public void testAddPropertyDefaultPlot() {
		//should create one property with 4 args & default plot
	
		assertEquals(m.addProperty("Mallory Square", "Wheaton", 1000, "Abbey McDonald"),3,0); //should create property with 4 args & default plot (0,0,1,1)
		assertEquals(m.addProperty("Lakewood", "Rockville", 3000, "Alex Tan",3,4,2,2),4,0); //should create property with 8 args
		assertEquals(m.addProperty("Lakewood", "Rockville", 3000, "Alex Tan",3,6,2,2),-1,0);  //exceeds the size of the array and can not be added, add property should return -1	
	}
 
 
	@Test
	public void testtoString() {
				
		assertTrue(m.toString().contains("Property Name: Belmar"));
		assertTrue(m.toString().contains("Located in Silver Spring"));
		assertTrue(m.toString().contains("Belonging to: John Smith"));
		assertTrue(m.toString().contains("Rent Amount: 1200.45"));
		assertTrue(m.toString().contains("Property Name: Hamptons"));
		assertTrue(m.toString().contains("Located in Rockville"));
		assertTrue(m.toString().contains("Belonging to: Rick Steves"));
		assertTrue(m.toString().contains("Rent Amount: 1250.0"));
		assertTrue(m.toString().contains("total management Fee:"));
		
 
	}
	@Test
	public void testMaxRentProp() {
		String propInfo = m.maxRentPropInfo();
		assertTrue(propInfo.contains("2450.0"));
		assertTrue(propInfo.contains("Camden Lakeway"));
		assertTrue(propInfo.contains("Rockville"));
		assertTrue(propInfo.contains("Ann Taylor")); 
	}
	 

	@Test
	public void testTotalRent() {

		assertEquals(m.totalRent(),4900.45,0);
	}

 }
