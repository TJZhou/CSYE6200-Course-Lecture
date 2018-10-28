package Vehicle;

/**
 * @author TianjuZhou
 *
 */
public class VehicleTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		Vehicle ve1 = new Vehicle();	//make a vehicle instance

		ve1.setPassengers(4);

		System.out.println("ve1 passenger is:" + ve1.getPassengers());
		
		Vehicle ve2 = new Vehicle();	//make a second vehicle instance
		
		ve1=ve2;
		
		System.out.println("ve1 passenger is:" + ve1.getPassengers());
		
		Vehicle ve3 = new Vehicle(5,30,20);	//make a third vehicle instance
		
		System.out.println("ve3 passenger is:" + ve3.getPassengers());
		
		System.out.println("Vehicel instance ve3 is: "+ve3.formattedToString());
		
		//same as the [ve3.toString()]
		
	}
}
