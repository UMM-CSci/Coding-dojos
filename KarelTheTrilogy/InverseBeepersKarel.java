/* File: InverseBeeperKarel.java
 * 
 * Given a world with one street (i.e. row), have Karel swap
 * the states of the beepers in each spot (so if there is a
 * beeper, pick it; if there is no beeper, put one).
 */

import stanford.karel.*;

public class InverseBeepersKarel extends SuperKarel {
	
	public void run() {
		while(frontIsClear()) {
			move();
		}
	}
}