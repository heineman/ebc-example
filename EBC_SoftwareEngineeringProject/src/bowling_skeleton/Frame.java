package bowling_skeleton;

import bowling.IFrame;

/** 
 * To partake of the generic capability, must implement IFrame. 
 */
public class Frame implements IFrame {

	@Override
	public boolean isStrike () {
		return false; // TODO
	}

	@Override
	public boolean isSpare() {
		return false; // TODO
	}

	@Override
	public int getNumRolls() {
		return -1; // TODO
	}

	@Override
	public int score () {
		return -1; // TODO
	}
	
	@Override
	public boolean isComplete() {
		return false;  // TODO
	}

	@Override
	public int getRoll(int n) {
		return -1;  // TODO
	}
}
