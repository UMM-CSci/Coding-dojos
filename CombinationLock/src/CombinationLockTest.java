import static org.junit.Assert.*;
import org.junit.Test;

public class CombinationLockTest {

	@Test
	public void test1() {
		CombinationLock FourtyLock = new CombinationLock(40);
		assertEquals(215, FourtyLock.calculateDistance(0, 10, 5, 15));
	}
	
	@Test
	public void test2() {
		CombinationLock FourtyLock = new CombinationLock(40);
		assertEquals(191, FourtyLock.calculateDistance(0, 10, 33, 15));
	}
	
	@Test
	public void test3() {
		CombinationLock FourtyLock = new CombinationLock(40);
		assertEquals(195, FourtyLock.calculateDistance(0, 5, 5, 5));
	}
	
	@Test
	public void test4() {
		CombinationLock FourtyLock = new CombinationLock(40);
		assertEquals(160, FourtyLock.calculateDistance(0, 0, 0, 0));
	}
}
