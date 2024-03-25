import java.util.Arrays;
public class _21_AggresiveCows {

    public static boolean placeCowsInStalls(int[] stalls, int cows, int dist) {// this function will check if I can place all the cows in the stalls with this given possible least distance (dist) between them

        int placedCows = 1; // It will track how many cows have been placed in the stalls
        // 1st cow is placed at 1st position (0th index) of the array
        int prevPos = stalls[0]; // The position of the previous cow placed in the stalls 
        // initially it is stalls[0] as 1st cow placed at index 0 (1st stall)

        for(int i=1; i<stalls.length; i++){
            if(stalls[i] - prevPos >= dist) {// `dist` is least distance between any 2 cows which are to be placed
		        // that means the gap between the cows should atleast be `dist`
                placedCows++; // cow is placed at this stall
                prevPos = stalls[i];
            }
        }

        if(placedCows >= cows) // if all the cows are placed in the stalls with this given possible distance (dist)
            return true;

        return false;
    }

    // Brute Force Approach
    public static int aggressiveCows(int []stalls, int cows) {// Return maximum possible minimum distance
        // There are lot of cows positioned in the stall
        // Difference of distance between any 2 cows can be different with other 2 Cows among all the cows
        // So I have to find the distance which is minimum in any 2 cows among all the cows.
        // I will try to keep this minimum distance as max as possible

        Arrays.sort(stalls); // sort the stalls array (stalls contains the positions of the stalls)
        // I'm sorting the stalls to keep track minimum distance between any 2 cows among all the cows


        int minDist = 1; // minimum distance between any 2 Cows
        int maxDist = stalls[stalls.length - 1]; // maximum distance between any 2 Cows (hypothatically)
        // maximum distance is the positin of last stall (hypothatically)
        // our answer will lie within this range

        for(int d = minDist; d <= maxDist; d++) {

            if(placeCowsInStalls(stalls, cows, d)) // if cows can be placed with at least distance `d` then continue the process as I want the max possible distance `d`
                continue; // as I want max possible distance `d`
            else 
                return d-1; // if cows can't be placed with at least distance `d` then return the previous distance `d-1`
        }

        return 0;
    }

    // Optimal Approaqch
    public static int aggressiveCows2ndApproach(int []stalls, int cows) {
        int dist = 0;// maximum possible minimum distance

        Arrays.sort(stalls);

        int minDist = 1; // minimum distance between any 2 Cows
        int maxDist = stalls[stalls.length - 1]; // maximum distance between any 2 Cows

        int low = minDist, high = maxDist;

        while(low <= high) {
            int mid = low + (high - low) / 2; // mid is the minimum distance between any 2 cows among all the cows

            if(placeCowsInStalls(stalls, cows, mid)) {
                dist = mid;
                low = mid + 1; // if cows can be placed with at least distance `mid` try to increse the value of mid (minimum distance between any 2 cows) so that I can get maximum possible minimum distance
            }
            else {
                high = mid - 1; // if cows can't be placed with at least distance `mid` try to decrese the value of mid (minimum distance between any 2 cows) so that I can get maximum possible minimum distance
            }
        }

        return dist;
    }

    public static void main(String[] args) {
        int[] stalls = new int[]{0, 3, 4, 7, 10, 9};
        int cows = 4;
        System.out.println(aggressiveCows(stalls, cows));
        System.out.println(aggressiveCows2ndApproach(stalls, cows));
    }
}
