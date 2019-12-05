/*
 * @author https://github.com/amattu2
 * @version 0.01
 * @date 12/4/2019
 */

// Imports
import static org.junit.Assert.*;
import java.util.ArrayList;
import org.junit.Test;

public class MoviePassTestSTUDENT {
	ArrayList<Ticket> fakeTickets = new ArrayList<Ticket>();
	Ticket ticket = new MoviePass("Ticket Test", 9, 1, "NONE", "MoviePass", "PG", 997, fakeTickets);

	@Test
	public void testgetId() {
		assertEquals(997, ticket.getId(), 0.01);
	}

	@Test
	public void testcalculateTicketPrice() {
		assertEquals(9.99, ticket.calculateTicketPrice(), 0.01);
	}
}
