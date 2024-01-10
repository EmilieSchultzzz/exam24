package interfaces;

import models.suggestedActivity;

/**
 * An interface TimeSlotDecider
 * Concrete subtypes of this interface provide an algorithm to choose
 * the time slot to schedule an activity 
 *
 * @author Gabriela Montoya
 * @version 1.1, 2023-12-07
 */

public interface TimeSlotDecider {

    void decideTimeSlot(suggestedActivity a);
}
