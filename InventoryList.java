// author Reza Aghazadeh Tabrizi 
// IB IA 
// 4th Period 
//The InventoryList List class
/**
 * InventoryList.java
 * 
 * A class that models a set of Inventory Objects. InventoryList
 * has an ArrayList of Inventories. 
 */
import java.util.ArrayList;

public class InventoryList 
{
	private ArrayList <Inventory> inStock;
	/**
	 * Constructs an empty Inventory List
	 */
	public InventoryList()
	{
		inStock = new ArrayList<Inventory>();
	}
	
	/**
	 * addItem adds a specified Inventory to the inStock.
	 * @param purchase the Inventory to add to inStock. 
	 */
	public void addItem(Inventory purchase)
	{
		inStock.add(purchase);
	}
	
	/**
	 * emptyInventory clears the Inventory List
	 */
	public void emptyInventory() 
	{
		inStock.clear();
	}
	
	/**
	 * removeItem removes a specified Inventory from the inStock if it exists, and returns true.
	 * If the Inventory does not exist in the inStock, returns false.
	 * @param purchase the Inventory to search for and remove.
	 * @return whether the Inventory was removed.
	 */
	public boolean removeItem(Inventory purchase)
	{
		if (inStock.indexOf(purchase)!= -1)
		{
			inStock.remove((inStock.indexOf(purchase)));
			return true;
		}
		else 
			return false;
	}
	
	/**
	 * looks for a given name in the Inventory List. If found returns true. 
	 * Else, it returns false. 
	 * @param name the name to find.
	 * @return whether the name was found or not.
	 */
	public boolean findItem(String name)
	{
		for (Inventory e: inStock)
			if(e.getName().equals(name))
				return true;  
			return false; 
	}
	
	/**
	 * looks for an object that has the name given.
	 * @param name the name of the object to find. 
	 * @return the object that has the name. If not found, returns null. 
	 */
	public Inventory findObject(String name)
	{
		for (Inventory e: inStock)
			if(e.getName().equals(name))
				return e;  
			return null;	
	}
	
	/**
	 * amountOfInventory returns the amount of a specified Inventory.
	 * If the Inventory does not exist in the inStock, returns 0.
	 * @param purchase the inventory to find amount for. 
	 * @return the amount of that Inventory or 0. 
	 */
	public int amountOfInventory (Inventory purchase)
	{
		if (inStock.indexOf(purchase)!= -1)
			return purchase.getAmount();
		else 
			return 0;
	}
	
	/**
	 * alphabetSortName Alphabetizes the name of the Inventory in the Inventory List. 
	 */
	public void alphabetSortName ()
	{
		for ( int i = 1; i <inStock.size(); i++)
			for (int position = 0; position < inStock.size()-i; position++)
				if (inStock.get(position).compareToName(inStock.get(position+1))>0)
				{
					Inventory temp = inStock.get(position);
					inStock.set(position, inStock.get(position + 1));
					inStock.set(position+1, temp);
				}
	}
	
	/**
	 * toString provides a String version of the Inventory List with
	 * each Inventory on a separate line.
	 * @return the String version of the inStock.
	 */
	public String toString()
	{
		String out = "";
		for (Inventory e: inStock)
			out+= e + "\n";
		return out;
	}
	
	/**
	 * saveToFile provides a String version of the Inventory List with
	 * each Inventory on a separate line to be saved. 
	 * @return the String version of the inStock. 
	 */
	public String saveToFile()
	{
		String out = "";
		for (Inventory e: inStock)
			out += e.saveToFile()+"\n";
		return out; 
	}
	
	/**
	 * size gets the length of the Inventory List.
	 * @return the length of the Inventory List.
	 */
	public int size()
	{
		return inStock.size();
	}
}

	

