import static org.junit.Assert.*;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class LRU_Test {
	@Test
	public void testNotFound() {
		LRU_Cache<Integer, String> cache = new LRU_Cache<Integer, String>(5);
		assertNull(cache.get(2));
	}
	
	@Test
	public void testFound() {
		LRU_Cache<Integer, String> cache = new LRU_Cache<Integer, String>(5);
		cache.set(2, "Happy");
		assertEquals("Happy", cache.get(2));
	}
	
	@Test
	public void testSetInMiddle() {
		LRU_Cache<Integer, String> cache = new LRU_Cache<Integer, String>(5);
		cache.set(4, "First");
		cache.set(2, "Second");
		cache.set(3, "Last");
		cache.set(2, "Sad");
		assertEquals("Sad", cache.get(2));
	}
	
	@Test
	public void testSetInOnly() {
		LRU_Cache<Integer, String> cache = new LRU_Cache<Integer, String>(5);
		cache.set(2, "Only");
		cache.set(2, "Sad");
		assertEquals("Sad", cache.get(2));
	}
	
	@Test
	public void testSetInHead() {
		LRU_Cache<Integer, String> cache = new LRU_Cache<Integer, String>(5);
		cache.set(2, "First");
		cache.set(3, "Second");
		cache.set(2, "Sad");
		assertEquals("Sad", cache.get(2));
	}
	
	@Test
	public void testSetInTail() {
		LRU_Cache<Integer, String> cache = new LRU_Cache<Integer, String>(5);
		cache.set(2, "First");
		cache.set(3, "Second");
		cache.set(3, "Sad");
		assertEquals("Sad", cache.get(3));
	}
	
	@Test
	public void testCapacity() {
		LRU_Cache<Integer, String> cache = new LRU_Cache<Integer, String>(2);
		cache.set(2, "First");
		cache.set(3, "Second");
		cache.set(4, "Third"); // Pushes out first item
		assertNull(cache.get(2));
	}
	
	@Test
	public void testSingleCapacity() {
		LRU_Cache<Integer, String> cache = new LRU_Cache<Integer, String>(1);
		cache.set(2, "First");
		cache.set(3, "Second"); // Pushes out first item
		assertNull(cache.get(2));
	}
	
	@Test
	public void testRefreshGet() {
		LRU_Cache<Integer, String> cache = new LRU_Cache<Integer, String>(2);
		cache.set(2, "First");
		cache.set(3, "Second");
		cache.get(2);
		cache.set(10, "Me"); // Pushes out "Second", should not push out "First"
		assertEquals("First", cache.get(2));
	}
	
	@Test
	public void testPushOutCorrectly() {
		LRU_Cache<Integer, String> cache = new LRU_Cache<Integer, String>(2);
		cache.set(2, "First");
		cache.set(3, "Second");
		cache.set(10, "Me"); // should push out first item, but not second
		assertNull(cache.get(2));
		assertEquals("Second", cache.get(3));
		assertEquals("Me", cache.get(10));
	}
	
	@Rule
	public ExpectedException expectedEx = ExpectedException.none();
	
	@Test
	public void testZeroCapacity() {
		expectedEx.expect(RuntimeException.class);
		expectedEx.expectMessage("Capacity given must be positive.");
		LRU_Cache<Integer, String> cache = new LRU_Cache<Integer, String>(0);
	}
	
	@Test
	public void testNegativeCapacity() {
		expectedEx.expect(RuntimeException.class);
		expectedEx.expectMessage("Capacity given must be positive.");
		LRU_Cache<Integer, String> cache = new LRU_Cache<Integer, String>(-822);
	}
}
