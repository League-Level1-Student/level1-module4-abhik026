package _11_whack_a_mole;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class mole implements ActionListener {
	JFrame frame = new JFrame();
	JPanel panel = new JPanel();
	JButton button = new JButton("MOLE!");
	Random ran = new Random();
	int mole = ran.nextInt(24);
	int count = 0;
	public void run() {
		drawButtons(mole);
	}

	void drawButtons(int location) {
		for (int i = 0; i < 24; i++) {
			if (i == location) {
				panel.add(button);
			} else {
				JButton temp = (new JButton("            "));
				temp.addActionListener(this);
				panel.add(temp);
			}

		}
		frame.add(panel);
		button.addActionListener(this);
		frame.setPreferredSize(new Dimension(300, 315));
		frame.setTitle("WHACK-A-MOLE");
		frame.pack();
		frame.setVisible(true);
		frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		JButton click = (JButton) e.getSource();
		if (click == button) {
			speak("HIT");
			frame.dispose();
			drawButtons(mole);
		} else {
			count +=1;
			if(count ==5) {
				speak("5 MISSES, GAME OVER");
				System.exit(0);
			}
			speak("MISSED");
			System.out.println("MISS");
			frame.dispose();
			drawButtons(mole);
		}
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
