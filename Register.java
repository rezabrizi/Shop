import javax.swing.JOptionPane;
import javax.swing.*;
import java.util.Scanner;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Register.java 
 * @author Reza Tabrizi
 * Register is a class to models a register of a shop using a graphical interface.
 */
public class Register {
	private static int [] time = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}; //shop opens at 12 PM and closes at 10 PM, 12 is index 0, and 10 is index 10 
	private static int [] faveItems = {0, 0 ,0 , 0}; //gelato is index 0 , water is index 1, soda is index 2, cake is index 3
	private static InventoryList stock;
	private static Purchased orders; 
	private static String path = "//Users//tabrizi//Desktop//Purchased.txt";
	private static int needAmount; 
	private static String sizeAsked;
	private static int quantityAsked;
	private static int hourPurchased; 
	/**
	 * main Displays the graphical user interface menu and keeps the menu running until
	 * the user enters choice 0 to close their store. 
	 * @param args not used
	 */
	public static void main(String[] args) 
	{
		
		stock = new InventoryList();
	    orders = new Purchased();

	       boolean done = false;
	    
	       while(!done)
	       {
	      	String menu = "0 - Quit" + "\n" + "1 -Open The Store " + "\n" + "2 - Add Today's Inventory " + "\n"+"3 - Add Order"+ "\n"+"4 - get favorite product "
	      			+ "\n"+"5 - get golden hour"+ "\n"+"6 - Profit "+ "\n"+"7 - Load from File "+ "\n"+"8 - Save to File" + "\n"+"9 - Sort Inventory" + "\n"+"10 - Print Inventory"+ "\n"+"11 - Print Orders";
	      	String inputValue = JOptionPane.showInputDialog(menu);
	      		 int n = Integer.parseInt(inputValue);
		       switch(n)
		       {
		       	   case 0:
		       		   JOptionPane.showMessageDialog(null,"Thank You for using this program! ");
		       		   done = true; break;
		           case 1:  
		   	    		stock.emptyInventory();
		   	    		orders.emptyOrders();
		   	    		JOptionPane.showMessageDialog(null,"Welcome! The Lists are clear.");
		   	    		break;
		           case 2:
		        	    AddtoInventory();
		   				break;
		           case 3: 
		        	    AddtoOrder();
		        	   	JOptionPane.showMessageDialog(null,"Thank You for Your Order! :D ");
		           		break;
		           case 4:  
		        		JOptionPane.showMessageDialog(null,faveProduct());
		        		break;
		           case 5:
		        	    JOptionPane.showMessageDialog(null,goldenHour());
		        	    break;
		           case 6: 
		        	   	JOptionPane.showMessageDialog(null,getProfit());
		        	   	break;
		           case 7: 
		        	   	loadInventoryFiles();
		        	   	JOptionPane.showMessageDialog(null,"The new Inventory is: \n" +stock.toString());
		        	  	break;
		           case 8: 
		        	   saveFile();
		        	   JOptionPane.showMessageDialog(null,"Orders were added to file");
		        	   break;
		           case 9: 
		        	   JOptionPane.showMessageDialog(null,"The sorted Inventory is: \n" + sort());
		        	   break;
		           case 10: 
		        	   if (stock.size() == 0)
		        	   {
		        		   JOptionPane.showMessageDialog(null,"No items in the Inventory.");
		        		   break;
		        	   }
		        	   else 
		        	   {
		        		   JOptionPane.showMessageDialog(null,stock.toString());
		        		   break;
		        	   }
		           case 11: 
		        	   if (orders.size() == 0)
		        	   {
		        		   JOptionPane.showMessageDialog(null,"No items purchased.");
		        		   break;
		        	   }
		        	   else 
		        	   {
		        		   JOptionPane.showMessageDialog(null,orders.toString());
		        		   break;
		        	   }
		       

		       }
	       }
	}

	/**
	 * addtoInventory adds Objects of type Inventory to the Inventory List Stock
	 */
	public static void AddtoInventory()
    {     boolean editMore = true;
          while(editMore)
          {
        	JTextField field1 = new JTextField();
      		JTextField field2 = new JTextField();
      		
      		Object[] message = 
      		{
      			"Name:", field1,
      			"Amount:", field2,
      		};
  
           
      		int option = JOptionPane.showConfirmDialog(null, message, "Enter all your values", JOptionPane.OK_CANCEL_OPTION);
      		if (option == JOptionPane.OK_OPTION)
      		{
      			  
      			String name1 = field1.getText();
      			int amount1 =  Integer.parseInt(field2.getText());
		  
      			if (stock.findItem(name1)) 
      			{
      				
      				Inventory temp = stock.findObject(name1);
      				temp.setAmount((temp.getAmount()+amount1));
      				JOptionPane.showMessageDialog(null, temp.getName() + "'s amount was updated to " + temp.getAmount() + " Grams.");

      			}
      			else
      			{
      				//creating an instance of the Inventory class to be put in the Inventory List
      				Inventory todayIn = new Inventory (name1, amount1); 
      				stock.addItem(todayIn);
      				JOptionPane.showMessageDialog(null,todayIn.getName() + " was added to the inventory with the amount of " + todayIn.getAmount() + " Grams.");
      			}
			
      		}
      		else
      			System.out.println("no data");
 
          	String  menu = "1 - Add" + "\n" + "2 - Done ";
        	String  inputValue = JOptionPane.showInputDialog(menu);
        	//out write a switch to evaluate the options -- following if would be in your switch
        	if (inputValue.equals("2"))
        		editMore = false;
          }
       
    }
	
	/**
	 * addtoOrder adds objects of type Order to the list of Purchased if the required amount is available in the Inventory 
	 */
	public static void AddtoOrder()
    {     
		boolean editMore = true;
        while(editMore)
        {
        	JTextField field1 = new JTextField();
      		JTextField field2 = new JTextField();
      		JTextField field3 = new JTextField();
      		JTextField field4 = new JTextField();
      		JTextField field5 = new JTextField();
      		JTextField field6 = new JTextField();
      		Object[] message = 
      		{
      			"Name:", field1,
      			"Quantity:", field2,
      			"Size:", field3,
      			"Cost: ", field4,
      			"Price:", field5,
      			"Hour Of Purchase:", field6,
            };
      		int option = JOptionPane.showConfirmDialog(null, message, "Enter all your values", JOptionPane.OK_CANCEL_OPTION);
      		if (option == JOptionPane.OK_OPTION)
      		{
      			String name = field1.getText();
      			int quantity =  Integer.parseInt(field2.getText());
      			String size = field3.getText();
      			double cost = Double.parseDouble(field4.getText());
      			double price = Double.parseDouble(field5.getText());
      			int hour =  Integer.parseInt(field6.getText());
      			sizeAsked = size; 
      			quantityAsked = quantity;
      			hourPurchased = hour; 
      			switch (name)
      			{
      				case "gelato": 
      					if (stock.findItem("gelato"))
      					{
      						Inventory temp = stock.findObject("gelato");
      						int amountAva = temp.getAmount();
      						if (neededAmount() <= amountAva)
      						{
      							Order todayOrder = new Order (name, quantity, size, cost, price, hour); 
      							orders.addPurchase(todayOrder);
      							faveItems[0]+= quantity;
      							temp.setAmount(amountAva - needAmount);
      							hourProcess();
      						}
      						else 
      							JOptionPane.showMessageDialog(null,"Gelato is not Availabe");
      					}
      					else 
      						JOptionPane.showMessageDialog(null,"Gelato is not Availabe");
      					break;
      			case "water": 
      				if (stock.findItem("water"))
      				{
      					Inventory temp = stock.findObject("water");
      					int amountAva = temp.getAmount();
      					if (neededAmount() <= amountAva)
      					{
      						Order todayOrder = new Order (name, quantity, size, cost, price, hour); 
      						orders.addPurchase(todayOrder);
      						faveItems[1]+= quantity;
      						temp.setAmount(amountAva - needAmount);
      						hourProcess();
      					}
      					else 
      						JOptionPane.showMessageDialog(null,"Water is not Availabe");
      				}
      				else 
      					JOptionPane.showMessageDialog(null,"Water is not Availabe");
      				break;
      			case "soda":
      				if (stock.findItem("soda"))
      				{
      					Inventory temp = stock.findObject("soda");
      					int amountAva = temp.getAmount();
      					if (neededAmount() <= amountAva)
      					{
      						Order todayOrder = new Order (name, quantity, size, cost, price, hour); 
      						orders.addPurchase(todayOrder);
      						faveItems[2]+= quantity;
      						temp.setAmount(amountAva - needAmount);
      						hourProcess();
      					}
      					else 
      						JOptionPane.showMessageDialog(null,"Soda is not Available");
      				}
      				else 
      					JOptionPane.showMessageDialog(null,"Soda is not Available");
      				break;
      			case "cake":
      				if (stock.findItem("cake"))
      				{
      					Inventory temp = stock.findObject("cake");
      					int amountAva = temp.getAmount();
      					int needAmount;
      					if (size.equals("slice"))
      					{
      						needAmount = 100 * quantity;
      					}
      					else
      					{
      						needAmount = 600 * quantity; 
      					}
      					if (needAmount <= amountAva)
      					{
      						Order todayOrder = new Order (name, quantity, size, cost, price, hour); 
      						orders.addPurchase(todayOrder);
      						faveItems[3]+= quantity;
      						temp.setAmount(amountAva - needAmount);
      						hourProcess();
      					}
      					else 
      						JOptionPane.showMessageDialog(null,"Cake is not Available");
      				}
      				else 
      					JOptionPane.showMessageDialog(null,"Cake is not Available");
      				break;
      		}	
      	}
      	else
          	System.out.println("no data");
          String  menu = "1 - Add" + "\n" + "2 - Done ";
          String  inputValue = JOptionPane.showInputDialog(menu);
        if (inputValue.equals("2"))
        		editMore = false;
          }
    }
	
	/**
	 * faveProduct looks for the purchased product with the highest quantity
	 * @return the favorite product that was purchased
	 */
	public static String faveProduct()
	{
		int max = faveItems[0];
	    int maxIndex = 0;
		for (var i = 1; i < faveItems.length; i++) 
	    {
		   if (faveItems[i] > max) 
	        {
	            maxIndex = i;
	            max = faveItems[i];
	        }
	    }
	    switch (maxIndex)
	    {
	    	case 0:
		   		return "gelato";
		   	case 1:
		   		return "water";
		   	case 2:
	    		return "soda";
	    	case 3:
	    		return "cake";
		   	default: 
		   		return "No Items purchased";
	    }
	}
	/** 
	 * goldenHour gives the hour when the highest quantity of products were purchased
	 * @return favorite hour with the highest quantity sale 
	 */
	public static String goldenHour()
	{
		int max = time[0];
		int maxIndex = 0;
		for (var i = 1; i < time.length; i++) 
		{
			if (time[i] > max) 
		    {
				maxIndex = i;
		        max = time[i];
		    }
		}
		switch (maxIndex)
		{
			case 0:
		    	return "The most number of items were purchased at 12 PM";
		    case 1:
		    	return "The most number of items were purchased at 1 PM";
		    case 2:
		    	return "The most number of items were purchased at 2 PM";
		   	case 3:
		   		return "The most number of items were purchased at 3 PM";
		   	case 4: 
		   		return "The most number of items were purchased at 4 PM";
	    	case 5: 
		    	return "The most number of items were purchased at 5 PM";
		   	case 6:
		   		return "The most number of items were purchased at 6 PM";
		   	case 7: 
		   		return "The most number of items were purchased at 7 PM";
	   		case 8:
	   			return "The most number of items were purchased at 8 PM";
		   	case 9:
		   		return "The most number of items were purchased at 9 PM";
		   	case 10:
		   		return "The most number of items were purchased at 10 PM";
			default: 
	   			return "No Items purchased";
		}
	}
	/**
	 * getProfit returns the profit of the shop 
	 * @return the profit of the shop 
	 */
	public static String getProfit()
	{
		double tempProfit = orders.getTotalIncome() - orders.getTotalCost();
		return ("Your Total Income was: $" + orders.getTotalIncome() + "\nYour Total Cost was: $" + orders.getTotalCost() +
				"\nYour Profit was: $" + tempProfit);
	}
	/**
	 * loadInventoryFiles loads data from a file into the Inventory List 
	 */
	public static void loadInventoryFiles()
    {
        Scanner saved;
        try
        {
            File file =  new File("//Users//tabrizi//Desktop//Inventory.txt");
            saved = new Scanner (file);
            while(saved.hasNextLine())
            {
                String name;
                int amount;
                name = saved.nextLine();
                amount = Integer.parseInt(saved.nextLine());
               
                if (stock.findItem(name)) 
      		  	{
                	Inventory temp = stock.findObject(name);
                	temp.setAmount((temp.getAmount()+amount));
      		  	}
      		  else
      		  {
      			  Inventory todayIn = new Inventory (name, amount); 
      			  stock.addItem(todayIn);
      			  System.out.println ("added");
      		  }
              
            } 
        } 
        
          catch (IOException e)
        {
            System.out.println ("input read failed " + e);
        }
    }
	/**
	 * saveFile saves data into a file from the Purchased List
	 */
	public static void saveFile() 
	{
		for (int i = 0; i < orders.size()-1; i ++)
		{
				try 
				{
					BufferedWriter out = new BufferedWriter(new FileWriter(path, true)); 
		            out.write(orders.saveToFile());
		            out.close(); 
		        } 
		        catch (IOException e) 
				{ 
		        	System.out.println("exception occoured" + e); 
		        } 
		}
	}
	/**
	 * sort alphabetizes the Inventory List 
	 * @return sorted Inventory List
	 */
	public static String sort()
	{
		stock.alphabetSortName();
		return (stock.toString());
	}
	/**
	 * neededAmount determines the how much of the product is needed in order for it to be sold
	 * @return the amount of product needed 
	 */
	public static int neededAmount()
	{
		if (sizeAsked.equals("s"))
		{
			needAmount = 100 * quantityAsked;
		}
		else if (sizeAsked.equals("m"))
		{
			needAmount = 200 * quantityAsked; 
		}
		else
		{
			needAmount = 300 * quantityAsked; 
		}
		return needAmount; 
	}
	/**
	 * hourProcess adds orders to the time array 
	 */
	public static void hourProcess()
	{
		switch (hourPurchased)
			{
				case 12:
					time[0]+= time[0] + quantityAsked;
				case 1:
					time[1]+= time[1] + quantityAsked;
				case 2:
					time[2]+= time[2] + quantityAsked;
				case 3:
					time[3]+= time[3] + quantityAsked;
				case 4:
					time[4]+= time[4] + quantityAsked;
				case 5:
					time[5]+= time[5] + quantityAsked;
				case 6:
					time[6]+= time[6] + quantityAsked;
				case 7:
					time[7]+= time[7] + quantityAsked;
				case 8:
					time[8]+= time[8] + quantityAsked;
				case 9:
					time[9]+= time[9] + quantityAsked;
				case 10:
					time[10]+= time[10] + quantityAsked;
			}
	}
}