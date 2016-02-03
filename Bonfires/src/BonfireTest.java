import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class BonfireTest {
	
	int[][] grid;
	
	@Before
	public void before() {
		grid = new int[3][4];
		grid[1][0] = 15;
		grid[1][1] = -1;
	}

	@Test
	public void test() {
		LightGenerator.generateLight(grid);
		assertEquals(15, grid[1][0]);
		assertEquals(-1, grid[1][1]);
		assertEquals(11, grid[1][2]);
		assertEquals(10, grid[1][3]);
		assertEquals(11, grid[2][3]);
	}

}
