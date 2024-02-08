import java.util.Arrays;
class _16_SecondLargestNumber {

    public static int[] getSecondOrderElements(int n, int []arr) {// O(n)
 
        int largest=Integer.MIN_VALUE, secndLargest=Integer.MIN_VALUE;
        int smallest=Integer.MAX_VALUE, secndSmallest=Integer.MAX_VALUE;

        for(int i=0; i<arr.length; i++) {
            // Second largest
            if(arr[i] > largest) {
                secndLargest = largest;
                largest = arr[i];
            } else if(arr[i] > secndLargest && arr[i] != largest) {
                secndLargest = arr[i];
            }

            // Second smallest
            if(arr[i] < smallest) {
                secndSmallest = smallest;
                smallest = arr[i];
            } else if(arr[i] < secndSmallest && arr[i] != smallest) {
                secndSmallest = arr[i];
            }
        }

        return new int[]{secndLargest, secndSmallest};
    }

    public static void main(String[] args) {
        int[] arr= new int[]{1,4,5,3,2};
        System.out.println(Arrays.toString(getSecondOrderElements(arr.length, arr)));
    }
}