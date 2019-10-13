/*
 * File: PaintTheTownKarel.java
 * Author: Sara Krehbiel
 * 
 * Starting on (1,1) facing east with an infinite
 * beeper bag in an arbitrary-sized rectangular world
 * without any beepers or internal walls,
 * Karel moves north painting one street at a time,
 * alternating between moving east and west, finally
 * stopping when there is no next street to move to.
 */

import stanford.karel.*;

public class PaintTheTownKarelSoln2 extends Karel {
	
	/* At the end of every iteration of the while loop,
	 * which consists of painting a row and repositioning
	 * for the next row, Karel should be facing an empty 
	 * street EXCEPT after completion of the last street,
	 * when she should be sitting on a beeper, causing the 
	 * while loop (and overall problem) to terminate.
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
	
	/* Karel checks her direction to see whether she just 
	 * finished a left-to-right or a right-to-left street
	 * and moves to the next unpainted street accordingly.
	 * If there is no next street, she stays in place. 
	 */
	private void setUpForNextStreet() {
		if (facingEast()) { 
			// facing east means just finished a L->R row 
			if (leftIsClear()) {
				turnLeft();
				move();
				turnLeft();
			} // left blocked means that was the last row
		} else {
			// not facing east means just finished a R->L row
			if (rightIsClear()) {
				turnRight();
				move();
				turnRight();
			} // right blocked means that was the last row
		}
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
