package edu.neu.csye6200.serial;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;

/**
 * @author Tianju Zhou
 *
 */
public class SerialTest {

	// serialize a cardata to a file
	public void streamOut(CarData cardata, String filename) {
		try {
			FileOutputStream fos = new FileOutputStream(filename);
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			oos.writeObject(cardata);
			oos.close();
			fos.close();

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public CarData streamIn(String filename) {
		CarData carData = null;

		try {
			FileInputStream fis = new FileInputStream(filename);
			ObjectInputStream ois = new ObjectInputStream(fis);
			carData = (CarData) ois.readObject();
			ois.close();
			fis.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return carData;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		SerialTest serTest = new SerialTest();

		CarData carData = new CarData(1, 1.0, 2.0, "Chevy");

		serTest.streamOut(carData, "src/edu/neu/csye6200/serial/chevy.data");
		
		CarData carData2 = serTest.streamIn("src/edu/neu/csye6200/serial/chevy.data");	
		System.out.println("CarData2 is " + carData2.getName());
		
		ArrayList<CarData> carList = new ArrayList<CarData>();	// a list for holding car data
		
		carList.add(new CarData(0, 1.0, 2.0, "Chevy"));
		carList.add(new CarData(1, 1.0, 2.0, "BMW"));
		carList.add(new CarData(2, 1.0, 2.0, "Land Rover"));
		carList.add(new CarData(3, 1.0, 2.0, "Audi"));
		carList.add(new CarData(5, 1.0, 2.0, "Mercedes"));
		carList.add(new CarData(6, 1.0, 2.0, "Ford"));	
		
		Collections.sort(carList);	//use collections packge to sort a list
	}
}
