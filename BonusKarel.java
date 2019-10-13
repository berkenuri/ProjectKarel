/*
 * File: Bonus.java
 * Author: Berke Nuri
 * 
 */

import stanford.karel.*;

//NOTE: KAREL MUST START FORM THE LOWER LEFT CORNER WITH INFINITE BEEPERS AND AN EMPTY WORLD
//AIM: KAREL SHOULD FILL THE WORLD WITH BEEPERS BESIDES THE PERIMETER 
public class BonusKarel extends Karel {

	public void run() {
		paint();	//Karel paints the row
		while (frontIsClear()) { //Karel moves up and paints if there is another row above 
			moveUp();
			paint();
		} 
		goToBeginningPoint(); //Karel comes backto the initial position
		cleanPerimeter();   	//Karel cleans the perimeter
		
	}
	
	private void goToBeginningPoint() {
		/* this method moves Karel to the lowest left corner of the map */
		turnLeft();
		turnLeft();
		while (frontIsClear()) {
			move();
		}
		turnLeft();
	}
	
	private void moveUp() {
		// this method moves Karel one tile up and turns it right again
		move();
		turnLeft();
		turnLeft();
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
	
	private void paint() {
		/* this method makes Karel put beepers on its way while moving until it hits the wall,
		 * after it hits the wall it goes back to the first tile of the row again */
		putBeeper();
		while (frontIsClear()) {
		move();
		putBeeper();
		}
		goBack();
	}

	private void cleanPerimeter() {
		/* this method cleans the perimeter by moving and picking beepers until it hits the wall 
		 * and turns left, this repeats three times */
		while (frontIsClear() ) {
			move();
			pickBeeper();
		}	
		for (int i=0; i<3; i++) {
			turnLeft();
			while (frontIsClear() ) {
				move();
				pickBeeper();
			}		
		}
		turnLeft();		
	}
}
