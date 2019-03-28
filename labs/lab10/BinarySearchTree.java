/**
 * Binary search tree implementation.
 * 
 * We do not allow duplicates.
 * 
 * @author Greg Gagne
 */
import java.util.Iterator;
import java.awt.*;
import java.awt.geom.*;
import javax.swing.*;
import java.util.List;


public class BinarySearchTree <K extends Comparable<? super K>> implements SearchTreeInterface<K> 
{
	class Node {
		K content;
		Node leftChild;
		Node rightChild;
		public Node(K content) {
			this.content = content;
		}
	}
	Node root;
	
	/**
	 * Create an empty binary search tree
	 */
	public BinarySearchTree() {
		root = null;
	}

	public boolean isEmpty() {
		/* TO BE COMPLETED */
		return root == null;
	}

	/**
	 * Solution that uses recursive helper method.
	 * We disallow duplicate elements in the tree. 
	 */
	public K add(K key) {
		if (contains(key))
			return null;
		else {
			root = add(key, root);
			return key;
		}
	}
	
	/* Return a new tree if tree == null; return input tree otherwise */
	private Node add(K key, Node tree) {
		if(tree == null) {
			return new Node(key);
		}
		else {
			if (tree.content.compareTo(key) > 0) {
				tree.leftChild = add(key, tree.leftChild);
			}
			else {
				tree.rightChild = add(key, tree.rightChild);
			}
			return tree;
		}
	}

	public K getLargest() {
		/* TO BE COMPLETED */

		return null;
	}

	public K getSmallest() {
		/* TO BE COMPLETED */

		return null;
	}

	public boolean contains(K key) {		
		/* TO BE COMPLETED */

		return false;
	}

	public K remove(K key) {
		/* TO BE COMPLETED */

		return null;
	}

	public int size() {
		/* TO BE COMPLETED */

		return -1;
	}

	public Iterator<K> iterator() {
		/* TO BE COMPLETED */

		return null;
	}
	public void print() {
		printHelper(root);
	}
	private void printHelper(Node n) {
		if(n != null) {
			printHelper(n.leftChild);
			System.out.println(n.content);
			printHelper(n.rightChild);
		}
	}
	public void draw() {
		TreeGraph tg = new TreeGraph();
		tg.draw();
	}

	private class TreeGraph extends JPanel {
		int nodeSize = 30;
		int currentX = 0;
		int frameX = 500;
		int frameY = 500;

		public void draw() {
			JFrame f = new JFrame();
			f.setSize(frameX,frameY);
			f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			f.add(this);
			f.setVisible(true);
		}
		public void paint(Graphics g) {
			drawNode(g,root,0);
		}
		public int drawNode(Graphics g, Node n, int parentY) {
			if (n == null) return 0;
			int myNodeY = parentY + nodeSize * 2; int sourceY = myNodeY +  nodeSize;
			int childY =  myNodeY + nodeSize * 2;
			
			// draw left node first
			int leftX = drawNode(g,n.leftChild,myNodeY);
			int myX = currentX; int sourceX = myX + nodeSize / 2;
			if(n.leftChild != null)  g.drawLine(sourceX,sourceY,leftX + nodeSize/2,childY); 

			// actually draw the node
			g.drawOval(myX, myNodeY, nodeSize, nodeSize);
			g.drawString(n.content.toString(), myX + 10, myNodeY + nodeSize/2 + 4);
			currentX += nodeSize * 2;

			// draw  the right child
			int rightX = drawNode(g,n.rightChild,myNodeY);
			if(n.rightChild != null) g.drawLine(sourceX,sourceY,rightX + nodeSize/2,childY);
			return  myX ;
		}
	}
}
