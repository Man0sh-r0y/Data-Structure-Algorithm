
// Import the HashSet class
import java.util.HashSet;

// A HashSet is a collection of items where every item is unique, and it is found in the java.util package
public class HashSetInJava {
    public static void main(String[] args) {
        HashSet<String> cars = new HashSet<String>();

        // Adding elements
        cars.add("Volvo");
        cars.add("BMW");
        cars.add("Ford");
        cars.add("BMW");
        cars.add("Mazda");
        System.out.println(cars);

        // HashSet Size
        System.out.println(cars.size());

        // Check If an Item Exists
        System.out.println(cars.contains("Mazda"));// true

        // Loop Through a HashSet
        for (String i : cars) {
            System.out.println(i);
        }

        // Remove an Item
        cars.remove("Volvo");

        // To remove all items, use the clear() method
        cars.clear();
    }
}
