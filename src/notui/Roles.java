package notui;

import java.util.ArrayList;

public class Roles {

	private String roleName;
	private ArrayList<Person> team = new ArrayList<Person>();
	private String desc;

	public Roles(String roleName, String desc) {
		this.roleName = roleName;
		this.desc = desc;
	}

	//setters to use in use in contructor in class group
	public void setRoleName(String roleName){
		this.roleName = roleName;
	}
	
	public void setDesc(String desc) {
		this.desc = desc;
	}
	
	//getter for data display
	public String getRoleName() {
		return roleName;
	}
	
	public ArrayList<Person> getTeam(){
		return new ArrayList<Person>(team);
	}
	
	public String getDesc() {
		return desc;
	}
	
	public void addPerson(Person person) {
		team.add(person);
	}
	
	public void removeMember(Person member) {
		team.remove(team.indexOf(member));
	}
	
	public int getTeamSize() {
		return team.size();
	}





}