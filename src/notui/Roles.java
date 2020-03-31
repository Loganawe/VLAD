package notui;

import java.util.ArrayList;

// TODO: Auto-generated Javadoc
/**
 * The Class Roles.
 */
public class Roles {

	/** The role name. */
	private String roleName;
	
	/** The team. */
	private ArrayList<Person> team = new ArrayList<Person>();
	
	/** The desc. */
	private String desc;

	/**
	 * Instantiates a new roles.
	 *
	 * @param roleName the role name
	 * @param desc the description
	 */
	public Roles(String roleName, String desc) {
		this.roleName = roleName;
		this.desc = desc;
	}

	/**
	 * Sets the role name.
	 *
	 * @param roleName the new role name
	 */
	//setters to use in use in contructor in class group
	public void setRoleName(String roleName){
		this.roleName = roleName;
	}
	
	/**
	 * Sets the desc.
	 *
	 * @param desc the new description
	 */
	public void setDesc(String desc) {
		this.desc = desc;
	}
	
	/**
	 * Gets the role name.
	 *
	 * @return the role name
	 */
	//getter for data display
	public String getRoleName() {
		return roleName;
	}
	
	/**
	 * Gets the team.
	 *
	 * @return the team
	 */
	public ArrayList<Person> getTeam(){
		return team;
	}
	
	/**
	 * Gets the desc.
	 *
	 * @return the description
	 */
	public String getDesc() {
		return desc;
	}
	
	/**
	 * Adds the person.
	 *
	 * @param person the person
	 */
	public void addPerson(Person person) {
		team.add(person);
	}
	
	/**
	 * Removes the member.
	 *
	 * @param member the member being removed
	 */
	public void removeMember(Person member) {
		team.remove(team.indexOf(member));
	}
	
	/**
	 * Gets the team size.
	 *
	 * @return the team size
	 */
	public int getTeamSize() {
		return team.size();
	}

	/**
	 * To string.
	 *
	 * @return the string
	 */
	public String toString() {
		return getRoleName();
	}
}