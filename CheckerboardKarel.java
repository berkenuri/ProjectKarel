import stanford.karel.Karel;

public class CheckerboardKarel extends Karel {

	public void run() {
		// TODO: implement your solution here!	
		putCheckersOne();
		
		while (frontIsClear()) {
			if (beepersPresent()) {
				move();
				turnRight();
				putCheckersOne();
			}
			else {
				move();
				turnRight();
				putCheckersTwo();
			}
		} 		
	}
		
	private void turnRight() {
		// TODO Auto-generated method stub
		for (int i=0; i<3; i++)
		turnLeft();
	}
	
	private void goBack() {
		// TODO Auto-generated method stub
		for (int i=0; i<2; i++)
		turnLeft();
		while (frontIsClear()) {
			move();
		}
		turnRight();	
	}
	
	private void putCheckersOne() {
		// TODO Auto-generated method stub
		while (frontIsClear()) {
			move();
			putBeeper();
			if (frontIsClear()) {
				move();
			}
		}
		goBack();
	}
	
	private void putCheckersTwo() {
		// TODO Auto-generated method stub
		while (frontIsClear()) {
			putBeeper();
			move();
			if (frontIsClear()) {	
				move();
			}
		}
		goBack();
	}

	
}