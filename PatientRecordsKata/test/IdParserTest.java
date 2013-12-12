import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;


public class IdParserTest {

	@Test
	public void testListParser() {
		String testMedList = "{1;3;9}";
		List<Integer> ids = IdParser.parse(testMedList);
		assertEquals(3, ids.size());
		assertEquals(new Integer(1), ids.get(0));
		assertEquals(new Integer(3), ids.get(1));
		assertEquals(new Integer(9), ids.get(2));
	}
	
	@Test
	public void testEmptyListParser() {
		String testMedList = "{}";
		List<Integer> ids = IdParser.parse(testMedList);
		assertEquals(0, ids.size());
	}
	@Test
	public void testSingletonListParser() {
		String testMedList = "{1}";
		List<Integer> ids = IdParser.parse(testMedList);
		assertEquals(1, ids.size());
		assertEquals(new Integer(1), ids.get(0));
	}

}
