import static org.junit.Assert.*;

import org.junit.Test;


public class TestByteKata{
	@Test
	public void testAnd() {
		Integer[] byteArray = {1, 1, 1, 1, 1, 1, 1, 1};
		ByteKata andTester = new ByteKata(byteArray);
		ByteKata secondAndTester = new ByteKata(byteArray);
		assertTrue(andTester.and(secondAndTester).equals(andTester));
	}
	
	@Test
	public void testAndTwo() {
		Integer[] byteArray = {0, 1, 0, 1, 1, 0, 0, 0};
		ByteKata andTester = new ByteKata(byteArray);
		ByteKata secondAndTester = new ByteKata(byteArray);
		assertTrue(andTester.and(secondAndTester).equals(andTester));
	}
	
	@Test
	public void testAndThree() {
		Integer[] byteArray = {0, 1, 0, 1, 1, 0, 0, 0};
		Integer[] byteArray2 = {0, 0, 0, 1, 1, 0, 1, 0};
		Integer[] byteArrayExpected = {0, 0, 0, 1, 1, 0, 0, 0};
		ByteKata andTester = new ByteKata(byteArray);
		ByteKata secondAndTester = new ByteKata(byteArray2);
		ByteKata expectedByteArray = new ByteKata(byteArrayExpected);
		assertTrue(andTester.and(secondAndTester).equals(expectedByteArray));
	}
	
	@Test
	public void testGetValue() {
		Integer[] byteArray = {1, 0, 0, 1, 1, 0, 1, 1};
		ByteKata tester = new ByteKata(byteArray);
		
		assertTrue(tester.getValue(0).equals(1));
		assertTrue(tester.getValue(2).equals(0));
		
	}
	
	@Test
	public void testOr() {
		Integer[] byteArray = {1, 1, 1, 1, 1, 1, 1, 1};
		ByteKata orTester = new ByteKata(byteArray);
		ByteKata secondAndTester = new ByteKata(byteArray);
		assertTrue(orTester.or(secondAndTester).equals(orTester));
	}
	
	@Test
	public void testOrTwo() {
		Integer[] byteArray = {0, 1, 0, 1, 1, 0, 0, 0};
		ByteKata orTester = new ByteKata(byteArray);
		ByteKata secondAndTester = new ByteKata(byteArray);
		assertTrue(orTester.or(secondAndTester).equals(orTester));
	}
	
	@Test
	public void testOrThree() {
		Integer[] byteArray = {0, 1, 0, 1, 1, 0, 0, 0};
		Integer[] byteArray2 = {0, 0, 0, 1, 1, 0, 1, 0};
		Integer[] byteArrayExpected = {0, 1, 0, 1, 1, 0, 1, 0};
		ByteKata orTester = new ByteKata(byteArray);
		ByteKata secondAndTester = new ByteKata(byteArray2);
		ByteKata expectedByteArray = new ByteKata(byteArrayExpected);
		assertTrue(orTester.or(secondAndTester).equals(expectedByteArray));
	}
	
	@Test
	public void testNot() {
		Integer[] byteArray = {1, 1, 1, 0, 0, 1, 0, 1};
		Integer[] expected = {0, 0, 0, 1, 1, 0, 1, 0};
		ByteKata notTester = new ByteKata(byteArray);
		ByteKata notExpected = new ByteKata(expected);
		
		assertTrue(notTester.not().equals(notExpected)); 
		//HAHAHAHAHAHAh
	}
	
	@Test
	public void testXor() {
		Integer[] byteArray = {1, 1, 1, 0, 0, 1, 0, 1};
		Integer[] byteArray2 = {1, 1, 1, 0, 0, 1, 0, 1};
		Integer[] expected = {0, 0, 0, 0, 0, 0, 0, 0};
		ByteKata xorTester = new ByteKata(byteArray);
		ByteKata xorTester2 = new ByteKata(byteArray2);
		ByteKata expectedXor = new ByteKata(expected);
	
		assertTrue(xorTester.xor(xorTester2).equals(expectedXor));
	}
}
