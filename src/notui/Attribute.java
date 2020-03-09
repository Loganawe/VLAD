package notui;

import java.util.HashMap;
import java.util.Map;

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
		
	}
	
	public int getScore(String rName) {
		
		return scores.get(rName);
		
	}
	
	public void setScore(String rName, int score) {
		
		scores.remove(rName);
		scores.put(rName, score);
		
	}

	
}
