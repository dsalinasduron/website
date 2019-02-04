/**
 * LinkedList.java
 * 
 * Implementation of List interface using a linked list.
 * 
 * @author Greg Gagne - February 2017
 *
 */

public class LinkedList implements List
{
    // reference to the head of the linked list
    private Node head;

    public LinkedList() {
        head = null;
    }

    /** 
     * Inner class representing a node in the linked list
     */

    private class Node
    {
        private Object data;
        private Node next;

        private Node(Object data) {
            this(data,null);
        }

        private Node (Object data, Node next) {
            this.data = data;
            this.next = next;
        }
    }

    // Methods

    /**
     * Adds an item to the linked list
     * This implementation adds to the beginning of the list.
     */
    public void add(Object item) {
        Node newNode = new Node(item);

        newNode.next = head;

        head = newNode;
    }

    /**
     * Removes the selected item from the list.
     */
    public void remove (Object item) {
    	// get a reference to the item we want to delete
        Node reference = getReferenceTo(item);

        if (reference != null) {
            /**
             * set the data of the node we want
             * to delete to the data currently
             * at the head.
             */
            reference.data = head.data;

            /**
             * now remove the head
             */
            head = head.next;
        }
    }

    /**
     * Returns the number of items in the linked list.
     */
    public int getLength() {
        return 0;
    }

    /**
     * Returns a boolean value indicating if the item
     * is contained in the list.
     */
    public boolean contains(Object item) {
    	return false;
    }

    /**
     * Returns a boolean value indicating if the 
     * list is empty or not.
     */
    public boolean isEmpty() {
        return false;
    }

    /**
     * Returns the frequency count of the item
     * in the list.
     */
    public int getFrequency(Object item) {
        return 0;
    }

    /**
     * Returns a reference to item.
     *
     * If items does not exist, returns null
     */
    private Node getReferenceTo(Object item) {
        Node reference = null;
        Node current = head;

        /**
         * We loop until we either:
         * 
         * (1) find the reference to item (reference != null) or
         * (2) do not find item and reach the end of the list (current == null).
         */
        while ( (current != null) && (reference == null) ) {
            if ( (current.data).equals(item) ) {
                reference = current;
            }
            current = current.next;
        }

        return reference;
    }

}

