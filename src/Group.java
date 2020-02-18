import java.util.ArrayList;
import java.util.Scanner;

public class Group {
	private String groupName;
	private ArrayList<Individual> members = new ArrayList<Individual>();
	private ArrayList<int[]> groupAvailability = new ArrayList<int[]>();
	
	public Group(String gName, ArrayList<Individual> memberList, ArrayList<int[]> gAvailability) {
		groupName = gName;
		members = memberList;
		groupAvailability = gAvailability;
	}
	
	public Group(String gName, ArrayList<Individual> memberList) {
		groupName = gName;
		members = memberList;
	}
	
	public Group(String gName) {
		groupName = gName;
	}
	
	public void setMembers(ArrayList<Individual> memberList) {
		members = memberList;
	}
	
	public void addMember(Individual member) {
		members.add(member);
	}
	
	public int getNumberOfMembers() {
		return members.size();
	}
	
	public String getName() {
		return groupName;
	}
	
	public ArrayList<int[]> getGroupUnavailability() {
		return new ArrayList<int[]>(groupAvailability);
	}
	
	public void checkAvailability(ArrayList<int[]> times) {
		int numbersOfTimes = times.size();
		for (int i = 0; i < numbersOfTimes; i++) {
			int secondNumberOfTimes = groupAvailability.size();
			for (int index = 0; index < secondNumberOfTimes; index++) {
				if (times.get(i)[0] == groupAvailability.get(index)[0]) {
					if ((int) times.get(i)[1] == (int) groupAvailability.get(index)[1] && (int) times.get(i)[2] == (int) groupAvailability.get(index)[2] ) {
						//do nothing
					}
					else if ((int) times.get(i)[1] < (int) groupAvailability.get(index)[1] && (int) times.get(i)[2] > (int) groupAvailability.get(index)[1] ) {
						groupAvailability.get(index)[1] = times.get(i)[1];
					}
					else if ((int) times.get(i)[1] < (int) groupAvailability.get(index)[2] && (int) times.get(i)[2] > (int) groupAvailability.get(index)[2] ) {
						groupAvailability.get(index)[2] = times.get(i)[2];
					}
					else {
						groupAvailability.add(times.get(i));

					}
				
				}
				else {
					groupAvailability.add(times.get(i));
				}
			
			}
		}
	}
	
	public void setAvailability() {
		for (int i = 0; i < members.get(0).getUnavailability().size(); i++) {
			groupAvailability.add(members.get(0).getUnavailability().get(i));
		}
		for (Individual person: members) {
			checkAvailability(person.getUnavailability());
		}
	}
	
	public String toString() {
		String availability = "";
		String returnStatment = "";
		for (int[] busyAt: groupAvailability) {
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
		returnStatment = groupName + " is unavailable on " + availability + "please plan around this.";
		return returnStatment;
	}
	
	public static void main(String[] args) {
		ArrayList<Individual> people = new ArrayList<Individual>();
		
		Scanner ginput = new Scanner(System.in);
		
		System.out.print("Enter your group name: ");
		String name = ginput.nextLine();
		
		
		String quit = "fdhasdh";
		while (!(quit.isEmpty())) {
			System.out.print("Would you like to add a group member? (enter 'yes', or nothing to quit): ");
			quit = ginput.nextLine();
			
			if (quit.equals("yes")) {
				Individual newMember = new Individual();
				people.add(newMember.setIndividual());
			}
			if (!(quit.equals("yes")) && !(quit.isEmpty())) {
				System.out.println("Please enter 'yes', or leave the field blank to exit");
				System.out.println(" ");
			}
		}
		ginput.close();
		
		Group newGroup = new Group(name);
		
		if (!(people.isEmpty())) {
			newGroup.setMembers(people);
			newGroup.setAvailability();
		}
		
		
		if (newGroup.getGroupUnavailability().size() >= 1) {
			System.out.println(newGroup.toString());
		}
	}



}
