
public class AlcoholDriver {

	public static void main(String[] args) {
		Alcohol a = new Alcohol("Alc1" , SIZE.MEDIUM, true);
		
		double price = a.calcPrice();
		System.out.println(price);
		System.out.println(a.toString());
		
		Alcohol a1 = new Alcohol("Alc1" , SIZE.MEDIUM, true);
		
		if(a.equals(a1))
		{
			System.out.println("They are the same");
		}
		else 
			System.out.println("They are NOT the same");
		
		Alcohol a2 = new Alcohol("Alc1" , SIZE.MEDIUM, false);
		
		if(a.equals(a2))
		{
			System.out.println("They are the same");
		}
		else 
			System.out.println("They are NOT the same");

	}

}
