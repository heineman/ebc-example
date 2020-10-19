package example.start.view;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import example.start.controller.FlipController;
import example.start.model.Model;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;

/**
 * Every Java GUI application needs an enclosing JFrame. This is responsible for constructing the
 * appropriate GUI given the Model being rendered.
 *
 * Top-level application object from which all other GUI widgets and such can be retrieved.
 */
public class StartingFrame extends JFrame {

	/** Internal GUI concerns for this frame. */
	JPanel contentPane;
	StartingPanel panel;

	/** For EBC: Boundary object needs to know the top-level model. */
	Model model;

	/**
	 * Create the frame.
	 */
	public StartingFrame(Model m) {
		this.model = m;

		setTitle("Sample Application");
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);

		panel = new StartingPanel(m);

		// register the controller
		panel.addMouseListener(new FlipController(this, m));

		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
				gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
						.addContainerGap()
						.addComponent(panel, GroupLayout.DEFAULT_SIZE, 404, Short.MAX_VALUE)
						.addContainerGap())
				);
		gl_contentPane.setVerticalGroup(
				gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
						.addContainerGap()
						.addComponent(panel, GroupLayout.DEFAULT_SIZE, 229, Short.MAX_VALUE)
						.addContainerGap())
				);
		contentPane.setLayout(gl_contentPane);
	}

	/** Make visible to those who are interested. */
	public StartingPanel getStartingPanel() { return panel; }

}
