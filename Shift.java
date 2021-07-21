// Author: Reza Aghazadeh Tabrizi 
// IB IA 
// 4th Period 
//The Shift Object Class 
/**
 * Shift.java
 * 
 * A class that has the instances of a Shift Object.
 */
public class Shift {
	private String name; 
	private double clockIn;
	private double clockOut;

	/**
	 * Constructs an empty Shift.
	 */
	public Shift ()
	{
		name = "nothing"; 
		clockIn = 0.0;
		clockOut = 0.0; 
	}
	
	/**
	 * Constructs a Shift with explicit parameters.
	 * @param name the name to set.
	 * @param clockIn the clockIn to set.
	 * @param clockOut the clockOut to set.
	 */
	public Shift(String name, double clockIn, double clockOut) 
	{
		this.name = name; 
		this.clockIn = clockIn;
		this.clockOut = clockOut;
	}
	
	/**
	 *returns the clockIn Time of the Shift.
	 *@return the clockIn of the Shift.
	 */
	public double getClockIn() 
	{
		return clockIn;
	}
	
	/**
	 *returns the name of the Shift.
	 *@return the name of the Shift.
	 */
	public String getName() 
	{
		return name;
	}
	
	/**
	 *returns the clockOut Time of the Shift.
	 *@return the clockOut of the Shift.
	 */
	public double getClockOut() 
	{
		return clockOut;
	}
	
	/**
	 * sets the clockIn of the Shift.
	 * @param clockIn the new clockIn of Shift.
	 */
	public void setClockIn(double clockIn) 
	{
		this.clockIn = clockIn;
	}
	
	/**
	 * sets the clockOut of the Shift.
	 * @param clockOut the new clockOut of Shift.
	 */
	public void setClockOut(double clockOut) 
	{
		this.clockOut = clockOut;
	}
	
	/**
	 * sets the name of the Shift.
	 * @param name the new name of Shift.
	 */
	public void setName(String name) 
	{
		this.name = name;
	} 
	
	/**
	 *returns how long the shift was in hours
	 *@return the length of the shift in hours.
	 */
	public double getHour ()
	{
		return ((clockOut - clockIn)/3600000); 
	}
	
	/**
	 * returns whatever or not the implicit parameter is equal to the explicit parameter.
	 * @param o the Shift Object to check for equality.
	 * @return whatever or not the clockIn of implicit parameter is equal to the clockIn of the explicit parameter.
	 */
	public boolean equals(Object o)
	{
		Shift other = (Shift) o; 
		return  (this.clockIn == other.clockIn);
	}
	
	/**
	 * returns the difference between the implicit and the explicit parameter of the clockIn.
	 * @param o the Shift Object to compare.
	 * @return the difference between the implicit and the explicit parameter.
	 */
	public double compareTo(Object o)
	{
		Shift other = (Shift) o;
		return (this.clockIn - other.clockIn);
	}
	
	/**
	 * returns all the characteristics of the Shift.
	 * @return the name, clockIn and clockOut.
	 */
	public String toString()
	{
		return name + "\nClocked in: " +  clockIn + "/nClocked Out: " + clockOut;
	}
}
