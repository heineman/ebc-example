package example.calc;

import java.awt.EventQueue;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import example.calc.model.Model;
import example.calc.view.CalculatorApp;
import example.oval.controller.ExitApplicationController;

public class Main {

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Model model = new Model();
					final CalculatorApp frame = new CalculatorApp(model);
					frame.addWindowListener (new WindowAdapter() {

						public void windowClosing(WindowEvent e) {
							new ExitApplicationController(frame).process();
						}
					});
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
