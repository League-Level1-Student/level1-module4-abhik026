package _08_calculator;

import java.awt.Dimension;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Calculator {
	JFrame frame = new JFrame();
	JPanel panel = new JPanel();
	JTextField field = new JTextField(5);
	JTextField field1 = new JTextField(5);
	JLabel label = new JLabel("sdfs");
	JButton add = new JButton("+");
	JButton sub = new JButton("-");
	JButton mult = new JButton("X");
	JButton div = new JButton("/");

	public void run() {

		frame.setVisible(true);
		frame.setPreferredSize(new Dimension(400, 300));
		frame.setTitle("CALCULATOR");
		frame.add(panel);
		panel.add(field);
		panel.add(label);
		panel.add(add);
		panel.add(sub);
		panel.add(mult);
		panel.add(div);
		frame.pack();
	}

	static void add() {

	}

	static void subtract() {

	}

	static void multiply() {

	}

	static void divide() {

	}

}
