/**
 * 
 */
package edu.neu.csye6200.serial;

import java.io.Serializable;

/**
 * @author Tianju Zhou
 *
 */
public class CarData implements Serializable, Comparable<CarData>{

	private int iValue = 0;
	private double dValue = 0.1;
	private double dValue2 = 0.2;
	private String name;

	// Constructor
	public CarData(int iValue, double dValue, double dValue2, String name) {
		this.iValue = iValue;
		this.dValue = dValue;
		this.dValue2 = dValue2;
		this.name = name;
	}

	/**
	 * @return the iValue
	 */
	public int getiValue() {
		return iValue;
	}

	/**
	 * @param iValue the iValue to set
	 */
	public void setiValue(int iValue) {
		this.iValue = iValue;
	}

	/**
	 * @return the dValue
	 */
	public double getdValue() {
		return dValue;
	}

	/**
	 * @param dValue the dValue to set
	 */
	public void setdValue(double dValue) {
		this.dValue = dValue;
	}

	/**
	 * @return the dValue2
	 */
	public double getdValue2() {
		return dValue2;
	}

	/**
	 * @param dValue2 the dValue2 to set
	 */
	public void setdValue2(double dValue2) {
		this.dValue2 = dValue2;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	@Override
	public int compareTo(CarData cd) {		
		return cd.getName().compareTo(name);
	}

}
