import bridges.base.BinTreeElement;
import java.util.Iterator;

public class BinaryTree<T>  {
	// the root of the binary tree
	private BinTreeElement<T> root;
	
	public BinaryTree(BinTreeElement<T> root) {
		this.root = root;
	}
	
	public int getHeight() {
		return getHeightHelper(root);
	}
	
	private int getHeightHelper(BinTreeElement<T> root) {
		if (root == null)
			return -1;
		
		int left = getHeightHelper(root.getLeft());
		int right = getHeightHelper(root.getRight());
		
		if (left > right)
			return 1 + left;
		else
			return 1 + right;
	}
	
	public int getSize() {
		return getSizeHelper(root);
	}
	
	private int getSizeHelper(BinTreeElement<T> node) {
		if (node == null)
			return 0;
		else {
			return 1 + getSizeHelper(node.getLeft()) + getSizeHelper(node.getRight());
		}
	}
	
	/**
	 * prints out the level that each node appears.
	 * also sets the color of each node to yellow
	 */
	public void printLevels() {
		/**
		 * We start at the root and do an inorder traversal
		 */
		printLevelHelper(root,0);
	}
	
	/**
	 * Helper method to print the levels
	 * @param node
	 * @param level
	 */
	private void printLevelHelper(BinTreeElement<T> node, int level) {
		if (node != null) {
			printLevelHelper(node.getLeft(), level + 1);
			//System.out.println(node.getValue()); // i.e. "visit"
			
			// now set the node to yellow as well as set the label to the level
			node.getVisualizer().setColor("yellow");
			node.setLabel(level + "");

			printLevelHelper(node.getRight(), level + 1);
		}
	}
	
	/**
	 * Highlights the left most node to green and
	 * returns the value associated with the node.
	 * @return
	 */
	public T getLeftMostData() {
		if (root == null)
			return null;
		else
			return getLeftMostHelper(root);
	}
	
	/**
	 * Helper method to get the value and highlight the
	 * node to green.
	 * @param node
	 * @return
	 */
	private T getLeftMostHelper(BinTreeElement<T> node) {
		if (node.getLeft() == null) {
			// visualize the node to the color green
			node.getVisualizer().setColor("green");
			// node is the left-most child in the tree
			return node.getValue();
		}
		else {
			// continue going left
			return getLeftMostHelper(node.getLeft());
		}
	}
	
	/**
	 * Removes and returns the left most node in the tree
	 * @return
	 */
	public T removeLeftMostNode() {
		if (root == null)
			return null;
		else if (root.getLeft() == null) {
			// special case - the root is the left most node
			
			T data = root.getValue();
			
			root = root.getRight();
			
			return data;
		}
		else {
			// call helper method
			return removeLeftMostNodeHelper(root);
		}
	}
	
	/**
	 * Private helper method to remove the left most node in the tree
	 * @param node
	 * @return
	 */
	private T removeLeftMostNodeHelper(BinTreeElement<T> node) {
		if ((node.getLeft()).getLeft() == null) {
			// node is the parent whose reference must be adjusted
			
			// node.getLeft() is a reference to the left-most node
			
			// retrieve the value
			T data = node.getLeft().getValue();
			
			// we must adjust the left child of node so that it
			// now refers to the right child of the node being deleted
			node.setLeft((node.getLeft()).getRight());
		
			return data;
		}
		else {
			// continue going left
			return removeLeftMostNodeHelper(node.getLeft());
		}
	}
	
	/**
	 * Highlights the left most node to green and
	 * returns the value associated with the node.
	 * @return
	 */
	public T getRightMostData() {
		if (root == null)
			return null;
		else
			return getRightMostHelper(root);
	}
	
	/**
	 * Helper method to get the value and highlight the
	 * node to green.
	 * @param node
	 * @return
	 */
	private T getRightMostHelper(BinTreeElement<T> node) {
		if (node.getRight() == null) {
			// visualize the node to the color green
			node.getVisualizer().setColor("pink");
			// node is the right-most child in the tree
			return node.getValue();
		}
		else {
			// continue going right
			return getRightMostHelper(node.getRight());
		}
	}
	
	/**
	 * Removes and returns the left most node in the tree
	 * @return
	 */
	public T removeRightMostNode() {
		if (root == null)
			return null;
		else if (root.getRight() == null) {
			// special case - the root is the right most node
			
			T data = root.getValue();
			
			root = root.getLeft();
			
			return data;
		}
		else {
			// call helper method
			return removeRightMostNodeHelper(root);
		}
	}
	
	/**
	 * Private helper method to remove the left most node in the tree
	 * @param node
	 * @return
	 */
	private T removeRightMostNodeHelper(BinTreeElement<T> node) {
		if ((node.getRight()).getRight() == null) {
			// node is the parent whose reference must be adjusted
			
			// node.getRight() is a reference to the right-most node
			
			// retrieve the value
			T data = node.getRight().getValue();
			
			// we must adjust the right child of node so that it
			// now refers to the left child of the node being deleted
			node.setRight((node.getRight()).getLeft());
		
			return data;
		}
		else {
			// continue going left
			return removeRightMostNodeHelper(node.getRight());
		}
	}
	
	public Iterator<T> getPreOrderIterator() {
		return new PreOrderIterator();
	}
	
	public Iterator<T> getInOrderIterator() {
		return new InOrderIterator();
	}
	
	public Iterator<T> getPostOrderIterator() {
		return new PostOrderIterator(); 
	}
	
	private class PreOrderIterator implements Iterator<T>
	{
		private T[] elements;
		private int next;

		@SuppressWarnings("unchecked")
		private PreOrderIterator() {
			// create an array large enough to hold all elements in the tree
			elements = (T[])new Object[getSize()];
			next = 0;

			// now perform an preorder traversal
			preOrder(root);

            // reset next back to the beginning of the array
			next = 0;
		}

		private void preOrder(BinTreeElement<T> node) {
			if (node != null) {
				elements[next++] = node.getValue();
				preOrder(node.getLeft());
				preOrder(node.getRight());
			}
		}

		public boolean hasNext() {
			return (next < getSize());
		}

        public T next() {
			return elements[next++];
		}
	}
	
	private class InOrderIterator implements Iterator<T>
	{
		private T[] elements;
		private int next;

		@SuppressWarnings("unchecked")
		private InOrderIterator() {
			// create an array large enough to hold all elements in the tree
			elements = (T[])new Object[getSize()];
			next = 0;

			// now perform an inorder traversal
			inOrder(root);

            // reset next back to the beginning of the array
			next = 0;
		}

		private void inOrder(BinTreeElement<T> node) {
			if (node != null) {
				inOrder(node.getLeft());
				elements[next++] = node.getValue();
				inOrder(node.getRight());
			}
		}

		public boolean hasNext() {
			return (next < getSize());
		}

        public T next() {
			return elements[next++];
		}
	}
	
	private class PostOrderIterator implements Iterator<T>
	{
		private T[] elements;
		private int next;

		@SuppressWarnings("unchecked")
		private PostOrderIterator() {
			// create an array large enough to hold all elements in the tree
			elements = (T[])new Object[getSize()];
			next = 0;

			// now perform an postorder traversal
			postOrder(root);

            // reset next back to the beginning of the array
			next = 0;
		}

		private void postOrder(BinTreeElement<T> node) {
			if (node != null) {
				postOrder(node.getLeft());
				postOrder(node.getRight());
				elements[next++] = node.getValue();
			}
		}

		public boolean hasNext() {
			return (next < getSize());
		}

        public T next() {
			return elements[next++];
		}
	}
	
}
