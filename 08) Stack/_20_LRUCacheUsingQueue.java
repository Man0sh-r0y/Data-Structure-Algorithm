import java.util.HashMap;
import java.util.Queue;
import java.util.LinkedList;

public class _20_LRUCacheUsingQueue {

    static class LRUCache {
        private int capacity;
        private int size;
        private HashMap<Integer, Integer> map;
        private Queue<Integer> queue;

        public LRUCache(int capacity) {
            this.capacity = capacity;
            map = new HashMap<>();
            queue = new LinkedList<>();
        }
        
        public int get(int key) {
            if(!map.containsKey(key))
                return -1;
            
            Queue<Integer> temp = new LinkedList<>();

            while(!queue.isEmpty()) {

                if(queue.peek() == key)
                    queue.remove();
                else 
                    temp.add(queue.remove());
            }

            queue = temp;
            queue.add(key);

            return map.get(key);
        }
        
        public void put(int key, int value) {
            if(size < capacity || (size == capacity && map.containsKey(key))) {

                if(map.containsKey(key)) {
                    Queue<Integer> temp = new LinkedList<>();

                    while(!queue.isEmpty()) {

                        if(queue.peek() == key) 
                            queue.remove();
                        else
                            temp.add(queue.remove());
                    }

                    queue = temp;
                    queue.add(key);
                } 
                else {
                    queue.add(key);
                    size++;
                }

                map.put(key, value);
            }
            else {
                int oldestKey = queue.remove();
                map.remove(oldestKey);
                map.put(key, value);
                queue.add(key);
            }
        }
    }
}