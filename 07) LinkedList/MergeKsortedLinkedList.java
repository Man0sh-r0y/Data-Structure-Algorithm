import java.util.Scanner;

// We have K sorted linked lists of size N each, merge them and print the sorted output.
public class MergeKsortedLinkedList {

    static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    // creating using LinkedList using Recursion
    public static Node createLinkedList(int N) {
        // creating linkedlist of N nodes
        if (N <= 0) {
            return null;
        }
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the data for Node : ");
        int data = sc.nextInt();
        Node head = new Node(data);
        head.next = createLinkedList(N - 1);
        return head;
    }

    public static void mergeLinkedList(Node arr[]) {
        for (int i = 0; i < arr.length - 1; i++) {
            Node temp = arr[i];
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = arr[i + 1];
        }
    }

    // printing linkedlist
    public static void printLinkedList(Node head) {
        if (head == null) {
            System.out.println("LinkedList is Empty.");
            return;
        }
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + "->");
            temp = temp.next;
        }
        System.out.println("null");
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter The Number of LinkedList");
        int k = sc.nextInt();
        System.out.println("Enter the Number of The nodes in each LinkedList: ");
        int N = sc.nextInt();

        Node arr[] = new Node[k]; // creating an array of LinkedList
        // k is the number of linkedlist

        for (int i = 0; i < k; i++) {
            // creating k numbers of LinkedLists
            System.out.println("-------Create LinkedList " + (i + 1) + "-------");
            arr[i] = createLinkedList(N);
        }

        mergeLinkedList(arr);// merging LinkedList
        printLinkedList(arr[0]); // Printing them

        sc.close();
    }
}
