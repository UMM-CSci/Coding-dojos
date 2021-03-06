
public class Assignment {

	private String name;
	private String dueDate;
	private int pointsPossible;
	private int score;

	public Assignment(String name, int ptsPoss, int score, String date) {
		this.name = name;
		this.pointsPossible = ptsPoss;
		this.score = score;
		this.dueDate = date;
	}
	
	public Assignment(String name, int ptsPoss, String date) {
		this.name = name;
		this.pointsPossible = ptsPoss;
		this.dueDate = date;
	}

	public void setScore(int score) {
		this.score = score;
	}
	
	public String getName() {
		return this.name;
	}

	public String getDueDate() {
		return dueDate;
	}

	public int getScore() {
		return score;
	}

	public int getPointsPossible() {
		return pointsPossible;
	}

	public double getPercentage() {
		if (pointsPossible > 0) {
			return (score * 1.0) / pointsPossible;
		} 
		return 1;
	}

	public String getLetterScore() {
		int score = (int) (getPercentage()*100);
		if(score>=90)return "A";
		else if(score>=80)return "B";
		else if(score>=70)return "C";
		else if(score>=60)return "D";
		else return "F";
	}


}
