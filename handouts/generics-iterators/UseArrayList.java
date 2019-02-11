/**
 * Illustration of Java generics
 *
 * @author Greg Gagne - September 2016.
 */

import java.util.List;
import java.util.ArrayList;
import java.text.DecimalFormat;

public class UseArrayList
{
    public static void main(String[] args) {
        DecimalFormat df = new DecimalFormat("0.00");

        List list = new ArrayList();
		
        // The following line is for generics
        //List<Item> list = new ArrayList<Item>();

        // add the items
        Item milk = new Item("Milk", 2, 3.79);
        Item apples = new Item("Apple", 12, 0.50);
        Item bread = new Item("Bread", 2, 2.99);

        list.add(milk);
        list.add(apples);
        list.add(bread);

        // now get the total cost for all items
        Item contents;
        double total = 0;

        for (int i = 0; i < list.size(); i++) {
            /**
             * ArrayList allows the use of an index to retrieve an item
             * Also note we have to typecast what get() returns 
             * to type Item
             */

        	// without generics you need to typecast
            contents = (Item)list.get(i); 
			
            // with generics you do not need to typecast
            //contents = list.get(i); 

            // accumulate total cost
            total += contents.getTotalCost();
        }

        System.out.println("Total cost = $" + df.format(total));
    }
}
