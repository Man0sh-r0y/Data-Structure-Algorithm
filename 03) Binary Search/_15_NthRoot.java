public class _15_NthRoot {

    public static int NthRoot(int n, int m) {
        int low = 0, high = m;

        while(low <= high){
            int mid = (low + high) / 2;
            double power = Math.pow(mid, n);

            if(power == m){
                return mid;
            }
            
            if(power < m){
                low = mid + 1; // trim the search space to right
            }
            else {
                high = mid - 1; // trim the search space to left
            }
        }

        return -1; // if Nth Root isn't found (It should have to be an Integer)
    }

    public static void main(String[] args) {
        int n = 4;
        int m = 69;
        System.out.println(NthRoot(n, m));
    }
}
