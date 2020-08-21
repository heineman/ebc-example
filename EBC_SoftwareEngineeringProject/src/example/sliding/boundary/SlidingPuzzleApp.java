package example.sliding.boundary;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import example.sliding.controller.SelectPieceController;
import example.sliding.model.Model;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;

public class SlidingPuzzleApp extends JFrame {

	private JPanel contentPane;
	PuzzlePanel panel;

	Model model;
	
	public PuzzlePanel getPuzzlePanel() { return panel; }
	
	/**
	 * Create the frame.
	 */
	public SlidingPuzzleApp(Model m) {
		super();
		this.model = m;
		setTitle("Sliding Puzzle Application");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 558, 464);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		panel = new PuzzlePanel(model);
		panel.addMouseListener(new MouseAdapter() { 
			@Override
			public void mousePressed(MouseEvent me) {
				new SelectPieceController(model, SlidingPuzzleApp.this).process(me.getPoint());
			}
		});
		
		JLabel nmLabel = new JLabel("Number of Moves:");
		
		JLabel actualMoves = new JLabel("0");
		
		JButton btnReset = new JButton("Reset");
		
		JButton btnUp = new JButton("^");
		
		JButton btnDown = new JButton("v");
		
		JButton btnRight = new JButton(">");
		
		JButton btnNewButton = new JButton("<");
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 320, GroupLayout.PREFERRED_SIZE)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGap(18)
									.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
										.addGroup(gl_contentPane.createSequentialGroup()
											.addComponent(nmLabel)
											.addPreferredGap(ComponentPlacement.UNRELATED)
											.addComponent(actualMoves, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE))
										.addComponent(btnReset)))
								.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
									.addGroup(gl_contentPane.createSequentialGroup()
										.addPreferredGap(ComponentPlacement.RELATED)
										.addComponent(btnDown))
									.addGroup(Alignment.LEADING, gl_contentPane.createSequentialGroup()
										.addGap(107)
										.addComponent(btnUp))))
							.addContainerGap(137, Short.MAX_VALUE))
						.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
							.addGap(62)
							.addComponent(btnNewButton)
							.addGap(50)
							.addComponent(btnRight)
							.addGap(119))))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addContainerGap()
							.addComponent(panel, GroupLayout.PREFERRED_SIZE, 400, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(22)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(nmLabel)
								.addComponent(actualMoves))
							.addGap(88)
							.addComponent(btnUp)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(btnRight)
								.addComponent(btnNewButton))
							.addGap(7)
							.addComponent(btnDown)
							.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addComponent(btnReset)))
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		contentPane.setLayout(gl_contentPane);
	}
}
