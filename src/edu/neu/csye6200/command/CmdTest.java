package edu.neu.csye6200.command;

/**
 * @author steve
 *
 */
public class CmdTest {
	
	private StringBuffer textDoc = new StringBuffer();	//my test document
	
	//constructor
	public CmdTest() {
		textDoc.append("Initial String");
		
		InsertTextCmd itc = new InsertTextCmd(textDoc, "ABC123", 8);
		
		System.out.println("Before insert textDoc: " + textDoc.toString());
		
		itc.execute();
		itc.execute();
		itc.undo();
		
		System.out.println("After insert textDoc: " + textDoc.toString());

	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		CmdTest cmdTest = new CmdTest();
		
	}
}
