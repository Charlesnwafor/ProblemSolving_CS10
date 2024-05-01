public class test1 {
    public static void main(String[] args) {

        Student alice = new Student("Alice", "f006vzw");
        Student ally;
        ally = alice;
        ally.setName("ally");
        System.out.println(alice.getName() + " " + ally.getName());
    }
}
