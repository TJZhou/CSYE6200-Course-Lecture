package edu.neu.csye6200.enumT;

/**
 * @author steve
 *
 */
public class EnumTest {

	enum WeekDay { 
		SUNDAY, MONDAY(10), TUESDAY(20), WEDNESDAY(30), THURSDAY(40), FRIDAY(50), SATURDAY(60);
	
		private int value;
		WeekDay(){
			
		}
		// constructor
		WeekDay(int n) {
			value = n;
		}
		public void setValue(int value) {
			this.value = value;
		}
		public int getValue() {
			return value;
		}
	};
	
	private WeekDay currDay = WeekDay.TUESDAY;
	
	//constructor
	public EnumTest() {
		
		
		System.out.println("Current day is " + currDay + " ordinal value " + currDay.ordinal());
		
		WeekDay days[] = WeekDay.values();
		for(WeekDay d : days) {
			System.out.println("Day: " + d.name() + " ordinal " + d.ordinal() + " value " + d.getValue());
		}
		
		setCurrDay(WeekDay.valueOf("MONDAY"));
		setCurrDay(WeekDay.FRIDAY);
	}
	
	
	/**
	 * @return the currDay
	 */
	public WeekDay getCurrDay() {
		return currDay;
	}


	/**
	 * @param currDay the currDay to set
	 */
	public void setCurrDay(WeekDay currDay) {
		this.currDay = currDay;
		System.out.println("Current day is " + currDay + " ordinal value " + currDay.ordinal());
	}


	/**
	 * @param args
	 */
	public static void main(String[] args) {
		EnumTest et = new EnumTest();		
	}
}
