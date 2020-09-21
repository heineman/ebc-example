package oo.covariance;

public class Explore {
	public static void main(String[] args) {
		float x = -0.9f;
		float delta = 0.01f;
		
		Sample1 s1 = new Sample1();   // accurate
		
		while (x < 0.9) {
			double logx1 = s1.compute(x);
			
			for (int nt = 8; nt <= 120; nt++) {
				double logx2 = new Sample2(nt).compute(x);
				
				if (Math.abs(logx1 - logx2) < 0.00001) {
					System.out.println(String.format("%.3f %d", x, nt));
					break;
				}
			}
			
			x += delta;
		}
		
	}
}
