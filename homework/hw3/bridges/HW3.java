import bridges.base.SLelement;
import bridges.connect.Bridges;

import java.io.File;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class HW3 {

	public static void main(String[] args) throws java.io.FileNotFoundException {
		Bridges<String, Integer> bridges = new Bridges<>(3, "1452430457579", "ggagne");

		Scanner inFile = new Scanner(new File(args[0]));

		int value = inFile.nextInt();
		SLelement <Integer> head = new SLelement<Integer>(Integer.toString(value), new Integer(value));
		SLelement <Integer> current = head;
		
		while (inFile.hasNext()) {
			value = inFile.nextInt();
			// TO-DO store each coin in a linked list
			SLelement <Integer>next = new SLelement <Integer>(Integer.toString(value), new Integer(value));
			current.setNext(next);
			current = next;
		}

		inFile.close();
		
		// traverse through the list
		current = head;
		
		int i = 0;
		
		while (current != null) {
			System.out.println(current.getValue());
			if (i % 2 == 0) {
				current.getVisualizer().setColor("red");
				current.getVisualizer().setSize(50);
			}
			else
				current.getVisualizer().setColor("blue");
			i++;
			
			current = current.getNext();
		}

		//pass the first element of the list 
		bridges.setDataStructure(head);

		// visualize the list 
		bridges.visualize();
	}

}
