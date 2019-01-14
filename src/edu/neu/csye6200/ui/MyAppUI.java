package edu.neu.csye6200.ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.logging.Logger;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JPanel;

import net.java.dev.designgridlayout.DesignGridLayout;

/**
 * @author Tianju Zhou
 *
 */
public class MyAppUI {

	private Logger log = Logger.getLogger(MyAppUI.class.getName());
	private JFrame frame = null;
	private JPanel mainPanel = null;
	private JPanel drawPanel = null;
	
	private JButton startBtn = null;
	private JButton stopBtn = null;
	
	private JTextField nameTF = new JTextField();	// A name input field
	private JTextField idTF = new JTextField();	// A id input field
	
	// constructor
	public MyAppUI() {
		log.info("App Started");
		initGUI();
	}

	// initialize the GUI
	private void initGUI() {
		frame = new JFrame();
		frame.setTitle("MyAppUI");
		frame.setSize(1000, 600); // set the size to something reasonable
		frame.setResizable(true); //set frame resizable
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // if we press the close button, exit
		frame.setLayout(new BorderLayout());
		frame.add(getMainPanel(), BorderLayout.NORTH);
		frame.add(getDrawPanel(), BorderLayout.CENTER);
		frame.setVisible(true);
	}

	// create a panel that we'll draw into
	public JPanel getMainPanel() {
		mainPanel = new JPanel();
		mainPanel.setLayout(new FlowLayout()); // flow from left to right
		DesignGridLayout playout =  new DesignGridLayout(mainPanel);
		
		startBtn = new JButton("Start"); // create button instances
		startBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				log.info("press start button - annoumous inner class");
				drawPanel.repaint(); 	// ask for a panel redraw
			}
		});
		
		stopBtn = new JButton("Stop");
		stopBtn.addActionListener(e->{
			log.info("press stop button - lambda expression");
		});
		
		//mainPanel.add(startBtn); // add them to the panel
		//mainPanel.add(stopBtn);
		
		/**
		 *  ---------using designGridLayout-----------
		 */
		nameTF.setText("Steve");
		playout.row().grid(new JLabel("Name")).add(nameTF);
		playout.row().grid(new JLabel("ID")).add(idTF);
		playout.emptyRow();
		playout.row().center().add(startBtn,stopBtn);
		
		
		mainPanel.setBackground(Color.LIGHT_GRAY);
		
		return mainPanel;
	}
	
	public JPanel getDrawPanel() {
		drawPanel = new MyPanel();
		return drawPanel;	
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		MyAppUI myApp = new MyAppUI();

		System.out.println("MyAppUI is exiting");

	}
}
