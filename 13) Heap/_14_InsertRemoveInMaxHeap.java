import java.util.ArrayList;

public class _14_InsertRemoveInMaxHeap {

    public static class Heap {
        ArrayList<Integer> heap = new ArrayList<>();

        public void add(int data) {
            heap.add(data);

            int childIndx = heap.size() - 1;
            int parentIndx = (childIndx - 1) / 2;

            while(heap.get(parentIndx) < heap.get(childIndx)) {
                // Swap the position
                int temp = heap.get(parentIndx);
                heap.set(parentIndx, heap.get(childIndx));
                heap.set(childIndx, temp);

                childIndx = parentIndx;
                parentIndx = (childIndx - 1) / 2;
            }
        }

        public int remove() {
            // Swap the psotion  of root element with the last element
            int temp = heap.get(0);
            heap.set(0, heap.get(heap.size() - 1));
            heap.set(heap.size() - 1, temp);

            heap.remove(heap.size() - 1);

            heapify(0);

            return temp; // returing the removed element
        }

        public void heapify(int indx) {
            int leftChildIndx = 2*indx + 1;
            int rightChildIndx = 2*indx + 2;
            int maxIndx = indx; // assuming the parent index is the max element

            if(leftChildIndx < heap.size() && heap.get(maxIndx) < heap.get(leftChildIndx)) {
                maxIndx = leftChildIndx;
            }

            if(rightChildIndx < heap.size() && heap.get(maxIndx) < heap.get(rightChildIndx)) {
                maxIndx = rightChildIndx;
            }

            if(maxIndx != indx) {
                int temp = heap.get(maxIndx);
                heap.set(maxIndx, heap.get(indx));
                heap.set(indx, temp);
                heapify(maxIndx);
            }
        }

        public boolean isEmpty() {
            return heap.size() == 0;
        }

        public int peak() {
            return heap.get(0);
        }

        public String toString() {
            return heap.toString();
        }
    }

    public static void main(String[] args) {
        Heap heap = new Heap();
        
        heap.add(3);
        heap.add(4);
        heap.add(1);
        heap.add(5);

        System.out.println(heap);
        System.out.println("Peak element: " + heap.peak());

        while(!heap.isEmpty())
            System.out.println(heap.remove());
    }
}
