public class SinglyLinkedDeque<ItemType> implements Deque<ItemType> {
    // private helper classes
    private class Node {
        ItemType data;
        Node next;
    }

    // fields
    private Node head;
    private int size;

    /**
     * Constructor: creates an empty deque of size 0
     */
    public SinglyLinkedDeque() {
        head = null;
        size = 0;
    }

    /**
     * Return the number of items in the deque
     *
     * @return number of items in the deque
     */
    @Override
    public int size() {
        return size;
    }

    /**
     * Adds an item to the front of the deque.
     *
     * @param item item to be added
     */
    @Override
    public void addFirst(ItemType item) {
        // consider the case of adding to an empty list
        // consider the case of adding to a non-empty list
        if(size == 0){
            //creating the new node, setting fields
            Node newNode = new Node();
            newNode.data = item;
            newNode.next = null;
            //assigning the new node to the head
            head = newNode;
        }else{
            Node newNode = new Node();
            //set data
            newNode.data = item;
            //point new node's next to current head
            //so the data doesn't get deleted
            newNode.next = head;
            //make newNode the new head
            head = newNode;

        }
    }

    /**
     * Adds an item to the back of the deque.
     *
     * @param item item to be added
     */
    @Override
    public void addLast(ItemType item) {
        // consider the case of adding to an empty list
        // consider the case of adding to a non-empty list
        //if the list is empty, same process as addFirst
        if(size==0){
            //creating the new node, setting fields
            Node newNode = new Node();
            newNode.data = item;
            newNode.next = null;
            //assigning the new node to the head
            head = newNode;
        }else{
            //make a temp variable to parse through the list
            Node current = head;
            //iterate through the list to get to the end
            while(current.next != null) {
                current = current.next;
            }
            //current = end of list
            //create new node
            Node newNode = new Node();
            newNode.data = item;
            newNode.next = null;
            //make current point to new node
            current.next = newNode;
        }
    }

    /**
     * Remove and return the item from the front, does nothing if empty.
     *
     * @return item at the front that was just removed, or null if empty
     */
    @Override
    public ItemType removeFirst() {
        // check if empty
        // if empty: do nothing and return null
        if(size == 0){
            return null;
        }
        // if there's only one item: is this a special case?
        //if there's only one item, head needs to be removed
        else if(size == 1){
            Node temp = head;
            head = null;
            return temp.data;
        }else{
            Node temp = head;
            //point head to node after head to lose head
            head = head.next;
            return temp.data;
        }
        // if not empty:
        // 0. figure out a way to access the item in the front
        // 1. make a variable to save a copy of the item at the front
        // 2. remove the item at the front
        // 3. return the variable that has the saved copy of the item at the front
    }

    /**
     * Remove and return the item from the back, does nothing if empty.
     *
     * @return item at the back that was just removed, or null if empty
     */
    @Override
    public ItemType removeLast() {
        // check if empty
        // if empty: do nothing and return null
        if(size == 0){
            return null;
        }
        // if there is only one item: is this a special case?
        //same as remove first
        else if(size == 1){
            removeFirst();
        }
        else{
            Node current = head;
            //unfinished!
            return null;

        }
        // if not empty, has more than one item:
        // 0. figure out a way to access the item in the back
        // 1. make a variable to save a copy of the item at the back
        // 2. remove the item at the back
        // 3. return the variable that has the saved copy of the item at the back

        return null;
    }

}
