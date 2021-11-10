package example.calc.view;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JList;

import example.calc.controller.ComputeController;
import example.calc.controller.CreateConstantController;
import example.calc.controller.DeleteConstantController;
import example.calc.model.Model;

public class CalculatorApp extends JFrame {

	Model model;
	
	JPanel contentPane;
	JTextField textArg1;
	JTextField textArg2;
	JTextField textSum;
	JTextField textConstantName;
	JTextField textConstantValue;
	JList list;
	
	public JTextField getTextArg1() { return textArg1; }
	public JTextField getTextArg2() { return textArg2; }
	public JTextField getConstantName() { return textConstantName; }
	public JTextField getConstantValue() { return textConstantValue; }
	public JTextField getTextSum() { return textSum; }
	public JList getList() { return list; }
	
	/**
	 * Create the frame.
	 */
	public CalculatorApp(Model model) {
		this.model = model;
		setTitle("Calculator App");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 700, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		textArg1 = new JTextField();
		textArg1.setColumns(10);
		
		JLabel lblArg = new JLabel("Arg1:");
		
		JLabel lblArg_1 = new JLabel("Arg2:");
		
		textArg2 = new JTextField();
		textArg2.setColumns(10);
		
		JLabel lblSum = new JLabel("Sum:");
		
		textSum = new JTextField();
		textSum.setColumns(10);
		
		JButton btnAdd = new JButton("Add");
		btnAdd.addActionListener (new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				new ComputeController(CalculatorApp.this, model).compute();
			}
			
		});
		
		JLabel lblConstant = new JLabel("Constant:");
		
		textConstantName = new JTextField();
		textConstantName.setColumns(10);
		
		JLabel lblValue = new JLabel("Value:");
		
		textConstantValue = new JTextField();
		textConstantValue.setColumns(10);
		
		JButton btnCreate = new JButton("Create");
		btnCreate.addActionListener (new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				new CreateConstantController(CalculatorApp.this, model).create();
			}
			
		});
		
		list = new JList();
		JButton btnDelete = new JButton("Delete");
		btnDelete.addActionListener (new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				new DeleteConstantController(CalculatorApp.this, model).delete();
			}
			
		});
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(lblConstant)
								.addComponent(lblArg))
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(textArg1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(textConstantName, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addGap(32)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(lblArg_1)
									.addGap(18)
									.addComponent(textArg2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
									.addGap(18)
									.addComponent(lblSum)
									.addGap(18)
									.addComponent(textSum, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
									.addGap(26)
									.addComponent(btnAdd))
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(lblValue)
									.addGap(18)
									.addComponent(textConstantValue, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
									.addGap(38)
									.addComponent(btnCreate))))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(list, GroupLayout.PREFERRED_SIZE, 258, GroupLayout.PREFERRED_SIZE)
							.addGap(31)
							.addComponent(btnDelete)))
					.addContainerGap(86, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(25)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblArg)
						.addComponent(btnAdd)
						.addComponent(textSum, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblSum)
						.addComponent(textArg2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblArg_1)
						.addComponent(textArg1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(38)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblConstant)
						.addComponent(textConstantName, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblValue)
						.addComponent(textConstantValue, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnCreate))
					.addPreferredGap(ComponentPlacement.RELATED, 29, Short.MAX_VALUE)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addComponent(list, GroupLayout.PREFERRED_SIZE, 92, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnDelete))
					.addGap(21))
		);
		contentPane.setLayout(gl_contentPane);
	}
}
