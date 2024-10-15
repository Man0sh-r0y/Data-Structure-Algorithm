import java.util.Stack;

public class _15_QueueUsing2Stacks {
    static class MyQueue {

        Stack<Integer> s1;
        Stack<Integer> s2;

        public MyQueue() {
            s1 = new Stack<>();
            s2 = new Stack<>();
        }
        
        public void push(int x) {
            s1.push(x);
        }
        
        public int pop() {
            int n = s1.size() - 1;

            for(int i=0; i<n; i++)
                s2.add(s1.pop());

            int element = s1.pop();

            while(!s2.isEmpty())
                s1.add(s2.pop());
            
            return element;
        }
        
        public int peek() {
            int n = s1.size() - 1;

            for(int i=0; i<n; i++)
                s2.add(s1.pop());

            int element = s1.peek();

            while(!s2.isEmpty())
                s1.add(s2.pop());
            
            return element;
        }
        
        public boolean empty() {
            if(s1.isEmpty()) return true;

            return false;
        }
    }

    public static void main(String[] args) {

        MyQueue q = new MyQueue();
        q.push(1);
        q.push(2);
        q.push(3);
        q.push(4);
        System.out.println(q.pop());
        System.out.println(q.pop());
        System.out.println(q.pop());
        System.out.println(q.pop());
    }
}
