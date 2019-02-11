import java.util.*;

public class UseIteratorV2
{
    public static void main(String[] args) {
    List<String> list = new Vector<String>();

    list.add("Apples");
    list.add("Bananas");
    list.add("Cherries");
    list.add("Dates");
    list.add("Dates");

    Iterator<String> itr = list.iterator();

    while (itr.hasNext())
        System.out.println(itr.next());

    }
}

