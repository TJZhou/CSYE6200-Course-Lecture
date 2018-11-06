package edu.neu.csye6200.concth;

/**
 * @author steve
 *
 */
public class MyThreadTest {

	private MyThread threadA = null;
	private MyThread[] threads = new MyThread[10];	//a group of threads
	
	public MyThreadTest() {
		threadA = new MyThread("A");
		for(int i = 0; i < threads.length; i++)
			threads[i] = new MyThread("Thread " + i);
	}
	
	public void run() {
		threadA.start();	//launch our thread - list off
		for(MyThread th : threads)
			th.start();
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		MyThreadTest mtt = new MyThreadTest();
		mtt.run();
		System.out.println("we are done with main.");
	}

}
