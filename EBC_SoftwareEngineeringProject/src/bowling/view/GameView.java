package bowling.view;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTextField;

import bowling.IBowling;
import bowling.controller.PinsEnteredController;
import javax.swing.JTextArea;

public class GameView extends JFrame {

	private static final long serialVersionUID = -8520213827650956390L;
	JPanel contentPane;
	IBowling model;
	FramesView framesPanel;
	private JTextField pinsField;
	
	/**
	 * Create the frame.
	 */
	public GameView(IBowling model) {
		setTitle("Bowling Frame");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 720, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		framesPanel = new FramesView(model);
		
		JLabel lblPinsRoll = new JLabel("Pins Roll:");
		
		pinsField = new JTextField();
		pinsField.setColumns(10);
		pinsField.addActionListener(new PinsEnteredController(this, model));
		
		JTextArea txtrEnterInEach = new JTextArea();
		txtrEnterInEach.setWrapStyleWord(true);
		txtrEnterInEach.setLineWrap(true);
		txtrEnterInEach.setText("Enter in each of the rolls by entering the number of pins knocked down in the pins field. With each roll. the display changes to show the appropriate graphical frame. Once game is over, pins entry is disabled and you have to exit.");

		
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(framesPanel, GroupLayout.DEFAULT_SIZE, 581, Short.MAX_VALUE)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(lblPinsRoll)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(pinsField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addComponent(txtrEnterInEach, GroupLayout.PREFERRED_SIZE, 581, Short.MAX_VALUE))
					.addContainerGap())
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(framesPanel, GroupLayout.PREFERRED_SIZE, 68, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblPinsRoll)
						.addComponent(pinsField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(txtrEnterInEach, GroupLayout.PREFERRED_SIZE, 113, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(18, Short.MAX_VALUE))
		);
		contentPane.setLayout(gl_contentPane);
		
	}

	public JTextField getPinsField() {
		return pinsField;
	}
}
