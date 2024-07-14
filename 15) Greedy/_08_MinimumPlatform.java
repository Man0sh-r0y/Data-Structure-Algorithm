import java.util.Arrays;

public class _08_MinimumPlatform {

    public static int minimumPlatform(int[] arrival, int[] departure, int n) {
        Arrays.sort(arrival);
        Arrays.sort(departure);

        int platform = 1; // platform needed
        int maxPlatformUsed = 1; // max platform used
        int i = 1; // pointer at arrival array
        int j = 0; // pointer at departure array

        while(i < arrival.length && j < departure.length) {
            if(arrival[i] <= departure[j]) {
                platform++; i++;
            } 
            else {
                platform--; j++;
            }

            maxPlatformUsed = Math.max(maxPlatformUsed, platform);
        }
        
        return maxPlatformUsed; // return the platform needed
    }

    public static void main(String[] args) {
        int[] arrival = {900, 940, 950, 1100, 1500, 1800};
        int[] departure = {910, 1200, 1120, 1130, 1900, 2000};

        System.out.println(minimumPlatform(arrival, departure, arrival.length));
    }
}
