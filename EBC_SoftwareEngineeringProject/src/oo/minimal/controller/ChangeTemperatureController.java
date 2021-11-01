package oo.minimal.controller;

import java.awt.event.*;

import javax.swing.JTextField;

import oo.minimal.model.*;
import oo.minimal.view.*;

public class ChangeTemperatureController implements ActionListener {
	Application application;     /** Application we have control over. */
	Model model;                 /** Model containing state. */
	
	public ChangeTemperatureController(Application app, Model m) {
		this.application = app;
		this.model = m;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		JTextField tf = application.getFahrenheitField();
		int newValue = Integer.valueOf(tf.getText());
		model.setTemperature(newValue);
		application.refresh();
	}
}
