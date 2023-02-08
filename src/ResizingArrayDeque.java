public class ResizingArrayDeque<ItemType> implements Deque<ItemType> {
    // constants
    public static int DEFAULT_CAPACITY = 10;

    // fields
    private ItemType[] data;
    private int size;

    /**
     * Constructor: creates an empty deque of size 0
     */
    public ResizingArrayDeque() {
        data = (ItemType[])new Object[DEFAULT_CAPACITY];
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

        // There is a private helper method checkSize() defined below to check/resize
        // that you can call as needed to check if the array is full and resize it.

        //if the list is empty, index 0 will be item
        if(size == 0){
            data[0] = item;
        }else{
            //check if array needs to be resized
            checkSize();
            //starting at the back, each datum will be moved forward one space
            for (int i = size(); i > 0; i--) {
                //new index will be i+1 for every existing piece of data
                data[i] = data[i+1];
            }
            //index 0 will be null,so we can insert item to the front now
            data[0] = item;
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

        // There is a private helper method checkSize() defined below to check/resize
        // that you can call as needed to check if the array is full and resize it.
        checkSize();
        if(size == 0){
            data[0] = item;
        }else{
            data[size-1] = item;
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
        checkSize();
        // if empty: do nothing and return null
        if(size == 0){
            return null;
        }else{
            // if there's only one item: is this a special case?
            //since it is an arraylist, we are able to access the front every time
            //using data[0]. It is not a special case
            ItemType temp = data[0];
            data[0] = null;
            return temp;
        }
        // if not empty:
        // 0. figure out a way to access the item in the front
        // 1. make a variable to save a copy of the item at the front
        // 2. remove the item at the front
        // 3. return the variable that has the saved copy of the item at the front
        /*if(size > 1){
            ItemType temp = data[0];
            data[0] = null;
            return temp;
        }*/
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
        }else{
            //accessing the item in the back. ArrayList indexes start at 0
            //so we can -1 from size to get last index
            ItemType temp = data[size-1];
            data[size-1] = null;
            return temp;
        }
        // if there is only one item: is this a special case?
            //same as removeFirst method in this class, no special case is needed
            //following the code:
                // size = 1, data[0] contains item
                //ItemType temp = data[size-1] --> temp = data[0]
                //data[0] = null
                //return temp
        // if not empty, has more than one item:
        // 0. figure out a way to access the item in the back
        // 1. make a variable to save a copy of the item at the back
        // 2. remove the item at the back
        // 3. return the variable that has the saved copy of the item at the back

    }

    // helper method to check to see if the size has reached the capacity
    // and more space needs to be allocated (creates a new larger array
    // and copies items over)
    private void checkSize() {
        if (size == data.length) {
            // resize up (double up the array size)

            // Step 1 - create a new larger array
            ItemType[] temp = (ItemType[]) new Object[size * 2];

            // Step 2 - copy items from data to temp
            for (int i = 0; i < size; i++) {
                temp[i] = data[i];
            }

            // Step 3 - repoint/refererence data to point to new array
            data = temp;

            // Optional:
            temp = null;
        } // end of if (need to resize)
    }

    public void print(){
        for (int i = 0; i < size-1; i++) {
            System.out.println(data[i]);
        }
    }
}
