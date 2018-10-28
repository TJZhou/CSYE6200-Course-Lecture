package edu.neu.csye6200.sim;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.logging.Logger;

/**
 * @author Tianju Zhou NUID 001420546
 */

public class RegistryIO {

	private static Logger log = Logger.getLogger(RegistryIO.class.getName());
	
	Plant plant;
	FlowerPlant flowerPlant;
	
	RegistryIO() {
		log.info("Constructing a RegistryIO instance");
	}

	/**
	 * save all Plant
	 * 
	 * @param plantMap
	 * @param fileName
	 */
	public void saveAll(HashMap<Integer, Plant> plantMap, String fileName) {
		
		log.info("Save method is called");
		
		for (Plant pt : plantMap.values()) {
			save(pt, fileName);
		}
	}

	/**
	 * save single Plant
	 * 
	 * @param pt
	 * @param fileName
	 */
	private void save(Plant pt, String fileName) {
		
		// open source and destination files
		// using try-with-resources
		try (FileWriter writer = new FileWriter(fileName, true)){
		
			saveBasicInfo(writer, pt);

			saveStemInfo(writer, pt);
			
			writer.write("---------------------------------------------------------------------------------------------------------\n");
			
		} catch (FileNotFoundException e) { // File cannot be found
			log.warning("FileNotFoundException occurs at save method");
			e.printStackTrace();
		} catch (IOException e) { // All other IO problem
			log.warning("(IOException occurs at save method");
			e.printStackTrace();
		}
	}


	/**
	 * write basic Plant info
	 * 
	 * @param writer
	 * @param pt
	 * @throws IOException
	 */
	private void saveBasicInfo(FileWriter writer, Plant pt) throws IOException {
		writer.write(String.format("%1$-16s %2$-16s %3$-16s %4$-16s %5$-16s %6$-16s %7$-16s", 
		"specimenID", "plantName", "totalHeight (cm)", "totalWidth (cm)", "stemNumbers","flowerColoer","petalNumbers"));
		writer.write("\n");
		writer.write(pt.toString());
		writer.write("\n\n");
	}

	/**
	 * write the stems info of the Plant
	 * 
	 * @param writer
	 * @param pt
	 * @throws IOException
	 */
	private void saveStemInfo(FileWriter writer, Plant pt) throws IOException {
		writer.write(pt.printChildStem());
	}


	/**
	 * @param readBase 
	 * to read from readBase
	 */
	public void load(HashMap<Integer,Plant> plantMap, String readBase) {
		FileInputStream fis = null;
		InputStreamReader isr = null;
		BufferedReader br = null;
		String[] plantStr;	//to save string after split by space and enter
		
		log.info("Load method is called");
		
		try {
			String str = "";	//to read each line
			String str1 = "";	//save each line (str) in this string
			fis = new FileInputStream(readBase);	// FileInputStream
			isr = new InputStreamReader(fis);	// InputStreamReader 
			br = new BufferedReader(isr);
			while ((str = br.readLine()) != null) {
				str1 += str + "\n";
			}
			
			plantStr = str1.split("\\s+"); //split by every space ane enter
			
			createNewPlant(plantMap, plantStr);

		} catch (FileNotFoundException e) { // File cannot be found
			log.severe("An error occurs at save method: FileNotFoundException");
			e.printStackTrace();
		} catch (IOException e) { // All other IO problem
			log.severe("An error occurs at save method: IOException");
			e.printStackTrace();
		}
	}

	//load plant info from disk and create new plant instance
	private void createNewPlant(HashMap<Integer,Plant> plantMap, String[] plantStr) {
		
		for(String str2 : plantStr){

			//for each string, if it equals plant name, then create a new instance of plant
			switch(str2){
			case "Maple":
				plant = new Plant("Maple");
				plantMap.put(plant.getSpecimenID(), plant);
				break;
			case "PhoenixTree":
				plant = new Plant("PhoenixTree");
				plantMap.put(plant.getSpecimenID(), plant);
				break;
			case "CamphorTree":
				plant = new Plant("CamphorTree");
				plantMap.put(plant.getSpecimenID(), plant);
				break;
			case "Rose":
				flowerPlant = new FlowerPlant("Rose", "red", 40, 5);
				plantMap.put(flowerPlant.getSpecimenID(), flowerPlant);
				break;
			case "Tulip":
				flowerPlant = new FlowerPlant("Tulip", "yellor", 40, 4);
				plantMap.put(flowerPlant.getSpecimenID(), flowerPlant);
				break;
			case "Lily":
				flowerPlant = new FlowerPlant("Lily", "white", 40, 6);
				plantMap.put(flowerPlant.getSpecimenID(), flowerPlant);
				break;
			}
		}
	}
}
