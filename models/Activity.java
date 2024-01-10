package models;
public abstract class Activity {
    private String title;
    private long minutes;

    public Activity(String title, long minutes) {
        this.title = title;
        this.minutes = minutes;
    }

    public String getTitle() {
        return this.title;
    }

    public long getDuration() {
        return this.minutes;
    }

}