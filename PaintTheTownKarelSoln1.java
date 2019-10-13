/*
 * File: PaintTheTownKarel.java
 * Author: Sara Krehbiel
 * 
 * Starting on (1,1) facing east with an infinite
 * beeper bag in an arbitrary-sized rectangular world
 * without any beepers or internal walls,
 * Karel moves north painting one street at a time,
 * painting to the east and returning to the west,
 * stopping when there is no next street to move to.
 */

import stanford.karel.*;

public class PaintTheTownKarelSoln1 extends Karel {
	
	/* At the end of every iteration of the while loop,
	 * which consists of painting a row left to right 
	 * and repositioning for the next row, Karel should be 
	 * facing east on an empty street EXCEPT after completion 
	 * of the last street, when she should be sitting on a beeper, 
	 * causing the while loop (and overall problem) to terminate.
	 */
	public void run() {
		while (noBeepersPresent()) {  
			paintStreet();
			setUpForNextStreet();
		}
	}
	
	/* Facing an empty street (either east or west), 
	 * Karel moves forward, putting a beeper on every 
	 * intersection until she reaches the wall.
	 */
	private void paintStreet() {
		putBeeper();
		while (frontIsClear()) {
			move();
			putBeeper();
		}
	}
	
	/* Karel returns to the west-most corner of her street
	 * and either moves to the next unpainted street or
	 * stays put if there is no next street. 
	 */
	private void setUpForNextStreet() {
		turnAround();
		moveToWall();
		if (rightIsClear()) {
			turnRight();
			move();
			turnRight();
		}
	}
	
	/* Without changing direction, move as far
	 * as you safely can
	 */
	private void moveToWall() {
		while (frontIsClear()) {
			move();
		}
	}
	
	/* Turn around with two lefts
	 */
	private void turnAround() {
		turnLeft();
		turnLeft();
	}
	
	/* Simulate a right turn with three lefts
	 */
	private void turnRight() {
		for (int i=0; i<3; i++) {
			turnLeft();
		}
		// note: you also could have just written
		// three turnLeft() statements without a loop
	}
	
}
