package oo.contravariance;

public class Base {
	int x;
	int y;
	
	public Base(int bx, int by) {
		this.x = bx;
		this.y = by;
	}
	
	public boolean same(Base b) {
		System.out.println("Base::same called");
		if (b == null) { return false; }
		return x == b.x && y == b.y;
	}
}
