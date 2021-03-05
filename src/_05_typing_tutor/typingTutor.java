package _05_typing_tutor;

import java.awt.Color;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class typingTutor implements KeyListener {
	char currentLetter;
	JLabel label = new JLabel();
	JPanel panel = new JPanel();
	String letter = String.valueOf(currentLetter);
	int times = 0;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		typingTutor tutor = new typingTutor();
		tutor.setup();
	}

	void setup() {
		JFrame frame = new JFrame();
		currentLetter = generateRandomLetter();
		String letter = String.valueOf(currentLetter);
		label.setText(letter);
		label.setFont(label.getFont().deriveFont(28.0f));
		label.setHorizontalAlignment(JLabel.CENTER);
		frame.addKeyListener(this);
		frame.add(panel);
		panel.add(label);
		frame.setVisible(true);
		frame.pack();
	}

	char generateRandomLetter() {
		// TODO Auto-generated method stub
		Random r = new Random();
		return (char) (r.nextInt(26) + 'a');
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		times +=1;
		System.out.println("you pressed: " + e.getKeyChar());
		if (e.getKeyChar() == currentLetter) {
			panel.setBackground(Color.green);
			System.out.println("CORRECT");
		} else {
			panel.setBackground(Color.red);
			System.out.println("INCORRECT");
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		currentLetter = generateRandomLetter();
		String let = String.valueOf(currentLetter);
		label.setText(let);
		if(times ==20) {
			System.exit(0);
		}

	}
}
