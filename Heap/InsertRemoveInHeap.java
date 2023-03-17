import java.util.ArrayList;

public class InsertRemoveInHeap {

    public static class Heap {
        ArrayList<Integer> heap = new ArrayList<>();

        // insert in Heap
        public void add(int data) {
            heap.add(data);
            // in arraylist data are generally added at the last position
            int childIndx = heap.size() - 1;
            // the index of the inserted element. Inserted element generally added at the
            // last position
            int parentIndx = (childIndx - 1) / 2;
            // parent index of inserted element's index
            // Making MIN Heap
            while (heap.get(childIndx) < heap.get(parentIndx)) {// O(logn) Time complexity
                // swap
                int temp = heap.get(childIndx);
                heap.set(childIndx, heap.get(parentIndx));
                heap.set(parentIndx, temp);

                childIndx = parentIndx;
                parentIndx = (childIndx - 1) / 2;
            }
        }

        // remove from heap
        public void remove() {
            // step-1: swap 1st injdex & last index element
            int temp = heap.get(0);
            heap.set(0, heap.get(heap.size() - 1));
            heap.set(heap.size() - 1, temp);

            // step-2: remove the last index element
            heap.remove(heap.size() - 1);

            // step-3: Rebuild the heap property
            heapify(0);
            // calling heapify for the root element as root element breaks the heap property
            // because of swapping
        }

        // recreate the Min Heap Property
        private void heapify(int indx) {// parameter has the index of the root element
            int leftChildIndx = 2 * indx + 1;
            int rightChildIndx = 2 * indx + 2;
            int minIndx = indx; // assumimg that root has the minimum indx

            if (leftChildIndx < heap.size() && heap.get(minIndx) > heap.get(leftChildIndx)) {
                // if the 'indx' is not the index of leaf element then only Loop will run as
                // leaf element has no child . If its not leaf element, then child element will
                // be present in the heap size range
                minIndx = leftChildIndx;
                // whichever index element will be minimum that will be assigned into minIndx
            }
            if (rightChildIndx < heap.size() && heap.get(minIndx) > heap.get(rightChildIndx)) {
                // if the element has a right Child then only it will be true. For leaf element
                // it will be false.
                minIndx = rightChildIndx;
                // whichever index element will be minimum that will be assigned into minIndx
            }

            if (minIndx != indx) {
                int temp = heap.get(indx);
                heap.set(indx, heap.get(minIndx));
                heap.set(minIndx, temp);

                heapify(minIndx);
            }
        }

        // if heap is empty or not
        public boolean isEmpty() {
            return heap.size() == 0;
        }

        // Get minimum value from min Heap
        public int peek() {
            return heap.get(0);// as we know that root of Min Heap is the minimum value. And it's stored in 0th
                               // index in ArrayList
        }
    }

    public static void main(String[] args) {
        Heap heap = new Heap();
        heap.add(3);
        heap.add(4);
        heap.add(1);
        heap.add(5);

        while (!heap.isEmpty()) {
            System.out.print(heap.peek() + " ");// we will get the elements in sorted order
            heap.remove();
        }

        // That's how Priority Queue is implemented by Heap Data Structure

    }
}
