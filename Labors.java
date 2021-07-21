//DONE NEED FINAL CHECK
// author Reza Aghazadeh Tabrizi 
// IB IA 
// 4th Period 
//The Labors List class
/**
 * Labors.java
 * 
 * A class that models a set of Employee Objects. Labors
 * has an ArrayList of Employee. 
 */
import java.util.ArrayList;

public class Labors 
{
	
	private ArrayList <Employee> employees;

	/**
	 * constructs an empty Employee List
	 */
	public Labors ()
	{
		employees = new ArrayList <Employee>();
	}
	
	/**
	 * addEmployee adds a specified Employee to the employees.
	 * @param newHire the Employee to add to employees. 
	 */
	public void addEmployee (Employee newHire)
	{
		employees.add(newHire);
	}
	
	/**
	 * removeEmployee removes a specified Employee from the employees.
	 * @param name the Employee remove from employees.
	 * @return whether the Employee was removed.
	 */
	public boolean removeEmployee (String name)
	{
		for (Employee e: employees)
			if(e.getName().equals(name))
			{
				employees.remove(e);
				return true; 
			}
			return false; 
	}
	
	/**
	 * emWage the wage of the specified Employee.
	 * @param name the Employee name to find wage.
	 * @return the wage if the Employee. 
	 */
	public double emWage (String name)
	{
		for (Employee e: employees)
			if(e.getName().equals(name))
				return e.getWage();  
			return (-1.0); 
	}
	
	/**
	 * findEm finds a specific person in the employees. 
	 * @param name the name of the specific Employee to find.
	 * @return whether the specific Employee was found. 
	 */
	public boolean findEm(String name)
	{
		for (Employee e: employees)
			if(e.getName().equals(name))
			{
				return true;  
			}
			return false; 
	}
	
	/**
	 * toString provides a String version of the Labors List with
	 * each Employee on a separate line.
	 * @return the String version of employees.
	 */
	public String toString()
	{
		String out = "";
		for (Employee e: employees)
			out+= e + "\n";
		return out;
	}
}
