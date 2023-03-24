import java.util.LinkedList;
import java.util.ArrayList;

public class _03_ImplementingHashMap {
    // Generics also provide compile-time type safety
    // that allows programmers to catch invalid types at compile time.
    static class HashMap<k, v> {// generics. Here k and v can be any type of data
        private class Node {// LinkedList Node creation
            k key;// k can be any data type
            v value;// v can be any data type

            Node(k key, v value) {
                this.key = key;
                this.value = value;
            }
        }

        private int size;// size of the HashMap
        private LinkedList<Node> buckets[];// array of LinkedList

        @SuppressWarnings("unchecked")
        // It is used when Java generics just don't let you do what you want to
        // and thus, you need to explicitly specify to the compiler
        // that whatever you are doing is legal
        // and can be executed at the time of execution.
        public HashMap() {// constructor of HashMap class
            this.buckets = new LinkedList[4];
            for (int i = 0; i < buckets.length; i++) {
                this.buckets[i] = new LinkedList<>();// initialized with empty LinkedList
                // this above line may create error, as we have not specified
                // which type of data LionkedList will be stored
                // that's why we added @SuppressWarnings
            }

        }

        private int hashFunction(k key) {
            // this function will generate index number for a hashcode
            // for every unique key in hashmap
            // on this index number I can store our key
            return Math.abs(key.hashCode()) % buckets.length;
            // HashCode might be in -ve so we need the absolute value
            // HashCode can be like this 12345 etc.
            // We need a index number where I can store this unique hashcode
            // So we need this index number in the range of the buckets array length
            // So Math.abs(key.hashCode()) % buckets.length will give the index number
            // for the key where I can store this key and can directly access
        }

        private int searchInLinkedList(k key, int bi) {
            // on the given bucket index, there might be a LinkedList
            // in this LinkedList, there might be any node which I'm finding
            LinkedList<Node> ll = buckets[bi]; // bi => buckte index
            // int di = 0; // di => data index, (index of the node where my data is stored)
            for (int i = 0; i < ll.size(); i++) {
                Node node = ll.get(i);// getting node at index i
                if (node.key == key) {
                    return i;// return the index
                }
            }
            return -1;
        }

        @SuppressWarnings("unchecked")
        private void reHash() {
            // when size of buckets array will be full(length crossed, not anymore index is
            // getting for storing)
            // then raHashing will be done
            // if reHashing will not be done then it might possible
            // that in a particular bucket index all the key is present
            // and it's taking O(n) to search
            // so rehashing is important
            LinkedList<Node> oldBucket[] = buckets;// storing all the data of buckets array in a new one
            buckets = new LinkedList[2 * buckets.length];// resize of the buckets array by doubling the size
            for (int i = 0; i < buckets.length; i++) {
                buckets[i] = new LinkedList<>();// initializing with empty linkedLsits
                // this above line may create error, as we have not specified
                // which type of data LionkedList will be stored
                // that's why we added @SuppressWarnings
            }

            // add the datas in new Bucket
            for (int i = 0; i < oldBucket.length; i++) {
                LinkedList<Node> ll = oldBucket[i];
                for (int j = 0; j < ll.size(); j++) {
                    Node node = ll.remove();
                    put(node.key, node.value);
                    // removing and putting into the new bucket
                }
            }
        }

        public void put(k key, v value) {
            int bi = hashFunction(key);// bi => bucket index(index at the bucket array)
            int di = searchInLinkedList(key, bi);// di => data index
            // if there already present the key the update its value
            // otherwise create a new key

            if (di != -1) {
                Node node = buckets[bi].get(di);
                node.value = value;
                return;
            }
            buckets[bi].add(new Node(key, value));// added a key with its value
            size++;

            double lambda = (double) size / buckets.length;
            if (lambda > 2.0) {
                reHash();
            }
        }

        public v remove(k key) {
            int bi = hashFunction(key);// bi => bucket index(index at the bucket array)
            int di = searchInLinkedList(key, bi);// di => data index

            if (di != -1) {
                Node node = buckets[bi].remove(di);
                size--;
                return node.value;
            }
            return null;
        }

        public boolean containsKey(k key) {
            int bi = hashFunction(key);
            int di = searchInLinkedList(key, bi);

            if (di != -1)
                return true;

            return false;// else false
        }

        public v get(k key) {
            int bi = hashFunction(key);// bi => bucket index(index at the bucket array)
            int di = searchInLinkedList(key, bi);// di => data index
            if (di != -1) {
                Node node = buckets[bi].get(di);
                return node.value;
            }
            return null;
        }

        public ArrayList<k> keySet() {
            // for returning the keys of the hashmap
            ArrayList<k> keys = new ArrayList<>();
            for (int i = 0; i < buckets.length; i++) {
                LinkedList<Node> ll = buckets[i];
                for (Node node : ll)
                    keys.add(node.key);
            }
            return keys;
        }

        public boolean isEmpty() {
            return size == 0;
        }
    }

    public static void main(String[] args) {
        HashMap<String, Integer> map = new HashMap<>();
        map.put("India", 500);
        map.put("US", 200);
        map.put("Nepal", 300);
        map.put("Japan", 100);
        map.put("Chaina", 100);
        map.put("Pakistan", 100);

        ArrayList<String> keys = map.keySet();
        for (String key : keys) {
            System.out.println("key = " + key + ", value = " + map.get(key));
        }

        System.out.println(map.remove("Nepal"));
        System.out.println(map.containsKey("Nepal"));
        System.out.println(map.containsKey("India"));
    }
}
