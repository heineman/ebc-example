package bowling_skeleton;

import java.util.ArrayList;
import java.util.Iterator;

import bowling.IBowling;
import bowling.IFrame;

/**
 * Complete this implementation as a challenge.
 */
public class Game implements IBowling {
	
	public Game () {
		
	}
	
	/** Add the following roll to the game. */
	@Override
	public void roll (int pins) {
		
	}
	
	/** Return the score of the game. */
	@Override
	public int score() {
		return -1; // TODO
	}

	@Override
	public Iterator<IFrame> iterator() {
		return new ArrayList<IFrame>().iterator();  // TODO
	}

	@Override
	public boolean isGameOver() {
		return false; // TODO
	}

	@Override
	public int currentFrame() {
		return -1;  // TODO
	}
}
