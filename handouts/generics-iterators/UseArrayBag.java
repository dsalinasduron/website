/**
 * Demo program of how to use an ArrayBag
 */

import java.util.Iterator;

public class UseArrayBag
{
    public static void main(String[] args) {
        Bag<String> bag = new ArrayBag<String>();

        Iterator<String> itr = bag.iterator();

        while (itr.hasNext())
            System.out.println(itr.next());

        bag.add("Mellow");
        bag.add("Yellow");
        bag.add("Frown");
        bag.add("Brown");
        bag.add("Lean");
        bag.add("Green");

        while (itr.hasNext())
            System.out.println(itr.next());

        itr.remove();

    }
}
