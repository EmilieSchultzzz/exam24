package models;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Scanner;

public class ActivityOrganizer {
    
    private List<suggestedActivity> suggestedActivities;

    public ActivityOrganizer() {
        suggestedActivities = new ArrayList<suggestedActivity>();
    }

    public void displaySuggestedActivities() {
        for (int i = 0; i < suggestedActivities.size(); i++) {
            System.out.println(i+1 + ": " + suggestedActivities.get(i).toString());
        }
    }

    public void registerAvailability() {
        boolean isRunning = true;
        Collection<TimeSlot> choices = new ArrayList<TimeSlot>();
        while (isRunning) {
            switch (getActivityID()) {
                case "1":
                    choices.add(suggestedActivities.get(0).getTimeSlot());
                    break;
                case "2":
                    choices.add(suggestedActivities.get(1).getTimeSlot());
                    break;
                case "3":
                    choices.add(suggestedActivities.get(2).getTimeSlot());
                    break;
                case "4":
                    choices.add(suggestedActivities.get(3).getTimeSlot());
                    break;
                case "5":
                    choices.add(suggestedActivities.get(4).getTimeSlot());
                    break;
                case "6":
                    choices.add(suggestedActivities.get(5).getTimeSlot());
                    break;
                case "7":
                    choices.add(suggestedActivities.get(6).getTimeSlot());
                    break;
                case "8":
                    choices.add(suggestedActivities.get(7).getTimeSlot());
                    break;
                case "9":
                    choices.add(suggestedActivities.get(8).getTimeSlot());
                    break;
                case "back":
                    isRunning = false;
                default:
                    System.out.println("Not a valid activity");
                    break;
            }
        }
    }

    public String getActivityID() {
        System.out.println("Please pick the number of the activity:");
        displaySuggestedActivities();
        System.out.println("Write *back* to exit.");
        Scanner input = new Scanner(System.in);
        return input.nextLine();
    }

    public void suggestActivity() {
        Scanner input = new Scanner(System.in);
        System.out.println("Please write the title of the activity:");
        String title = input.nextLine();

        System.out.println("Please write the start time of the activity:");
        LocalDateTime start = LocalDateTime.parse(input.nextLine());

        System.out.println("Please write the duration of the activity:");
        long duration = input.nextLong();

        suggestedActivity newActivity = new suggestedActivity();
        TimeSlot t = new TimeSlot(start, duration, 0);

        newActivity.setTitle(title);
        newActivity.setDuration(duration);
        newActivity.setTimeSlot(t);
        

        suggestedActivities.add(newActivity);
    }

    public void ScheduleActivity(){
        boolean isRunning = true;
        SimpleDecider simpleDecider = new SimpleDecider();
        while (isRunning) {
            switch (getActivityID()) {
                case "1":
                    simpleDecider.decideTimeSlot(suggestedActivities.get(1));
                    break;
                case "2":
                    simpleDecider.decideTimeSlot(suggestedActivities.get(2));
                    break;
                case "3":
                    simpleDecider.decideTimeSlot(suggestedActivities.get(3));
                    break;
                case "4":
                    simpleDecider.decideTimeSlot(suggestedActivities.get(4));
                    break;
                case "5":
                    simpleDecider.decideTimeSlot(suggestedActivities.get(5));
                    break;
                case "6":
                    simpleDecider.decideTimeSlot(suggestedActivities.get(6));
                    break;
                case "7":
                    simpleDecider.decideTimeSlot(suggestedActivities.get(7));
                    break;
                case "8":
                    simpleDecider.decideTimeSlot(suggestedActivities.get(8));
                    break;
                case "9":
                    simpleDecider.decideTimeSlot(suggestedActivities.get(9));
                    break;
                case "back":
                    isRunning = false;
                default:
                    System.out.println("Not a valid activity");
                    break;
            }
        }

    }

}
