package edu.neu.csye6200.concth;

public class MyThread extends Thread {

	private boolean done = false; // we are not done initially
	private int ctr = 0; // how many times around the loop?

	public MyThread(String name) {
		super(name);
	}

	public void run() {
		while (!done) {
			doWork(); // Do important time consuming work
			System.out.println("Thread:" + this.getName() + " - loop:" + ctr);
			if (++ctr > 1000) // Count how many times around the loop
				done = true;
		}
	}

	public void doWork() {
		for (int i = 0; i < 100000; i++) {
			double val = Math.exp((double) i);
		}
	}
}
