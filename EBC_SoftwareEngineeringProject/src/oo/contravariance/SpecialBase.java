package oo.contravariance;

public class SpecialBase extends Base {
	
	public SpecialBase(int bx, int by) {
		super(bx, by);
	}

	// this does not override the same(Base b) method in superclass.
	public boolean same(Object o) {
		System.out.println("SpecialBase::same called");
		return false;
	}
	
	public static void main(String []args) { 
		Base b = new Base(13,77);
		Base b2 = new Base(13,77);

		SpecialBase sb = new SpecialBase(13,77);
		System.out.println(b.same(b2));
		System.out.println(b2.same(b));
		
		System.out.println(b.same(sb));
		
		System.out.println(sb.same(b));
		System.out.println(sb.same("SOMETHING ELSE"));
	}
}
