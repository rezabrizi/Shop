// IB IA 
// 4th Period 
//The Purchased List class
/**
 * Purchased.java
 * @Author Reza Aghazadeh Tabrizi
 * A class that models a set of Order Objects. Purchased
 * has an ArrayList of Orders. 
 */
import java.util.ArrayList;

public class Purchased 
{
	
	private ArrayList <Order> sold; 
	/**
	 * Constructs an empty Purchased List
	 */
	public Purchased()
	{
		sold = new ArrayList<Order>();
	}
	/**
	 * clears the Sold Array List
	 */
	public void emptyOrders()
	{
		sold.clear();
	}
	
	/**
	 * addItem adds a specified Order to Sold.
	 * @param purchase the Order to add to Sold. 
	 */
	public void addPurchase(Order purchase)
	{
		sold.add(purchase);
	}
	/**
	 * finds the total Income of all the orders in the Purchased List.
	 * @return the total Income of all the orders in the Purchased List. 
	 */
	public double getTotalIncome()
	{
		double totalIncome = 0.0; 
		for (Order e: sold)
		{
			totalIncome += e.getTotPrice();
		}
		return totalIncome; 
	}
	/**
	 * finds the total cost of all the orders in the Purchased List.
	 * @return the total cost of all the orders in the Purchased List. 
	 */
	public double getTotalCost()
	{
		double totalCost = 0.0; 
		for (Order e: sold)
		{
			totalCost += e.getTotCost();
		}
		return totalCost; 
	}
	/**
	 * saveToFile provides a String version of the Purchased List with
	 * each Order on a separate line to be saved. 
	 * @return the String version of sold. 
	 */
	public String saveToFile()
	{
		String out = "";
		for (Order e: sold)
			out += e.saveToFile()+"\n";
		return out; 
	}
	/**
	 * toString provides a String version of the Purchased List with
	 * each Order on a separate line.
	 * @return the String version of sold.
	 */
	public String toString()
	{
		String out = "";
		for (Order e: sold)
			out+= e + "\n";
		return out;
	}
	/**
	 * size gets the length of the Purchased List.
	 * @return the length of the Purchased List.
	 */
	public int size()
	{
		return sold.size();
	}
}
