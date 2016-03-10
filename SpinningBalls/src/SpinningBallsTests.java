import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;


public class SpinningBallsTests {
	Juggler juggler1;
	Ball ball1;
	Ball ball2;
	Ball ball3;
	
	@Before
	public void testSetup() {
		juggler1 = new Juggler();
		ball1 = new Ball(new String[]{"Red", "Green", "Blue", "Yellow"}, 0);
		ball2 = new Ball(new String[]{"Yellow", "Green", "Blue", "Red"}, 2);
		ball3 = new Ball(new String[]{"Blue", "Green", "Red", "Yellow"}, 1);
		
		juggler1.add(ball1);
		juggler1.add(ball2);
		juggler1.add(ball3);
	}

	@Test
	public void testJuggler() {
		assertEquals(juggler1.getMinRotations(), 2);
	}
	
	@Test
	public void testBall() {
		assertEquals(ball1.getRotation("Red"), 0);
		assertEquals(ball1.getRotation("Yellow"), 1);
		assertEquals(ball2.getRotation("Red"), 1);
		assertEquals(ball2.getRotation("Yellow"), 2);
	}

}
