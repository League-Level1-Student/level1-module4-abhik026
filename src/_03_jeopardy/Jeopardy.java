package _03_jeopardy;

/*
 *    Copyright (c) The League of Amazing Programmers 2013-2019
 *    Level 1
 */

import java.applet.AudioClip;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.net.URL;

import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.BoxLayout;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JApplet;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/* Check out the Jeopardy Handout to see what the end result should look like: http://bit.ly/1bvnvd4 */

public class Jeopardy implements ActionListener {
	private JButton firstButton;
	private JButton secondButton;
	private JButton thirdButton, fourthButton;
	private JPanel quizPanel;
	private int score = 0;
	private JLabel scoreBox = new JLabel("0");
	private int buttonCount = 0;
	private AudioClip sound;

	public void run() {
		JFrame frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		quizPanel = new JPanel();
		frame.setLayout(new BorderLayout());
		frame.setVisible(true);
		// 1. Make the frame show up

		// 2. Give your frame a title
		frame.setTitle("Online Jeopardy");
		// 3. Create a JPanel variable to hold the header using the createHeader method
		JPanel panel = createHeader("Header");

		// 4. Add the header component to the quizPanel
		frame.add(panel);
		// 5. Add the quizPanel to the frame
		frame.add(quizPanel);

		// 6. Use the createButton method to set the value of firstButton
		firstButton = createButton("$200");
		// 7. Add the firstButton to the quizPanel
		quizPanel.add(firstButton);
		// 8. Write the code to complete the createButton() method below. Check that
		// your
		// game looks like Figure 1 in the Jeopardy Handout - http://bit.ly/1bvnvd4.

		// 9. Use the secondButton variable to hold a button using the createButton
		// method
		secondButton = createButton("$400");
		// 10. Add the secondButton to the quizPanel
		quizPanel.add(secondButton);
		firstButton.addActionListener(this);
		secondButton.addActionListener(this);
		// 11. Add action listeners to the buttons (2 lines of code)

		// 12. Write the code to complete the actionPerformed() method below

		// 13. Add buttons so that you have $200, $400, $600, $800 and $1000 questions

		/*
		 * [optional] Use the showImage or playSound methods when the user answers a
		 * question
		 */

		frame.pack();
		quizPanel.setLayout(new GridLayout(buttonCount + 1, 3));
		frame.add(makeScorePanel(), BorderLayout.NORTH);
		frame.setSize(Toolkit.getDefaultToolkit().getScreenSize().height,
				Toolkit.getDefaultToolkit().getScreenSize().width);
	}

	private JButton createButton(String dollarAmount) {
		JButton button = new JButton();
		// Create a new JButton
		button.setText(dollarAmount);
		// Set the text of the button to the dollarAmount
		buttonCount += 2;
		// Increment the buttonCount (this should make the layout vertical)

		// Return your new button instead of the temporary button

		return button;
	}

	public void actionPerformed(ActionEvent e) {


		JButton buttonPressed = (JButton) e.getSource();
		// If the buttonPressed was the firstButton
		if (buttonPressed == firstButton) {
			askQuestion("In this year between 1970 and 1980 the Steelers defeated the Cowboys in the Super Bowl",
					"1979", 200);
			firstButton.setText("");
		} else if (buttonPressed == secondButton) {
			askQuestion("This fruit has the highest calories of any fruit.", "Avocado", 400);
			secondButton.setText("");
		}
		// If the buttonPressed was the secondButton

		// Call the askQuestion() method with a harder question

		// Clear the text on the button that was pressed (set the button text to
		// nothing)

	}

	private void askQuestion(String question, String correctAnswer, int prizeMoney) {
	
		playJeopardyTheme();
		// Use the playJeopardyTheme() method to play music while the use thinks of an
		// answer

		// Remove this temporary message and replace it with a pop-up that asks the user
		// the question
		String answer = JOptionPane.showInputDialog(question);
		clip.stop();
		// Stop the theme music when they have entered their response. Hint: use the
		// sound variable
	
		// If the answer is correct
		if (answer.equalsIgnoreCase(correctAnswer)) {
			score += prizeMoney;
			JOptionPane.showMessageDialog(null, "Correct! You recieve $" + prizeMoney);

		} else {
			score -= prizeMoney;
			JOptionPane.showMessageDialog(null, "Incorrect, -$" + prizeMoney+"\nCorrect answer is " + correctAnswer);
			// Incre// the

		}
		updateScore();
		// Pop up a message to tell the user they were correct
		// Otherwise

		// Decrement the score by the prizeMoney

		// Pop up a message to tell the user they were wrong and give them the correct
		// answer

		// Call the updateScore() method

	}

	public void playJeopardyTheme() {
	playSound("jeopardy.wav");
	}
	Clip clip;
	private void playSound(String soundFile) {
		String path = "src/_03_jeopardy/";
			File sound = new File(path+soundFile);
			if (sound.exists()) {
				new Thread(() -> {
				try {
					clip = AudioSystem.getClip();
					clip.open(AudioSystem.getAudioInputStream(sound));
					clip.start();
					Thread.sleep(clip.getMicrosecondLength()/1000);
				}
				catch (Exception e) {
					System.out.println("Could not play this sound");
				}}).start();
	 		}
			else {
				System.out.println("File does not exist");
			}
		
	}

	private Component makeScorePanel() {
		JPanel panel = new JPanel();
		panel.add(new JLabel("score:"));
		panel.add(scoreBox);
		panel.setBackground(Color.CYAN);
		return panel;
	}

	private void updateScore() {
		scoreBox.setText("" + score);
	}

	private JPanel createHeader(String topicName) {
		JPanel panelj = new JPanel();
		panelj.setLayout(new BoxLayout(panelj, BoxLayout.PAGE_AXIS));
		JLabel l1 = new JLabel(topicName);
		l1.setAlignmentX(Component.CENTER_ALIGNMENT);
		panelj.add(l1);
		return panelj;
	}

	void showCorrectImage() {
		showImage("correct.jpg");
	}

	void showIncorrectImage() {
		showImage("incorrect.jpg");
	}

	private void showImage(String fileName) {
		JFrame frame = new JFrame();
		URL imageURL = getClass().getResource(fileName);
		Icon icon = new ImageIcon(imageURL);
		JLabel image = new JLabel(icon);
		frame.add(image);
		frame.setVisible(true);
		frame.pack();
	}
}
