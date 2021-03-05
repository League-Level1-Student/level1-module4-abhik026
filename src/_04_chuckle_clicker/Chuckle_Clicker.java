package _04_chuckle_clicker;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class Chuckle_Clicker implements ActionListener {
	private JFrame frame = new JFrame();
	private JPanel panel = new JPanel();
	private JButton joke = new JButton();
	private JButton punch = new JButton();

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Chuckle_Clicker().makeButtons();

	}

	private void makeButtons() {
		// TODO Auto-generated method stub

		frame.add(panel);
		panel.add(joke);
		panel.add(punch);
		frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);

		joke.addActionListener(this);
		punch.addActionListener(this);
		joke.setSize(20, 50);
		punch.setSize(90, 40);

		joke.setText("JOKE");
		punch.setText("PUNCH");
		frame.setVisible(true);
		frame.pack();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		JButton pressed = (JButton) e.getSource();
		if (pressed == joke) {
			System.out.println("joke");
		} else if (pressed == punch) {
			System.out.println("punch");
		}
	}

}
