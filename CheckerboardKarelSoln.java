/*
 * File: CheckerboardKarel.java
 * Author: Sara Krehbiel
 * 
 * This Karel creates a checkerboard pattern
 * on any rectangular board.
 */

import stanford.karel.Karel;

public class CheckerboardKarelSoln extends Karel {

	public void run() {
		// TODO: fix the logic bug causing karel to loop counter-clockwise
		tileFirstRow(); // tile the first row, starting with a beeper
		while (true) {
			tileRow(); // checks what type of row to tile
		}
	}
	
	// tile the second row, starting with a beeper 
	// either at the first corner or second, 
	// depending on where you ended the previous row
	private void tileRow() {
		// if (condition) { set up to tile a row starting with a beeper }
		if (beepersPresent()) { // this means she needs to shift over before tiling next row
			// move up to the next row and move over a spot before starting to tile
			turnLeft();
			move();
			turnLeft();
			move();
		} else {
			// move up to the next row without moving over
			turnLeft();
			move();
			turnLeft(); 
			/* note this sequence of 3 commands is duplicated and could be a helper method*/
		}
		tileFirstRow();
	}

	/* tiles a row, starting with the first beeper;
	 * note: this works with an even or odd width,
	 * and karel ends at the last spot facing the
	 * same direction she started
	 */
	private void tileFirstRow() {
		putBeeper();

		while (frontIsClear()) {
			move();
			if (frontIsClear()) {
				move();
				putBeeper();				
			}
		}
	}
}



