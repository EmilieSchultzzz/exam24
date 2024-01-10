package models;

import interfaces.TimeSlotDecider;

public class SimpleDecider implements TimeSlotDecider{
    SimpleDecider simpleDecider;

    public SimpleDecider() {
        this.simpleDecider = new SimpleDecider();
    }

    public void decideTimeSlot(suggestedActivity a) {
        TimeSlot highestVotes = new TimeSlot(null, 0, 0);
        for (TimeSlot t : a.getPossibleTimeSlots()) {
            if (highestVotes.getAmountOfVotes() == 0 || highestVotes.getAmountOfVotes() < t.getAmountOfVotes()) {
                highestVotes = t;
            }
        }
        a.setTimeSlot(highestVotes);
    }
}
