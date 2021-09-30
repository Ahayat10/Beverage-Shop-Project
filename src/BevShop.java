/**
 * @author Amna Hayat
 */
import java.util.ArrayList;
public class BevShop implements BevShopInterfce {

	private int numAlcDrinks;
	private ArrayList<Order> orders = new ArrayList<>();
	
	/**
	 * Checks if the time is valid (between 8 and 23 )
	 * @param time time represents the time 
	 * @return true if times is within the range of 8 to 23 , false otherwise
	 */
	@Override
	public boolean validTime(int time) {
		if (time >=MIN_TIME && time <=MAX_TIME)
			return true;
		
		return false;
	}

	/**
	 * checks if the number of alcohol beverages for the current order has reached the maximum
	 * @return true if number of alcohol drinks for the current order has reached the maximum , false otherwise
	 */
	@Override
	public boolean eligibleForMore() {
		
		if(numAlcDrinks >= MAX_ORDER_FOR_ALCOHOL)
		{
			return false;
		}
		
		return true;
	}

	/**
	 * check the valid age for the alcohol drink
	 * @param age the age  
	 * @return returns true if age is more than minimum eligible age , false otherwise  
	 */
	@Override
	public boolean validAge(int age) {
		
		if(age > MIN_AGE_FOR_ALCOHOL)
		{
			return true;
		}
		
		return false;
	}

	/**
	  * Creates a new order ,  NO BEVERAGE is added to the order yet 
	  * @param time time of the order  
	  * @param day day of the order of type DAY
	  * @param customerName customer name 
	  * @param customerAge customer age
	  */
	@Override
	public void startNewOrder(int time, DAY day, String customerName, int customerAge) {
		numAlcDrinks = 0;
		Customer c = new Customer(customerName , customerAge);
		Order o = new Order (time, day, c);
		orders.add(o);
	}

	/**
	 * process the Coffee order for the current order by adding it to the current order
	 * @param bevName beverage name
	 * @param size beverage size
	 * @param extraShot true if the coffee beverage has extra shot , false otherwise
	 * @param extraSyrup true if the coffee beverage has extra syrup , false otherwise
	 */
	@Override
	public void processCoffeeOrder(String bevName, SIZE size, boolean extraShot, boolean extraSyrup) {
		getCurrentOrder().addNewBeverage(bevName, size, extraShot, extraSyrup);
	}

	/**
	 * process the Alcohol order for the current order by adding it to the current order
	 * @param bevName beverage name
	 * @param size beverage size
	 */
	@Override
	public void processAlcoholOrder(String bevName, SIZE size) {
		getCurrentOrder().addNewBeverage(bevName, size);
		numAlcDrinks++;
		
	}

	/**
	 * process the Smoothie order for the current order  by adding it to the current order
	 * @param bevName beverage name
	 * @param size beverage size
	 * @param numOfFruits number of fruits to be added 
	 * @param addProtien true if protein is added , false otherwise
	 */
	@Override
	public void processSmoothieOrder(String bevName, SIZE size, int numOfFruits, boolean addProtien) {
		getCurrentOrder().addNewBeverage(bevName, size, numOfFruits, addProtien);
		
	}

	/**
	 * locate an order based on  the order number
	 * @param orderNo the order number
	 * @return the index of the order in the list of Orders  if found or -1 if not found
	 */
	@Override
	public int findOrder(int orderNo) {
		for(int i =0; i<orders.size();i++)
		{
			
			if (orders.get(i).getOrderNo() == orderNo)
			{
				return i;
			}
			
		}
		return -1;
	}

	/**
	 * locates an order in the list of orders and returns the total value on the order.
	 * @param orderNo the order number
	 * @return the calculated price on this order.
	 */
	@Override
	public double totalOrderPrice(int orderNo) {
		return orders.get(findOrder(orderNo)).calcOrderTotal();
	}

	/**
	 *  Calculates the total sale of all the orders for this beverage shop
	 *  @return the total sale of all the orders 
	 */
	@Override
	public double totalMonthlySale() {
		double total = 0;
		
		for(int i = 0; i<orders.size(); i++)
		{
			total += orders.get(i).calcOrderTotal();
		}
		
		return total;
	}

	/**
	 * sorts the orders within this bevShop using the Selection
	 * sort algorithm
	 */
	@Override
	public void sortOrders() {
		
		for(int i = 0; i <orders.size(); i++)
		{
			int minIndex = i;
			int minOrderNum = orders.get(minIndex).getOrderNo();
			
			for(int j = i+1; j <orders.size(); j++)
			{
				
				if(orders.get(j).getOrderNo() < minOrderNum)
				{
					minIndex = j;
				}
				
			}
			
			
			Order temp = orders.get(minIndex); // creates temporary order starting with last order dealt with
			orders.set(minIndex, orders.get(i)); // moves order numbers into order into array list
			orders.set(i, temp); // sets array list current index with order from previous search
			
			
		}
		
	}

	/**
	 * returns Order in the list of orders at the index
	 * Notes: this method returns the shallow copy of the order
	 * @return Order in the list of orders at the index 
	 */
	@Override
	public Order getOrderAtIndex(int index) {
		return orders.get(index);
	}
	
	public int totalNumOfMonthlyOrders() {
		return orders.size();
	}
	
	public boolean isMaxFruit(int i) {
		if(i > MAX_FRUIT)
			return true;
		
		return false;
	}
	
	public String toString()
	{
		String s = " ";
		for(int i = 0; i<orders.size();i++)
		{
			s+= orders.get(i).toString() + "\n";
		}
		
		s += "\nMonthly Sale: " + totalMonthlySale();
		
		return s;
	}


	/**
	 * setters and getters
	 * @return 
	 */
	public int getNumOfAlcoholDrink() {
		return numAlcDrinks;
	}

	public void setNumOfAlcoholDrink(int numAlcDrinks) {
		this.numAlcDrinks = numAlcDrinks;
	}

	public ArrayList<Order> getOrders() {
		return orders;
	}

	public void setOrders(ArrayList<Order> orders) {
		this.orders = orders;
	}

	public Order getCurrentOrder() {
		return orders.get(orders.size()-1);
	}

	public int getMaxOrderForAlcohol() {
		return MAX_ORDER_FOR_ALCOHOL;
	}

	public int getMinAgeForAlcohol() {
		
		return MIN_AGE_FOR_ALCOHOL;
	}
	

}
