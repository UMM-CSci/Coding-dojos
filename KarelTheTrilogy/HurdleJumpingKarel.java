/* File: HurdleJumpingKarel.java
 * This program has Karel jumping eight hurdles each of arbitrary
 * height.
 */
import stanford.karel.*;

public class HurdleJumpingKarel extends SuperKarel {

	public void run() {
		for (int i = 1; i < 9; i++) {
			if (frontIsBlocked()) {
			  doHurdle();
			} 
			else {
			  move();
			}
		}

	}
	
	public void doHurdle() {
		turnLeft();
		while (rightIsBlocked()) {
			move();
		} 
		turnRight();
		move();
		turnRight();
		while (frontIsClear()) {
			move();
		}
		turnLeft();
	}
}