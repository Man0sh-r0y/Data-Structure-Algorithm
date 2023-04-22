public class _02_StackUsingLinkedList {

    public static class node { // creating linkedlist node
        int data;
        node next;

        node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public static node Top = null; // statck top initializes with null

    public static boolean isEmpty() {
        return Top == null;
    }

    public static void push(int data) {
        node newNode = new node(data);
        if (isEmpty()) {
            Top = newNode;
            return;
        }
        // addFirst() function of linkedlist
        newNode.next = Top;
        Top = newNode;
    }

    public static int pop() {
        if (isEmpty()) {
            return -1;
        }
        int val = Top.data;
        Top = Top.next;
        return val; // return the value which has been deleted
    }

    public static int peek() {
        if (isEmpty()) {
            return -1;
        }
        return Top.data;
    }

    public static void display() {
        node temp = Top;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        _02_StackUsingLinkedList s = new _02_StackUsingLinkedList();
        s.push(1);
        s.push(2);
        s.push(3);
        s.push(4);
        s.push(5);
        s.push(6);
        display();
        s.pop();
        s.pop();
        display();
    }
}
