package notui;


// TODO: Auto-generated Javadoc
/**
 * The Class Person.
 */
public class Person {

	/** The name. */
	private String name;
	
	/** The schedule. */
	private Schedule schedule = new Schedule();
	
	/** The attributes. */
	private Attribute attributes;
	
	/**
	 * Instantiates a new person.
	 *
	 * @param aName the person's name
	 */
	public Person(String aName) {
		name = aName;
	}
	
	/**
	 * Sets the name.
	 *
	 * @param aName the new name
	 */
	public void setName(String aName) {
		name = aName;
	}
	
	/**
	 * Gets the name.
	 *
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * Sets the schedule.
	 *
	 * @param aSchedule the new schedule
	 */
	public void setSchedule(Schedule aSchedule) {
		schedule = new Schedule(aSchedule);
	}
	
	/**
	 * Gets the schedule.
	 *
	 * @return the schedule
	 */
	public Schedule getSchedule() {
		return new Schedule(schedule);
	}
	
	/**
	 * Sets the attributes.
	 *
	 * @param aAttributes the new attributes
	 */
	public void setAttributes(Attribute aAttributes) {
		attributes = new Attribute(aAttributes);
	}
	
	/**
	 * Gets the attributes.
	 *
	 * @return the attributes
	 */
	public Attribute getAttributes() {
		return new Attribute(attributes);
	}
	
	
}