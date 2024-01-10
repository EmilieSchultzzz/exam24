package models;
/**
 * A class TimeSlot that represents time slots when activities can be scheduled
 *
 * @author Gabriela Montoya
 * @version 1.4, 2023-12-19
 */
 
import java.time.LocalDateTime;

public class TimeSlot {
    private LocalDateTime start;
    private LocalDateTime end;
    private int amountOfvotes;

    public TimeSlot(LocalDateTime s, long d, int amountOfvotes) {
        start = s;
        end = s.plusMinutes(d);
        this.amountOfvotes = amountOfvotes;
    }

    public boolean overlaps(TimeSlot other) {
        return !other.end.isBefore(this.start)
               &&
               !this.end.isBefore(other.start);
    }

    public boolean covers(TimeSlot other) {
        return !other.start.isBefore(this.start)
                && 
               !other.end.isAfter(this.end);
    }

    public LocalDateTime getStartDate() {
        return start;
    }

    public LocalDateTime getEndDate() {
        return end;
    }

    public int getAmountOfVotes() {
        return amountOfvotes;
    }

    public String toString() {
        return "Start time: " + start + "\nEnd time: " + end;
    }
    
    @Override
    public boolean equals(Object o) {
        if (!(o instanceof TimeSlot)) {
            return false;
        }
        TimeSlot other = (TimeSlot) o;
        
        return start.equals(other.start) && end.equals(other.end);
    }
}