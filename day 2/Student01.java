/**
 * Student series demonstrates encapsulation by representing a student in a class
 * Student01 - adds setters for instance variables
 *
 * @author Tim Pierson, Dartmouth CS10, Winter 2024
 */
public class Student01 {
    protected String studentId;
    protected String name;
    protected int graduationYear;

    /**
     * Setters for instance variables
     */
    public void setId(String studentId) { this.studentId = studentId; }
    public void setName(String name) { this.name = name; }
    public void setYear(int year) { graduationYear = year; }

    public static void main(String[] args) {
        Student01 alice = new Student01();
        alice.setId("f00xyz");
        alice.setName("Alice");
        alice.setYear(2027);
        System.out.println("ID: " + alice.studentId +
                ", Name: " + alice.name +
                ", Year: " + alice.graduationYear);
    }
}