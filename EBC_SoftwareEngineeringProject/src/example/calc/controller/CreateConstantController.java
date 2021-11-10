package example.calc.controller;

import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.ListModel;

import example.calc.model.Constant;
import example.calc.model.Model;
import example.calc.view.CalculatorApp;

public class CreateConstantController {
	CalculatorApp app;
	Model model;
	
	public CreateConstantController(CalculatorApp app, Model m) {
		this.app = app;
		this.model = m;
	}
	
	public void create() { 
		String name = app.getConstantName().getText();
		
		// interesting: if exception, then KEEP!
		try {
			double checking = Double.parseDouble(name);
			JOptionPane.showMessageDialog(app,
				    "Cannot use \"" + name + "\" as a constant name.",
				    "WARNING.",
				    JOptionPane.WARNING_MESSAGE);
			return;
		} catch (Exception e) {
			
		}
		
		String value = app.getConstantValue().getText();
		try {
			double v = Double.parseDouble(value);
			model.add(name,  v);
			app.getConstantName().setText("");
			app.getConstantValue().setText("");
			
			JList<Constant> list = app.getList();
			DefaultListModel<Constant> listModel = new DefaultListModel<>();
			for (Constant c : model) {
				listModel.addElement(c);
			}
			list.setModel(listModel);
			app.repaint();
		} catch (Exception e) {
			JOptionPane.showMessageDialog(app,
				    "Value \"" + value + "\" is not a value.",
				    "WARNING.",
				    JOptionPane.WARNING_MESSAGE);
			app.getConstantValue().setText("");
		}
		
	}
}
