// author Reza Aghazadeh Tabrizi 
// IB IA 
// 4th Period 
//The inventory object class
/**
 * Inventory.java
 * 
 * A class that has the instances of an Inventory Object.
 */
public class Inventory 
{
	private String name;
	private int amount; 
	
	/**
	 * Constructs an empty Inventory.
	 */
	public Inventory () 
	{
		name = null; 
		amount = 0; 
	}
	
	/**
	 * Constructs an Inventory with the explicit parameter.
	 * @param name the name to set.
	 * @param amount the amount to set.
	 */
	public Inventory(String name, int amount) 
	{
		this.name = name;
		this.amount = amount;
	}

	/**
	 *returns the name of the inventory.
	 *@return the name of the inventory.
	 */
	public String getName() 
	{
		return name;
	}

	/**
	 * returns the amount of the Inventory.
	 * @return the amount of the Inventory.
	 */
	public int getAmount() 
	{
		return amount;
	}

	/**
	 * sets the name of the Inventory.
	 * @param name the new name of Inventory.
	 */
	public void setName(String name) 
	{
		this.name = name;
	}

	/**
	 * sets the new amount of the Inventory.
	 * @param amount the new amount to set for the Inventory.
	 */
	public void setAmount(int amount) 
	{
		this.amount = amount;
	}
	
	/**
	 * returns whatever or not the implicit parameter is equal to the explicit parameter.
	 * @param o the Inventory Object to check for equality.
	 * @return whatever or not the name and type of the implicit parameter is equal to the name of the explicit parameter.
	 */
	public boolean equals(Object o) 
	{
		Inventory other = (Inventory) o; 
		return this.name.equals(other.name);
	}
	
	/**
	 * returns the difference between the implicit and the explicit parameter of the name.
	 * @param o the Inventory Object to compare.
	 * @return the difference between the implicit and the explicit parameter.
	 */
	public int compareToName(Object o)
	{
		Inventory other = (Inventory) o; 
		return this.name.compareTo(other.name);
	}

	/**
	 * returns all the characteristics of the Inventory.
	 * @return the name and the amount.
	 */
	public String toString()
	{
		return "Name: " + name + "\nAmount: "  + amount + " Grams"; 
	}
	/**
	 * returns all the characteristics of the Inventory.
	 * @return the name and the amount.
	 */
	public String saveToFile()
	{
		return  name  + "\n" + amount; 
	}

}
