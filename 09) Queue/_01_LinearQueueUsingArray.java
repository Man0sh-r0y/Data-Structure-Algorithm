public class _01_LinearQueueUsingArray {

    static int arr[];
    static int front = -1, rear = -1;// initially front & rear is -1

    public static boolean isFull() {
        return rear == arr.length - 1;
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
            rear++;
        }
        arr[rear] = element;
        System.out.println("Element Added");
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
            front++;
        }
    }

    public static void display() {
        if (isEmpty()) {
            System.out.println("Queue is empty.");
            return;
        }

        for (int i = front; i <= rear; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int size = 5;
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
    }
}