import bridges.connect.Bridges;
import bridges.base.BinTreeElement;

import java.util.Iterator;

public class BinaryTreeExample {

	public static void main(String[] args) {
		//create the Bridges object
		// Use YOUR API Sha1 key and username
		Bridges<String, String> bridge = new Bridges<>(3, "29345546555", "ggagne");

		// create elements
		// First parameter is String depicted when using mouseover with bridges animation
		// Second parameter is data object stored at that tree element
		BinTreeElement<String> root = new BinTreeElement<String>("M", "Mango");

		BinaryTree<String> tree = new BinaryTree<String>(root);

		BinTreeElement<String> dTree = new BinTreeElement<String>("D", "Donut");
		BinTreeElement<String> gTree = new BinTreeElement<String>("G", "Grape");
		BinTreeElement<String> lTree = new BinTreeElement<String>("L", "Lettuce");
		BinTreeElement<String> tTree = new BinTreeElement<String>("T", "Tea");
		BinTreeElement<String> fTree = new BinTreeElement<String>("F", "Fig");
		BinTreeElement<String> hTree = new BinTreeElement<String>("H", "Honey");
		BinTreeElement<String> rTree = new BinTreeElement<String>("R", "Ramen");
		BinTreeElement<String> qTree = new BinTreeElement<String>("Q","Quinoa");

		//link elements
		hTree.setLeft(gTree);
		hTree.setRight(lTree);

		rTree.setRight(tTree);
		
		dTree.setRight(qTree);

		fTree.setLeft(dTree);
		fTree.setRight(hTree);

		root.setLeft(fTree);
		root.setRight(rTree);
		
		tree.printLevels();
		
		System.out.println("left most data is: " + tree.getLeftMostData());
		
		System.out.println("right most data is: " + tree.getRightMostData());
		
		//System.out.println("removing left most data is: " + tree.removeLeftMostNode());
		
		//System.out.println("removing right most data is: " + tree.removeRightMostNode());
		
		System.out.println("height = " + tree.getHeight());
		
		System.out.println("size = " + tree.getSize());

		//pass root element of data structure
		bridge.setDataStructure(root);

		//visualize data structure
		bridge.visualize();
		
		System.out.println("iterator = ");
		Iterator<String> itr = tree.getPreOrderIterator();
		
		while (itr.hasNext()) {
			System.out.println(itr.next());
		}
	}

}
