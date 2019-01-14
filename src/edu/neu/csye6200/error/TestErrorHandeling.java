package edu.neu.csye6200.error;

import java.io.IOException;

/**
 * @author Tianju Zhou
 *
 */
public class TestErrorHandeling extends Throwable{

	public void run() {
		testCatch();
	}

	// Let's call the error-prone method
	public void testCatch() {
		try {
			testError(1);
		}catch(IOException e){
			System.out.println("ERROR: " + e.getLocalizedMessage());
			e.printStackTrace();
		} catch (Exception e) {
			System.out.println("ERROR: " + e.getLocalizedMessage());
			e.printStackTrace();
		} catch (TestErrorHandeling e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	// could produce an Exception
	public void testError(int val) throws Exception, TestErrorHandeling {
		if (val > 5) {
			throw new TestErrorHandeling();
		}
			
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
