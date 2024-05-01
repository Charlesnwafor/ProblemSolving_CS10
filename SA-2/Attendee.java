public class Attendee {
    // Declaring instance variables
    protected String attendeeName;
    protected boolean rsvp;

    // Creating an attendee constructor with name and rsvp as parameters
    public Attendee(String name, boolean rsvp) {
        this.attendeeName = name;
        this.rsvp = rsvp;

    }

    /* Creating Setters and Getters */

    //Setters
    public void setAttendeeName(String attendeeName){this.attendeeName = attendeeName;}
    public void setRsvp(boolean rsvp){this.rsvp = rsvp;}

    //Getters
    public String getAttendeeName(){return attendeeName;}
    public boolean getRsvp(){return rsvp;}

    //toString method
    public String toString(){
        String s = attendeeName;
        return s;
    }

}
