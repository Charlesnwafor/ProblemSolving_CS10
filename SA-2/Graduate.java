public class Graduate extends Attendee {
    //TODO: Question for TA: Do we not need to state if the instance variables in a subclass are public, protected or private?
    int graduationYear; //setting instance variables
    String department;

    public Graduate(String name, boolean rsvp, int graduationYear, String department){    //constructor that stores additional parameters for graduation year and department
        super(name, rsvp); //sets name and rsvp using the Attendee parent class
        this.graduationYear = graduationYear; //set graduation year and department of attendee to parameters given
        this.department = department;

    }

    public String toString() {         //method to print out string when Attendee object is printed out
        String s = super.toString();
        s += " '" + graduationYear;
        s += " " + department;
        return s;
    }

}
