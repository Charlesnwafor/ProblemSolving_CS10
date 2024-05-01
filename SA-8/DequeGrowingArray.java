/**
 * @author Ikenna Nwafor, CS 10, Spring 24
 */

import net.datastructures.Node;

import java.security.InvalidKeyException;

public class DequeGrowingArray<T> implements SimpleDeque<T> {
    private T[] array;

    private int size;
    private static final int InitCap = 3;

    public DequeGrowingArray(){
        // initialize array and size
        array = (T[]) new Object[InitCap];  // java generics oddness -- create an array of objects and typecast to array of T
        size = 0;
    }

    /**
     * Add item at the front of the deque
     * @param item
     */
    @Override
    public void addFirst(T item) {
        if (size == 0) array[0] = item;
        else {
            if (size == array.length){ //if array is full, create a new bigger array and initial array into new array
                T[] copy = (T[]) new Object[size*2];
                for (int i = 0; i < size; i++){copy[i] = array[i];}
                array = copy;
            }
            // shift right to make room
            for (int i = size-1; i >= 0; i--) {array[i+1] = array[i];}
            array[0] = item;
        }
        size++;

    }


    /**
     * Add item at end of the deque
     * @param item
     */
    @Override
    public void addLast(T item) {
        if (size < array.length){
            array[size] = item;
        }
        if (size == array.length){
            T[] copy  = (T[]) new Object[size*2];
            for (int i = 0; i < size; i++) copy[i] = array[i];
            array = copy;
            array[size] = item;
        }
        size++;
    }

    /**
     * Removes and returns item at front of the deque, throws exception if deque is empty
     * @return
     * @throws Exception
     */
    @Override
    public T removeFirst() throws Exception {

        if (isEmpty()) throw new Exception ("deque is empty");
        T temp = array[0];
        for (int i = 0; i < size-1; i++){
            array[i] = array[i+1];
        }
        size--;
        return temp;
    }

    /**
     * Removes and returns item at the end of queue, throws exception if deque is empty
     * @return
     * @throws Exception
     */
    @Override
    public T removeLast() throws Exception {
        if(isEmpty()) throw new Exception("deque is empty");
        T temp = array[size-1];
        if (size == array.length){
            T[] copy = (T[]) new Object[size*2];
            for (int i = 0; i < size; i++){
                copy[i] = array[i];
            }
            array = copy;
        }
        for (int i = size-1; i < array.length-1; i++){
            array[i] = array[i+1];
        }
        size--;
        return temp;
    }

    /**
     * Returns the item at the front of the deque, throws exception if deque is empty
     * @return
     * @throws Exception
     */
    @Override
    public T getFirst() throws Exception {
        if (isEmpty()) throw new Exception("deque is empty");
        return array[0];
    }


    /**
     * Returns the item at the end of the deque, throws exception is the deque is empty
     * @return
     * @throws Exception
     */
    @Override
    public T getLast() throws Exception {
        if (isEmpty()) throw new Exception("deque is empty");
        return array[size-1];
    }

    /**
     * Clears the deque
     */
    @Override
    public void clear() {
        array = (T[]) new Object[InitCap];
        size = 0;
    }

    /**
     * Returns true if the deque contains the item, false otherwise
     * @param item
     * @return
     */
    @Override
    public boolean contains(T item) {
        for (int i = 0; i < size; i++){
            if (array[i] == item) return true;
        }
        return false;
    }

    @Override
    public boolean isEmpty() {return size == 0;}

    @Override
    public int size() {return size;}

    @Override
    public String toString(){
        String s = "";
        int i;
        for (i = 0; i < size-1; i++){
            s += (String) array[i] + ", ";
        }
        s += (String) array[i];
        return s;

    }
}
