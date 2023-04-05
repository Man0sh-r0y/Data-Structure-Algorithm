import java.util.ArrayList;
import java.util.Comparator;
import java.util.Arrays;

public class _02_ActivitySelection {
    public static void activitySelect(int[] start, int[] end) {
        ArrayList<Integer> ans = new ArrayList<>();
        int activities[][] = new int[end.length][3];// end.length number of rows and 3 columns
        // I have to sort the activity according to the end activity time point
        for (int i = 0; i < end.length; i++) {// At first storing
            activities[i][0] = i;// in the 1st column index will be stored
            activities[i][1] = start[i];// in the 2nd column start time point will be stored
            activities[i][2] = end[i];// in the 3rd column end time point will be stored
        }

        Arrays.sort(activities, Comparator.comparingDouble(o -> o[2]));// sorting the Array based on the 2nd index
        // so that end time point will be stored
        // When we will sort the array based on column 2 (end time point)
        // the actual (real) index will be jumbled
        // So whenever,
        // we will print the activity according to the index order it'll be incorrect
        // That's why we took the index in the 0th column
        ans.add(activities[0][0]);// We inserted the 0th index of 'end' array
        int maxActivity = 1;// initializde variable with 1 as one task has been complted
        int lastEnd = activities[0][2];// last taken time point of the 'end' array
        for (int i = 1; i < end.length; i++) {
            if (activities[i][1] >= lastEnd) {
                maxActivity++;
                ans.add(i);// inserted the index of the time point of the 'end' array
                lastEnd = activities[i][2];// every time lastEnd is getting changed
            }
        }
        System.out.println("Max Acitivies in the given time point: " + maxActivity);
        // now printing the name of the activities
        for (int i = 0; i < ans.size(); i++) {
            System.out.println("Activity " + ans.get(i));
        }
    }

    public static void main(String[] args) {
        int[] start = { 1, 3, 0, 5, 8, 5 };
        int[] end = { 2, 4, 6, 7, 9, 9 }; // End time isn't in sorted order
        activitySelect(start, end);
    }
}
