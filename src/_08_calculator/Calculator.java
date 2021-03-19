package _08_calculator;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Calculator implements ActionListener {
	JFrame frame = new JFrame();
	JPanel panel = new JPanel();
	JTextField field = new JTextField(5);
	JTextField field1 = new JTextField(5);
	JLabel label = new JLabel("");
	JButton add = new JButton("+");
	JButton sub = new JButton("-");
	JButton mult = new JButton("X");
	JButton div = new JButton("/");
	String numOne;
	String numTwo;
	double fld;
	double fld1;
	double finalnum;
	String answer;

	public void run() {

		frame.setVisible(true);
		frame.setPreferredSize(new Dimension(400, 300));
		frame.setTitle("CALCULATOR");
		frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);

		add.addActionListener(this);
		sub.addActionListener(this);
		mult.addActionListener(this);
		div.addActionListener(this);

		add.setPreferredSize(new Dimension(50,30));
		sub.setPreferredSize(new Dimension(50,30));
		mult.setPreferredSize(new Dimension(50,30));
		div.setPreferredSize(new Dimension(50,30));
		
		add.setLocation(13,	34);
		frame.add(panel);
		panel.add(field);
		panel.add(label);
		panel.add(add);
		panel.add(sub);
		panel.add(mult);
		panel.add(div);
		panel.add(field1);
		frame.pack();

	}

	void add() {
		
		numOne = field.getText();
		numTwo = field1.getText();

		fld = Double.parseDouble(numOne);
		fld1 = Double.parseDouble(numTwo);
		finalnum = fld + fld1;
		answer = Double.toString(finalnum);
		label.setText("="+answer);
	}

	void subtract() {
		numOne = field.getText();
		numTwo = field1.getText();

		fld = Double.parseDouble(numOne);
		fld1 = Double.parseDouble(numTwo);
		finalnum = fld-fld1;
		answer = Double.toString(finalnum);
		label.setText("="+answer);
	}

	void multiply() {
		numOne = field.getText();
		numTwo = field1.getText();

		fld = Double.parseDouble(numOne);
		fld1 = Double.parseDouble(numTwo);
		finalnum = fld * fld1;
		answer = Double.toString(finalnum);
		label.setText("="+answer);
	}

	void divide() {
		numOne = field.getText();
		numTwo = field1.getText();

		fld = Double.parseDouble(numOne);
		fld1 = Double.parseDouble(numTwo);
		finalnum = fld / fld1;
		answer = Double.toString(finalnum);
		label.setText("="+answer);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		JButton button = (JButton) e.getSource();
		if (button == add) {
			add();
		} else if (button == sub) {
			subtract();
		} else if (button == mult) {
			multiply();
		} else if (button == div) {
			divide();
		}
	}

}
