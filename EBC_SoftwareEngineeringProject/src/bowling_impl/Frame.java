package bowling_impl;

import bowling.IFrame;

/** To partake of the generic capability, must implement IFrame. */
public class Frame implements IFrame {
	final int num;
	int rollNumber = 0;
	Frame nextFrame;

	/** All but last frame have a next frame. */
	Frame (int num, Frame nextFrame) {
		this.num = num;
		this.nextFrame = nextFrame;
	}

	public boolean isStrike () {
		return roll[0] == 10;
	}

	public boolean isSpare() {
		return (roll[0] + roll[1] == 10) && (roll[0] != 10);
	}

	public int getNumRolls() {
		return rollNumber;
	}

	int roll[] = new int[3];

	public void roll(int pins) {
		roll[rollNumber++] = pins;
	}

	public int score () {
		//return roll[0]+roll[1]+roll[2];

		//return rolls[0] + rolls[1] + rolls[2];

		if (isSpare()) {
			return 10 + nextFrame.getFirstRoll();
		} else if (isStrike()) {
			// Used to be frames[i+1].getTwoRolls(); but that doesn't handle 2strikes in a row
			int firstRoll = nextFrame.getFirstRoll();
			if (firstRoll == 10) {
				int secondRoll = nextFrame.nextFrame.getFirstRoll();
				return 10 + firstRoll + secondRoll;
			} else {
				return 10 + nextFrame.getTwoRolls();
			}
		} else {
			return roll[0] + roll[1] + roll[2];
		}
	}

	public int getFirstRoll() {
		return roll[0];
	}

	public int getTwoRolls() {
		return roll[0] + roll[1];
	}

	// generic addition
	public boolean isComplete() {
		if (isStrike()) { 
			if (nextFrame.getNumRolls() == 2) { return true; }
			if (nextFrame.getFirstRoll() == 10 && nextFrame.nextFrame.getNumRolls() >= 1) { return true; }
			return false;
		}
		if (isSpare()) { return nextFrame.getNumRolls() >= 1; }
		return rollNumber == 2;
	}

	@Override
	public int getRoll(int n) {
		return roll[n];
	}
}
