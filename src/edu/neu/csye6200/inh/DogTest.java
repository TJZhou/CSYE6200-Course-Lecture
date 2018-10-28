/**
 * 
 */
package edu.neu.csye6200.inh;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * @author Tianju Zhou
 *
 */
public class DogTest {

	private Dog simpleDog1;
	private Dog simpleDog2;
	private Collie simpleCollie;

	private ArrayList<Dog> dogList; // An ArrayList
	private HashMap<String, Dog> dogMap; // A HashMap class

	// constructor
	public DogTest() {
		// double airTemp = Dog.temperatue;

		dogList = new ArrayList<Dog>(); // create an ArrayList instance
		dogMap = new HashMap<String, Dog>(); // create a HashMap instance

		simpleDog1 = new Dog("Fido", 10.0, 4);
		simpleDog2 = new Dog("Twos", "10.0");
		simpleCollie = new Collie("Tramp", 12.0, 4);

	}

	// A run method
	private void run() {
		System.out.println("My simple dog:" + simpleDog1.getName());
		simpleDog1.bark();
		System.out.println("Simple dog ID is" + simpleDog1.getId());

		System.out.println("My simple dog:" + simpleDog2.getName());
		simpleDog2.bark();
		System.out.println("Simple dog ID is" + simpleDog2.getId());

		System.out.println("My simple dog:" + simpleCollie.getName());
		simpleCollie.bark();
		simpleCollie.wagTail();
		System.out.println("Simple dog ID is" + simpleCollie.getId());

		// Add to the list
		dogList.add(simpleDog1);
		dogList.add(simpleDog2);
		dogList.add(simpleCollie);

		for (Dog dg : dogList) {
			System.out.println("before: " + dg);
		}

		dogMap.put(simpleDog1.getName(), simpleDog1);
		dogMap.put(simpleDog2.getName(), simpleDog2);
		dogMap.put(simpleCollie.getName(), simpleCollie);

		dogList.remove(1);

		for (Dog dg : dogList) {
			System.out.println("after : " + dg);
		}

		for (Dog dg2 : dogMap.values()) {
			System.out.println("Map:" + dg2);
		}
		
		Dog bulletDog = dogMap.get("Twos");
		System.out.println("My dog is " + bulletDog);
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		DogTest dt = new DogTest();
		dt.run();
	}

}
