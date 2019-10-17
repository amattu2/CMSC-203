import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class GradeBookTest {
	GradeBook gb1, gb2;
	
	@BeforeEach
	void setUp() throws Exception {
		// Initialize Variables
		gb1 = new GradeBook(5);
		gb2 = new GradeBook(5);
		
		// Add Scores
		gb1.addScore(78);
		gb1.addScore(69);
		gb1.addScore(10);
		gb2.addScore(97);
		gb2.addScore(88);	
	}

	@AfterEach
	void tearDown() throws Exception {
		gb1 = null;
		gb2 = null;
	}

	@Test
	void testAddScore() {}

	@Test
	void testSum() {
		// Test .sum
		assertTrue(157.0 == gb1.sum());
		assertTrue(185.0 == gb2.sum());
	}

	@Test
	void testMinimum() {
		// Test .minimum
		assertTrue(10.0 == gb1.minimum());
		assertTrue(88.0 == gb2.minimum());
	}

	@Test
	void testFinalScore() {
		// Test .finalScore
		assertTrue(147.0 == gb1.finalScore());
		assertTrue(97.0 == gb2.finalScore());	
	}

	@Test
	void testGetScoreSize() {
		// Test .getScoreSize
		assertEquals(3, gb1.getScoreSize());
		assertEquals(2, gb2.getScoreSize());
	}

	@Test
	void testToString() {
		// Test .toString
		assertTrue("78.0 69.0 10.0".equals(gb1.toString()));
		assertTrue("97.0 88.0".equals(gb2.toString()));
	}

}
