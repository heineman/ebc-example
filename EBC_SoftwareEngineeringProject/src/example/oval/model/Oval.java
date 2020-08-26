package example.oval.model;

import java.awt.*;

public class Oval {
	public final int x, y;
	public final int width, height;
	
	public Oval(Point origin, int halfWidth, int halfHeight) {
		this.x = origin.x - halfWidth;
		this.y = origin.y - halfHeight;
		this.width = 2*halfWidth;
		this.height = 2*halfHeight;
	}
}