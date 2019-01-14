package edu.neu.csye6200.ui;


import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;

/**
 * @author steve
 *
 */
public class MyPanel extends JPanel {
	int ctr = 0;
	
	
	public void paint(Graphics g) {
		ctr++;
		Graphics2D g2d = (Graphics2D) g;
		Dimension size = getSize();
		
	
		g2d.setColor(Color.white);
		g2d.fillRect(0, 0, size.width, size.height);	//fill the entire panel
		
		g2d.setColor(Color.red);
		g2d.drawLine(0, 0, size.width, size.height);
		
	}
}
