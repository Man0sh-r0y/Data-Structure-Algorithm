import java.util.HashMap;
import java.util.Map;

// Java HashMap class implements the Map interface which allows us to store key and value pair, where keys should be unique. If you try to insert the duplicate key, it will replace the element of the corresponding key
public class HashMapInJava {
    public static void main(String[] args) {
        HashMap<String, Integer> rollNo = new HashMap<String, Integer>();

        // to add items to it, use the put() method
        rollNo.put("Manash", 1);
        rollNo.put("Rahul", 5);
        rollNo.put("Riya", 7);

        // To access a value in the HashMap, use the get() method and refer to its key
        System.out.println(rollNo.get("Manash"));// I have to pass the key
        System.out.println(rollNo.get("Riya"));

        // HashMap size
        System.out.println(rollNo.size());

        // Use the keySet() method if you only want the keys,
        // and use the values() method if you only want the values
        for (String i : rollNo.keySet()) {
            System.out.println(i);
        }
        // print values
        for (Integer i : rollNo.values()) {
            System.out.println(i);
        }

        // print keys & values together
        for (String i : rollNo.keySet()) {
            System.out.println("key: " + i + ", value: " + rollNo.get(i));
        }
        // One more way to print keys & values
        for (Map.Entry m : rollNo.entrySet()) {
            System.out.println(m.getKey() + " " + m.getValue());
        }
        // To get the key and value elements,
        // we should call the getKey() and getValue() methods.
        // The Map.Entry interface contains the getKey() and getValue() methods.
        // But, we should call the entrySet() method of Map interface
        // to get the instance of Map.Entry.

        // Replace items
        rollNo.replace("Riya", 7, 2);// key-oldvalue-newvalue
        System.out.println(rollNo.get("Riya"));

        // Remove an item
        rollNo.remove("Rahul");
        rollNo.remove("riya", 7);

        // Remove all items
        rollNo.clear();

    }
}
