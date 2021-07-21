//DONE NEED FINAL CHECK
// author Reza Aghazadeh Tabrizi 
// IB IA 
// 4th Period 
//The Order object class
/**
 * Order.java
 * 
 * A class that has the instances of an Order Object.
 */
public class Order 
{
	private String name; 
	private int quantity; 
	private String size;
	private double cost; 
	private double price; 
	private int hourOfPurchase;
	/**
	 * Constructs an empty Order.
	 */
	public Order()
	{
		name = null; 
		quantity = 0; 
		size = null;
		cost = 0.0;
		price = 0.0; 
		hourOfPurchase = 0;
	}
	/**
	 * Constructs an Order with the explicit parameters.
	 * @param name the name to set.
	 * @param quantity the quantity to set.
	 * @param size the size to set.
	 * @param cost the cost to set.
	 * @param price the price to set.
	 * @param hourOfPurchase the hour of purchase to set. 
	 */
	public Order(String name, int quantity, String size, double cost, double price, int hourOfPurchase) 
	{
		this.name = name;
		this.quantity = quantity;
		this.size = size;
		this.cost = cost; 
		this.price = price;
		this.hourOfPurchase = hourOfPurchase;
	}
	/**
	 * returns the name of the Order.
	 * @return the name of the Order.
	 */
	public String getName() 
	{
		return name;
	}
	/**
	 * returns the quantity of the Order.
	 * @return the quantity of the Order.
	 */
	public int getQuantity() 
	{
		return quantity;
	}
	/**
	 * returns the size of the Order.
	 * @return the size of the Order.
	 */
	public String getSize() 
	{
		return size;
	}
	/**
	 * returns the cost of the Order.
	 * @return the cost of the Order.
	 */
	public double getCost()
	{
		return cost; 
	}
	/**
	 * returns the price of the Order. 
	 * @return the price of the Order.
	 */
	public double getPrice() 
	{
		return price;
	}
	/**
	 * returns the hourOfPurchase of the Order. 
	 * @return the hourOfPurchase of the Order.
	 */
	public int getHourOfPurchase() 
	{
		return hourOfPurchase;
	}
	/**
	 * sets the new name of the Order.
	 * @param name the new name to set for Order.
	 */
	public void setName(String name) 
	{
		this.name = name;
	}
	/**
	 * sets the new quantity of the Order.
	 * @param quantity the new quantity to set for the Order.
	 */
	public void setQuantity(int quantity) 
	{
		this.quantity = quantity;
	}
	/**
	 * sets the new size of the Order.
	 * @param size the new size to set for the Order.
	 */
	public void setSize(String size) 
	{
		this.size = size;
	}
	/**
	 * sets the new cost of the Order.
	 * @param cost the new cost to set for the Order.
	 */
	public void setCost(double cost)
	{
		this.cost=cost;	
	}
	/**
	 * sets the new price of the Order
	 * @param price the new price to set for the Order.
	 */
	public void setPrice(double price) 
	{
		this.price = price;
	}
	/**
	 * sets the new hourOfPurcahse of the order  
	 * @param hourOfPurchase the new hourOfPurchase to set for the Order.
	 */
	public void setHourOfPurchase(int hourOfPurchase) 
	{
		this.hourOfPurchase = hourOfPurchase;
	} 
	/**
	 * returns whatever or not the implicit parameter is equal to the explicit parameter.
	 * @param o the Order Object to check for equality.
	 * @return whatever or not the name and type of the implicit parameter is equal to the name of the explicit parameter.
	 */
	public boolean equals(Object o) 
	{
		Order other = (Order) o; 
		return this.name.equals(other.name);
	}
	/**
	 * returns the difference between the implicit and the explicit parameter of the name.
	 * @param o the Order Object to compare.
	 * @return the difference between the implicit and the explicit parameter.
	 */
	public int compareToName(Object o)
	{
		Order other = (Order) o; 
		return this.name.compareTo(other.name);
	}
	/**
	 * returns all the characteristics of the Order.
	 * @return the name, price, quantity, size, and the hourOfPurchase.
	 */
	public String toString()
	{
		return "Name: " + name + "\nQuantity: "  + quantity + "\nSize: " + size +  "\nCost: $"  + 
		cost + "\nprice: $" + price + "\nHour of Purchase: " + hourOfPurchase; 
	}
	/**
	 * returns all the characteristics of the Order.
	 * @return the name, price, quantity, size, and the hourOfPurchase. 
	 */
	public String saveToFile()
	{
		return  name + "\n" + quantity + "\n" + size + "\n" + cost  + "\n" +  price + "\n" + hourOfPurchase; 
	}
	/**
	 * getTotPrice calculates the final price of an Order based on it's size and quantity.
	 * @return the final price of an Order based on it's size and it's quantity.
	 */
	public double getTotPrice() 
	{
		double totPrice = 0; 
		switch(getName()) 
		{
		  case "gelato":
		    if (getSize().equals("s"))
		    {
		    	totPrice = getPrice() * getQuantity(); 
		    }
		    else if  (getSize().equals("m"))
		    {
		    	totPrice = getPrice() * getQuantity() * 2; 
		    }
		    else if (getSize().equals("l"))
		    {
		    	totPrice = getPrice() * getQuantity() * 3; 
		    }
		    return totPrice;
		  case "soda":
			  if (getSize().equals("s"))
			    {
			    	totPrice = getPrice() * getQuantity(); 
			    }
			    else if  (getSize().equals("m"))
			    {
			    	totPrice = getPrice() * getQuantity() * 2; 
			    }
			    else if (getSize().equals("l"))
			    {
			    	totPrice = getPrice() * getQuantity() * 3; 
			    }
			  return totPrice; 
		  case "water":
			  if (getSize().equals("s"))
			    {
			    	totPrice = getPrice() * getQuantity(); 
			    }
			    else if  (getSize().equals("m"))
			    {
			    	totPrice = getPrice() * getQuantity() * 2; 
			    }
			    else if (getSize().equals("l"))
			    {
			    	totPrice = getPrice() * getQuantity() * 3; 
			    }
			  return totPrice; 
		  case "cake": 
			  if (getSize().equals("slice"))
			    {
			    	totPrice = getPrice() * getQuantity(); 
			    }
			    else if  (getSize().equals("whole"))
			    {
			    	totPrice = getPrice() * getQuantity() * 6; 
			    }
			  	return totPrice;
			  	default: 
			  		return totPrice;
		}
	}
	/**
	 * getTotCost calculates the final cost of an Order based on it's size and quantity.
	 * @return the final cost of an Order based on it's size and it's quantity. 
	 */
	public double getTotCost() 
	{
		double totCost = 0; 
		switch(getName()) 
		{
		  case "gelato":
		    if (getSize().equals("s"))
		    {
		    	totCost = getCost() * getQuantity(); 
		    }
		    else if  (getSize().equals("m"))
		    {
		    	totCost = getCost() * getQuantity() * 2; 
		    }
		    else if (getSize().equals("l"))
		    {
		    	totCost = getCost() * getQuantity() * 3; 
		    }
		    return totCost;
		  case "soda":
			  if (getSize().equals("s"))
			    {
			    	totCost = getCost() * getQuantity(); 
			    }
			    else if  (getSize().equals("m"))
			    {
			    	totCost = getCost() * getQuantity() * 2; 
			    }
			    else if (getSize().equals("l"))
			    {
			    	totCost = getCost() * getQuantity() * 3; 
			    }
			  return totCost; 
		  case "water":
			  if (getSize().equals("s"))
			    {
			    	totCost = getCost() * getQuantity(); 
			    }
			    else if  (getSize().equals("m"))
			    {
			    	totCost = getCost() * getQuantity() * 2; 
			    }
			    else if (getSize().equals("l"))
			    {
			    	totCost = getCost() * getQuantity() * 3; 
			    }
			  return totCost; 
		  case "cake": 
			  if (getSize().equals("slice"))
			    {
				  totCost = getCost() * getQuantity(); 
			    }
			    else if  (getSize().equals("whole"))
			    {
			    	totCost = getCost() * getQuantity() * 6; 
			    }
			  	return totCost;
			  	default: 
			  		return totCost;
		}
	}

}
