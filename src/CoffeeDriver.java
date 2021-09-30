
public class CoffeeDriver {

	public static void main(String[] args) {
		
		Coffee c = new Coffee("jack" , SIZE.LARGE , true , true);
		Coffee c1 = new Coffee("jack" , SIZE.MEDIUM , true , true);
		
		if(c.equals(c1))
		{
			System.out.println("They are the same");
		}
		else 
			System.out.println("They are NOT the same");
		
		System.out.println(c.toString());
		System.out.println(c1.toString());
		
		double price = c.calcPrice();
		System.out.println(price);
		

	}

}
