import static org.junit.Assert.*;

import org.junit.Test;


public class TestPlayer {
	@Test
	public void testName() {
		Player player1 = new Player();
		player1.setName("Bart");
		assertEquals(player1.getName(), "Bart");
	}
	
	
}
