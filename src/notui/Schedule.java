package notui;

import java.util.ArrayList;

// TODO: Auto-generated Javadoc
/**
 * The Class Schedule.
 */
public class Schedule {

	/** The busy times. */
	//Index of the Arraylist is the day and then int array is the times
	ArrayList<int[]> busyTimes = new ArrayList<int[]>();
	
	/**
	 * Instantiates a new schedule.
	 */
	public Schedule() {
		
	}
	
	
	/**
	 * Instantiates a new schedule from a copy
	 *
	 * @param aSchedule the a schedule
	 */
	public Schedule(Schedule aSchedule) {
		
	}
	
	/**
	 * Adds the busy auto.
	 */
	//dont need to add this one yet, we havnt looked at the libary
	public void addBusyAuto() {
		
	}
	
	/**
	 * Adds the busy manual.
	 *
	 * @param busytime the busytime
	 */
	//console input currently for the ArrayList<int[]>
	public void addBusyManual(int[] busytime) {
		busyTimes.add(busytime);
	}
	
	/**
	 * Removes the busy.
	 */
	//in-case of manual mistake
	public void removeBusy() {
		
	}
	
	/**
	 * Gets the times.
	 *
	 * @return the times
	 */
	public ArrayList<int[]> getTimes() {
		return new ArrayList<int[]>(busyTimes);
	}
	
	/**
	 * Sets the times.
	 *
	 * @param times the new times
	 */
	public void setTimes(ArrayList<int[]> times) {
		busyTimes = new ArrayList<int[]>(times);
	}
	
	/**
	 * To string.
	 *
	 * @return the string
	 */
	//for console use of program
	public String toString() {
		
		String availability = "";
		
		for (int[] busyAt: busyTimes) {
			if (busyTimes.indexOf(busyAt) == busyTimes.size() - 1 && busyTimes.size() > 1) {
				availability += "and ";
			}
			if (busyAt[0] == 1) {
				availability += "Sunday from " + busyAt[1] + " - " + busyAt[2] + ", ";
			}
			else if (busyAt[0] == 2) {
				availability += "Monday from " + busyAt[1] + " - " + busyAt[2] + ", ";
			}
			else if (busyAt[0] == 3) {
				availability += "Tuesday from " + busyAt[1] + " - " + busyAt[2] + ", ";
			}
			else if (busyAt[0] == 4) {
				availability += "Wednesday from " + busyAt[1] + " - " + busyAt[2] + ", ";
			}
			else if (busyAt[0] == 5) {
				availability += "Thursday from " + busyAt[1] + " - " + busyAt[2] + ", ";
			}
			else if (busyAt[0] == 6) {
				availability += "Friday from " + busyAt[1] + " - " + busyAt[2] + ", ";
			}
			else if (busyAt[0] == 7) {
				availability += "Saturday from " + busyAt[1] + " - " + busyAt[2] + ", ";
			}
		}
		return availability;
	}
}