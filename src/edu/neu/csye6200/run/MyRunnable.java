package edu.neu.csye6200.run;

/**
 * @author steve
 *
 */
public class MyRunnable implements Runnable {

	private String name;
	private boolean done = false; // we are not done initially
	private int ctr = 0;
	private boolean paused = false; // set true to pause program

	public MyRunnable(String name) {
		this.name = name;
	}

	@Override
	public void run() {
		while (!done) {
			if (ctr == 100)
				paused = true;
			if (ctr == 109)
				paused = false;
			if (paused) {
				try {
					Thread.sleep(500L);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				ctr++;
			} else {
				ctr++;
				doWork(); // Do important time consuming work
				if ((ctr % 10) == 0)
					System.out.println("Thread:" + name + " - loop:" + ctr);
				if (ctr > 1000) // Count how many times around the loop
					done = true;
			}
		}
	}

	public void doWork() {
		for (int i = 0; i < 100000; i++) {
			double val = Math.exp((double) i);
		}
	}
}
