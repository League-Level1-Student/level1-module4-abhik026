package _01_nasty_surprise;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.MalformedURLException;
import java.net.URL;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class TrickOrTreat implements ActionListener {
JFrame frame = new JFrame();
JPanel panel = new JPanel();
JButton trick = new JButton("Treat");
JButton treat = new JButton("Trick");
public void  run(){
	frame.setPreferredSize(new Dimension(650, 80));
	frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
	frame.setVisible(true);
	frame.add(panel);
	panel.add(trick);
	panel.add(treat);
	frame.pack();
	trick.addActionListener(this);
	treat.addActionListener(this);
	trick.setPreferredSize(new Dimension(250,150));
	treat.setPreferredSize(new Dimension(250,150));
	frame.pack();
}
@Override
public void actionPerformed(ActionEvent e) {
	// TODO Auto-generated method stub
	JButton clicked = (JButton) e.getSource();
	if(clicked == trick) {
		showPictureFromTheInternet("https://www.hillspet.com/content/dam/cp-sites/hills/hills-pet/en_us/exported/dog-care/new-pet-parent/images/golden-retriever-puppy-running-outside.jpg");
	}
	else {
		showPictureFromTheInternet("https://static-23.sinclairstoryline.com/resources/media/d60d4f1c-9fcc-4ae4-8058-05e885080e19-large16x9_momo2.PNG?1551379953599");
	}
}
private void showPictureFromTheInternet(String imageUrl) {
    try {
        URL url = new URL(imageUrl);
        Icon icon = new ImageIcon(url);
        JLabel imageLabel = new JLabel(icon);
        JFrame frame = new JFrame();
        frame.add(imageLabel);
        frame.setVisible(true);
        frame.pack();
    } catch (MalformedURLException e) {
        e.printStackTrace();
    }
}
}