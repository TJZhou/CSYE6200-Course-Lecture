package edu.neu.csye6200.run;

/**
 * @author steve
 *
 */
public class MyRunTest {

	Thread thread = null;

	
	public MyRunTest(String name) {
		 // Create a Runnable
		thread = new Thread(new MyRunnable(name)); // create a thread
		thread.start();	// start the thread
	}


	/**
	 * @param args
	 */
	public static void main(String[] args) {
		MyRunTest mrtestA = new MyRunTest("A"); // initialize the threads
		MyRunTest mrtestB = new MyRunTest("B"); // initialize the threads
	}
}
