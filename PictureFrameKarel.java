/*
 * File: PictureFrameKarel.java
 * Author: Berke Nuri
 * 
 */

import stanford.karel.*;


public class PictureFrameKarel extends Karel {

	public void run() {
		paintPerimeter();	//the method which paints the outer frame
		paintInside();   	//the method which paints the inner frame
		
	}
	
	private void paintPerimeter() {
		/* this method paints the outer frame by moving and tiling beepers until it hits the wall 
		 * and turns left, this repeats three times */
		while (frontIsClear() ) {
			move();
			putBeeper();
		}	
		for (int i=0; i<3; i++) {
			turnLeft();
			while (frontIsClear() ) {
				move();
				putBeeper();
			}		
		}
		turnLeft();		
	}
	
	private void getInside() {
		/* this method moves Karel to the lowest left corner of the inner frame after 
		 * it finishes painting the outer layer */
		turnLeft();
		move();
		move();
		turnLeft();
		turnLeft();
		turnLeft();
		move(); 
		move();
	}
	
	private void paintInside() {
		/* this method makes Karel tile beepers until it hits the wall after it gets its 
		 * position at the lowest left corner of the inner frame */
		getInside();
		while (frontIsClear()) {
			move();
			putBeeper();
		}
		for (int i=0; i<3; i++) {
			takePosition();
			while (frontIsClear() ) {
				move();
				putBeeper();
			}
		}
		takePosition();		
	}
	
	private void takePosition() {
		/* this method makes Karel turn back to the previous corner of the inner frame after it 
		 * removes the extra beepers that it put previously until it hit the wall */
		
		turnLeft();
		turnLeft();
		pickBeeper();
		move	();
		pickBeeper();
		move();
		turnLeft();
		turnLeft();
		turnLeft();
	}
		
}
