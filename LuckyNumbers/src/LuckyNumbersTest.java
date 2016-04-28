import static org.junit.Assert.*;
import org.junit.Test;

public class LuckyNumbersTest {

	@Test
	public void test() {
		int[] array = {1, 2, 3, 4, 5, 6, 7, 8};
		assertArrayEquals(new int[] {1, 5, 7, 3, 4, 8, 6, 2}, LuckyNumbers.findLuckyNumbers(array));
	}
	
	@Test
	public void test2() {
		int[] array = {4, 3, 2, 1};
		assertArrayEquals(new int[] {4, 2, 1, 3}, LuckyNumbers.findLuckyNumbers(array));
	}
	
	@Test
	public void test3() {
		int[] array = {4, 3, 2, 1, 5, 6, 7, 8, 9, 10, 11, 12};
		assertArrayEquals(new int[] {4, 5, 9, 11, 7, 2, 1, 8, 12, 10, 6, 3}, LuckyNumbers.findLuckyNumbers(array));
	}
}
