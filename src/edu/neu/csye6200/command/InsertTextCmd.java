package edu.neu.csye6200.command;

/**
 * @author steve
 *
 */
public class InsertTextCmd extends Command {

	private String inputTxt = "";
	private int startIndex = 0;
	
	public InsertTextCmd(StringBuffer doc, String inputTxt, int insertIndex) {
		super(doc);
		this.inputTxt = inputTxt;	//hang on to input command parms 
		this.startIndex = insertIndex;		
	}


	@Override
	public void execute() {
		doc.insert(startIndex, inputTxt);	//insert the imput at an index
	}

	@Override
	public void undo() {
		int endIndex = startIndex + inputTxt.length();
		doc.delete(startIndex, endIndex);
	}
}
