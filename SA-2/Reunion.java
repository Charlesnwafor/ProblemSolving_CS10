public class Reunion {

    //initialize instance variables
   private int maxAttendees;
   private Attendee[] attendees;
   private int numOfAttendees;

    public Reunion(int maxAttendees){    // constructor takes max number of attendees
        this.maxAttendees = maxAttendees;
        this.attendees = new Attendee[maxAttendees];
        this.numOfAttendees = 0;
    }
    public void addAttendee(Attendee newAttendee){  //takes object newAttendee and appends to array of Attendees
        if (numOfAttendees >= maxAttendees){
            System.out.println("Unable to accomodate " + newAttendee.toString() + ", max attendees is " + maxAttendees);
            return;
        }

        attendees[numOfAttendees] = newAttendee;
        numOfAttendees++;
        System.out.println("Added "+ newAttendee + ", rsvp: " + newAttendee.getRsvp());
    }

    public void rsvp(String attendeeName, boolean rsvp){  //Updates Rsvp status for attendees
        for (int i = 0; i < numOfAttendees; i++){
            if (attendees[i].attendeeName == attendeeName){
                attendees[i].rsvp = rsvp;
                System.out.println("Set RSVP to " + rsvp + " for " + attendeeName);
                return;
            }
        }
        System.out.println(attendeeName + " not found");
    }

    public String toString(){  // prints selected string when Reunion object is printed out
        String s = "Reunion attendees that have RSVP: \n";
        for (int i = 0; i < numOfAttendees; i++){ //goes through list of attendees and prints the ones who have rsvp'd
            if (attendees[i].rsvp){
                s += "\t" + attendees[i].toString() + "\n";
            }
        }
        s += "\n";
        s += "Reunion attendees that have NOT RSVP: \n";
        for (int i = 0; i < numOfAttendees; i++){ //goes through list of attendees and prints the ones who have NOT rsvp'd
            if (!attendees[i].rsvp){
                s += "\t" + attendees[i].toString() + "\n";
            }
        }
        return s;
    }


    public static void main(String[] args) {
        Reunion r = new Reunion(5);
        r.addAttendee(new Attendee("Alice", true));
        r.addAttendee(new Attendee("Bob", false));
        r.addAttendee(new Graduate("Charlie", true, 22, "Government"));
        r.addAttendee(new Graduate("Denise", false, 21, "Econ"));
        r.addAttendee(new Graduate("Elvis", true, 23, "Computer Science"));
        r.addAttendee(new Graduate("Falcon", false, 26, "Biology"));
        System.out.println(r);
        System.out.println();

        System.out.println("Update rsvp status");
        r.rsvp("George", false);  //print not found
        r.rsvp("Bob", true);  //update
        System.out.println(r);
    }
}
