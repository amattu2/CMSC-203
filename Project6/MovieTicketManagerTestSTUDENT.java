/*
 * @author https://github.com/amattu2
 * @version 0.01
 * @date 12/4/2019
 */

// Imports
import static org.junit.Assert.*;
import java.util.ArrayList;
import org.junit.Before;
import org.junit.Test;

public class MovieTicketManagerTestSTUDENT {
	// Variables
	private MovieTicketManager ticketList;

	@Before
	public void setUp() throws Exception {
		// Variables
		ticketList = new MovieTicketManager();

		// Add Tickets
		ticketList.addTicket("Movie 1", "G", 4, 11, "NONE", "Adult", 0);
		ticketList.addTicket("Movie 2", "G", 3, 8, "NONE", "Child", 0);
		ticketList.addTicket("Movie 3", "R", 2, 9, "3D", "Employee", 12345);
		ticketList.addTicket("Movie 4", "R", 1, 10, "NONE", "MoviePass", 22222);
	}

	@Test
	public void testNumVisits() {
		assertEquals(1, ticketList.numVisits(12345));
		assertEquals(1, ticketList.numVisits(22222));
		assertEquals(0, ticketList.numVisits(2019));
	}

	@Test
	public void testNumThisMovie() {
		assertEquals(1, ticketList.numThisMovie(12345, "Movie 3"));
		assertEquals(0, ticketList.numThisMovie(12345, "Fake Movie"));
	}

	@Test
	public void testNumMoviesToday() {
		assertEquals(1, ticketList.numMoviesToday(12345, 2));
		assertEquals(1, ticketList.numMoviesToday(22222, 1));
	}

	@Test
	public void testAddTicket() {
		MovieTicketManager tickets = new MovieTicketManager();
		assertEquals(15.34, tickets.addTicket("Movie ABC", "PG13", 5, 19, "NONE", "Adult", 0), 0.01);
		assertEquals(0.00, tickets.addTicket("Movie ABC", "PG13", 5, 19, "NONE", "Employee", 0), 0.01);
	}

	@Test
	public void testTotalSalesMonth() {
		assertEquals(29.32, ticketList.totalSalesMonth(), 0.01);
	}

	@Test
	public void testGet3DTickets() {
		ArrayList<String> result = ticketList.get3DTickets();
		assertTrue("Day 2", result.get(0).contains("Movie 3"));
	}

	@Test
	public void testGetAllTickets() {
		ArrayList<String> result = ticketList.getAllTickets();
		assertTrue("Day 1",result.get(0).contains("Day: 1"));
		assertTrue("Day 2",result.get(1).contains("Day: 2"));
	}

	@Test
	public void testGetMoviePassTickets() {
		ArrayList<String> result = ticketList.getMoviePassTickets();
		assertTrue("22222",result.get(0).contains("22222"));
	}
}
