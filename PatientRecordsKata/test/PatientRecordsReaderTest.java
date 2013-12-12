import static org.junit.Assert.*;

import java.io.File;
import java.util.List;

import org.junit.Ignore;
import org.junit.Test;


public class PatientRecordsReaderTest {
	@Test
	@Ignore
	public void parseEmptyFile() {
		File testFile = new File("test/TestFiles/EmptyFile.txt");
		PatientRecordsReader reader = new PatientRecordsReader(testFile);
		
		assertTrue(testFile.exists());
		
		List<Patient> patients = reader.parse();
		
		assertEquals(0, patients.size());
	}
}
