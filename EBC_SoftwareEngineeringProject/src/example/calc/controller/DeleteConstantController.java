package example.calc.controller;

import javax.swing.DefaultListModel;
import javax.swing.JList;

import example.calc.model.Constant;
import example.calc.model.Model;
import example.calc.view.CalculatorApp;

public class DeleteConstantController {
	CalculatorApp app;
	Model model;

	public DeleteConstantController(CalculatorApp app, Model m) {
		this.app = app;
		this.model = m;
	}

	public void delete() { 
		Constant sel = (Constant) app.getList().getSelectedValue();
		if (sel == null) {
			return;
		}

		model.delete(sel.name);
		
		JList<Constant> list = app.getList();
		DefaultListModel<Constant> listModel = new DefaultListModel<>();
		for (Constant c : model) {
			listModel.addElement(c);
		}
		list.setModel(listModel);
		app.repaint();
	}
}
