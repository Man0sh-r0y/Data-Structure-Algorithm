import java.util.*;

public class StackUsingArrayList {

    static ArrayList<Integer> list = new ArrayList<>();

    public static boolean isEmpty() {
        return list.size() == 0;
    }

    public static void push(int data) {
        list.add(data);
    }

    public static int pop() {
        if (isEmpty()) {
            return -1;
        }
        int top = list.get(list.size() - 1);
        list.remove(list.size() - 1);
        return top;
    }

    public static int peek() {// returns the value at top
        if (isEmpty()) {
            return -1;
        }
        return list.get(list.size() - 1);
    }

    public static void main(String[] args) {
        StackUsingArrayList s = new StackUsingArrayList();
        s.push(1);
        s.push(2);
        s.push(3);
        s.push(4);
        s.push(5);
        System.out.println(list);
        s.pop();
        s.pop();
        System.out.println(list);
    }
}