
public class _16_KokoEatingBananas {

    public static int findMax(int[] piles) {
        int max = piles[0];

        for(int i=1; i<piles.length; i++) {
            max = Math.max(piles[i], max);// find maximum in the piles array
        }

        return max;
    }

    public static long totalHourToEat(int[] piles, int k) {
        long hour = 0;

        for(int i=0; i<piles.length; i++) {
            if(piles[i] < k){// if any piles have less bananas than koko can eat per hour
                hour += 1; // then koko will eat only that much banana in that 1 hour
            }
            else {
                hour += piles[i] / k; // how many hours koko will take to eat all the bananas in that pile if she eats k bananas per hour
                if(piles[i] % k != 0){ // if remaining bananas are there in that pile then koko will take 1 more hour to eat those bananas
                    hour += 1;
                }
            }
        }

        return hour;
    }

    // Brute Force
    public static int minEatingSpeed(int[] piles, int h) {
        int k;// per hour koko eats bananas 

        int max = findMax(piles); // max in the piles array
        // koko can eat minimum 1 bananna per hour
        // koko can eat maximum findMax(piles) bananna per hour

        for(k=1; k<=max; k++) {
            long requiredTime = totalHourToEat(piles, k);
    
            if(requiredTime <= h) 
                break;
        }

        return k;
    }

    // Optimal approach
    public static int minEatingSpeed2(int[] piles, int h) {
        int k = 1;// per hour koko eats bananas
        int max = findMax(piles);
        // koko can eat minimum 1 bananna per hour
        // koko can eat maximum findMax(piles) bananna per hour

        int low = 1, high = max;

        while(low <= high) {
            int mid = low + (high - low) / 2;

            if(totalHourToEat(piles, mid) <= h) {// required time to finish all the bananas is less than or equal to h
                k = mid; // this is my possible answer
                high = mid - 1; // trim the search space to left as I want minimum value of k for that it satisfy the condition
            }
            else {// required time to finish all the bananas is more than h
                low = mid + 1; // trim the search space to right
            }
        }

        return k;
    }

    public static void main(String[] args) {
        int[] piles = new int[]{3,6,7,11};
        int hour = 8;
        System.out.println(minEatingSpeed(piles, hour));
        System.out.println(minEatingSpeed2(piles, hour));
    }
}
