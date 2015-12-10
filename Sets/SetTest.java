import static org.junit.Assert.*;

import org.junit.Test;


public class SetTest {

	@Test
	public void testIsEmptyOnEmptySet() {
		OurSet<String> set = new OurSet<String>();
		assertTrue(set.isEmpty());
	}
	
	@Test
	public void testSizeOnEmptySet() {
		OurSet<String> set = new OurSet<String>();
		assertEquals(0, set.size());
	}
	
	@Test
	public void testAddChangesSizeAndMarksNotEmpty() {
		OurSet<String> set = new OurSet<String>();
		set.add("Hi");
		assertEquals(1, set.size());
		assertFalse(set.isEmpty());
	}
	
	@Test
	public void testAddDuplicates() {
		OurSet<String> set = new OurSet<String>();
		set.add("Hi");
		assertFalse(set.add("Hi"));
	}
	
	@Test
	public void testAddWithoutDuplicateReturnsTrue() {
		OurSet<String> set = new OurSet<String>();
		set.add("Hi");
		assertTrue(set.add("Apple"));
	}
	
	@Test
	public void testContains() {
		OurSet<String> set = new OurSet<String>();
		set.add("Hi");
		assertTrue(set.contains("Hi"));
		assertFalse(set.contains("Apple"));
	}
	
	@Test
	public void testRemove() {
		OurSet<Integer> set = new OurSet<Integer>();
		set.add(45);
		set.add(10);
		assertEquals(2, set.size());
		assertTrue(set.remove(45));
		assertEquals(1, set.size());
		assertFalse(set.remove(37));
		assertEquals(1, set.size());
	}
	
	@Test
	public void clear() {
		OurSet<String> set = new OurSet<String>();
		set.add("Hi");
		assertEquals(1, set.size());
		assertFalse(set.isEmpty());
		set.clear();
		assertEquals(0, set.size());
		assertTrue(set.isEmpty());
	}
	
	@Test
	public void testEquals() {
		OurSet<String> set1 = new OurSet<String>();
		set1.add("Hi");
		set1.add("Hi1");
		set1.add("Hi2");
		OurSet<String> set2 = new OurSet<String>();
		set2.add("Hi");
		set2.add("Hi1");
		set2.add("Hi2");
		OurSet<Integer> set3 = new OurSet<Integer>();
		set3.add(5);
		set3.add(6);
		set3.add(7);

		assertTrue(set1.equals(set2));
		assertFalse(set1.equals(set3));
		assertFalse(set1.equals(17));
	}
	
	@Test
	public void testPerfectUnion() {
		OurSet<String> set1 = new OurSet<String>();
		set1.add("Hi");
		set1.add("Hi1");
		set1.add("Hi2");
		OurSet<String> set2 = new OurSet<String>();
		set2.add("Hi");
		set2.add("Hi1");
		set2.add("Hi2");
		assertEquals(OurSet.union(set1, set2), set1);
		assertEquals(OurSet.union(set1, set2), set2);
	}
	
	@Test
	public void testUnionSmallerSubset() {
		OurSet<String> set1 = new OurSet<String>();
		set1.add("Hi");
		set1.add("Hi1");
		set1.add("Hi2");
		OurSet<String> set2 = new OurSet<String>();
		set2.add("Hi");
		set2.add("Hi1");
		assertEquals(OurSet.union(set1, set2), set1);
		assertNotEquals(OurSet.union(set1, set2), set2);
	}
	
	@Test
	public void testUnionNotOverlap() {
		OurSet<Integer> set1 = new OurSet<Integer>();
		set1.add(0);
		set1.add(1);
		set1.add(2);
		OurSet<Integer> set2 = new OurSet<Integer>();
		set2.add(3);
		set2.add(4);
		
		OurSet<Integer> expectedResult = new OurSet<Integer>();
		expectedResult.add(0);
		expectedResult.add(1);
		expectedResult.add(2);
		expectedResult.add(3);
		expectedResult.add(4);
		
		assertEquals(OurSet.union(set1, set2), expectedResult);
		assertNotEquals(OurSet.union(set1, set2), set2);
	}
	

}
