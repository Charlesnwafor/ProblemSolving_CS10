/**
 * @author Ikenna Nwafor, CS 10, Spring 24
 */
public class DoublyLinkedListDeque<T> implements SimpleDeque<T> {
    private Element head;
    private Element tail;
    private int size;

    private class Element {
        private T data;
        private Element next;
        private Element prev;

        private Element(T data) {
            this.data = data;
            this.next = null;
            this.prev = null;
        }

        private Element(T data, Element next) {
            this.data = data;
            this.next = next;
            this.prev = null;
        }
        private Element(T data, Element next, Element prev) {
            this.data = data;
            this.next = next;
            this.prev = prev;


        }


    }
    public DoublyLinkedListDeque() {
        head = null;
        tail = null;
        size = 0;
    }


    /**
     * Add item at the front of the deque
     * @param item
     */
    @Override
    public void addFirst(T item) {
        if (isEmpty()){
            head = new Element(item, head);
            tail = head;
        }
        else head = new Element(item, head);
        size++;
    }

    /**
     * Add item at the end of deque
     * @param item
     */
    @Override
    public void addLast(T item) {
        if (isEmpty()){
            head = tail = new Element(item, head);
        }
        else {
            tail.next = new Element(item, tail.next, tail);
            tail = tail.next;
        }
        size++;
    }

    /**
     * Removes and returns item at the front of deque, throws exception if deque is empty
     * @return
     * @throws Exception
     */
    @Override
    public T removeFirst() throws Exception {
        if (isEmpty()) throw new Exception ("deque is empty");
        T temp = (T) head;
        head = head.next;
        return temp;
    }

    /**
     * Removes and returns item at end of deque, throws exception if deque is empty
     * @return
     * @throws Exception
     */
    @Override
    public T removeLast() throws Exception {
        if (isEmpty()) throw new Exception("deque is empty");
        T temp = (T) tail;
        tail = tail.prev;
        tail.next = null;
        return temp;
    }

    /**
     * Returns the item at the front of the deque, throws exception if deque is empty
     * @return
     * @throws Exception
     */
    @Override
    public T getFirst() throws Exception {
        if (isEmpty()) throw new Exception ("deque is empty");
        return head.data;
    }

    /**
     * Returns the item at the end of the deque, throws exception if deque is empty
     * @return
     * @throws Exception
     */
    @Override
    public T getLast() throws Exception {
        if (isEmpty()) throw new Exception("deque is empty");
        return (T) tail;
    }

    @Override
    public void clear() {
        head = tail = null;
        size = 0;

    }

    @Override
    public boolean contains(T item) {
        for (Element counter = head; counter != null; counter = counter.next){
            if (counter.data ==  item) return true;
        }
        return false;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public String toString(){
        String s = "";
        for (Element x = head; x != null; x = x.next){
            s += x.data + "-->";
        }
        s += "[/]";
        return s;
    }
}
