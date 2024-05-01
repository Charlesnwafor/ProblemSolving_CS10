/**
 * Instructor - models one instructor, inherits from Person class
 *
 * @author Tim Pierson, Dartmouth CS10, Winter 2024
 */
public class Instructor extends Person {
    boolean tenured;
    int yearsEmployed;
    String department;

    /**
     * Constructors
     */
    public Instructor(String name, String Id) {
        super(name, Id);
        this.tenured = false;   //not required, Java initializes boolean instance variables to false
        this.yearsEmployed = 0; //not required, Java initializes numeric values instance variables to 0
        this.department = null;  //not required, Java initializes objects to null
    }
    public Instructor(String name, String Id, boolean tenured, int yearsEmployed, String department) {
        super(name, Id);
        this.tenured = tenured;
        this.yearsEmployed = yearsEmployed;
        this.department = department;
    }


    /**
     * Getters
     */
    public boolean getTenuredStatus() { return tenured;}
    public int getYearsEmployed() { return yearsEmployed;}
    public String getDepartment() { return department; }

    /**
     * Setters
     */
    public void setTenured(boolean tenured) { this.tenured = tenured; }
    public void setYearsEmployed(int yearsEmployed) { this.yearsEmployed = yearsEmployed; }
    public void setDepartment(String department) { this.department = department;}

    /**
     * Return a String representation of an instructor
     * @return - string representing the instructor
     */
    @Override
    public String toString() {
        String s = super.toString() + "\n";
        s += "\tTenured: " + tenured + "\n";
        s += "\tYears Employed: " + yearsEmployed + "\n";
        s += "\tDepartment: " + department;
        return s;
    }
}
