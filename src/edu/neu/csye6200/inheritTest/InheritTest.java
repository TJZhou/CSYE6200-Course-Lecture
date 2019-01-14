package edu.neu.csye6200.inheritTest;

/**
 * @author Tianju Zhou
 */
public class InheritTest {
	
	public InheritTest(){
		
	}
	
	public void run(){
		PowerMeasure pm0 = new PowerMeasure();
		System.out.println("PowerMeasure resistivity:" + pm0.getResistivity());
		
		PowerMeasure apm0 = new AltPowerMeasure();
		System.out.println("AltPowerMeasure resistivity:" + apm0.getResistivity());
	
		displayMeasure(apm0);	// it is-a MeterI
		
		//static call to create an instance of MeterManger
		MeterManager meterMgr = MeterManager.instance();
		meterMgr.add(pm0);
		meterMgr.add(apm0);
		meterMgr.displayMeters();
		
		MeterManager meterMgr2 = MeterManager.instance();
		meterMgr2.displayMeters();
	}
	
	public void displayMeasure(PowerMeasure meter){
		System.out.println("Measure isc" + meter.measure());
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		InheritTest iTest = new InheritTest();
		iTest.run();
	}
}
