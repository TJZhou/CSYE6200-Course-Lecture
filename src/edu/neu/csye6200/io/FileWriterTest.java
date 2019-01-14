package edu.neu.csye6200.io;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * @author Tianju Zhou
 *
 */
public class FileWriterTest {

	private String base = "src/edu/neu/csye6200/io/";
	
	public void run(){
		
		try(BufferedReader br = new BufferedReader(new FileReader(base + "FileWriterTest.java"));
				BufferedWriter bw = new BufferedWriter(new FileWriter(base + "FWDuplicateX.txt"));){
			
			String str = br.readLine();
			while(str!=null) {
				bw.write(str+'\n');
				str = br.readLine();
			}
			
		}catch(FileNotFoundException e) {
			e.printStackTrace();
		}catch (IOException e) {
			e.printStackTrace();
		}
/*		try {
			//open source and destination files
			FileReader reader = new FileReader(base + "FileWriterTest.java");
			FileWriter writer = new FileWriter(base + "FWDuplicateX.txt");
			
			int inVal = reader.read();
			while(inVal >= 0){
				writer.write(" " + (char) inVal);
				inVal = reader.read();
			}
			
			//responsibility to close open files
			reader.close();
			writer.close();
		} catch (FileNotFoundException e) { //File cannot be found			
			e.printStackTrace();
		} catch (IOException e) {	// All other IO problem
			e.printStackTrace();
		}*/ 
		
		
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		FileWriterTest fwtDemo = new FileWriterTest();
		
		fwtDemo.run();
		
	}
}