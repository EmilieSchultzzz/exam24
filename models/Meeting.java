package models;
public class Meeting extends Activity{
    
    private String agenda;

    public Meeting(String title, long minutes) {
        super(title, minutes);
    }

    public String getAgenda() {
        return this.agenda;
    }

    public String toString() {
        return "Meeting title: " + getTitle() + ", meeting agenda: " + getAgenda() + ", and meeting length in minutes: " + getDuration();
    }

}
