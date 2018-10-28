package edu.neu.csye6200.inheritTest;

/**
 * @author Tianju ZHou
 */
public class PowerMeasure extends MeterA implements MeterI{

	protected double current = 1.0;	//1 Ampere
	protected double voltage = 12.0; //12 volts
	
	//constructor
	public PowerMeasure(){
		System.out.println("PowerMeasure constuctor called");
	}
		
	//U = IR
	public double getResistivity(){
		return voltage / current;
	}

	// From INterface (MeterI)
	@Override
	public double measure() {
		return voltage * current;
	}

	//From Abstract class (MeterA)
	@Override
	public double calcProbeMeasure() {
		return 0;
	}
}
