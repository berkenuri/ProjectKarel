/*
 * File: SchoolBusKarel.java
 * Author: Sara Krehbiel
 * 
 * This program instructs Karel to pick up two beeper children
 * at locations specified by the busroute.w world and drop
 * them off at the school located in the northeast corner.
 */


import stanford.karel.*;

public class SchoolBusKarel extends Karel {

	// from (1,1), drive to each beeper then school
	public void run() {
		pickUpFirstChild();
		pickUpSecondChild();
		dropOffKidsAtSchool();		
	}

	// starting from (1,1) facing east, move to (3,1) and pick up the beeper there
	private void pickUpFirstChild() {
		move();
		move();
		pickBeeper();	
	}

	// starting from (3,1) facing east, move to (6,5) and pick up the beeper there
	private void pickUpSecondChild() {
		move();
		move();
		move();
		turnLeft();
		move();
		move();
		move();
		move();
		pickBeeper();		
	}

	// starting from (6,5) facing north, move to (6,7) and drop off both beepers there
	private void dropOffKidsAtSchool() {
		move();
		move();
		putBeeper();
		putBeeper();
	}
	
}
