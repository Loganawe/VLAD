import java.util.ArrayList;

public class Group {

	String groupname;
	ArrayList<Roles> group = new ArrayList<Roles>();
	Schedule freesch = new Schedule();

	public Group(String gname) {
		groupname = gname;
		
		//default roles of a group
		group.add(new Roles("Leader","is the leader"));
		group.add(new Roles("Organizer","is the organizer"));
		group.add(new Roles("Finisher","is the finisher"));
		group.add(new Roles("Implementer","is the implementer"));
		group.add(new Roles("Team Member","is placeholder till person is moved to spesific role"));
	}
	
	//in-case of group name change
	public void setGroupName() {
		
	}
	
	//getters for all to display data
	public String getGroupName() {
		
	}
	
	public ArrayList<Roles> getGroup(){
		
	}
	
	public Schedule getFreeSch() {
		
	}
	
	//add another non-default role
	public void addRole() {
		
	}
	
	public int groupSize() {
		
	}
	
	//outputs the sync'ed schedule
	public Schedule sync() {
		
	}
	
	//moves members from unspesificed to their role teams
	public void deligate() {
		
	}
}