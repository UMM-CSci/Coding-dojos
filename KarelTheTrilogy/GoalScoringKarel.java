/*
 * File: GoalScoringKarel.java
 * ---------------------
 * Have Karel's dream come true by "kicking the ball" into the goal.
 * Watch out for the goalie!
 */

import stanford.karel.*;

public class GoalScoringKarel extends Karel {

	/*
	 * Karel moves the beeper into the goal.
	 * 
	 * Precondition: Karel is facing East at (1, 1).
	 * Postcondition: Karel has moved the beeper into the goal area.
	 */
	public void run() {
		dash();
		pickBeeper();
		dash();
		turnLeft();
		dash();
		turnRight();
		//Karel is about to enter the goal and score!
		move();
		putBeeper();
	}
	
	/*  Method: dash
	 *  Usage:  When you want Karel to move thrice
	 */
	private void dash() {
		for(int i = 0; i < 3; i++) {
			move();
		}
	}
	
	/*  Method: turnRight
	 *  Usage:  When you want Karel to turn right, have her turn thrice
	 */
	private void turnRight() {
		turnLeft();
		turnLeft();
		turnLeft();
	}
}