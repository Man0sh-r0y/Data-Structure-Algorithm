
public class _17_MinDaysToMakeBouquets {

    public static int[] findMinMax(int[] arr) {
        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;

        for(int i=0; i<arr.length; i++) {
            min = Math.min(min, arr[i]);
            max = Math.max(max, arr[i]);
        }

        return new int[]{min, max};
    }

    public static int totalBouquets(int[] bloomDay, int days, int k) {
        int bouquets = 0, count = 0;

        for(int i=0; i<bloomDay.length; i++) {
            if(bloomDay[i] <= days) 
                count++;
            else 
                count = 0;

            if(count == k) {
                bouquets++;
                count = 0;
            }
        }

        return bouquets;
    }

    // Brute Force Approach
    public static int minDays(int[] bloomDay, int m, int k) {
        if(bloomDay.length < m*k) // Not enough flowers to make m bouquets (each of k flowers)
            return -1;

        int[] minMax = findMinMax(bloomDay);
        int min = minMax[0], max = minMax[1];

        for(int days=min; days<=max; days++) {
            int bouquets = totalBouquets(bloomDay, days, k);

            if(bouquets >= m) 
                return days;
        }

        return -1;
    }

    // Optimal Approach
    public static int minDays2(int[] bloomDay, int m, int k) {
        int days = -1;

        if(bloomDay.length < m*k) // Not enough flowers to make m bouquets (each of k flowers)
            return days;;
        
        int[] minMax = findMinMax(bloomDay);

        int low = minMax[0], high = minMax[1];

        while(low <= high) {
            int mid = low + (high - low) / 2;

            int bouquets = totalBouquets(bloomDay, mid, k);

            if(bouquets >= m) {
                days = mid;
                high = mid - 1;
            }
            else {
                low = mid + 1;
            }
        }

        return days;
    }

    public static void main(String[] args) {
        int[] bloomDay = {7,7,7,7,12,7,7};
        int m = 2, k = 3;
        System.out.println("Minimum days to make bouquets: " + minDays(bloomDay, m, k));
        System.out.println("Minimum days to make bouquets: " + minDays2(bloomDay, m, k));
    }
}
