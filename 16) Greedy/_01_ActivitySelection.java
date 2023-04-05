import java.util.ArrayList;

public class _01_ActivitySelection {

    public static void activitySelect(int[] start, int[] end) {
        ArrayList<Integer> ans = new ArrayList<>();
        // As end time points are sorted so I'll traverse through 'end' array
        ans.add(0);// We inserted the 0th index of 'end' array
        // so now 1st task has been complted. Now I have to look at the next time point
        int maxActivity = 1;// initializde variable with 1 as one task has been complted
        int lastEnd = end[0];// last taken time point of the 'end' array
        for (int i = 1; i < end.length; i++) {
            if (start[i] >= lastEnd) {
                maxActivity++;
                ans.add(i); // inserted the index of the time point of the 'end' array
                lastEnd = end[i];// every time lastEnd is getting changed
            }
        }
        System.out.println("Max Acitivies in the given time point: " + maxActivity);
        // now printing the name of the activities
        for (int i = 0; i < ans.size(); i++) {
            System.out.println("Activity " + ans.get(i));// 0 based indexing of the activity
            // whenever 1 end time point finished , 1 activity has been finished
        }
    }

    public static void main(String[] args) {
        int[] start = { 1, 3, 0, 5, 8, 5 };
        int[] end = { 2, 4, 6, 7, 9, 9 }; // End time is in sorted order
        // There are some task
        // starting time & ending time graph point is given
        // At a time a single activity can be done
        // I have to choose start & ending point in a way
        // that maximum activity can be done
        activitySelect(start, end);
    }
}