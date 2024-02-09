public class _17_CheckIfArraySorted {

    public static int isSorted(int n, int []arr) {
        if(n == 0 || n == 1) return 1;

        for(int i=0; i<arr.length-1; i++) {
            if(arr[i] > arr[i+1]) return 0;
        }

        return 1;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1, 2, 3, 4, 5};
        System.out.println(isSorted(arr.length, arr));
    }
}
