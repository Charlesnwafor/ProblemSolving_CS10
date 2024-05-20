import java.util.*;

public class test1 {

    private Stack stack;
    private String name;

    public test1(Stack stack) {
        this.name = name;
        this.stack = stack;

    }

    public test1() {
        this.stack = new Stack();
    }

    public Object push(Integer num){
        return this.stack.push(num);
    }

    public Stack getStack(){
        return this.stack;
    }
    public static void main(String[] args) {


        //Stack<Integer> stack = new Stack<>();
        test1 stack;
        stack = new test1();
        stack.stack.push(2);
        stack.stack.push(3);
        stack.stack.push(4);

        System.out.println("Stack is " + stack);

        Stack newStack = new Stack<>();
        test1 Nwafor = new test1(newStack);
        Nwafor.stack.push(4);
        Nwafor.stack.push(9);
        Nwafor.stack.push(45);

        Boolean Charles = true;

        while (Charles){
            if (!Nwafor.stack.isEmpty()){
                Integer element = (Integer) Nwafor.stack.pop();
                if (Nwafor.stack.size() == 0){
                    System.out.println("Stack is empty every element was removed.");
                    Charles = false;
                }
                else{
                    System.out.println("Stack is now " + Nwafor.stack + ". " + element + " was removed.");
                }

            }
        }

        Boolean Ikenna = true;

        while (Ikenna){
            if (!stack.stack.isEmpty()){
                Integer element = (Integer) stack.stack.pop();
                if (stack.stack.size() == 0){
                    System.out.println("Stack is empty every element was removed.");
                    Ikenna = false;
                }
                else{
                    System.out.println("Stack is now " + stack.stack + ". " + element + " was removed.");
                }

            }
        }
    }
}
