package edu.neu.csye6200.inheritTest;

/**
 * @author Tianju Zhou
 */
public class AltPowerMeasure extends PowerMeasure {

	public AltPowerMeasure(){
		System.out.println("AltPowerMeasure constructor called");
	}
	
	
	//U = IR
	@Override
	public double getResistivity(){
		return super.getResistivity() * 2;
		//return (voltage / current) * 2;
	}
}