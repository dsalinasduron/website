/**
 * Binary search tree implementation.
 * 
 * We do not allow duplicates.
 * 
 * @author Greg Gagne
 */
import java.util.Iterator;


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
}
