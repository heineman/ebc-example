package oo.liskov;

import junit.framework.TestCase;

public class TestDetector extends TestCase {
	public void testInteger() {
		int f1x = 1;
		int f1y = 1;
		int f2x = 2;
		int f2y = 2;
		int f3x = 3;
		int f3y = 3;

		IntRightHandDetector rhd = new IntRightHandDetector();
		rhd.append(f1x, f1y);
		rhd.append(f2x, f2y);
		rhd.append(f3x, f3y);

		assertFalse (rhd.isLeftTurn());
	}

	// big number check
	public void testBigFloat() {
		int c = -164;
		float k = 3517293.8f;

		float f1x = -1.0f/30000.0f;
		float f1y = -c/30000.0f;
		float f2x = 33;
		float f2y = 33*c;
		float f3x = 12345679*k;
		float f3y = 12345679*c*k;		
		FloatRightHandDetector rhd = new FloatRightHandDetector();
		rhd.append(f1x, f1y);
		rhd.append(f2x, f2y);
		rhd.append(f3x, f3y);

		// Despite being collinear, these points are not because of 
		// floating point error. The cross product is -1.71798692 E10
		// which is exceptionally close to ZERO, but isn't ZERO after all.
		assertTrue (rhd.isRightTurn());
	}

	public void testBigDouble() {
		int c = -164;
		double k = 3517293.8;

		double f1x = -1.0/30000.0;
		double f1y = -c/30000.0;
		double f2x = 33;
		double f2y = 33*c;
		double f3x = 12345679*k;
		double f3y = 12345679*c*k;		
		DoubleRightHandDetector rhd = new DoubleRightHandDetector();
		rhd.append(f1x, f1y);
		rhd.append(f2x, f2y);
		rhd.append(f3x, f3y);

		// with extra precision, this can be detected as being collinear.
		assertTrue (rhd.isCollinear());
	}

	// This is the program I ran to determine when a double precision 
	// detects collinear but floating point does not.
	public static void main(String[]args) {
		boolean floatTurnRight;
		boolean doubleTurnRight;
		int c = 1823767;
		
		while (true) {
			{
				float k = 3517293.8f;

				float f1x = -1.0f/30000.0f;
				float f1y = -c/30000.0f;
				float f2x = 33;
				float f2y = 33*c;
				float f3x = 12345679*k;
				float f3y = 12345679*c*k;		
				FloatRightHandDetector rhd = new FloatRightHandDetector();
				rhd.append(f1x, f1y);
				rhd.append(f2x, f2y);
				rhd.append(f3x, f3y);

				// Despite being collinear, these points are not because of 
				// floating point error. The cross product is -2.6132435 E21
				// which is exceptionally close to ZERO, but isn't ZERO after all.
				floatTurnRight = rhd.isRightTurn();
			}

			{
				double k = 3517293.8;

				double f1x = -1.0/30000.0;
				double f1y = -c/30000.0;
				double f2x = 33;
				double f2y = 33*c;
				double f3x = 12345679*k;
				double f3y = 12345679*c*k;		
				DoubleRightHandDetector rhd = new DoubleRightHandDetector();
				rhd.append(f1x, f1y);
				rhd.append(f2x, f2y);
				rhd.append(f3x, f3y);

				doubleTurnRight = rhd.isRightTurn();
			}

			if (doubleTurnRight != floatTurnRight) {
				System.out.println("c = " + c + doubleTurnRight + "," + floatTurnRight);
				
				System.out.println("c = " + c + " is difference!");
				break;
			}
			
			c += 7;
		}

	}
}

