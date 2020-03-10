package notui;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Attribute {
	
	private Map<String, Integer> scores = new HashMap<String, Integer>();
	
	public Attribute(Group group) {
		
		for(Roles role: group.getGroupRoles()){
			scores.put(role.getRoleName(), 0);
		}
		
	}
	
	public Attribute(Attribute attribute) {
		this.scores = attribute.scores;
	}
	
	public Map<String, Integer> getScores(){
		return scores;
		
	}
	
	public int getScore(String rolename) {
		
		return scores.get(rolename);
		
	}
	
	public void setScore(String rolename, int score) {
		
		scores.remove(rolename);
		scores.put(rolename, score);
		
	}

	
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
