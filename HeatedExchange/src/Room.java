public class Room {
	private double temp;
	
	public Room(double initialTemp) {
		temp = initialTemp;
	}
	
	public double getTemp() {
		return temp;
	}
	
	public void updateTemp(double tempDifference) {
		temp += tempDifference;
	}
}
