/**
 * 
 * @author Amna Hayat
 *
 */
public abstract class Beverage {
	private String bevName; //name of beverage
	private TYPE bevType; // type of beverage
	private SIZE bevSize; //size of beverage
	private final double BASE_PRICE = 2.00; // starting price of beverage 
	private final double SIZE_PRICE = 1.00; // increasing price for beverage by each increase in size
	
	/**
	 * 
	 * @param bevName name of beverage
	 * @param bevType type of beverage
	 * @param bevSize size of beverage
	 * Parameterized constructor
	 */
	public Beverage(String bevName, TYPE bevType, SIZE bevSize)
	{
		this.bevName = bevName;
		this.bevType = bevType;
		this.bevSize = bevSize;
	}
	
	/**
	 * @return price of beverage
	 * abstract method 
	 */
	public abstract double calcPrice();
	
	/**
	 * returns string of beverage name and size
	 */
	@Override
	public String toString()
	{
		return "Beverage Name: " + bevName + " \nBeverage Size: " + bevSize;
	}
	
	/**
	 * 
	 * @param b beverage object
	 * @return true if equal, false if not
	 * checks to see if two beverages are equal
	 */
	public boolean equals (Beverage b)
	{
		if(bevName.equals(b.bevName) && bevType == b.getType() && bevSize == b.getSize())
		{
			return true;
		}
		
		else return false;
	}
	/*
	 * setters and getters
	 */
	public double getBasePrice() {
		return BASE_PRICE;
	}

	public double getSizePrice() {
		return SIZE_PRICE;
	}

	public String getBevName() {
		return bevName;
	}

	public void setName(String bevName) {
		this.bevName = bevName;
	}

	public TYPE getType() {
		return bevType;
	}

	public void setType(TYPE bevType) {
		this.bevType = bevType;
	}

	public SIZE getSize() {
		return bevSize;
	}

	public void setBevSize(SIZE bevSize) {
		this.bevSize = bevSize;
	}

	
}
