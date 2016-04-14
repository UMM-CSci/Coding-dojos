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
		cache.set(2, "Frank");
		cache.set(3, "Susie");
		cache.set(2, "Sad");
		assertEquals("Sad", cache.get(2));
	}
	
	@Test
	public void testSetInTail() {
		LRU_Cache<Integer, String> cache = new LRU_Cache<Integer, String>(5);
		cache.set(2, "Brad");
		cache.set(3, "Lacey");
		cache.set(3, "Sad");
		assertEquals("Sad", cache.get(3));
	}
	
	@Test
	public void testCapacity() {
		LRU_Cache<Integer, String> cache = new LRU_Cache<Integer, String>(2);
		cache.set(2, "Annie");
		cache.set(3, "Teddy");
		cache.set(4, "Trina"); // Pushes out first item
		assertNull(cache.get(2));
	}
	
	@Test
	public void testSingleCapacity() {
		LRU_Cache<Integer, String> cache = new LRU_Cache<Integer, String>(1);
		cache.set(2, "Nella");
		cache.set(3, "Bella"); // Pushes out first item
		assertNull(cache.get(2));
	}
	
	@Test
	public void testRefreshGet() {
		LRU_Cache<Integer, String> cache = new LRU_Cache<Integer, String>(2);
		cache.set(2, "You");
		cache.set(3, "Us");
		cache.get(2);
		cache.set(10, "Me"); // Pushes out "Second", should not push out "First"
		assertNull(cache.get(3));
		assertEquals("You", cache.get(2));
		
	}
	
	@Test
	public void testPushOutCorrectly() {
		LRU_Cache<Integer, String> cache = new LRU_Cache<Integer, String>(2);
		cache.set(2, "You");
		cache.set(3, "Us");
		cache.set(10, "Me"); // should push out first item, but not second
		assertNull(cache.get(2));
		assertEquals("Us", cache.get(3));
		assertEquals("Me", cache.get(10));
	}
	
	@Rule
	public ExpectedException expectedEx = ExpectedException.none();
	
	@Test
	public void testZeroCapacity() {
		expectedEx.expect(RuntimeException.class);
		expectedEx.expectMessage("Capacity given must be positive.");
		new LRU_Cache<Integer, String>(0);
	}
	
	@Test
	public void testNegativeCapacity() {
		expectedEx.expect(RuntimeException.class);
		expectedEx.expectMessage("Capacity given must be positive.");
		new LRU_Cache<Integer, String>(-822);
	}
	
	@Test
	public void testRefreshSingleNode() {
		LRU_Cache<String, String> cache = new LRU_Cache<String, String>(3);
		cache.set("Entree", "Beef stroganoff");
		cache.get("Entree");
		cache.set("Dessert", "Ice cream");
		cache.set("Soup", "Tomato basil");
		cache.set("Salad dressing", "Ranch"); // pushes off Entree, forcing removeTail to be called
		assertEquals("Ice cream", cache.get("Dessert"));
		assertEquals("Tomato basil", cache.get("Soup"));
		assertEquals("Ranch", cache.get("Salad dressing"));
		assertNull(cache.get("Entree"));
	}
	
	@Test
	public void testToString() {
		LRU_Cache<String, String> cache = new LRU_Cache<String, String>(2);
		cache.set("Entree", "Beef stroganoff");
		cache.set("Salad dressing", "Ranch");
		assertEquals("Hash: [Salad dressing, Entree], List: [Salad dressing, Entree]", cache.toString());
		cache.set("Dessert", "Ice cream"); // push out Entree
		assertEquals("Hash: [Dessert, Salad dressing], List: [Dessert, Salad dressing]", cache.toString());
	}
}
