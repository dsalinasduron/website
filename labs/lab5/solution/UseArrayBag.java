import java.util.Iterator;


public class UseArrayBag {

	public static void main(String[] args) {
		Bag<String> bag =  new ArrayBag<String>();
		String Apple= new String ("Apple");
		String Bannana= new String ("Bannana");
		String Cherry= new String ("Chery");
		String Donut= new String ("Donut");
		String Eggs= new String ("Eggs");

		bag.add(Apple);
		bag.add(Bannana);
		bag.add(Cherry);
		bag.add(Donut);
		bag.add(Eggs);
		
		String contents;

		Iterator<String> itr = bag.iterator();
		while (itr.hasNext()) {
			{
				contents = itr.next(); 
				System.out.println("breakfast is "+contents);	
			}
		}

	}
}
