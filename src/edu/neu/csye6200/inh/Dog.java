/**
 * 
 */
package edu.neu.csye6200.inh;

/**
 * @author Tianju Zhou
 *
 */
public class Dog {

	static private int idCounter = 1;
	static public double temperatue = 39.0;
	private int id;
	private int legs;
	private double speed;
	private String name = " ";

	public Dog(String name, double speed, int legs) {
		this.name = name;
		this.speed = speed;
		this.legs = legs;
		this.id = idCounter++;	//Create a unique ID
	}
	
	public Dog(String name, String speed) {
		this.name = name;
		this.speed = Double.valueOf(speed);	//a static metond call
		this.legs = 4;
		this.id = idCounter++;	//Create a unique ID
	}
	
	public void bark(){
		System.out.println("Bark");
	}	

	public int getLegs() {
		return legs;
	}
	public void setLegs(int legs) {
		if(legs < 0)
			legs = 0;
		this.legs = legs;
	}

	public double getSpeed() {
		return speed;
	}

	public void setSpeed(double speed) {
		this.speed = speed;
	}

	public String getName(){
		return this.name;
	}
	
	public void setName(String name) {
		this.name = name;
	}

	public int getId() {
		return id;
	}
	
	public String toString(){
		return String.format("Dog: %1$12s %2$5.2f %3$1d", getName(), getSpeed(), getLegs());
	}
}
