import java.util.Arrays;
class _16_SecondLargestNumber {

    // SECOND LARGEST ELEMENT
    // 1. If current element is greater than largest (As We took a largest variable), then update largest 
    // 2. if current element isn't greater than largest, then check if it is greater than second largest then update second largest

    // SECOND SMALLEST ELEMENT
    // 1. If current element is smaller than smallest(As We took a smallest variable), then update smallest
    // 2. If current element isn't smaller than smallest, then check if it is smaller than second smallest then update second smallest

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