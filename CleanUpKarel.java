/*
 * File: CleanUpKarel.java
 * Author: Berke Nuri 
 * 
 */

import stanford.karel.*;

public class CleanUpKarel extends Karel {

	public void run() {
		/* Karel cleans the row and if there is another row on top, it moves up and cleans that row
		 * too, in the end it goes back to the very lowest left corner and drop the beepers in its bag */
		clean();
		while (frontIsClear()) {
			moveUp();
			clean();
		} 
		goBackAndDrop();
	}
		
	private void moveUp() {
		// this method moves Karel one tile up and turns it right again
		move();
		turnRight();
	}

	private void turnRight() {
		// this method turns Karel to the right by turning it left three times
		for (int i=0; i<3; i++)
		turnLeft();
	}
	
	private void goBack() {
		// this method turns Karel back to the beginning of the row
		for (int i=0; i<2; i++)
		turnLeft();
		
		while (frontIsClear()) {
			move();
		}
		
		for (int i=0; i<3; i++)
			turnLeft();		
	}
	
	private void clean() {
		/* this method makes Karel pick up any beeper on its way while moving until it hits the wall,
		 * after it hits the wall it goes back to the first tile of the row again */
		while (frontIsClear()) {
			if (beepersPresent()) {
				while (beepersPresent()) {
					pickBeeper();
				}
			}
		move();
			if (beepersPresent()) {
				while (beepersPresent()) {
					pickBeeper();
				}
			}
		}
		goBack();
	}
	
	private void goBackAndDrop() {
		/* this method moves Karel to the lowest left corner of the map and makes it drop all the 
		 * beepers it has */
		turnLeft();
		turnLeft();
		while (frontIsClear()) {
			move();
		}
		while (beepersInBag()) {
			putBeeper();
		}
	}
	
}
