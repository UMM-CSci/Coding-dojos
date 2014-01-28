import static org.junit.Assert.*;
import org.junit.*;

public class TestAssignment {

	Assignment lab1, lab2;
	
	@Before
	public void before() {
		lab1 = new Assignment("Lab 1", 100, 65, "1/25/14");
		lab2 = new Assignment("Lab 2", 10, 3, "1/25/14");
	}

	@Test
	public void testConstructor() {
		assertEquals(lab1.getName(), "Lab 1");
		assertEquals(lab1.getDueDate(), "1/25/14");
		assertEquals(lab1.getPointsPossible(), 100);
		assertEquals(lab1.getScore(), 65);
	}
	
	@Test
	public void testGrade() {
		System.out.println(lab1.getPercentage());
		assertTrue(lab1.getPercentage() == 0.65);
		assertEquals(lab1.getLetterScore(), "D");
	}
	
	@Test
	public void testGrade2() {
		System.out.println(lab2.getPercentage());
		assertTrue(lab2.getPercentage() == 0.30);
		assertEquals(lab2.getLetterScore(), "F");
	}
}
