import java.util.Stack;

public class BusyB {
    public static void main(String[] args) {
        Stack stack = new Stack();
        stack.push((int)(Math.random()*100));
        stack.push((int)(Math.random()*100));
        stack.push((int)(Math.random()*100));
        test1 Ikenna = new test1(stack);
        System.out.println(Ikenna.getStack());

        stack.push(12);
        System.out.println(Ikenna.getStack());

    }
}
