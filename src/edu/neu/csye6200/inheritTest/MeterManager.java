package edu.neu.csye6200.inheritTest;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.logging.Logger;

import edu.neu.csye6200.bg.BGStem;
import edu.neu.csye6200.sim.Flower;

/**
 * @author Tianju Zhou
 *	example of the singleton pattern
 */
public class MeterManager {

	private static Logger log = Logger.getLogger(MeterManager.class.getName());
	
	private static MeterManager instance = null; // the single copy
	private ArrayList<MeterI> meterList = new ArrayList<MeterI>();

	
	private MeterManager(){	// can't be built externally to class
		log.info("Constructing a MeterManager instance");
	}
	
	public static MeterManager instance(){
		if(instance == null)
			instance = new MeterManager(); //build if needed
		return (instance);	//return the single copy
	}
	
	public void add(MeterI meter){
		meterList.add(meter);
		log.warning("Added a meter ");
	}
	
	public void displayMeters(){
		for(MeterI meter : meterList){
			String fTxt = String.format("Measure: %1$8f %2$8f", meter.measure(), meter.getResistivity());
			System.out.println(fTxt);
		}
	}
}
