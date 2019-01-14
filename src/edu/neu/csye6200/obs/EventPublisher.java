package edu.neu.csye6200.obs;

import java.util.Observable;

/**
 * @author steve
 *
 */
public class EventPublisher extends Observable{

	private boolean done = false;	//set true to stop the run method
	private int ctr = 0;	//count how many times we loop around
	
	//constructor
	EventPublisher(){
		System.out.println("EventPublisher - we are here");
	}
	
	//An event has occurred, so notify the subscribers
	public void doAction() {
		setChanged();	//Indicate that a change has happened
		notifyObservers(new String("A message" + ctr));
	}
	
	//Do a lot of message
	public void run() {
		while(!done) {
			doAction();
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if(++ctr > 10)
				done = true;
		}
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		EventPublisher ep = new EventPublisher();	//we have a publisher
		new Thread() {
			public void run() {
				EventSubscriber sub1 = new EventSubscriber();	//we have a subscriber
				ep.addObserver(sub1);
			}
		}.start();
		
		new Thread() {
			public void run() {
				EventSubscriber sub2 = new EventSubscriber();	//we have a subscriber
				ep.addObserver(sub2);
			}
		}.start();
		ep.run();
	}
}
