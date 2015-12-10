import java.util.ArrayList;


public class Student {

	private String name;
	private ArrayList<Assignment> assignments;
	
	public Student(String name) {
		this.name = name;
		this.assignments = new ArrayList<Assignment>();
	}
	
	public String getName() {
		return this.name;
	}

	public ArrayList<Assignment> getAssignments() {
		return assignments;
	}

	public void assign(Assignment assignment) {
		assignments.add(assignment);
	}
	
	public void assign(Assignment[] assignments) {
		for (Assignment assignment: assignments) {
			this.assignments.add(assignment);
		}
	}

	public double getPercentage() {
		int totalScore = 0;
		int actualScore = 0;
		for (Assignment assignment : assignments) {
			actualScore += assignment.getScore();
			totalScore += assignment.getPointsPossible();
		}
		if (totalScore!=0) {
			return (actualScore*1.0)/totalScore;
		} else {
			return 1;
		}
	}
	
	public String getLetterGrade() {
		int score = (int) (getPercentage()*100);
		System.out.println(score);
		if(score>=90)return "A";
		else if(score>=80)return "B";
		else if(score>=70)return "C";
		else if(score>=60)return "D";
		else return "F";		
	}
	
	public double getLetterPercentage(String grade) {
		if(grade.equals("A"))return .90;
		else if(grade.equals("B"))return .80;
		else if(grade.equals("C"))return .70;
		else if(grade.equals("D"))return .60;
		else return 0;		
	}
	
	public int estimateFinalGrade(String wantedGrade, int pointsLeft) {
		int pointsEarned = 0;
		int pointsPossible = 0;
		for (Assignment assignment : assignments){
			pointsEarned += assignment.getScore();
			pointsPossible += assignment.getPointsPossible();
		}
		int pointsPossibleTotal = pointsPossible + pointsLeft;
		double wantedPercentage = getLetterPercentage(wantedGrade);
		int pointsRequired = (int) Math.ceil(wantedPercentage * pointsPossibleTotal) 
				- pointsEarned;
		if (pointsRequired > pointsLeft) {
			return -1;
		} else if (pointsRequired <= 0) {
			return 0;
		}
		return pointsRequired;
	}
	
}
