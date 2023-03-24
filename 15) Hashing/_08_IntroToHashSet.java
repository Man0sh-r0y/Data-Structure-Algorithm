import java.util.HashSet;

public class _08_IntroToHashSet {
    public static void main(String[] args) {
        HashSet<Integer> set = new HashSet<>();
        // Internally HashSet is implemented in HashMap
        // Only unique value is stored here.
        // as it's implemented in HashMap,
        // so every value is mapped with some dummy value.
        // so no dublicate isn't allowed
        set.add(1);
        set.add(2);
        set.add(4);
        set.add(3);
        set.add(1);
        set.add(2);
        System.out.println(set);// [1, 2, 3, 4]
        // Only unique value is stored

        // contains key or not
        System.out.println(set.contains(1));// true

        // Set size:
        System.out.println(set.size());// 4

        // Clear the whole set
        set.clear();
        System.out.println();

        // isEmpty or not
        System.out.println(set.isEmpty());// true
    }
}
