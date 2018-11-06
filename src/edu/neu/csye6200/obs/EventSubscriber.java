package edu.neu.csye6200.obs;

import java.util.Observable;
import java.util.Observer;

/**
 * @author steve
 *
 */
public class EventSubscriber implements Observer{

	@Override
	public void update(Observable src, Object msg) {
		System.out.println("ES received update from: " + src);
		System.out.println("				message: " + msg);
	}	
}
