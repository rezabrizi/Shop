// Author: Reza Aghazadeh Tabrizi 
// IB IA 
// 4th Period 
//The Employees Object Class 
/**
 * Employee.java
 * 
 * A class that has the instances of an Employee Object.
 */
public class Employee 
{
	
	private String name; 
	private double wage;
	
	/**
	 * Constructs an empty Employee.
	 */
	public Employee ()
	{
		name = null;
		wage = 0.0; 
	}
	
	/**
	 * Constructs an Employee with explicit parameters.
	 * @param name the name to set.
	 * @param wage the wage to set.
	 */
	public Employee(String name, double wage) {
		this.name = name;
		this.wage = wage;
	}
	
	/**
	 *returns the name of the Employee.
	 *@return the name of the Employee.
	 */
	public String getName()
	{
		return name; 
	}
	/**
	 *returns the wage of the Employee.
	 *@return the wage of the Employee.
	 */
	public double getWage()
	{
		return wage; 
	}
	
	/**
	 * sets the name of the Employee.
	 * @param name the new name of Employee.
	 */
	public void setName(String name)
	{
		this.name = name; 
	}

	/**
	 * sets the wage of the Employee.
	 * @param wage the new wage of Employee.
	 */
	public void setWage(double wage)
	{
		this.wage = wage; 
	}
	
	/**
	 * returns whatever or not the implicit parameter is equal to the explicit parameter.
	 * @param o the Employee Object to check for equality.
	 * @return whatever or not the name of implicit parameter is equal to the name of the explicit parameter.
	 */
	public boolean equals(Object o) 
	{
		Employee other = (Employee) o; 
		return this.name.equals(other.name);
	}
	
	/**
	 * returns the difference between the implicit and the explicit parameter of the name.
	 * @param o the Employee Object to compare.
	 * @return the difference between the implicit and the explicit parameter.
	 */
	public int compareTo(Object o)
	{
		Employee other = (Employee) o; 
		return this.name.compareTo(other.name);
	}

	/**
	 * returns all the characteristics of the Employee.
	 * @return the name and the wage.
	 */
	public String toString()
	{
		return name + "\n$" + wage + " Per Hour";
	}

}
