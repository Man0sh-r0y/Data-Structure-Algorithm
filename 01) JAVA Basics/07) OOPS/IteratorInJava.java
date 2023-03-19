import java.util.Iterator;
import java.util.ArrayList;

// An Iterator is an object that can be used to loop through collections, like ArrayList and HashSet. It is called an "iterator" because "iterating" is the technical term for looping.
public class IteratorInJava {
    public static void main(String[] args) {
        ArrayList<String> cars = new ArrayList<String>();
        cars.add("Volvo");
        cars.add("BMW");
        cars.add("Ford");
        cars.add("Mazda");

        // Get the iterator
        Iterator<String> it = cars.iterator();
        // The iterator() method can be used to get an Iterator
        // for any collection Make a collection

        System.out.println(it.next());// Print the first item

        // To loop through a collection,
        // use the hasNext() and next() methods of the Iterator
        while (it.hasNext()) {
            System.out.println(it.next());
        }
        // .hashNext() => It returns true if there are more elements left in the
        // iteration. If there are no more elements left, then it will return false.
        // .next() => It returns the next element in the traversal

        it.remove();// Mazda deleted
        System.out.println(cars);

    }
}
