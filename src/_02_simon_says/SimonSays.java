package _02_simon_says;

/*
 *    Copyright (c) The League of Amazing Programmers 2013-2019
 *    Level 1
 */

import java.awt.Component;

import java.awt.Frame;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.net.URL;
import java.util.Date;
import java.util.HashMap;
import java.util.Random;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.io.IOException;

public class SimonSays extends KeyAdapter {
	int score = 0;
	HashMap<Integer, String> images = new HashMap<Integer, String>();
	private int imageIndex;
	private int tries = 0;
	private boolean simonSays = false;
	Date timeAtStart;

	// Complete steps 1 - 7 before you test
	// 1. Declare a JFrame variable
	JFrame frame = new JFrame();

	public void run() {

		// 2. Add the four images that match keyboard keys like this:
		images.put(KeyEvent.VK_UP, "up.jpg");
		images.put(KeyEvent.VK_DOWN, "down.jpg");
		images.put(KeyEvent.VK_LEFT, "left.jpg");
		images.put(KeyEvent.VK_RIGHT, "right.jpg");

		JOptionPane.showMessageDialog(null, "Press the matching key when Simon says, otherwise, press a different key");
		// 3. Use a JOptionPane to tell the user the rules: "Press the matching
		// key when
		// 'Simon says' otherwise press a different key"

		// 4. Call the showImage method to show an image
		showImage();
	}

	public void keyPressed(KeyEvent e) {
		// 15. Make a points variable to track the score.

//Left = 37
//Up  =38
//Right =39
//Down= 39
		// 16. If the keyCode matches the imageIndex and "Simon says"
		int key = e.getKeyCode();

		if (key == imageIndex && simonSays) {
			score += 5;
			speak("Noice, 5 points");

		} else if (!(key == imageIndex) && !simonSays) {
			score += 5;
			speak("Noice, 5 points");

		} else {
			speak("Incorrect");
			score -= 3;

		}
		tries += 1;
		if (tries >= 1 && tries < 3) {
			frame.dispose();
			showImage();
		} else if (tries >= 3) {
			frame.dispose();
			JOptionPane.showMessageDialog(null, "Score: " + score);
			System.exit(0);

		}
		// 17. Increase the value of score
		// 18. Use the speak method to tell the user they were correct

		// 19. If the keyCode doesn't match the imageIndex and "Simon didn't
		// say..."

		// 20. Increase the value of score

		// 21. Use the speak method to tell the user they were correct

		// 22. Increment tries by 1

		// 25. If tries is greater than 9 (or however many you want)...

		// 26. Tell the user their score

		// 27. Exit the program

		// 23. Dispose of the frame

		// 24. Call the showImage method to show a new image
	}

	private void showImage() {
		// 5. Initialize your frame to a new JFrame()
		JFrame image = new JFrame();
		image.setVisible(true);
		// 6. Set the frame to visible

		// 7. Uncomment the following line to add a random image to your frame
		image.add(getNextRandomImage());
		image.setTitle("Simon Says!");
		// 8. Set the name of your frame
		image.pack();
		// 9. Pack the frame
		image.setDefaultCloseOperation(image.EXIT_ON_CLOSE);
		// 10. Set the defaultCloseOperation of your frame to
		// JFrame.EXIT_ON_CLOSE
		image.addKeyListener(this);

		// 11. Add a key listener to the frame

		// 12. Create a new instance of Random

		// 13. Use the Random and the speak method to either say
		// "Simon says press this key" or "Press this key"
		Random ran = new Random();
		int simon = ran.nextInt(2);
		if (simon == 0) {
			speak("Simon says press this key");
			simonSays = true;
		} else {
			speak("Press this key");
			simonSays = false;
		}

		// 14. Above, set the value of simonSays to true/false appropriately

	}

	private Component getNextRandomImage() {
		this.imageIndex = new Random().nextInt(4) + 37;
		return loadImage(images.get(imageIndex));
	}

	private JLabel loadImage(String fileName) {
		URL imageURL = getClass().getResource(fileName);
		Icon icon = new ImageIcon(imageURL);
		return new JLabel(icon);
	}

	static void speak(String words) {

		if (System.getProperty("os.name").contains("Windows")) {
			String cmd = "PowerShell -Command \"Add-Type -AssemblyName System.Speech; (New-Object System.Speech.Synthesis.SpeechSynthesizer).Speak('"
					+ words + "');\"";
			try {
				Runtime.getRuntime().exec(cmd).waitFor();
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else {
			try {
				Runtime.getRuntime().exec("say " + words).waitFor();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

}

/*
 * BONUS! Add a timer : ~~~ where the code starts running ~~~ timeAtStart =
 * newDate();
 *
 * ~~~ where the code ends ~~~ Date timeAtEnd = new Date();
 * System.out.println((timeAtEnd.getTime()-timeAtStart.getTime())/1000);
 * System.exit(0);
 */
