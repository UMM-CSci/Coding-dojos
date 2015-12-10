import static org.junit.Assert.*;

import org.junit.Test;


public class DigitalTest {
	
	@Test(expected=IllegalArgumentException.class)
	public void testGarbageDay() {
		Digital ourDigital = new Digital();
		ourDigital.convertToDigit("League", "of", "Legends");
	}

	@Test
	public void testZero() {
		Digital ourDigital = new Digital();
		assertEquals(0, ourDigital.convertToDigit(" _ ", "| |", "|_|"));
	}
	
	@Test
	public void testOne() {
		Digital ourDigital = new Digital();
		assertEquals(1, ourDigital.convertToDigit("   ", " | ", " | "));
	}
	
	@Test
	public void testTwo() {
		Digital ourDigital = new Digital();
		assertEquals(2, ourDigital.convertToDigit(" _ ", " _|", "|_ "));
	}

	@Test
	public void test3and4and5() {
		Digital ourDigital = new Digital();
		assertEquals(3, ourDigital.convertToDigit(" _ ", " _|", " _|"));
		assertEquals(4, ourDigital.convertToDigit("   ", "|_|", "  |"));
		assertEquals(5, ourDigital.convertToDigit(" _ ", "|_ ", " _|"));
	}
	
	@Test
	public void test6and7() {
		Digital ourDigital = new Digital();
		assertEquals(6, ourDigital.convertToDigit(" _ ", "|_ ", "|_|"));
		assertEquals(7, ourDigital.convertToDigit(" _ ", "  |", "  |"));
	}
	
	@Test
	public void test8and9() {
		Digital ourDigital = new Digital();
		assertEquals(8, ourDigital.convertToDigit(" _ ", "|_|", "|_|"));
		assertEquals(9, ourDigital.convertToDigit(" _ ", "|_|", "  |"));
	}
	
	@Test
	public void testSeriesOfNums() {
		Digital ourDigital = new Digital();
		assertEquals(543210, ourDigital.convertSeriesToInteger(" _     _  _     _ ", "|_ |_| _| _| | | |", " _|  | _||_  | |_|"));
	}
	
	@Test
	public void testSingleNumber() {
		Digital ourDigital = new Digital();
		assertEquals(8, ourDigital.convertSeriesToInteger(" _ ", "|_|", "|_|"));
	}
	
	@Test
	public void test06789Run() {
		Digital ourDigital = new Digital();
		assertEquals(6789, ourDigital.convertSeriesToInteger(" _  _  _  _  _ ", "| ||_   ||_||_|", "|_||_|  ||_|  |"));
	}
	
}
