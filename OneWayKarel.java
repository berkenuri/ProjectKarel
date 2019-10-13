/* 
 * File: OneWayKarel.java
 * Author: Sara Krehbiel
 * 
 * This class solves a general 1-D version
 * of the school bus task, assuming that Karel
 * starts at (1,1) facing east in a rectangular world 
 * of arbitrary dimensions with beepers scattered 
 * along Street 1 but no beepers in her bag. She first
 * picks up all beepers walking east along Street 1,
 * and then with the right wall in front of her
 * empties her beeper bag.
 * 
 * Recall that we developed this solution in class
 * by first programming Karel to work with 3 beepers
 * with 8 avenues, and then modifying it to work for 
 * any number of avenues and any number of beepers.
 * Finally, we made a small modification to handle 
 * multiple beepers per corner.
 */

import stanford.karel.*;

public class OneWayKarel extends Karel {

	public void run() {
		// collect beepers left to right
		pickUpAllBeepers();
		// put all collected beepers at far right wall
		dropOffAllBeepers();
		
	}

	// Starting from (1,1) facing east, karel moves to end of 1st street, 
	// picking up all beepers along the way, excluding beepers at the end.
	private void pickUpAllBeepers() {
		while (frontIsClear()) {
			// at this point, karel is facing east on 1st ave
			// with her front clear, possibly with beepers present

			// inner while loop (instead of if) allows
			// karel to pick up multiple beepers at one stop
			while (beepersPresent()) {
				pickBeeper();				
			}
			
			// progress toward the right wall
			move();
		}
		// note that Karel doesn't pick up beepers at last spot
	}
	
	// Deposit all beepers at the end of first street
	private void dropOffAllBeepers() {
		// ignoring beepers already present, empty the bag
		while (beepersInBag()) {
			putBeeper();
		}
	}

}
