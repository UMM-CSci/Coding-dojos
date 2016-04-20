import static org.junit.Assert.*;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;


public class MagicSquareTest {
	
	@Rule
	public ExpectedException thrown = ExpectedException.none();

	@Test
	public void test3by3True() {
		assertTrue(MagicSquare.isMagicSquare(new int[] {8, 1, 6, 3, 5, 7, 4, 9, 2}));
	}
	
	@Test
	public void test3by3True2() {
		assertTrue(MagicSquare.isMagicSquare(new int[] {2, 7, 6, 9, 5, 1, 4, 3, 8}));
	}
	
	@Test
	public void test3by3FalseBadDiagonals() {
		assertFalse(MagicSquare.isMagicSquare(new int[] {3, 5, 7, 8, 1, 6, 4, 9, 2}));
	}
	
	@Test
	public void test3by3FalseBadColumns() {
		assertFalse(MagicSquare.isMagicSquare(new int[] {8, 1, 6, 7, 5, 3, 4, 9, 2}));
	}
	
	@Test
	public void test3by3FalseBadRows() {
		assertFalse(MagicSquare.isMagicSquare(new int[] {8, 7, 4, 1, 5, 9, 6, 3, 2}));
	}
	
	@Test
	public void test4by4True() {
		assertTrue(MagicSquare.isMagicSquare(new int[] {7, 12, 1, 14, 2, 13, 8, 11, 16, 3, 10, 5, 9, 6, 15, 4}));
	}
	
	@Test
	public void test4by4False() {
		assertFalse(MagicSquare.isMagicSquare(new int[] {7, 12, 1, 2, 14, 13, 8, 11, 16, 3, 10, 5, 9, 6, 15, 4}));
	}
	
	@Test
	public void testNotSquare() {
		thrown.expect(IllegalArgumentException.class);
		thrown.expectMessage("Array size must be a perfect square.");
		MagicSquare.isMagicSquare(new int[] {1, 2});
	}
	
	@Test
	public void testNotSquare2() {
		thrown.expect(IllegalArgumentException.class);
		thrown.expectMessage("Array size must be a perfect square.");
		MagicSquare.isMagicSquare(new int[] {1, 2, 3, 4, 5});
	}
	
	@Test
	public void testHugeTrue() {
		assertTrue(MagicSquare.isMagicSquare(new int[] {37, 78, 29, 70, 21, 62, 13, 54, 5,
														6, 38, 79, 30, 71, 22, 63, 14, 46,
														47, 7, 39, 80, 31, 72, 23, 55, 15,
														16, 48, 8, 40, 81, 32, 64, 24, 56,
														57, 17, 49, 9, 41, 73, 33, 65, 25,
														26, 58, 18, 50, 1, 42, 74, 34, 66,
														67, 27, 59, 10, 51, 2, 43, 75, 35,
														36, 68, 19, 60, 11, 52, 3, 44, 76,
														77, 28, 69, 20, 61, 12, 53, 4, 45}));
	}
	
	@Test
	public void testHugeFalse() {
		assertFalse(MagicSquare.isMagicSquare(new int[] {37, 78, 29, 70, 21, 62, 13, 54, 5,
														6, 38, 79, 30, 71, 22, 63, 14, 46,
														47, 7, 39, 80, 31, 72, 23, 55, 15,
														16, 48, 8, 40, 81, 32, 64, 24, 56,
														57, 17, 49, 9, 41, 73, 33, 65, 25,
														26, 58, 18, 50, 1, 42, 74, 34, 66,
														67, 27, 59, 10, 51, 2, 43, 75, 35,
														36, 68, 19, 60, 11, 52, 3, 44, 45,
														77, 28, 69, 20, 61, 12, 53, 4, 76}));
	}

}
