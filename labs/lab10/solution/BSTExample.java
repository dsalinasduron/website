/**
 * Demo program of the binary search tree
 * 
 */
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import bridges.connect.Bridges;

public class BSTExample {
	public static void main(String[] args) {
		//create the Bridges object
		// Use YOUR API Sha1 key and username
		Bridges<String, String> bridges = new Bridges<>(4, "281675598135", "ggagne");
		
		//Create elements and insert them into the tree
		BinarySearchTree<Integer> tree = new BinarySearchTree<Integer>();
		
		
		List<Integer> list = new ArrayList<Integer>();
		
		list.add(50);
		list.add(75);
		list.add(20);
		list.add(10);
		list.add(30);
		list.add(5);
		list.add(15);
		list.add(25);
		list.add(35);
		list.add(3);
		list.add(8);
		list.add(13);
		list.add(28);
		list.add(33);
		list.add(38);
		list.add(85);
		list.add(95);
		
		// iterate through the list and insert the
		// elements into the tree
		Iterator<Integer> itr = list.iterator();
		
		while (itr.hasNext()) {
			tree.add(itr.next());
		}
		
		// Now perform some operations on the tree
		// i.e. isEmpty(), size(), iterator(), contains(), remove(), 
		
		// #1 - isEmpty()
		System.out.println("False: " + tree.isEmpty());
		
		// #2 size()
		System.out.println("17: " + tree.size());
		
		// #3 contains()
		System.out.println("True: " + tree.contains(10));
		
		System.out.println("False: " + tree.contains(22));
		
		// #4 - getLargest()
		tree.getLargest();
		
		// #5 getSmallest();
		tree.getSmallest();

		// #6 - iterator()
		itr = tree.iterator();
		
		System.out.print("inorder traversal: ");
		while (itr.hasNext()) {
			System.out.print(itr.next() + ", ");
		}
		
		System.out.println();
		
		// #7 - remove()
		tree.remove(20);
		System.out.println("16: " + tree.size());
				
		
		// visualize the tree
		bridges.setDataStructure(tree.getRoot());
		
		bridges.visualize();
		
	}

}
