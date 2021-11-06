package oo.minimal.view;

import javax.swing.*;

import oo.minimal.controller.*;
import oo.minimal.model.*;

public class Application extends JFrame {
	JTextField fahrenheitField;    /** Relevant GUI widgets for this screen. */
	JButton convertButton;
	Model model;             
	JLabel lblCelsius;
	
	public Application(Model m) {
		this.model = m;
		initialize();
		
		// synchronize view with GUI
		refresh();
	}
	
	public JTextField getFahrenheitField() {
		return fahrenheitField;
	}
	
	public JButton getConvertButton() {
		return convertButton;
	}
	
	public JLabel getCelsiusLabel() {
		return lblCelsius;
	}
	
	void initialize() {
		setTitle("Fahrenheit to Celsius");
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setBounds(100, 100, 290, 100);
		JPanel contentPane = new JPanel();
		setContentPane(contentPane);
		
		JLabel lblName = new JLabel("Fahrenheit:");
		contentPane.add(lblName);
		
		fahrenheitField = new JTextField(10);
		contentPane.add(fahrenheitField);
		
		convertButton = new JButton("Convert");
		contentPane.add(convertButton);
		
		lblCelsius = new JLabel("Celsius: ");
		contentPane.add(lblCelsius);
		
		// install controller.
		convertButton.addActionListener(new ChangeTemperatureController(this, model));
	}

	/** Boundary knows how to refresh itself in relation to model. */ 
	public void refresh() {
		getFahrenheitField().setText("" + model.getFahrenheit());
		getCelsiusLabel().setText("Celsius: " + model.getCelsius());
	}
}
