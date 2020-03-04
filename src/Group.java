import java.util.ArrayList;

public class Group {

	String groupName;
	ArrayList<Roles> groupRoles = new ArrayList<Roles>();
	Schedule freeSch = new Schedule();

	public Group(String gName) {
		defaultRoles();
		groupName = gName;
		
	}
	
	public void defaultRoles() {
		groupRoles.add(new Roles("Leader","is the leader"));
		groupRoles.add(new Roles("Organizer","is the organizer"));
		groupRoles.add(new Roles("Finisher","is the finisher"));
		groupRoles.add(new Roles("Implementer","is the implementer"));
		groupRoles.add(new Roles("Team Member","is placeholder till person is moved to spesific role"));
	}
	
	//in-case of group name change
	public void setGroupName(String gName) {
		groupName = gName;
	}
	
	//getters for all to display data
	public String getGroupName() {
		return groupName;
	}
	
	public ArrayList<Roles> getGroupRoles(){
		return new ArrayList<Roles>(groupRoles);
	}
	
	public Schedule getFreeSch() {
		return new Schedule(freeSch);
	}
	
	//add another non-default role
	public void addRole(Roles nRole) {
		groupRoles.add(nRole);
	}
	
	public int indexOfRole(String rName) {
		int index = 0;
		for (int i = 0; i < groupRoles.size(); i++) {
			if (groupRoles.get(i).getRoleName().equals(rName)) {
				index = i;
			}
		}
		return index;
		
	}
	
	public void removeRole(String rName) {
		groupRoles.remove(indexOfRole(rName));
	}
	
	public boolean checkDayExist(int[] time) {
		ArrayList<int[]> groupAvailability = new ArrayList<int[]>(freeSch.getTimes());
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
		ArrayList<int[]> groupAvailability = new ArrayList<int[]>(freeSch.getTimes());
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
		freeSch.setTimes(groupAvailability);
	}
	
	//outputs the sync'ed schedule
	public void setAvailability() {
		for (Roles role: groupRoles) {
			for (Person member: role.getTeam()) {
				checkAvailability(member.getSchedule().getTimes());
			}
		}
	}
	
	//moves members from unspesificed to their role teams
	public void addRoleMember(Person member, String rName) {
		groupRoles.get(indexOfRole(rName)).addPerson(member);
	}
	public void rmRoleMember(Person member, String rName) {
		groupRoles.get(indexOfRole(rName)).removeMember(member);
	}
}