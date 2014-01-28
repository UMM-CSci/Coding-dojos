import static org.junit.Assert.*;
import java.util.ArrayList;
import org.junit.*;

public class TestStudents {

	private Student bill;
	private ArrayList<Assignment> assignment;
	private Assignment lab1;
	private Assignment lab2;
	private Assignment lab3;
	
	@Before
	public void before() {
		bill = new Student("Bill");
		lab1 = new Assignment("Lab 1", 100, 65, "1/25/14");
		lab2 = new Assignment("Lab 2", 10, 3, "1/25/14");
		lab3 = new Assignment("Lab 3", 50, 47, "1/25/14");
	}

	@Test
	public void testConstructor() {
		assertEquals(bill.getName(), "Bill");
		assertTrue(bill.getAssignments().isEmpty());
	}
	
	@Test
	public void testAssign() {
		assertTrue(bill.getAssignments().isEmpty());
		bill.assign(lab1);
		assertEquals(bill.getAssignments().size(), 1);
	}
	
	@Test
	public void testGetGrade() {
		bill.assign(lab1);
		bill.assign(lab2);
		bill.assign(lab3);
		assertTrue(bill.getPercentage() == .71875);
	}
	@Test
	public void testGetGradeZero() {
		assertTrue(bill.getPercentage() == 1);
	}
	@Test
	public void testGetLetterGrade() {
		bill.assign(lab1);
		bill.assign(lab2);
		bill.assign(lab3);
		assertTrue(bill.getLetterGrade() == "C");
	}
}