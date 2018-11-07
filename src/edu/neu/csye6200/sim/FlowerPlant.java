package edu.neu.csye6200.sim;

import java.util.logging.Logger;

import edu.neu.csye6200.bg.BGStem;

/**
 * @author Tianju Zhou NUID 001420546
 */
public class FlowerPlant extends Plant {
	private static Logger log = Logger.getLogger(FlowerPlant.class.getName());

	private String color;
	private int petalNumber;
	private Flower flower;
	private int flowerNumbers;
	
	// inherit from the parent class Plant
	FlowerPlant(String plantName, String color, double length, int petals) {
		super(plantName, length);
		setColor(color);
		setPetals(petals);
		this.flowerNumbers = 0;
		log.info("Constructing a FlowerPlant instance");
	}

	// getter and setter of color
	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	// getter and setter of flower numbers
	public int getFlowerNumbers() {
		return this.flowerNumbers;
	}

	public void setFlowerNumbers(int flowerNumbers) {
		this.flowerNumbers = flowerNumbers;
	}

	//getter and setter of the numbers of petals
	public int getPetals() {
		return this.petalNumber;
	}
	public void setPetals(int petals) {
		this.petalNumber = petals;
	}

	public Flower getFlower() {
		return flower;
	}
	
	//override the plantGrowth method from the father class
	@Override
	public void plantGrowth(int age){		
		super.plantGrowth(age);
		
		for(int i = (int) (this.getBaseStem().getStemID() + Math.pow(2, age - 1)); i < this.getBaseStem().getStemID() + Math.pow(2, age); i++){
			flower = new Flower(BGStem.getStemMap().get(i).getLocationX(), BGStem.getStemMap().get(i).getLocationY(), this.color, this.petalNumber);
			this.flowerNumbers++;
			setFlowerNumbers(this.flowerNumbers);
		}	
	}
	
	// print every petal
	@Override
	public String printChildStem() {
		
		String str = super.printChildStem();
		str = str + "The total number of stems is:" + getFlowerNumbers() + '\n';
		str = str + String.format("%1$-16s %2$-16s %3$-16s %4$-16s %5$-16s", "flowerID", "locationX", "locationY", "color", "petalNumbers") + '\n';
		/*System.out.println("The total number of stems is:" + getFlowerNumbers());
		System.out.println(
				String.format("%1$-16s %2$-16s %3$-16s %4$-16s %5$-16s", "flowerID", "locationX", "locationY", "color", "petalNumbers"));*/
		return str + flower.traverseHashMap(this);
	}

	@Override
	public String toString() {
		return String.format("%1$-16d %2$-16s %3$-16d %4$-16.2f %5$-16.2f %6$-16s %7$-16d", super.getSpecimenID(), super.getPlantName(),
				super.getAge(), super.getLength(),super.getWidth(), getColor(), getPetals());
	}
}
