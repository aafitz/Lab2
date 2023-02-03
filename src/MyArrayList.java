import java.util.Arrays;

public class MyArrayList <E> implements MyList <E> {
// E = placeholder for the type of data storing
    private E[] data; // creates list E called  data
    private int size; // creates a size variable for the data Array
    private static final int DEFAULT_CAPACITY = 10; // creates a variable for the org or default capacity/space-- final so that this cannot change
// final b/c read-only--- no modification
    // static b/c shared
    public MyArrayList() {
        this(DEFAULT_CAPACITY);  // call other constructor w/ default capacity from above
    }

    @SuppressWarnings("unchecked")
    public MyArrayList(int initialCapacity) {  // creates an object area & casts into an array of type E
        size = 0;
        data = (E[]) new Object[initialCapacity];
    }

    /**
     * Appends the specified element to the end of this list
     *
     * @param e element to be appended to this list
     */
    @Override
    public void add(E e) {
        if (size == data.length) { // if the # of items in list = to the length of the list i.e. the list is full--
            // call reallocate i.e-- double size and keep orevious items
            reallocate();
        }
        data[size++] = e; // else-- if "data" is NOT full -- add element 'e' to the end of the list (size plus-- to give the end)
    }

    private void reallocate() {
        // creating a copy of org array "data"- X2 size & add to
        // pasting elements from the orig array to the newly sized array
        E[] newData = Arrays.copyOf(data, (data.length * 2));
        data = newData;

    }

    /**
     * Inserts the specified element at the specified position in this list.
     * Shifts the element currently at that position (if any) and any
     * subsequent elements to the right (adds one to their indices).
     *
     * @param index index at which the specified element is to be inserted
     * @param e     element to be inserted
     * @throws IndexOutOfBoundsException if the index is out of range
     */
    @Override
    public void add(int index, E e) {
        if(index>size-1 || index < 0){ // if the index > size-1 (the last index) or if index is < 0 meaning negative
            // print outboundsexp with the said index given
            throw new IndexOutOfBoundsException(index);

        }
        if (size == data.length) { // if the data is full then save the data imported and double size aka--- call reallocate
            reallocate();
        }
        if(data[index] == null) { //if the index wanted is empty--- add element e to said index
            data[index] = e;

        }
        else { // if index wanted is not empty-- run the for loop
           for(int i = size-1; i > index-1; i--){ // start at the end of the list, move backwards
               data[i+1] = data[i];  //set index = to the element at data +1-- ie-- move it
           }
           data[index] = e; // if the for loop is satisfied then data at the index specified inout element e

        }
        size++; // update size of the list
    }



    /**
     * Returns the element at the specified position in this list.
     *
     * @param i index of the element to return
     * @return the element at the specified position in this list
     * @throws IndexOutOfBoundsException if the index is out of range
     */
    @Override
    public E get(int i) {
        if(i>size-1 || i<0){ // same thing as before virtually -- check to make sure that the i is not negative or larger than the size / length
            throw new IndexOutOfBoundsException(i);

        }

        return data[i]; //gives the i from data
    }

    /**
     * Returns true if this list contains no elements.
     *
     * @return true if this list contains no elements
     */
    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * Returns the number of elements in this list.
     *
     * @return the number of elements in this list
     */
    @Override
    public int size() {
        return size;
    }
}
