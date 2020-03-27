package notui;

import java.util.ArrayList;

public class Schedule {

	//Index of the Arraylist is the day and then int array is the times
	ArrayList<int[]> busyTimes = new ArrayList<int[]>();
	
	public Schedule() {
		
	}
	
	
	public Schedule(Schedule aSchedule) {
		
	}
	//dont need to add this one yet, we havnt looked at the libary
	public void addBusyAuto() {
		
	}
	
	//console input currently for the ArrayList<int[]>
	public void addBusyManual(int[] busytime) {
		busyTimes.add(busytime);
	}
	
	//in-case of manual mistake
	public void removeBusy() {
		
	}
	
	public ArrayList<int[]> getTimes() {
		return new ArrayList<int[]>(busyTimes);
	}
	
	public void setTimes(ArrayList<int[]> times) {
		busyTimes = new ArrayList<int[]>(times);
	}
	
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