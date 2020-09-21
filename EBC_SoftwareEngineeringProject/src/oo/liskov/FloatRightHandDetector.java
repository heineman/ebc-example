package oo.liskov;

/**
 * Compute direction of the "elbow" (p1,p2) and (p2,p3).
 * 
 * | 1 p1x p1y |
 * | 1 p2x p2y | :   cp=(p2x–p1x)(p3y–p1y)–(p2y–p1y)(p3x–p1x)
 * | 1 p3x p3y |
 * 
 * If cp is negative, then the three points determine a right 
 * turn. If cp is positive then a left turn. If cp=0 then the
 * three points are colinear.
 */
public class FloatRightHandDetector implements IDetector {
	
	float p1x, p1y;
	float p2x, p2y;
	float p3x, p3y;
	
	// current one
	int current = 1;
	
	private float crossProduct() {
		float cp = (p2x-p1x)*(p3y-p1y) - (p2y-p1y)*(p3x-p1x);
		return cp;
	}
	
	public boolean isCollinear() { 
		return crossProduct() == 0;
	}
	
	public boolean isLeftTurn() {
		return crossProduct() > 0;
	}
	
	public boolean isRightTurn() {
		return crossProduct() < 0;
	}

	public void append(Number x, Number y) {
		if (current == 1) {
			p1x = x.floatValue(); p1y = y.floatValue();
		} else if (current == 2) {
			p2x = x.floatValue(); p2y = y.floatValue();
		} else if (current == 3) {
			p3x = x.floatValue(); p3y = y.floatValue();
		} else {
			throw new RuntimeException ("too many points!");
		}
		
		current++;
	}
}
