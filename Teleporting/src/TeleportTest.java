import static org.junit.Assert.*;

import org.junit.Test;

public class TeleportTest {

	@Test
	public void testDistance() {
		Planet[] planets = new Planet[3];
		planets[0] = new Planet(5, 6, 7);
		planets[1] = new Planet(6, 11, 11);
		planets[2] = new Planet(10, 10, 10);

		assertEquals(1, Planet.distance(planets[1], planets[0]));
		assertEquals(1, Planet.distance(planets[1], planets[2]));
	}

	@Test
	public void testMinTotalDistance() {
		Planet[] planets = new Planet[4];
		planets[0] = new Planet(5, 6, 7);
		planets[1] = new Planet(6, 11, 11);
		planets[2] = new Planet(10, 10, 10);
		planets[3] = new Planet(12, 12, 12);

		assertEquals(3, Planet.minTotalDistance(planets));
	}

	@Test
	public void edgeComparatorTest() {
		Planet p1 = new Planet(1, 1, 1);
		Planet p2 = new Planet(2, 2, 2);
		Planet p3 = new Planet(20, 20, 20);

		Edge smallEdge = new Edge(p1, p2); // distance 1
		Edge bigggerEdge = new Edge(p1, p3); // distance 19
		assertEquals(0, smallEdge.compareTo(smallEdge));
		assertEquals(-18, smallEdge.compareTo(bigggerEdge)); // negative since e1 is smaller
		assertEquals(18, bigggerEdge.compareTo(smallEdge));

	}

}
