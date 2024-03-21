public class _14_FindSqrt {

    public static int findSqrt(long N) {
        long sqrt = Integer.MIN_VALUE;
        long low = 0, high = N;

        while(low <= high){
            long mid = low + (high - low) / 2;
            
            if(mid * mid <= N){
                sqrt = Math.max(sqrt, mid);
                low = mid + 1;
            }
            else {
                high = mid - 1;
            }
        }

        return (int)sqrt;
    }

    public static void main(String[] args) {
        int N = 25;
        System.out.println(findSqrt(N));
    }
}
