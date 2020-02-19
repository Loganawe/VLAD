import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Quiz 
{
	
	static int leader = 0;
	static int organizer = 0;
	static int finisher = 0;
	static int implementer = 0;
	
	public static void asker ()
	{
		Scanner keyboard = new Scanner(System.in);
		System.out.println("How many group members?: ");
		int members = keyboard.nextInt();
		List<Member> listOfMembers = new ArrayList<>();
		
		int x = 0;
		
		for(x = 0; x < members; x++) 
		{
			int answer;
			listOfMembers.add(new Member());
			Member member = listOfMembers.get(x);
			
			do {
			System.out.println("are you a leader?(pick between 0 and 5)");
			answer = keyboard.nextInt();
			
			} while(answer > 5);
			
			member.setLeaderscore(answer + member.getLeaderscore());
			
			do {
				System.out.println("are you a boss?(pick between 0 and 5)");
				answer = keyboard.nextInt();
				
				} while(answer > 5);
			member.setLeaderscore(answer + member.getLeaderscore());
			
			do {
				System.out.println("are you a organizer?(pick between 0 and 5)");
				answer = keyboard.nextInt();
				
				} while(answer > 5);
			member.setOrganscore(answer + member.getOrganscore());
			
			do {
				System.out.println("are you a planner?(pick between 0 and 5)");
				answer = keyboard.nextInt();
				
				} while(answer > 5);
			member.setOrganscore(answer + member.getOrganscore());

			do {
				System.out.println("are you a finisher?(pick between 0 and 5)");
				answer = keyboard.nextInt();
				
				} while(answer > 5);
			member.setFinscore(answer + member.getFinscore());
			
			do {
				System.out.println("are you a completer?(pick between 0 and 5)");
				answer = keyboard.nextInt();
				
				} while(answer > 5);
			member.setFinscore(answer + member.getFinscore());
			
			do {
				System.out.println("are you a implementer?(pick between 0 and 5)");
				answer = keyboard.nextInt();
				
				} while(answer > 5);
			member.setImpscore(answer + member.getImpscore());
			
			do {
				System.out.println("are you one that likes implementing?(pick between 0 and 5)");
				answer = keyboard.nextInt();
				
				} while(answer > 5);
			member.setImpscore(answer + member.getImpscore());

			//compares everybodys scores
			if(listOfMembers.get(x).getLeaderscore() > listOfMembers.get(leader).getLeaderscore() )
			{
				leader = x;
			}
			if(listOfMembers.get(x).getOrganscore() > listOfMembers.get(organizer).getOrganscore() )
			{
				organizer = x;
			}
			if(listOfMembers.get(x).getImpscore() > listOfMembers.get(organizer).getImpscore())
			{
				implementer = x;
			}
			
			if(listOfMembers.get(x).getFinscore() > listOfMembers.get(finisher).getFinscore())
			{
				finisher = x;
			}
			
		}
		System.out.println("the leader is group member:  "+ (leader+1));
		System.out.println("the organizer is group member:  "+ (organizer+1));
		System.out.println("the finisher is group member:  "+ (finisher+1));
		System.out.println("the implementer is group member:  "+ (implementer+1));

	}
	

	public static void main(String[] args) 
	{
		asker();
	}
}
