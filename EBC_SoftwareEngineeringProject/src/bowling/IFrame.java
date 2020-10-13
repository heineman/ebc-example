package bowling;

/**
 * Generic interface to extract meaningful information about a frame.
 * 
 * Frames are numbered from 0 to 9.
 */
public interface IFrame {
	/** Only show scores for complete frames. */
	boolean isComplete();
	
	boolean isStrike();
	
	boolean isSpare();
	
	/** return the nth roll. */
	int getRoll(int n);
	
	/** How many rolls in frame. */
	int getNumRolls();
	
	/** Score for the frame. */
	int score();
}
