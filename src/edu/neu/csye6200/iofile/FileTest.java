package edu.neu.csye6200.iofile;

import java.io.File;

/**
 * @author Tianju ZHou
 *	print all the file name and length in this directory and sub-directory
 */
public class FileTest {

	public void run() {
		File baseDir = new File(".");
		if(!baseDir.exists())	//does it exist?
			baseDir.mkdirs();	//if not create the directory	
		listDir(baseDir);	//list the base directory
	}
	
	public void listDir(File dirFile){
		//if(!dirFile.isDirectory()) return;	//reject non-directory
		
		System.out.println("Dir: " + dirFile.getAbsolutePath());
		
		//Handle data files
		for(File file : dirFile.listFiles()){
			
			//handle data files
			if(!file.isDirectory())	{
				//skip directories
				String fTxt = String.format("%1$32s %2$10d", file.getName(), file.length());
				System.out.println(fTxt);
			}
				
			
			//handle directory files
			if(file.isDirectory())	//skip data files - keep directories
				listDir(file);	//recursive call the list the folder				
		}		
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		FileTest fileTest = new FileTest();
		fileTest.run();

	}
}
