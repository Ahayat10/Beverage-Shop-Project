/**
 * 
 * @author Amna Hayat
 *
 */
public class Alcohol extends Beverage {
	
	private boolean weekend;
	private final double WEEKEND_PRICE = 0.60;
	
	/**
	 * 
	 * @param name name of beverage
	 * @param size size of beverage
	 * @param weekend checks if offered on weekend or not
	 */
	public Alcohol (String name, SIZE size, boolean weekend)
	{
		super(name, TYPE.ALCOHOL, size);
		this.weekend = weekend;
	}

	@Override
	public boolean equals (Beverage b)
	{
		Alcohol a = (Alcohol) b;
		
		if(super.equals(a) && weekend == a.getWeekend())
		{
			return true;
		}
		
		return false;
	}
	
	@Override
	public double calcPrice()
	{
		double price = super.getBasePrice();
		
		if(super.getSize() == SIZE.MEDIUM)
		{
			price += super.getSizePrice();
		}
		
		if(super.getSize() == SIZE.LARGE)
		{
			price += 2 * super.getSizePrice();
		}
		
		if (weekend == true)
		{
			price += WEEKEND_PRICE;
		}
		return price;
	}
	
	@Override
	public String toString()
	{
		String wkend = "";
		
		if(weekend == true)
		{
			wkend = "\nWeekend";
		}
		
		return super.toString() + wkend + "\nPrice: $" + calcPrice();
	}
	
	/*
	 * setters and getters
	 */
	public boolean getWeekend() {
		return weekend;
	}

	public void setWeekend(boolean weekend) {
		this.weekend = weekend;
	}

	public double getWEEKEND_PRICE() {
		return WEEKEND_PRICE;
	}

}
