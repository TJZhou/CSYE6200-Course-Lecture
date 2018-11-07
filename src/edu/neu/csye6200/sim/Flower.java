package edu.neu.csye6200.sim;

import java.util.HashMap;
import java.util.logging.Logger;

import edu.neu.csye6200.bg.BGStem;

/**
 * @author Tianju Zhou NUID 001420546
 *
 */
public class Flower {
	
	//create a static HashMap to store all the stems 
	private static HashMap<Integer, Flower> flowerMap = new HashMap<Integer, Flower>();
	
	private static Logger log = Logger.getLogger(BGStem.class.getName());
	
	private static int flowerCounter = 0;
	
	private int flowerID;			//create a unique flowerID
	private double locationX;		
	private double locationY;
	private int petalNumbers;
	private String color;
	
	Flower(double locationX, double locationY, String color, int petalNumbers){
		this.flowerID = flowerCounter++;
		setLocationX(locationX);
		setLocationY(locationY);
		setColor(color);
		setPetalNumbers(petalNumbers);
		addToHashMap(this);
		log.info("Constructing a Flower instance");
	}
	
	//getter and setter of flower color and petal numbers
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public int getPetalNumbers() {
		return petalNumbers;
	}
	public void setPetalNumbers(int petalNumbers) {
		this.petalNumbers = petalNumbers;
	}

	// getter and setter of location
	public double getLocationX() {
		return locationX;
	}
	public void setLocationX(double locationX) {
		this.locationX = locationX;
	}
	public double getLocationY() {
		return locationY;
	}
	public void setLocationY(double locationY) {
		this.locationY = locationY;
	}

	
	public int getFlowerID() {
		return flowerID;
	}
	
	//add flower instance to the hashMap
	public void addToHashMap(Flower flower) {
		flowerMap.put(flowerID, flower);
	}
		
	public HashMap<Integer, Flower> getFlowerMap() {
		return flowerMap;
	}

	//traverse and print the hashMap 
	public String traverseHashMap(FlowerPlant flowerPlant){
		String str = "";
		for(Flower f : flowerMap.values()){
			if(f.color == flowerPlant.getColor())
				str = str + f.toString() + '\n';
		}
		return str + '\n';		
	}
	
	public String toString(){
		return String.format("%1$-16d %2$-16.2f %3$-16.2f %4$-16s %5$-16d",
				this.flowerID, this.locationX, this.locationY, this.color, this.petalNumbers);	
	}
}
