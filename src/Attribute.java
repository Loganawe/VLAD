
public class Attribute {
	
	//keep these as is or turn into a list of int and just remember the order of score
	int leaderscore;
	int organscore;
	int finscore;
	int impscore;

	//setters to be used in takeTest()
	public void setLeaderScore(int point)
	{
		leaderscore = leaderscore + point;
	}
	
	public void setOrganScore(int point) 	
	{
		organscore = organscore + point;
	}
	
	public void setFinScore(int point) 
	{
		finscore = finscore + point;
	}
	
	public void setImpScore(int point) 
	{
		impscore = impscore + point;
	}
	
	//getters to be used in public class Group deligate() and in takeTest()
	public int getLeaderScore() 
	{
		return leaderscore;
	}
	
	public int getOrganScore() 
	{
		return organscore;
	}
	
	public int getFinScore() 
	{
		return finscore;
	}
	
	public int getImpScore() 
	{
		return impscore;
	}
	
	//the test taking code, working in progress questions
	public void takeTest() {
		
	}
	
	//so we can fully run a console only version of the program
	//public String toString() 
	//{
		
	//}
}
