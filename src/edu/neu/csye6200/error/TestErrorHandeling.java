package edu.neu.csye6200.error;

import java.io.IOException;

/**
 * @author Tianju Zhou
 *
 */
public class TestErrorHandeling {

	public void run() {
		testCatch();
	}

	// Let's call the error-prone method
	public void testCatch() {
		try {
			testError(6);
		}catch(IOException e){
			System.out.println("ERROR: " + e.getLocalizedMessage());
			e.printStackTrace();
		} catch (Exception e) {
			System.out.println("ERROR: " + e.getLocalizedMessage());
			e.printStackTrace();
		}
	}

	// could produce an Exception
	public void testError(int val) throws Exception {
		if (val > 5)
			throw new IOException("This is an IO Error");
		if (val < 2)
			throw new IllegalArgumentException("This is an IA Error");
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		TestErrorHandeling teh = new TestErrorHandeling();

		teh.run();
	}

}
