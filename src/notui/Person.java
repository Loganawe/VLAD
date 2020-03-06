package notui;


public class Person {

	private String name;
	private Schedule schedule = new Schedule();
	private Attribute attributes = new Attribute();
	
	public Person(String aName) {
		name = aName;
	}
	
	public void setName(String aName) {
		name = aName;
	}
	
	public String getName() {
		return name;
	}
	
	public void setSchedule(Schedule aSchedule) {
		schedule = new Schedule(aSchedule);
	}
	
	public Schedule getSchedule() {
		return new Schedule(schedule);
	}
	
	public void setAttributes(Attribute aAttributes) {
		attributes = new Attribute(aAttributes);
	}
	
	public Attribute getAttributes() {
		return new Attribute(attributes);
	}
	
	
}