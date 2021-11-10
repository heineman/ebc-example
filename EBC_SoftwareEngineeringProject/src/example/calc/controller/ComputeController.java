package example.calc.controller;

import javax.swing.JOptionPane;

import example.calc.model.Constant;
import example.calc.model.Model;
import example.calc.view.CalculatorApp;

public class ComputeController {
	CalculatorApp app;
	Model model;
	
	public ComputeController(CalculatorApp app, Model m) {
		this.app = app;
		this.model = m;
	}
	
	public void compute() { 
		String arg1 = app.getTextArg1().getText();
		String arg2 = app.getTextArg2().getText();
		double v1, v2;
		
		try {
			v1 = Double.parseDouble(arg1);
		} catch (Exception e) {
			Constant c = model.getConstant(arg1);
			if (c == null) {
				JOptionPane.showMessageDialog(app,
						"Arg1 \"" + arg1 + "\" is not a constant or value.",
					    "WARNING.",
					    JOptionPane.WARNING_MESSAGE);
				return;
			} else {
				v1 = c.value;
			}
		}
			
		try {
			v2 = Double.parseDouble(arg2);
		} catch (Exception e) {
			Constant c = model.getConstant(arg2);
			if (c == null) {
				JOptionPane.showMessageDialog(app,
					    "Arg2 \"" + arg2 + "\" is not a constant or value.",
					    "WARNING.",
					    JOptionPane.WARNING_MESSAGE);
				return;
			} else {
				v2 = c.value;
			}
		}	
			
		double sum = v1 + v2;
		app.getTextSum().setText("" + sum);
		app.repaint();
	}
}
