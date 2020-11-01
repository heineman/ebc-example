package example.range.view;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import example.range.controller.ComputeController;
import example.range.model.Model;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;

/**
 * Example that enables Compute button ONLY if both fields are non-empty
 */
public class App extends JFrame {

	Model model;
	JPanel contentPane;
	JTextField startDateField;
	JTextField endDateField;
	JButton btnCompute;
	JLabel lblNumberDays;

	public JTextField getStartDateField () { return startDateField; }
	public JTextField getEndDateField () { return endDateField; }
	public JButton getComputeButton() { return btnCompute; }
	public JLabel getNumberDays() { return lblNumberDays; }

	/**
	 * Create the frame.
	 * @param m
	 */
	public App(Model m) {
		this.model = m;
		setTitle("Date Range Calculator");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 380, 129);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);

		JLabel lblStartDate = new JLabel("Start Date:");

		startDateField = new JTextField();
		startDateField.setText("MM/DD/YYYY");
		startDateField.setColumns(10);
		JLabel lblEndDate = new JLabel("End Date:");

		endDateField = new JTextField();
		endDateField.setText("MM/DD/YYYY");
		endDateField.setColumns(10);

		btnCompute = new JButton("Compute");
		btnCompute.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				new ComputeController(App.this, model).compute();
			}

		});

		lblNumberDays = new JLabel("Number Days:");
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
				gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
						.addContainerGap()
						.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
								.addGroup(gl_contentPane.createSequentialGroup()
										.addComponent(lblStartDate)
										.addPreferredGap(ComponentPlacement.RELATED)
										.addComponent(startDateField, GroupLayout.PREFERRED_SIZE, 109, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_contentPane.createSequentialGroup()
										.addComponent(lblEndDate)
										.addPreferredGap(ComponentPlacement.UNRELATED)
										.addComponent(endDateField)))
						.addGap(30)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(lblNumberDays)
								.addComponent(btnCompute))
						.addGap(142))
				);
		gl_contentPane.setVerticalGroup(
				gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
						.addContainerGap()
						.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblStartDate)
								.addComponent(startDateField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(btnCompute))
						.addGap(18)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblEndDate)
								.addComponent(endDateField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblNumberDays))
						.addContainerGap(189, Short.MAX_VALUE))
				);
		contentPane.setLayout(gl_contentPane);
	}
}
