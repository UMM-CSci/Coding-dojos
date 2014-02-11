import static org.junit.Assert.*;

import org.junit.Test;

public class TestFrame {
	@Test
	public void testAddScore() throws OverTenException {
		Frame frame = new Frame(1);
		frame.addScore(2);
		Integer expect = 2;
		assertEquals(frame.getRoll(1), expect);
		frame.addScore(5);
		assertEquals(frame.getRoll(1), expect);
		expect = 5;
		assertEquals(frame.getRoll(2), expect);
		
	}
	
	@Test(expected=OverTenException.class)
	public void testTenthFrame() throws OverTenException {
		Frame frame = new Frame(10);
		frame.addScore(10);
		frame.addScore(10);
		frame.addScore(2);
		Integer expect = 10;
		assertEquals(frame.getRoll(1), expect);
		assertEquals(frame.getRoll(2), expect);
		expect = 2;
		assertEquals(frame.getRoll(3), expect);
	}
	
	 @Test(expected=OverTenException.class)
	 public void testOverTenException() throws OverTenException {
		 Frame frame = new Frame(1);
		 frame.addScore(9);
		 frame.addScore(9);
	 }
	
}
