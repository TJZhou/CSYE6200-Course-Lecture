package Vehicle;

/**
 * @author Tianju Zhou
 *
 */
public class Vehicle {

	private int passengers; // number of passengers
	private int fuelCap; // Liters of fuel
	private double kpl; // killometers per litter

	// constructor
	public Vehicle() {
		passengers = 2;
		fuelCap = 10;
		kpl = 20;
	}

	public Vehicle(int passengers, int fuelCap, double kpl) {
		setPassengers(passengers);
		setFuelCap(fuelCap);
		setKpl(kpl);
	}

	// getter for passengers
	public int getPassengers() {
		return passengers;
	}

	// setter for passengers
	public void setPassengers(int passengers) {
		if (passengers < 0)
			passengers = 0;
		this.passengers = passengers;
	}

	public int getFuelCap() {
		return fuelCap;
	}

	public void setFuelCap(int fuelCap) {
		this.fuelCap = fuelCap;
	}

	public double getKpl() {
		return kpl;
	}

	public void setKpl(double kpl) {
		this.kpl = kpl;
	}

	public double calcRange() {
		double range = fuelCap * kpl;
		return range;
	}

	public String toString() {
		return "\n[passengers=" + passengers + "]\n[fuelCap="+fuelCap+"]\n[kpl="+kpl+"]\n";
	}
	
	//-----------use of String.format-------------------
	public String formattedToString(){
		String type = "Volvo";
		String str = String.format("Vehicle %1$5s %2$10d %3$5.2f", type,passengers,kpl);
		return str;
	}
	
}
