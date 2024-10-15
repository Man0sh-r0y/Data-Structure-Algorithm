import java.util.LinkedList;
import java.util.Queue;

public class _14_Stackusing2Queues {

    static class MyStack {

        Queue<Integer> q1;
        Queue<Integer> q2;

        public MyStack() {
            q1 = new LinkedList<>();
            q2 = new LinkedList<>();
        }
        
        public void push(int x) {
            if(!q1.isEmpty()) 
                q1.add(x);
            else 
                q2.add(x);
        }
        
        public int pop() {
            if(!q1.isEmpty()) {
                int n = q1.size() - 1;
                for(int i=0; i<n; i++) {
                    q2.add(q1.remove());
                }

                return q1.remove();
            } 
            else {
                int n = q2.size() - 1;
                for(int i=0; i<n; i++) {
                    q1.add(q2.remove());
                }

                return q2.remove();
            }
        }
        
        public int top() {
            if(!q1.isEmpty()) {
                int n = q1.size() - 1;

                for(int i=0; i<n; i++) {
                    q2.add(q1.remove());
                }

                int element = q1.remove();
                q2.add(element);
                return element;
            }
            else {
                int n = q2.size() - 1;

                for(int i=0; i<n; i++) {
                    q1.add(q2.remove());
                }

                int element = q2.remove();
                q1.add(element);
                return element;
            }
        }
        
        public boolean empty() {
            if(q1.isEmpty() && q2.isEmpty()) return true;

            return false;
        }
    }

    
    public static void main(String[] args) {
        MyStack s = new MyStack();

        s.push(1);
        s.push(2);
        s.push(3);

        // System.out.println(s.pop());
        // System.out.println(s.pop());
        // System.out.println(s.pop());
        System.out.println(s.top());


    }
}
