package _10_pig_latin;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Pig_Latin implements ActionListener {
	JFrame frame = new JFrame("Google Translate");
	JPanel panel = new JPanel();
	JButton button = new JButton("Translate");
	JTextField field = new JTextField(20);
	JLabel translate = new JLabel();
	String input;

	public void run() {
		frame.setPreferredSize(new Dimension(700, 85));
		frame.add(panel);
		frame.setVisible(true);

		button.setPreferredSize(new Dimension(150, 25));
		button.addActionListener(this);
		translate.setPreferredSize(new Dimension(140, 15));
		translate.setText("");

		String input = field.getText();
		panel.add(field);
		panel.add(button);
		panel.add(translate);

		frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
		frame.pack();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		input = field.getText();
		
		translate.setText(new PigLatinTranslator().translate(input));
	}
}
