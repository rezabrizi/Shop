// IB IA 
// 4th Period 
//The Payroll List class
/**
 * Payroll.java
 * @Author Reza Aghazadeh Tabrizi
 * A class that models a set of Shift Objects. Payroll
 * has an ArrayList of Shift. 
 */

import java.util.ArrayList;

public class Payroll 
{
	private ArrayList <Shift> hours; 
	
	/**
	 * Constructs an empty Payroll List
	 */
	public Payroll ()
	{
		hours = new ArrayList <Shift> ();
	}
	
	/**
	 * addShift adds a specified Shift to hours.
	 * @param newShift the Shift to add to hours. 
	 */
	public void addShift (Shift newShift)
	{
		hours.add(newShift);
	}
	
	/**
	 * findShift finds a person's last shift based on their name. 
	 * @param name the name of the person to find their last shift. 
	 * @return the last Shift of the employee with the given name. 
	 */
	public Shift findShift(String name)
	{
		double tempClock = 0.0; 
		Shift temp = new Shift();
		for (Shift e: hours)
			if(e.getName().equals(name))
				if(tempClock < e.getClockIn() && e.getClockOut() == 0.0)
				{	
					tempClock = e.getClockIn();
					temp = e; 
				}	
		return temp;  
	}
	
	/**
	 * employeeHour calculates total hours a person has worked in hours. 
	 * @param name the name of the person to calculate their total work time in hours. 
	 * @return the total hours a specific employee worked. 
	 */
	public double employeeHour(String name)
	{
		double totHours = 0.0; 
		int test = 0; 
		for (Shift e: hours)
		{
			if (e.getName().equals(name))
			{
				totHours += e.getHour();
				test += 1;
			}
		}
		if (test == 0)
			return -1.0;
		else 
			return (totHours);
	}
	
	/**
	 * toString provides a String version of the Payroll List with
	 * each Shift on a separate line.
	 * @return the String version of hours.
	 */
	public String toString()
	{
		String out = "";
		for (Shift e: hours)
			out+= e + "\n";
		return out;
	}	
}


