package notui;

import java.util.Scanner;

public class maintest {

	public static void main(String[] args) {
	
		Scanner input = new Scanner(System.in);
		
		boolean runningfull=true;
		
		while(runningfull==true) {
			
			System.out.println("1. Create new group");
			System.out.println("2. Quit");
	
			String answer = input.nextLine();
	
			if(answer.equals("1")) {
				
				System.out.println("Enter group name:");
				String gname = input.nextLine();
				Group group = new Group(gname);
				
				boolean runninggroup = true;
				
				while(runninggroup=true){
					System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
					System.out.println("Group: " + gname);
					System.out.println(group.getGroupRoles());
					
					System.out.println("1. Add new role");
					System.out.println("2. Remove role");
					System.out.println("3. Add new member");
					System.out.println("4. Remove member");
					System.out.println("5. Print current group structure");
					System.out.println("6. Find free schedule");
					System.out.println("7. Deligate roles");
					System.out.println("8. Quit");
					
					String command = input.nextLine();
					
					if(command.equals("1")) {
						System.out.println("Enter role name: ");
						String rolename = input.nextLine();
						System.out.println("Enter role description: ");
						String roledesc = input.nextLine();
						group.addRole(rolename, roledesc);
					}
					else if(command.equals("2")) {
						System.out.println("Enter role name: ");
						String rolename = input.nextLine();
						group.removeRole(rolename);
					}
					else if(command.equals("3")) {
						System.out.println("Enter person name: ");
						String name = input.nextLine();
						Person person = new Person(name);
						
						System.out.println("Do you want to add a schedule? (y)/(n) ");
						String membercommand = input.nextLine();
						if(membercommand.equals("y")) {
							Schedule sch = new Schedule();
							boolean schrunning = true;
							while(schrunning==true) {
								System.out.print("Enter day (0=Sun / 6=Sat): ");
								int day = input.nextInt();
								System.out.print("Enter start time (9am = 900 / 1pm = 1300): ");
								int starttime = input.nextInt();
								System.out.print("Enter end time (9am = 900 / 1pm = 1300): ");
								int endtime = input.nextInt();
								input.nextLine();
								int[] busytime = new int[] {day,starttime,endtime};
								sch.addBusyManual(busytime);
								System.out.println("Add another time? (y)/(n)");
								String schcommand2 = input.nextLine();
								if(schcommand2.equals("n")) {
									schrunning = false;
									person.setSchedule(sch);
								}
							}
						}
						System.out.println("Do you want to add roles? (y)/(n) ");
						membercommand = input.nextLine();
						if(membercommand.equals("y")) {
							Attribute attr = new Attribute(group);
							attr.takeQuiz()
							person.setAttributes(attr);

							attr.takeTest(name, group, person);				
						}
						group.addRoleMember(person, "Team Member");
					}
					else if(command.equals("4")) {
						System.out.println("Enter person name: ");
						String name = input.nextLine();
					}
					else if(command.equals("5")) {
						System.out.println(group.getGroupName());
						for(Roles role:group.getGroupRoles()) {
							System.out.println();
							System.out.print(role.getRoleName()+": ");
							for(Person person:role.getTeam()) {
								System.out.print(person.getName()+", ");
							}
						}
						System.out.println();
					}
					else if(command.equals("6")) {
						group.setAvailability();
						System.out.println(group.getFreeSch().toString());
					}
					else if(command.equals("7")) {
						group.deligate();
						System.out.println("Print group structure to see");
					}
					else if(command.equals("8")) {
						runninggroup=false;
					}
					else {
						System.out.println("Enter valid command");
					}
				}
			}
			else if(answer.equals("2")) {
				runningfull=false;
			}
			else {
				System.out.println("Enter valid command");
			}
		}
	}

}
