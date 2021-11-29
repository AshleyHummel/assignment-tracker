/*
 * Assignment.java class used in Tracker.java
*/

package assignment.tracker;

import java.time.LocalDate;
import java.time.Period;
import java.util.Comparator;

public class Assignment 
{
	private String name;
	private String description;
	private LocalDate date;
	
	public Assignment(String name, String description, LocalDate date) {
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
	
	public LocalDate getDate() {
		return date;
	}
	
	//return how many days are left until assignment is due
	public long daysLeft() {
		LocalDate now = LocalDate.now();
		
		long daysBetween = java.time.temporal.ChronoUnit.DAYS.between(now, date); 
		
		return daysBetween;
	}
	
	// Comparator for sorting the list by date
    public static Comparator<Assignment> dateComparator = new Comparator<Assignment>() {

	    public int compare(Assignment a1, Assignment a2) {
		   LocalDate date1 = a1.getDate();
		   LocalDate date2 = a2.getDate();
	
		   /*For ascending order*/
		   return date1.compareTo(date2);
	   }
	};
}