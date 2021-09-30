
public class OrderDriver {

	public static void main(String[] args) {
		Customer c = new Customer ("jake" , 20);
		Customer c1 = new Customer("Ann", 15);
		
		Order o = new Order(12, DAY.MONDAY, c);
		Order o1 = new Order(1,DAY.THURSDAY,c1);

		
		o.addNewBeverage("ALC", SIZE.MEDIUM);
		o.addNewBeverage("COFF", SIZE.SMALL, false, true);
		o1.addNewBeverage("COFFEE", SIZE.LARGE, true, true);
		o1.addNewBeverage("SMOOTHIE", SIZE.MEDIUM, 2, true);
		
		System.out.println(o.getBeverage(0));
		System.out.println(o.getBeverage(1));
		
		if(o.compareTo(o) == 0)
		{
			System.out.println("SAME ORDER");
		}
		else if(o.compareTo(o) == 1 )
		{
			System.out.println("Order number is greater");
		}
		else
			System.out.println("Order number is less");
		
		
		if(o.compareTo(o1) == 0)
		{
			System.out.println("SAME ORDER");
		}
		else if(o.compareTo(o) == 1 )
		{
			System.out.println("Order number is greater");
		}
		else
			System.out.println("Order number is less");
		
		System.out.println();
		System.out.println(o.toString());
		
		System.out.println();
		System.out.println(o1.toString());
			
	
	}

}
