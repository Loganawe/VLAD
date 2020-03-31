package notui;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

// TODO: Auto-generated Javadoc
/**
 * The Class Attribute.
 */
public class Attribute {
	
	/** The scores. */
	private Map<String, Integer> scores = new HashMap<String, Integer>();
	
	/**
	 * Instantiates a new attribute.
	 *
	 * @param Creates the list of attributes a group will have
	 */
	public Attribute(Group group) {
		
		for(Roles role: group.getGroupRoles()){
			scores.put(role.getRoleName(), 0);
		}
		
	}
	
	/**
	 * Instantiates a new attribute.
	 *
	 * @param  copy construct for attribute
	 */
	public Attribute(Attribute attribute) {
		this.scores = attribute.scores;
	}
	
	/**
	 * Gets the scores.
	 *
	 * @return returns all the scores for a groups attributes
	 */
	public Map<String, Integer> getScores(){
		return scores;
		
	}
	
	/**
	 * Gets the score.
	 *
	 * @param rolename of what you want to get the score of
	 * @return the spesific score of that role name
	 */
	public int getScore(String rolename) {
		
		return scores.get(rolename);
		
	}
	
	/**
	 * Sets the score.
	 *
	 * @param rolename of what you want to set
	 * @param score of that rolename
	 */
	public void setScore(String rolename, int score) {
		
		scores.remove(rolename);
		scores.put(rolename, score);
		
	}

	
	/**
	 * Take test.
	 *
	 * @param name of the person
	 * @param name of the group
	 * @param person the person
	 */
	public void takeTest(String name, Group group, Person person)
	{
		Scanner input = new Scanner(System.in);
		

		for(Roles rolename:group.getGroupRoles())
		{
			if(rolename.getRoleName() != "Team Member")
			{
				System.out.println("How much do you want to be a " + rolename + "(Out of 5)");
				int answer = input.nextInt();	
				
				if (answer <= 5)
					{
						setScore(rolename.getRoleName(), answer + getScore(rolename.getRoleName()));
					}
				if (getScore(rolename.getRoleName()) >=5)
				{
					group.addRoleMember(person, rolename.getRoleName());
				}
			}
		}
	}
	
}
