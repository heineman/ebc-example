import java.awt.*;import java.awt.event.*;import java.util.Random;import javax.swing.*;class P extends JFrame{int w=99,j=45,x=w,y=w,m,H=450,W=300;String u[]={"Heads","Tails"};JPanel p;Random n=new Random();public P(){setTitle("Sample Application");setDefaultCloseOperation(0);setBounds(w,w,H,W);setContentPane(p=new JPanel(){public void paintComponent(Graphics g){if(m>0){g.fillRect(x,y,w,w);g.setColor(Color.WHITE);}else g.drawRect(x,y,w,w);g.drawString(u[m],x+j,y+j);}});p.addMouseListener(new MouseAdapter(){public void mousePressed(MouseEvent e){if(new Rectangle(x,y,w,w).contains(e.getPoint())){m=1-m;x=n.nextInt(W/2);y=n.nextInt(H/2);repaint();}}});}public static void main(String[]b){P a=new P();a.addWindowListener(new WindowAdapter(){public void windowClosing(WindowEvent e){if(0==JOptionPane.showConfirmDialog(a,"Do you wish to exit Application?"))a.dispose();}});a.setVisible(true);}}