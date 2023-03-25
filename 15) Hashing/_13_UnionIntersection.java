import java.util.HashSet;

public class _13_UnionIntersection {

    public static void union(int[] arr1, int[] arr2) {
        HashSet<Integer> set = new HashSet<>();

        for (int i = 0; i < arr1.length; i++) {
            set.add(arr1[i]);
        }
        for (int i = 0; i < arr2.length; i++) {
            set.add(arr2[i]);
        }
        System.out.println(set);
    }

    public static void intersection(int[] arr1, int[] arr2) {
        HashSet<Integer> set = new HashSet<>();
        // We will all all the array 1 elements into the set
        for (int i = 0; i < arr1.length; i++) {
            set.add(arr1[i]);
        }
        // if we found same element then we will print and the will remove also
        // As if it comes again later then we will not print that anymore.
        for (int i = 0; i < arr2.length; i++) {
            if (set.contains(arr2[i])) {
                System.out.print(arr2[i] + " ");
                set.remove(arr2[i]);
            }
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] arr1 = { 7, 3, 9 };
        int[] arr2 = { 6, 3, 9, 2, 9, 4 };
        union(arr1, arr2);
        intersection(arr1, arr2);
    }
}
