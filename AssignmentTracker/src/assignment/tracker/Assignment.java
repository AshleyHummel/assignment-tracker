/*
 * Assignment.java class used in Tracker.java
*/

package assignment.tracker;

public class Assignment 
{
	private String name;
	private String description;
	private String date;
	
	public Assignment(String name, String description, String date) {
		this.name = name;
		this.description = description;
		this.date = date;
	}
	
	public String getName() {
		return name;
	}
	
	public String getDescription() {
		return description;
	}
	
	public String getDate() {
		return date;
	}
}