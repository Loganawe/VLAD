import java.util.ArrayList;

public class Group {

	//Instance Variables
	ArrayList<Person> memberList = new ArrayList<Person>();
	Schedule freeSchedule;
	String groupName;
	
	//Constructors
	public Group(String gName, ArrayList<Person> members, Schedule freeSch) {
		groupName = gName;
		memberList = members;
		freeSchedule = freeSch;
	}
	
	public Group(String gName, ArrayList<Person> members) {
		groupName = gName;
		memberList = members;
	}
	
	public Group(String gName) {
		groupName = gName;
	}

	//Methods
	public void setMembers(ArrayList<Person> members) {
		memberList = members;
	}
	
	public void addMember(Person member) {
		memberList.add(member);
	}
	
	public int getNumberOfMembers() {
		return memberList.size();
	}
	
	public String getName() {
		return groupName;
	}
	
	public Schedule getFreeSchedule() {
		return freeSchedule;
	}
}

	
/*
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
	for (Person person: members) {
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
		for (Person person: members) {
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
*/
