/**
 * Binary search tree implementation.
 * 
 * We do not allow duplicates.
 * 
 * @author Greg Gagne
 */
import java.util.Iterator;

import bridges.base.BSTElement;

public class BinarySearchTree <K extends Comparable<? super K>> implements SearchTreeInterface<K> 
{
	// the root of the binary search tree
	private BSTElement<K, String> root;

	/**
	 * Create an empty binary search tree
	 */
	public BinarySearchTree() {
		root = null;
	}

	/**
	 * This method has nothing to do with a binary search tree,
	 * but is necessary to provide the bridges visualization.
	 */
	public BSTElement<K, String> getRoot() {
		return root;
	}

	public boolean isEmpty() {
		return root == null;
	}

	/**
	 * Solution that uses recursive helper method.
	 * We disallow duplicate elements in the tree. 
	 */
	public K add(K item) {
		if (contains(item))
			return null;
		else {
			root = add(item, root);

			return item;
		}
	}

	/**
	 * private helper method for adding a node to the binary search tree
	 * @param key
	 * @param subtree
	 * @return the root of the tree
	 */
	private BSTElement<K, String> add(K key, BSTElement<K,String> subtree) {
		if (subtree == null) {
			// we have found the spot for the addition

			// create the new node
			// parameters are (1) label (2) key (3) null [not used]
			return new BSTElement<K, String>(key.toString(), key, "");
		}

		int direction = key.compareTo(subtree.getKey());

		if (direction < 0) {
			subtree.setLeft( add(key, subtree.getLeft()) );
		}
		else if (direction > 0) {
			subtree.setRight( add(key, subtree.getRight()) );
		}

		return subtree;
	}

	/**
	 * Non-recursive algorithm for addition
	 * This only serves the purpose of demonstrating how the
	 * recursive approach provides a much cleaner algorithm!
	 */
	/*
	public K add(K key) {
		// we disallow duplicates
		if (contains(key))
			return null;

		// create the new node
		// parameters are (1) label (2) key (3) null [not used]
		BSTElement<K, String> newNode = new BSTElement<K, String>(key.toString(), key, "");
		newNode.getVisualizer().setColor("red");

		// if the tree is empty, set the root to the new node
		if (isEmpty()) {
			root = newNode;
		}
		else {
			// else treat it like an unsuccessful search
			BSTElement<K, String> node = root;
			boolean keepLooking = true;

			while (keepLooking) {
				int direction = key.compareTo(node.getKey());
				
				if (direction < 0) {
					// go left
					if (node.getLeft() == null) {
						// we found the place for the insert
						node.setLeft(newNode);
						keepLooking = false;
					}
					else
						node = node.getLeft();
				}
				else if (direction > 0) {
					// go right
					if (node.getRight() == null) {
						// we found the place for the insert
						node.setRight(newNode);
						keepLooking = false;
					}
					else
						node = node.getRight();
				}
			}
		}

		return key;
	}
	*/


	public boolean contains(K key) {		
		/* TO BE COMPLETED */

		return contains(key, root);

	}

	private boolean contains(K key, BSTElement<K,String> subtree) {

		if (subtree == null)
			return false;
		else {
			// get the direction
			int direction = key.compareTo(subtree.getKey());

			if (direction < 0) {
				// go left
				return contains(key, subtree.getLeft());
			}
			else if (direction > 0) {
				// go right
				return contains(key, subtree.getRight());
			}
			else {
				// we found it!

				// to visualize this, set the color to red
				subtree.getVisualizer().setColor("pink");

				return true;
			}
		}
	}

	public K remove(K key) {

		root = remove(key, root);

		if (root != null)
			return key;
		else
			return null;
	}

	private BSTElement<K, String> remove(K key, BSTElement<K,String> subtree)  {
		if (subtree == null) {
			return null; // item not found
		}
		else {
			// get the direction
			int direction = key.compareTo(subtree.getKey());
			
			if (direction < 0) {
				// go left
				BSTElement<K, String> newLeft = remove(key, subtree.getLeft());
				
				subtree.setLeft(newLeft);
			}
			else if (direction > 0) {
				// go right
				BSTElement<K, String> newRight = remove(key, subtree.getRight());
				
				subtree.setRight(newRight);
			}
			else if (subtree.getLeft() != null && subtree.getRight() != null) {
				// two children
				
				// get leftmost node of the right subtree
				BSTElement<K, String> successor = getLeftMost(subtree.getRight());
				
				// successor is the leftmost node of the right subtree
				// get the value and the label of successor
				K newKey = successor.getKey();
				String label = successor.getLabel();
				
				subtree.setKey(newKey);
				subtree.setLabel(label);
				
				// now remove the leftmost child
				
				BSTElement<K, String> newRight = remove(newKey, subtree.getRight());
				subtree.setRight(newRight);
			}
			else {
				// 1 or 0 children
				
				if (subtree.getLeft() != null) {
					// we only have a left child
					subtree = subtree.getLeft();
				}
				else {
					// we only have a right child
					subtree = subtree.getRight();
				}
			}
		}
		
		return subtree;
	}
	
	private BSTElement<K, String> getLeftMost(BSTElement<K, String> subtree) {
		if (subtree.getLeft() == null)
			return subtree;
		else
			return getLeftMost(subtree.getLeft());
	}

	public K getLargest() {
		if (root != null)
			return getLargest(root);
		else
			return null;
	}
	
	private K getLargest(BSTElement<K,String> subtree) {
		// keep going right until there is no right child
		if (subtree.getRight() == null) {
			subtree.getVisualizer().setColor("red");
			return subtree.getKey();
		}
		else { 
		}
			return getLargest(subtree.getRight());
	}

	public K getSmallest() {
		if (root != null)
			return getSmallest(root);
		else
			return null;
	}
	
	private K getSmallest(BSTElement<K,String> subtree) {
		// keep going left until there is no left child
		if (subtree.getLeft() == null) {
			subtree.getVisualizer().setColor("yellow");
			return subtree.getKey();
		}
		else { 
		}
			return getSmallest(subtree.getLeft());
	}

	public int size() {
		/* TO BE COMPLETED */

		return size(root);
	}
	
	private int size(BSTElement<K, String> subtree) {
		if (subtree == null)
			return 0;
		else
			return 1 + size(subtree.getLeft()) + size(subtree.getRight());
	}
	
	public Iterator<K> iterator() {
		/* TO BE COMPLETED */

		return new InOrderIterator();
	}
	
	private class InOrderIterator implements Iterator<K>
	{
		private K[] elements;
		private int next;

		@SuppressWarnings("unchecked")
		private InOrderIterator() {
			// create an array large enough to hold all elements in the tree
			elements = (K[])new Comparable[size()];
			next = 0;

			// now perform an preorder traversal
			inOrder(root);

            // reset next back to the beginning of the array
			next = 0;
		}

		private void inOrder(BSTElement<K, String> node) {
			if (node != null) {
				inOrder(node.getLeft());
				elements[next++] = node.getKey();
				inOrder(node.getRight());
			}
		}

		public boolean hasNext() {
			return (next < size());
		}

        public K next() {
			return elements[next++];
		}
	}
	
}
