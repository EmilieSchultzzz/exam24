package models;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import interfaces.TimeSlotDecider;

public class suggestedActivity {
    
    private Activity suggestedActivity;
    private TimeSlot suggestedTimeSlot;
    private String title;
    private long minutes;
    private Map<Participant, Collection<TimeSlot>> interestedParticipants;

    public suggestedActivity() {
        interestedParticipants = new HashMap<Participant, Collection<TimeSlot>>();
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDuration(long minutes) {
        this.minutes = minutes;
    }

    public Activity getActivity() {
        return this.suggestedActivity;
    }

    public Collection<Participant> getVotes(TimeSlot t) {
        ArrayList<Participant> votedForT = new ArrayList<Participant>();
        for(Participant p : interestedParticipants.keySet()){
            if(interestedParticipants.values().contains(t)){
                votedForT.add(p);
            }
        }
        return votedForT;
    }

    public void closePolling(TimeSlotDecider tsd) {
        tsd.decideTimeSlot(null);
        notifyAllParticipants();
    }

    public Collection<TimeSlot> getPossibleTimeSlots() {
        Collection<TimeSlot> possibleSlots = new ArrayList<TimeSlot>();
        for (Participant p : interestedParticipants.keySet()) {
            if (possibleSlots.isEmpty()) {
                possibleSlots.addAll(interestedParticipants.get(p));
            }
            else {
                if (!possibleSlots.containsAll(interestedParticipants.get(p))) {
                    possibleSlots.addAll(interestedParticipants.get(p));
                }
            }
        }
        return possibleSlots;
    }

    public void vote(Participant p, Collection<TimeSlot> ts) {
        interestedParticipants.put(p, ts);
    }

    public TimeSlot getTimeSlot() {
        return this.suggestedTimeSlot;
    }

    public void setTimeSlot(TimeSlot t) {
        this.suggestedTimeSlot = t;
    }

    public void notifyAllParticipants() {
        interestedParticipants.notifyAll();
    }

    public String toString() {
        return suggestedActivity.getTitle() + "takes place at " + getTimeSlot();
    }

}
