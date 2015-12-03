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
	public void testMinTotalDistance(){
		Planet[] planets = new Planet[4];
		planets[0] = new Planet(5, 6, 7);
		planets[1] = new Planet(6, 11, 11);
		planets[2] = new Planet(10, 10, 10);
		planets[3] = new Planet(12, 12, 12);
		
		assertEquals(3, Planet.minTotalDistance(planets));
	}
	

}
