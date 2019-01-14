package edu.neu.csye6200.timer;

import java.awt.Toolkit;
import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;
/**
 * @author steve
 *
 */
public class TimerDemo {

	private Timer timer;
	
	//constructor
	public TimerDemo() {
		timer = new Timer();
		
		// task, delay time, periodic delay
		// use anonymous inner class
		timer.schedule(new TimerTask() {
			private int ctr = 0;
			public void run(){
				System.out.println("Timer alert " + ctr++);
				Toolkit.getDefaultToolkit().beep();
				if(ctr > 5)	timer.cancel();
			}
		}, 3000L, 1000L);
	}
	

	
/*	class RemindTask extends TimerTask{

		private int ctr = 0;
		
		@Override
		public void run() {
			System.out.println("Timer alert " + ctr++);
			Toolkit.getDefaultToolkit().beep();
			if(ctr > 5)	timer.cancel();
		}		
	}*/
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {

		new TimerDemo();
		
	}
}
