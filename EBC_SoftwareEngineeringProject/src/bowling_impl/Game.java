package bowling_impl;

import oo.iterator.ArrayIterator;

import java.util.Iterator;

import bowling.IBowling;
import bowling.IFrame;

// Identified concepts:
//   1. Only need to return score *AT END* of game
//   2. Strikes (rolling 10) 
//   3. Spare (two rolls in a roll that add to 10)
//   4. FRAME is important
//   5. FINAL FRAME can have up to but no more than 3
//   6. FRAME has score
//   7. HOW TO PREVENT INVALID INPUT
//   8. CURRENT FRAME
//   
public class Game implements IBowling {
	Frame[] frames = new Frame[12];   // twelve strikes maximum
	
	final static int MAXFRAME = 10;
	
	int currentFrame = 0;
	
	public Game () {
		Frame nextFrame = null;
		for (int i = MAXFRAME+1; i >=0; i--) {      // allow up to 12 frames because 12 strikes possible
			frames[i] = new Frame (i, nextFrame);
			nextFrame= frames[i];
		}
	}
	
	/** Add the following roll to the game. */
	public void roll (int pins) {
		frames[currentFrame].roll(pins);
		if (pins == 10) {
			currentFrame++;
		} else if (frames[currentFrame].getNumRolls() == 2) {
			currentFrame++;
		}
	}
	
	/** Return the score of the game. */
	public int score() {
		int score = 0;
		// DON'T DOUBLE COUNT EXTRA BONUS FRAME!
		for (int i = 0; i <= currentFrame && i < MAXFRAME; i++) {
			Frame f = frames[i];
//			if (!f.isSpare() && !f.isStrike()) {
//				score += f.score();
//			} else if (f.isSpare()) {
//				score += 10 + frames[i+1].getFirstRoll();
//			} else if (f.isStrike()) {
//				// Used to be frames[i+1].getTwoRolls(); but that doesn't handle 2strikes in a row
//				score += 10 + nextTwoRolls(i+1);
//			}
			score += f.score();
		}
		
		return score;
	}
	
	/** Compute score of first roll in this frame. Takes into account strike as first roll. */
	int nextTwoRolls(int f) {
		int count = frames[f].getFirstRoll();
		if (count == 10) {
			return 10+frames[f+1].getFirstRoll(); 
		}
		return frames[f].getTwoRolls();
	}

	/** Generic addition. Retrieve iterator over all frames. */
	public Iterator<IFrame> iterator() {
		return new ArrayIterator<IFrame>(frames, MAXFRAME);
	}

	@Override
	public boolean isGameOver() {
		return currentFrame == 11;
	}

	@Override
	public int currentFrame() {
		return currentFrame;
	}
}
