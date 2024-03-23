public class _19_ShipPackagesWithinDays {

    public static int[] findMinMax(int[] arr) {
        int min = arr[0], max = 0;

        for(int i=0; i<arr.length; i++) {
            min = Math.min(arr[i], min);// min will be minimum amoung all the weights
            max += arr[i];// max weights will be sum of all the weights
        }

        return new int[]{min, max};
    }

    public static int countDays(int[] weights, int capacity){
        int days = 1; // first day
        int load = 0; // initially the ship is empty

        for(int i=0; i<weights.length; i++) {
            if(weights[i] > capacity) 
                return Integer.MAX_VALUE; // If the current weight is greater than the machine's capacity then machine can't carry it. So No days will found, So return Integer.MAX_VALUE (unlimited days)

            if(load + weights[i] <= capacity) {
                load += weights[i]; // load the weight to Ship
            }
            else {
                days++; // move to next day
                load = weights[i]; // load the weight to Ship
            }
        }

        return days;
    }

    public static int shipWithinDays(int[] weights, int days) {
        int minWeight = 0;
        int[] minMax = findMinMax(weights);
        // The machine can carry at least a package within a Day (The package which has minimum weight amoung all the packages)
        // The machine can carry at most all the packages in a day (All the weights)
        // So the range is [minimum weight amoung all the packages, All the weights]
        // But I have to find the minimum weights that the machine can carry and can be shipped in the given days

        int low = minMax[0], high = minMax[1];
        // low is pointing to min weight amoung all the packages
        // High is pointing to the at most weight which is sum of all the weight

        while(low <= high) {
            int mid = low + (high - low) / 2;
            int daysToShip = countDays(weights, mid);

            if(daysToShip <= days) {
                minWeight = mid;
                high = mid - 1;
            }
            else {
                low = mid + 1;
            }
        }

        return minWeight;
    }

    public static void main(String[] args) {
        int[] weights = new int[]{1,2,3,4,5,6,7,8,9,10};
        int days = 5;
        System.out.println(shipWithinDays(weights, days));
    }
}
