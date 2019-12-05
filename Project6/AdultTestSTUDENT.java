/*
 * @author https://github.com/amattu2
 * @version 0.01
 * @date 12/4/2019
 */

// Imports
import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class AdultTestSTUDENT {
	Ticket ticket = new Adult("Ticket Test", 9, 1, "NONE", "Adult", "PG", -1);

	@Test
	public void testgetId() {
		assertEquals(-1, ticket.getId(), 0.01);
	}

	@Test
	public void testcalculateTicketPrice() {
		assertEquals(11.50, ticket.calculateTicketPrice(), 0.01);
	}
}
