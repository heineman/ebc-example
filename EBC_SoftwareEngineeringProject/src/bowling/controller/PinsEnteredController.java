package bowling.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextField;

import bowling.IBowling;
import bowling.view.GameView;

public class PinsEnteredController implements ActionListener {

	GameView game;
	IBowling model;
	
	public PinsEnteredController(GameView gameView, IBowling model) {
		this.game = gameView;
		this.model = model;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		JTextField jf = game.getPinsField();
		
		try {
			Integer pins = Integer.parseInt(jf.getText());
			jf.setText("");
			model.roll(pins);
			
			game.repaint();
		} catch (Exception ex) {
			
		}

	}

}
