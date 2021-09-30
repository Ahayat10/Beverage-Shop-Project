
public class SmoothieDriver {

	public static void main(String[] args) {
		
		Smoothie s = new Smoothie ("Smoothie1" ,SIZE.MEDIUM , 3 , true);

		double price = s.calcPrice();
		System.out.println(price);
		System.out.println(s.toString());
		
		Smoothie s1 = new Smoothie ("Smoothie1" ,SIZE.MEDIUM , 3 , true);
		
		if(s.equals(s1))
		{
			System.out.println("they are the same");
		}
		else 
			System.out.println("they are NOT the same");
		
		Smoothie s2 = new Smoothie ("Smoothie1" ,SIZE.MEDIUM , 2 , true);
		
		if(s.equals(s2))
		{
			System.out.println("they are the same");
		}
		else 
			System.out.println("they are NOT the same");
		
	}

}
