import java.awt.*;import java.awt.event.*;import java.util.Random;import javax.swing.*;
class O extends JFrame{int w=99,x=w,y=w,m=0;String u[]={"Heads","Tails"};JPanel c;S p;
Random n=new Random();public class S extends JPanel{public void paintComponent(Graphics g) {
if(m>0){g.fillRect(x,y,w,w);g.setColor(Color.WHITE);}else g.drawRect(x,y,w,w);g.drawString(u[m],x+45,y+45);}}
public O(){setTitle("Sample Application");setDefaultCloseOperation(0);setBounds(w,w,450,300);
setContentPane(c=new JPanel());p=new S();p.addMouseListener(new MouseAdapter(){public void mousePressed(MouseEvent e){
if(new Rectangle(x,y,w,w).contains(e.getPoint())){m=1-m;x=(int)((p.getWidth()-w)*n.nextDouble());
y=(int)((p.getHeight()-w)*n.nextDouble());repaint();}}});c.setLayout(new BorderLayout());c.add(p);}
public static void main(String[]b){O a=new O();a.addWindowListener(new WindowAdapter(){public void windowClosing(WindowEvent
e){if(0==JOptionPane.showConfirmDialog(a,"Do you wish to exit Application?"))a.dispose();}});a.setVisible(true);}}

