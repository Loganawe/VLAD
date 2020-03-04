import java.util.ArrayList;

public class Schedule {

	//Index of the Arraylist is the day and then int array is the times
	ArrayList<int[]> busyTimes = new ArrayList<int[]>();
	
	//dont need to add this one yet, we havnt looked at the libary
	public void addBusyAuto() {
		
	}
	
	//console input currently for the ArrayList<int[]>
	public void addBusyManual() {
		
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
		
	}
}
