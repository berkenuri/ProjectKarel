/*
 * File: PaintTheTownKarel.java
 * Author:
 * 
 * Implement this class so that Karel places a
 * beeper on every corner in a rectangular world
 * of arbitrary dimensions. You can assume Karel
 * starts at (1,1) facing east with an infinite 
 * beeper bag and that there are initially no
 * beepers in the world. Karel can end anywhere
 * facing any direction.
 */

import stanford.karel.*;

public class PaintTheTownKarel extends Karel {
	
	public void run() {
		// TODO: write your solution here
		paint();	
	}

	private void paint() {
		// TODO Auto-generated method stub
		while (frontIsClear()) {
			putBeeper();
			move();
		}
		putBeeper();
	}
	
	
}
