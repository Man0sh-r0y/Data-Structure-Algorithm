import java.util.HashSet;
import java.util.Iterator;

public class _09_IterationInHashSet {
    public static void main(String[] args) {
        HashSet<String> cities = new HashSet<>();
        // Set doesn't follow the order (in which order we add the element)
        // priniting will not be done in the same order
        // so it's also unordered
        cities.add("Kolkata");
        cities.add("Delhi");
        cities.add("Mumbai");
        cities.add("Bengaluru");
        cities.add("Noida");
        cities.add("Chennai");

        // Method-1: Using Iterator

        Iterator city = cities.iterator(); // Iterator is an interface in JAVA
        // The iterator() method can be used to get an Iterator for any collection
        while (city.hasNext()) {
            // The hasNext() method of ListIterator interface is used to return true
            // if the given list iterator contains more number of element
            // during traversing the given list in the forward direction.
            System.out.print(city.next() + ", ");
            // The next() method => ListIterator interface
            // It is used to return the next element in the given list.
            // This method is used to iterate through the list.
        }

        System.out.println();

        // Method-2: Using Enhanced Loop / for each loop

        for (String myCity : cities) {
            System.out.print(myCity + ", ");
        }
    }
}
