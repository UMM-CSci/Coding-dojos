import static org.junit.Assert.*;

import org.junit.Test;

public class PlantTest {

	@Test
	public void testLocalSunlight0() {
		assertEquals(60, Plants.localSunlightFunction(28, 12, 3, 76));
	}
	
	@Test
	public void testLocalSunlight1() {
		assertEquals(76, Plants.localSunlightFunction(30, 40, 3, 76));
	}
	
	@Test
	public void testLocalSunlight2() {
		assertEquals(45, Plants.localSunlightFunction(28, 0, 3, 76));
	}
	
	@Test
	public void testLocalSunlight3() {
		assertEquals(76, Plants.localSunlightFunction(0, 12, 0, 76));
	}
	
	@Test
	public void testLocalSunlight4() {
		assertEquals(76, Plants.localSunlightFunction(0, 0, 0, 76));
	}
	
	@Test
	public void testLocalSunlight5() {
		assertEquals(0, Plants.localSunlightFunction(15, 25, 27, 0));
	}
	
	@Test
	public void testLocalSunlight6() {
		assertEquals(98, Plants.localSunlightFunction(15, 25, 27, 100));
	}
	
	@Test
	public void testLocalSunlight7() {
		assertEquals(80, Plants.localSunlightFunction(20, 10, 20, 100));
	}
	
	/**
	 * TESTING GROWTH
	 */
	
	@Test
	public void testGrowth() {
		assertEquals(0, Plants.growthFunction(100, 0));
	}
	
	@Test
	public void testGrowth2() {
		assertEquals(17, Plants.growthFunction(100, 1));
	}
	
	@Test
	public void testGrowth3() {
		assertEquals(50, Plants.growthFunction(50, 50));
	}
	
	@Test
	public void testGrowth4() {
		assertEquals(41, Plants.growthFunction(25, 40));
	}
	
	@Test
	public void testGrowth5() {
		assertEquals(40, Plants.growthFunction(24, 40));
	}
	
	/**
	 * TESTING GROWTH
	 */
	@Test
	public void testDayHandler() {
		int[] garden = new int[] {1};
		Plants.doDay(garden, 80);
		assertArrayEquals(new int[] {13}, garden);
	}
}
