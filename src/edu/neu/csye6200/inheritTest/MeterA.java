package edu.neu.csye6200.inheritTest;

/**
 * @author Tianju ZHou
 *
 */
public abstract class MeterA {

	private double probeVal = 12.3;

	
	public double getProbeVal() {
		return probeVal;
	}
	public void setProbeVal(double probeVal) {
		this.probeVal = probeVal;
	}
	
	public abstract double calcProbeMeasure();
}
