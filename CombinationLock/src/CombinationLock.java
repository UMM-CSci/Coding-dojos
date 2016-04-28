
public class CombinationLock {
	int lockLength;

	public CombinationLock(int lockLength) {
		this.lockLength = lockLength;
	}

	public int calculateDistance(int initialPosition, int firstNumber, int secondNumber, int thirdNumber) {
		// there will always be 3 full rotations
		int totalDistance = 3*lockLength;
		System.out.println(-3 / 2);

		totalDistance += (lockLength - firstNumber + initialPosition) % 40;
		totalDistance += (lockLength - firstNumber + secondNumber) % 40;
		
		if (secondNumber == thirdNumber) {
			totalDistance += lockLength;
		} else {
			totalDistance += (lockLength - thirdNumber + secondNumber) % 40;
		}

		return totalDistance;
	}

}
