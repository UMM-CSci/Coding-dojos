import java.util.ArrayList;
import java.util.List;


public class Patient {
	private final Integer id;
	private String name;
	private final String bloodType;
	private final String ssNum;
	private String allergy;
	private List<Integer> ailments;
	private List<Integer> meds;
	
	public Patient(String patientString) {
		String[] patientInfo = patientString.split(",");
		this.id = Integer.parseInt(patientInfo[0]);
		this.name = patientInfo[1];
		this.bloodType = patientInfo[2];
		this.ssNum = patientInfo[3];
		this.allergy = patientInfo[4];
		this.ailments = IdParser.parse (patientInfo[5]);
		this.meds = IdParser.parse (patientInfo[6]);
	}

	public Integer getId() {
		return this.id;
	}

	public String getName() {
		return this.name;
	}

	public String getBloodType() {
	
		return this.bloodType;
	}

	public String getSSNum() {
		
		return this.ssNum;
	}

	public String getAllergy() {
		
		return this.allergy;
	}

	public List<Integer> getAilments() {
		return this.ailments;
	}

	public List<Integer> getMeds() {
		return this.meds;
	}
	
	

}
