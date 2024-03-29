public class _25_RowWithMax1 {

    public static int findLowerBoundOfOne(int[] arr) {// this function will find the starting index of 1
        int indx = -1;

        int low = 0, high = arr.length - 1;

        while(low <= high) {
            int mid = low + (high - low) / 2;

            if(arr[mid] == 1) {
                indx = mid;
                high = mid - 1;
            }
            else {
                low = mid + 1;
            }
        }

        return indx;
    }

    public static int maxOnesRow(int[][] arr) {
        int rowIndex = -1, prevFreqOfOne = 0;

        for(int i=0; i<arr.length; i++) {
            int s = findLowerBoundOfOne(arr[i]); // starting index of 1
            int l = arr[i].length - 1; // ending index of 1

            if(s != -1) {
                int freqOfOne = l - s + 1; // count the occurences of 1

                if(freqOfOne > prevFreqOfOne) {
                    rowIndex = i;
                    prevFreqOfOne = freqOfOne;
                }
            }
        }

        return rowIndex;
    }

    public static void main(String[] args) {
        int[][] arr = new int[][] {
            {1, 1, 1},
            {0, 0, 1},
            {0, 0, 0}
        };
        System.out.println(maxOnesRow(arr));
    }
}
