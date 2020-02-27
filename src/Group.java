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