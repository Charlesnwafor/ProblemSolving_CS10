/**
 * @author Ikenna Nwafor, CS 10, Spring 24
 */

public class DequeTest extends DequeGrowingArray {
    public static void main(String[] args) throws Exception {

        /**
         * Testing for Implementation done using Double Linked List
         */

        DoublyLinkedListDeque<String> deque = new DoublyLinkedListDeque<>();
        deque.addFirst("Ikenna");
        System.out.println(deque);
        deque.addFirst("Charles");
        System.out.println(deque);
        deque.addLast("nwafor");
        System.out.println(deque);
        deque.addFirst("Umahia");
        System.out.println(deque);
        deque.addLast("Obi");
        System.out.println(deque);
        deque.removeFirst();
        System.out.println(deque);
        deque.removeFirst();
        System.out.println(deque);
        deque.removeLast();
        System.out.println(deque);
        deque.removeLast();
        System.out.println(deque);
        deque.addFirst("Charles");
        deque.addLast("Nwafor");
        deque.addLast("Michael");
        System.out.println(deque);
        System.out.println(deque.getFirst()); //Why can't I print this out?
        System.out.println(deque.contains("Ikenna"));


        System.out.println("");
        System.out.println("");



        /**
         * Testing for implementation done using Array
         */

        /*
        DequeGrowingArray<String> deque = new DequeGrowingArray<>();
        deque.addFirst("Ikenna");
        System.out.println(deque);
        deque.addFirst("Nwafor");
        System.out.println(deque);
        deque.addFirst("Charles");
        System.out.println(deque);
        deque.addFirst("Umahia");
        System.out.println(deque);
        deque.addLast("Jumboo");
        System.out.println(deque);
        deque.addLast("King");
        System.out.println(deque);
        deque.addLast("Adanma");
        System.out.println(deque);
        deque.removeFirst();
        System.out.println(deque);
        System.out.println(deque.removeFirst());
        System.out.println(deque);
        deque.removeLast();
        System.out.println(deque);
        System.out.println(deque.getLast());
        System.out.println(deque.getFirst());
        System.out.println(deque.contains("Ikennan"));
        deque.clear();
        System.out.println(deque); */




    }
}
