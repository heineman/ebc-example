package oo.liskov;

public interface IDetector {
	
	void append (Number x, Number y);
	
	boolean isCollinear();
	boolean isLeftTurn();
	boolean isRightTurn();
	
}
