package edu.neu.csye6200.inner;

/**
 * @author steve
 *
 */
public class InnerTest {

	private int key = 20;

	// An inner class
	public class InnerProc {
		public String encode(String input) {
			char c2;
			StringBuffer sb = new StringBuffer();
			for (char c : input.toCharArray()) {
				c2 = (char) (c ^ key); // XOR - Exclusive OR each character
				sb.append(c2); // Add the encoded character to the buffer
			}
			return sb.toString(); // return the encoded buffer
		}
	}

	/**
	 * constructor - this is the construction of my class
	 * 
	 * @param key the secret encryption key
	 * @author steve
	 */
	public InnerTest(int key) {
		this.key = key;
		InnerProc iProc = new InnerProc();
		
		String str0 = "My secret message 123";
		System.out.println("str0: " + str0);
		
		String str1 = iProc.encode(str0);	// Initial encode
		System.out.println("str1: " + str1);
		
		String str2 = iProc.encode(str1);	// Reverse the encoding due to XOR
		System.out.println("str2: " + str2);
	}

	/**
	 * My main method
	 * 
	 * @param args input arguments
	 */
	public static void main(String[] args) {
		InnerTest inTest = new InnerTest(0b00011110);
	}

}
