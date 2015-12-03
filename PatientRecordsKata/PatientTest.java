import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;


public class PatientTest {
	@Test
	public void testConstructor() {
		String patientString = "0,Andrew Latterner,A,123-45-6789,caffeine,{},{}";
		Patient patient = new Patient(patientString);
		assertEquals(new Integer(0), patient.getId());
		assertEquals("Andrew Latterner", patient.getName());
		assertEquals("A", patient.getBloodType());
		assertEquals("123-45-6789", patient.getSSNum());
		assertEquals("caffeine", patient.getAllergy());
		assertEquals(0, patient.getAilments().size());
		assertEquals(0, patient.getMeds().size());
	}
	
	@Test
	public void testConstructorWithAils(){
		String patientString = "0,Andrew Latterner,A,123-45-6789,caffeine,{1;2},{}";
		Patient patient = new Patient(patientString);
		List<Integer> ailments = patient.getAilments();
		List<Integer> medications = patient.getMeds();
		assertEquals(2,ailments.size());
		assertEquals(0,medications.size());
		assertEquals(new Integer(1), ailments.get(0));
		assertEquals(new Integer(2), ailments.get(1));
	}
	@Test
	public void testConstructorWithMeds(){
		String patientString = "0,Andrew Latterner,A,123-45-6789,caffeine,{1;2},{1;2}";
		Patient patient = new Patient(patientString);
		List<Integer> ailments = patient.getAilments();
		List<Integer> medications = patient.getMeds();
		assertEquals(2,ailments.size());
		assertEquals(2,medications.size());
		assertEquals(new Integer(1), ailments.get(0));
		assertEquals(new Integer(2), ailments.get(1));
		assertEquals(new Integer(2), medications.get(1));
		assertEquals(new Integer(1), medications.get(0));
	}
}
