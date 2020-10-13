package bowling.view;

import java.awt.Font;
import java.awt.Graphics;

import javax.swing.JPanel;

import bowling.IBowling;
import bowling.IFrame;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Iterator;

/**
 * Final frame has bonus square for three rolls; other frames have two
 *  */
public class FramesView extends JPanel {

	private static final long serialVersionUID = -7569334261449339555L;
	
	IBowling model;
	public static final String fontName = "Comic Sans MS";
	Font smallFont = null;
	Font largeFont = null;

	/** Width of frame. */
	int boxWidth;

	/** x-offset into frame for inner box. */
	int offset;

	/**
	 * Create the panel.
	 */
	public FramesView(IBowling model) {
		super();
		this.model = model;
		setBackground(Color.ORANGE);

		smallFont = new Font(fontName, Font.PLAIN, 12);
		largeFont = new Font(fontName, Font.PLAIN, 24);
	}

	/** Draw nth frame. Note that final frame has room for an additional bonus roll. */
	void drawFrame(Graphics g, int n) {

		int frameWidth = boxWidth;
		if (n == 9) { frameWidth += boxWidth-offset; }

		// outer box
		g.drawRect(n*boxWidth, 0, frameWidth, getHeight());
		
		// inner one; be sure to draw an additional one in final frame
		g.drawRect(n*boxWidth + offset, 0, boxWidth - offset, boxWidth-offset);
		if (n == 9) {
			g.drawRect(n*boxWidth + boxWidth, 0, boxWidth- offset, boxWidth-offset);
		}
	}
	
	void showStrike (Graphics g, int n, boolean bonus) {
		if (!bonus) {
			g.fillRect(n*boxWidth + offset, 0, boxWidth - offset, boxWidth-offset);
		} else {
			g.fillRect(n*boxWidth, 0, boxWidth - offset, boxWidth-offset);
		}
	}
	
	void showSpare (Graphics g, int n, int roll) {
		int x = n*boxWidth;
		int startx = x + 10;
		g.setFont(smallFont);
		g.drawString("" + roll, startx, 15);
		startx += boxWidth;
		
		g.fillPolygon(new int[] {x+offset, x+boxWidth, x+boxWidth, x+offset},
				new int[] {boxWidth-offset, 0, boxWidth-offset, boxWidth-offset},
				4);
	}

	/**
	 * Paint frame in the space provided.
	 */
	@Override
	public void paintComponent (Graphics g) {
		super.paintComponent(g);

		// compute values here since we might not have been properly initialized until now.
		boxWidth = getWidth() / 10;
		offset = 2*boxWidth/3 - 5;
		boxWidth -= offset/12;  // shave fraction to leave room in final frame.

		// get each frame, one at a time.
		int x = 0;
		int y = 0;

		// quick hack to generate default empty iterator.
		Iterator<IFrame> it = new ArrayList<IFrame>().iterator();
		if (model != null) {
			it = model.iterator();
		}
		g.setColor(Color.black);
		int score = 0;
		for (int n = 0; n < 10; n++) {
			drawFrame(g, n);

			if (it.hasNext()) {
				IFrame frame = it.next();
				if (frame.isComplete()) {
					if (frame.isStrike()) {
						showStrike (g, n, false);
					} else if (frame.isSpare()) {
						showSpare (g, n, frame.getRoll(0));
					} else {
						int startx = x + 10;
						for (int i = 0; i < frame.getNumRolls(); i++) {
							g.setFont(smallFont);
							g.drawString("" + frame.getRoll(i), startx, y + 15);
							startx += boxWidth/2;
						}
					}
				} else {
					g.setColor(Color.red);
					
					if (frame.isStrike()) {
						showStrike (g, n, false);
					} else {
						int startx = x + 10;
						g.setFont(smallFont);
						g.drawString("" + frame.getRoll(0), startx, y + 15);
						startx += boxWidth;
						
						if (frame.isSpare()) {
							showSpare (g, n, frame.getRoll(0));
						}
					}
				}

				g.setColor(Color.black);

				// score in big, if complete
				score += frame.score();
				if (frame.isComplete()) {
					g.setFont(largeFont);
					g.drawString("" + score, x+boxWidth/5, y+boxWidth);
				}
			}

			x += boxWidth;
		}
	}

}
