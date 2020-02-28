
public class Person {

	/*basic info no need for role var because the person will already be places in 
	an arraylist of their role */
	String name;
	Schedule Schedule = new Schedule();
	Attribute attributes = new Attribute();
	
	//person needs a name
	public Person(String mName) {
		name = mName;
	}
	
	//set for others are in the specific classes so no need for setter in this class
	public void setName() {
		
	}
	
	//get for synco() and deliagte() in public class group and name for console use
	public String getName() {
		
	}
	
	public Schedule getSchedule() {
		
	}
	
	public Attribute getAttributes() {
		
	}
	
	
}