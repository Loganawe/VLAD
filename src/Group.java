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
	
	public boolean checkDayExist(int[] time) {
		ArrayList<Integer> whichDays = new ArrayList<Integer>();
		for (int[] index: groupAvailability) {
			if (time[0] == index[0]) {
				whichDays.add(time[0]);
			}
		}
		if (whichDays.size() >= 1) {
			return true;
		}
		else {
			return false;
		}
	}
	
	public void checkAvailability(ArrayList<int[]> times) {
		int numbersOfTimes = times.size();
		for (int i = 0; i < numbersOfTimes; i++) {
			if (groupAvailability.contains(times.get(i))) {
				// do nothing
				//System.out.println("Same already exists");
			}
			else if (checkDayExist(times.get(i))) {
				
				int secondNumberOftimes = groupAvailability.size();
				for (int index = 0; index < secondNumberOftimes; index++) {
					
					if (times.get(i)[0] == groupAvailability.get(index)[0]) {
						if (times.get(i)[1] <= groupAvailability.get(index)[1] && times.get(i)[2] >= groupAvailability.get(index)[2] ) {
							groupAvailability.get(index)[1] = times.get(i)[1];
							groupAvailability.get(index)[2] = times.get(i)[2];
							//System.out.println("bigger than old");
						}
						else if (times.get(i)[1] >= groupAvailability.get(index)[1] && times.get(i)[2] <= groupAvailability.get(index)[2] ) {
							// do nothing
							//System.out.println("smaller than old");
						}
						else if (times.get(i)[1] < groupAvailability.get(index)[1] && times.get(i)[2] >= groupAvailability.get(index)[1] ) {
							groupAvailability.get(index)[1] = times.get(i)[1];
							//System.out.println("starts before, but is during");
						}
						else if (times.get(i)[1] <= groupAvailability.get(index)[2] && times.get(i)[2] > groupAvailability.get(index)[2] ) {
							groupAvailability.get(index)[2] = times.get(i)[2];
							//System.out.println("ends after, but is during");
						}
						else if (times.get(i)[2] < groupAvailability.get(index)[1] || times.get(i)[1] > groupAvailability.get(index)[2] ) {
							groupAvailability.add(times.get(i));
							//System.out.println("Same day, but not same or overlapping times");
						}
					}

				}
				
			}
			else {
				groupAvailability.add(times.get(i));
				//System.out.println("Day doesn't exist");
			}
			
		
		
		}
	}
	
	public void setAvailability() {
		groupAvailability.add(members.get(0).getUnavailability().get(0));
		for (Individual person: members) {
			checkAvailability(person.getUnavailability());
		}
	}
	
	public String toString() {
		String availability = "";
		String groupMemberNames = "";
		String returnStatment = "";
		for (int[] busyAt: groupAvailability) {
			if (groupAvailability.indexOf(busyAt) == groupAvailability.size() - 1 && groupAvailability.size() > 1) {
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
		
		if (members.size() == 1) {
			groupMemberNames += members.get(0).getName();
		}
		else if (members.size() == 2) {
			groupMemberNames += members.get(0).getName() + " and " + members.get(1).getName();
		}
		else {
			for (Individual person: members) {
				if (members.indexOf(person) == members.size() - 1) {
					groupMemberNames += "and " + person.getName();
				}
				else {
					groupMemberNames += person.getName() + ", ";
				}
			}
		}
		
		returnStatment = groupName + ", which is composed of member(s) " + groupMemberNames + " is unavailable on " + availability + "please plan around this.";
		return returnStatment;
	}
	
	public static void main(String[] args) {
		ArrayList<Individual> people = new ArrayList<Individual>();
		
		Scanner ginput = new Scanner(System.in);
		
		System.out.println("############################################################################");
		System.out.println("1. Enter your group and member names normally");
		System.out.println("2. Days are in the form of integers from 1-7 (i.e. 1 = Sunday, 7 = Saturday)");
		System.out.println("3. Enter your times in 24 hour format (i.e. 2:30 pm = 1430)");
		System.out.println("############################################################################");
		System.out.println(" ");
		System.out.println(" ");
		
		System.out.print("Enter your group name: ");
		String name = ginput.nextLine();
		
		
		String quit = "fdhasdh";
		while (!(quit.isEmpty())) {
			System.out.println(" ");
			System.out.print("Would you like to add a group member? (enter 'yes', or nothing to quit): ");
			quit = ginput.nextLine();
			
			if (quit.equals("yes")) {
				Individual newMember = new Individual();
				people.add(newMember.setIndividual());
			}
			else if (!(quit.equals("yes")) && !(quit.isEmpty())) {
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
			String outputText = newGroup.toString();
			String boarderText = "";
			int textLength = outputText.length();
			for (int i = 0; i < textLength; i++) {
				boarderText += "#";
			}
			System.out.println(" ");
			System.out.println(boarderText);
			System.out.println(outputText);
			System.out.println(boarderText);
		}
	}



}
