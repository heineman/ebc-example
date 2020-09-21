package oo.contravariance;

public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Point p = new Point (10,20);
		Point p2 = new Point (10,20);
		
		// expected behavior
		System.out.println ("Points are same:" + p.equals (p2));
		
		// NOT EXPECTED! Goes above and beyond the call of duty. In fact,
		// the server has 'weakened' its preconditions in an attempt to provide
		// better service.
		System.out.println ("Points are also same:" + p.equals ("(10,20)"));
	}

}