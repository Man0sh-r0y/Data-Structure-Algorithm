public class CheckPalindrome {
    static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }

        public static Node head = null;

        public void addLast(int data) {
            if (head == null) {
                head = new Node(data);
                return;
            }
            Node temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            Node newNode = new Node(data);
            temp.next = newNode;
            newNode.next = null;
        }

        public void printLinkedList() {
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

        public boolean CheckPalindrome() {
            if (head == null || head.next == null) {
                return true;
            }
            // getting mid Node
            Node slow = head;
            Node fast = head;
            while (fast != null && fast.next != null) {
                slow = slow.next;
                fast = fast.next.next;
            }
            Node mid = slow;
            // reverse 2nd half
            Node curr = mid;
            Node prev = null;
            Node next;
            while (curr != null) {
                next = curr.next;
                curr.next = prev;
                prev = curr;
                curr = next;
            }
            Node rightHead = prev;
            Node leftHead = head;
            while (rightHead != null) {
                if (leftHead.data != rightHead.data) {
                    return false;
                }
                leftHead = leftHead.next;
                rightHead = rightHead.next;
            }
            return true;
        }

    }

    public static void main(String[] args) {
        Node head = new Node(1);
        head.addLast(2);
        head.addLast(2);
        head.addLast(2);
        head.addLast(1);
        head.printLinkedList();
        System.out.println(head.CheckPalindrome());
    }
}