package models;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Participant {
    
    private String id;
    private Calendar calendar;

    public Participant(String id) {
        this.id = id;
        calendar = new Calendar();
    }

    public void notify(suggestedActivity a) {
        calendar.add(a);
    }

    public String getCalendar() {
        calendar.sort();
        return "Participant " + id + " with calendar:\n" + calendar;
    }

    static class Calendar {
        private Map<LocalDate, List<TimeSlot>> times;

        public Calendar() {
            times = new HashMap<LocalDate, List<TimeSlot>>();
        }
        
        public String toString(LocalDate d) {
            
            List<TimeSlot> ts = times.get(d);
            String str = "";
            
            if (ts == null) {
                str = "All times available";
            } else {
                for (TimeSlot t0 : ts) {
                    str += t0.toString()+"\n";
                }
            }
            
            return str;
        }

        public String toString() {
            Set<LocalDate> ds = times.keySet();
            String str = "";
            
            if (ds.size()==0) {
                str = "Empty calendar";
            }
            
            for (LocalDate d : ds) {
                str += d.toString()+"\n"+toString(d) + "\n\n";
            }
            
            return str;
        }

        public boolean available(TimeSlot t) {
            LocalDate d = t.getStartDate().toLocalDate();
            List<TimeSlot> ts = times.get(d);
            
            if (ts == null) {
                return true;
            }
            
            for (TimeSlot t0 : ts) {
                if (t0.overlaps(t) || t0.equals(t)) {
                    return false;
                }
            }
            return true;
        }

        public void add(suggestedActivity a) {
            LocalDate d = a.getTimeSlot().getStartDate().toLocalDate();
            List<TimeSlot> ts = times.get(d);
            if (available(a.getTimeSlot())) {
                times.put(a.getTimeSlot().getStartDate().toLocalDate(), ts);
            }
            else {
                throw new RuntimeException("The Participant is not available to attend");
            }
            
        }

        public void sort() {
            Map<LocalDate, List<TimeSlot>> newTimes = new HashMap<LocalDate, List<TimeSlot>>();
            for (LocalDate d : times.keySet()) {
                for (LocalDate d2 : times.keySet()) {
                    if (d.compareTo(d2) < 0) {
                        newTimes.put(d, times.get(d));
                    }
                    else if (d.compareTo(d2) > 0){
                        newTimes.put(d2, times.get(d2));
                    }
                }
            }
            times = newTimes;
        }
    }
}
