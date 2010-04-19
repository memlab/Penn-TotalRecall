package components;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;

import util.GUIUtils;

public class CalibrationFrame extends JFrame {
	
	private static CalibrationFrame instance;
	
	private CalibrationFrame() {
		setSize(600, 300);
		setTitle("Audio Calibration");
		setLocation(GUIUtils.chooseLocation(this));
		
		JPanel panel = new JPanel();
		panel.setOpaque(true);
		panel.setForeground(Color.WHITE);
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));		
		setContentPane(panel);
		
		
		JPanel textPanel = new JPanel();
		textPanel.setLayout(new BoxLayout(textPanel, BoxLayout.X_AXIS));
		textPanel.setBorder(BorderFactory.createEmptyBorder(15, 15, 5, 15));
		textPanel.add(Box.createHorizontalGlue());
		textPanel.add(new JLabel(getInstructions()));
		textPanel.add(Box.createHorizontalGlue());
		
		JPanel buttonPanel = new JPanel();
		buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.X_AXIS));
		JButton playButton = new JButton("Play");
		buttonPanel.add(playButton);
		
		
		JPanel sliderPanel = new JPanel();
		JSlider slider = new JSlider(JSlider.HORIZONTAL, 0, 50, 0);
		panel.setMaximumSize(new Dimension(Integer.MAX_VALUE, 40));
		slider.setMinorTickSpacing(1);
		slider.setMajorTickSpacing(10);
		slider.setPaintTicks(true);
		slider.setPaintLabels(true);
		slider.setPaintTrack(true);
		slider.setSnapToTicks(true);
		sliderPanel.add(slider);
		sliderPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
		sliderPanel.setLayout(new BoxLayout(sliderPanel, BoxLayout.X_AXIS));
		sliderPanel.setPreferredSize(new Dimension(Integer.MAX_VALUE, (int)slider.getPreferredSize().getHeight() + 20));
				
		panel.add(textPanel);
		panel.add(Box.createVerticalGlue());
		panel.add(buttonPanel);
		panel.add(sliderPanel);
	}
	
	private String getInstructions() {
		StringBuffer buff = new StringBuffer();
		buff.append("<html>");
		buff.append("<p>To calibrate your audio system, please move the slider to the smallest value for which you hear a sound when you hit the Play button.</p>");
		buff.append("<br>");
		buff.append("<p>For example, if you hear nothing at all when the slider is on 5, but hear a tiny blip when the slider is on 6, choose 6.</p>");		
		buff.append("</html>");
		return buff.toString();
	}
	
	public static CalibrationFrame getInstance() {
		if(instance == null) {
			instance = new CalibrationFrame();
		}
		return instance;
	}
}
