public class _02_CircularQueueUsingArray {

    static int arr[];
    static int front = -1, rear = -1;// initially front & rear is -1
    static int size;

    public static boolean isFull() {
        return (rear + 1) % size == front;
    }

    public static boolean isEmpty() {
        return rear == -1 && front == -1;
    }

    public static void add(int element) {
        if (isFull()) {
            System.out.println("Queue is Full.");
            return;
        }

        if (isEmpty()) { // inserting 1st element
            front = rear = 0;
        } else {
            rear = (rear + 1) % size;
        }
        arr[rear] = element;
        System.out.println(arr[rear] + " Added");
    }

    public static void remove() {
        if (isEmpty()) {
            System.out.println("Queue is Empty.");
            return;
        }

        if (front == rear) {// when there are single element left in the array/Queue
            System.out.println("Deleted " + arr[front]);
            front = rear = -1;
        } else {
            System.out.println("Deleted " + arr[front]);
            front = (front + 1) % size;
        }
    }

    public static void display() {
        if (isEmpty()) {
            System.out.println("Queue is empty.");
            return;
        }

        int i = front;
        while (i != rear) {
            System.out.print(arr[i] + " ");
            i = (i + 1) % size;
        }
        System.out.println(arr[i] + " "); // printing the rear (last left element)
    }

    public static void main(String[] args) {
        size = 5;
        arr = new int[size]; // declearing the size
        add(1);
        add(2);
        add(3);
        add(4);
        add(5);
        display();
        remove();
        remove();
        display();
        add(6);
        add(7);
        add(8);
        display();
    }
}
