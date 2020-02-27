import java.util.ArrayList;
import java.util.Scanner;

public class Person {

	//Instance Variables
	String name;
	Schedule Schedule;
	
	Attribute attributes;
	String role;
	
	//Constructors
	public Person() {
	}
	
	public Person(String mName) {
		name = mName;
	}
	
	public Person(Schedule sch ) {
		Schedule = sch;
	}
	
}