import java.util.Scanner; 

public class GroupMInput 
{
	//all instance variables must be private..
	private int members = 0;
	
	public static void main(String[] args) 
	{
		Scanner keyboard = new Scanner(System.in);
		System.out.println("How many group members?: ");
		int members = keyboard.nextInt();
		System.out.println(members);
		
	}
}
