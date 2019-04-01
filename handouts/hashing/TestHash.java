import java.util.*;

public class TestHash
{
	public static void main(String[] args) {
		HashPerson william = new HashPerson("Willy");
		HashPerson bill = new HashPerson("Willy");

		/**
		 * what hashCode() returns
		 */
		System.out.println("Hash code for william = " + william.hashCode());
		System.out.println("Hash code for bill = " + bill.hashCode());

		/**
		 * map key william to "Son"
		 */
		Map<HashPerson, String> table = new HashMap<HashPerson, String>();
		table.put(william,"Son");

		if (table.containsKey(william )) 
			System.out.println("Key william " + " is mapped to " + table.get(william));
		else
			System.out.println("Key " + william + " not found");

		/**
		 * now look for the same key
		 */
		if (table.containsKey(bill)) 
			System.out.println("Key bill " + " is mapped to " + table.get(bill));
                else
                        System.out.println("Key bill " + " not found");
	}
}
