package oo.bad;
import java.applet.Applet;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

// Initial by Heineman. Undo implemented by Joe Politz. Further obscured by Heineman.
// Not the way a programmer should work!
// https://en.wikipedia.org/wiki/Perpetual_Motion_(solitaire)
public class BadNarcotic extends Applet implements MouseMotionListener, MouseListener {
	Stack<int[]> m = new Stack<int[]>();
	Image cards[] = new Image[53];
	int d[] = new int[52];
	int pt[][] = new int[4][52];
	int tp[] = new int[4];
	int lm[] = new int[5];
	Point p;
	int ax, ay, sc, nl=52, b=0, h=-1, z=-1, idx=0;
	public void init() {
		java.awt.MediaTracker mt = new java.awt.MediaTracker (this);
		String p1 = "A 2 3 4 5 6 7 8 9 10 J Q K";
		String p2 = "C D H S";
		for (StringTokenizer rst = new StringTokenizer(p1); rst.hasMoreTokens(); ) {
			String r = rst.nextToken();
			for (StringTokenizer sst = new StringTokenizer(p2); sst.hasMoreTokens(); ) {
				String key = r + sst.nextToken();
				java.net.URL url = this.getClass().getResource ("/oo/bad/images/" + key + ".gif");
				cards[b] = java.awt.Toolkit.getDefaultToolkit().getImage(url);
				mt.addImage (cards[b], b++);
			}
		}
		java.net.URL u = this.getClass().getResource ("/oo/bad/images/Back.gif");
		cards[52] = java.awt.Toolkit.getDefaultToolkit().getImage(u);
		mt.addImage (cards[52], b++);
		try { mt.waitForAll(); } catch (InterruptedException ie) {}
		addMouseListener (this);
		addMouseMotionListener (this);
		setBackground(new Color (220, 255, 220));
		setSize (800,650);
		for (int i = 0; i < 52; i++) { d[i] = i; }
		for (int i = 0; i < 2048; i = i+2) {
			int idx1 = (int)(52*Math.random());
			int idx2 = (int)(52*Math.random());
			int t = d[idx1]; d[idx1] = d[idx2]; d[idx2] = t;
		}
		for (int i = 0; i < 4; i++) tp[i] = -1;
		b=0;
		update();
	}

	private void update() {
		if (idx == 52) {
			m.clear();
			idx = b;
			for (int i = 0; i < 4; i++) {
				for (int j = 0; j <= tp[i]; j++) d[idx++] = pt[i][j];
				tp[i] = -1;
			}
			nl=idx-b;
			idx = b;
		}
		for (int i = 0; i < 4; i++) {
			if (++tp[i] < 0) { tp[i] = 0; }
			pt[i][tp[i]] = d[idx++];
			nl--;
			if (idx == 52) {
				lm[4] = 1;
				m.push(lm.clone());
				return;
			}
		}
		lm[4] = 1;
		m.push(lm.clone());
	}

	public void paint (Graphics g) {
		if (idx != 52) g.drawImage(cards[52], 10, 10, this);
		for (int i = 0; i < 4; i++) {
			if (tp[i] < 0) continue;
			int x = pt[i][tp[i]];
			if (x >= 0)     g.drawImage(cards[x], 20+(i+1)*80, 10, this);
		}
		if (z != -1) g.drawImage(cards[z], p.x-ax, p.y-ay, this);
		g.drawString(""+sc, 500, 10);
		g.drawString(""+nl, 500, 80);
	}

	public void mouseClicked(MouseEvent e) {
		if (e.getY() < 10 || e.getY() > 107) return;
		if (e.getButton() == 3) return;
		if (e.getClickCount() > 1) {
			int c = pt[0][tp[0]];
			for (int i = 1; i < 4; i++) if (tp[i]==-1 || pt[i][tp[i]]/4 != c/4) return;
			for (int i = 0; i < 4; i++) {
				lm[i] = pt[i][tp[i]];
				pt[i][tp[i]--] = -1;
				sc++;
				b++;
			}
			lm[4] = 2;
			m.push(lm.clone());
		}
		if (sc == 52) setBackground(Color.red);
	}
	public void mouseEntered(MouseEvent e) {}
	public void mouseExited(MouseEvent e) {}
	public void mouseMoved(MouseEvent e) {}
	public void mousePressed(MouseEvent e) {
		if (e.getY() < 10 || e.getY() > 107) return;
		if (e.getButton() == 3) {
			if (m.empty()) return;
			int l[] = m.pop();
			if (l[4] == 2) {
				for (int i = 0; i < 4; i++) pt[i][++tp[i]] = l[i];
				sc -= 4;
				b -= 4;
			} else if(l[4] == 1) {
				for (int i = 3; i>=0; i--) {
					d[--idx] = pt[i][tp[i]--];
					nl++;
				}
			} else {
				pt[l[0]][l[1]] = pt[l[2]][l[3]];
				pt[l[2]][l[3]] = -1;
				tp[l[0]]++;
				tp[l[2]]--;
			}
			repaint();
			return;
		}
		p = e.getPoint();
		h = -1+(p.x-20)/80;
		if (h == -1) {
			update();
			h--;
		}
		if (h < -1 || h > 3) {
			repaint();
			h = -1;
			return;
		}
		ax = tp[h]--;
		if (ax < 0) { h = -1; return; }
		lm[0] = h;
		lm[1] = ax;
		z = pt[h][ax];
		pt[h][ax] = -1;
		ax = p.x - (20+(h+1)*80);
		ay = p.y-10;
	}

	public void mouseReleased(MouseEvent e) {
		if (h == -1) return;
		if (e.getButton() == 3) return;
		if (e.getY() < 10 || e.getY() > 107)
			pt[h][++tp[h]] = z;
		else {
			p.x = e.getX();
			p.y = e.getY();
			ax = -1+(p.x-20)/80;
			if (ax == -1 || h == ax || ax > 3 || tp[ax] == -1 || ax > h)
				pt[h][++tp[h]] = z;
			else if (z/4 == pt[ax][tp[ax]]/4) {
				pt[ax][++tp[ax]] = z;
				lm[2] = ax;
				lm[3] = tp[ax];
				lm[4] = 0;
				m.push(lm.clone());
			} else
				pt[h][++tp[h]] = z;
		}
		z=-1;
		repaint();
	}

	public void mouseDragged(MouseEvent e) {
		p = e.getPoint();
		repaint();
	}
}
