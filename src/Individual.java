import java.util.ArrayList;
import java.util.Scanner;

public class Individual {

	private String memberName;
	ArrayList<int[]> unavailableList = new ArrayList<int[]>();
	
	public Individual() {
		//empty constructor
	}
	
	public Individual(String name) {
		memberName = name;
	}
	
	public Individual(ArrayList<int[]> availability) {
		unavailableList = availability;
	}
	
	public Individual(String name, ArrayList<int[]> availability) {
		memberName = name;
		unavailableList = availability;
	}
	
	public void setAddBadDate(int[] busyAt) {
		unavailableList.add(busyAt);
	}
	
	public void setName(String name) {
		memberName = name;
	}
	
	public void setAvailability(ArrayList<int[]> availability) {
		unavailableList = availability;
	}
	
	public String getName() {
		return memberName;
	}
	
	public ArrayList<int[]> getUnavailability() {
		return new ArrayList<int[]>(unavailableList);
	}
	
	public void setAvailability(int day, int startTime, int endTime) {
		int[] busyAt = {day, startTime, endTime};
		unavailableList.add(busyAt);
	}

	
	public String toString() {
		String availability = "";
		String returnStatment = "";
		for (int[] busyAt: unavailableList) {
			if (busyAt[0] == 1) {
				availability += "Sunday from " + busyAt[1] + " - " + busyAt[2] + ", ";
			}
			if (busyAt[0] == 2) {
				availability += "Monday from " + busyAt[1] + " - " + busyAt[2] + ", ";
			}
			if (busyAt[0] == 3) {
				availability += "Tuesday from " + busyAt[1] + " - " + busyAt[2] + ", ";
			}
			if (busyAt[0] == 4) {
				availability += "Wednesday from " + busyAt[1] + " - " + busyAt[2] + ", ";
			}
			if (busyAt[0] == 5) {
				availability += "Thursday from " + busyAt[1] + " - " + busyAt[2] + ", ";
			}
			if (busyAt[0] == 6) {
				availability += "Friday from " + busyAt[1] + " - " + busyAt[2] + ", ";
			}
			if (busyAt[0] == 7) {
				availability += "Saturday from " + busyAt[1] + " - " + busyAt[2] + ", ";
			}
		}
		returnStatment = memberName + " is unavailable on " + availability + "please plan around this.";
		return returnStatment;
	}
	
	public Individual setIndividual()  {
		ArrayList<int[]> availability = new ArrayList<int[]>();
		
		
		Scanner input = new Scanner(System.in);
		
		System.out.print("Enter your name: ");
		String name = input.nextLine();
		
		String quit = "askljgklas";
		while (!(quit.isEmpty())) {
			System.out.print("What day are you unavailable? (enter nothing to quit): ");
			String value = input.nextLine();
			quit = value;
			if (quit.isEmpty()) {
				System.out.println(" ");
				// do nothing
			}
			else {
				int day = Integer.parseInt(value);
				
				System.out.print("Starting at what time?: ");
				value = input.nextLine();
				int start = Integer.parseInt(value);
				
				System.out.print("Ending when?: ");
				value = input.nextLine();
				int end = Integer.parseInt(value);
				
				System.out.println(" ");
				
				int[] busyAt = {day, start, end};
				availability.add(busyAt);
			}
			
		}
		
		Individual person = new Individual(name, availability);
		
		
		
		return person;
	}

}
