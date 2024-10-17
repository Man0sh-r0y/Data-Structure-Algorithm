import java.util.Stack;

public class _18_SortStack {

    public static void placeItems(Stack<Integer> stack, int num) {
        if(stack.isEmpty() || num < stack.peek()) {
            stack.push(num);
            return;
        }
        int poppedElement = stack.pop();
        placeItems(stack, num);
        stack.push(poppedElement);
    }

    public static void sortStack(Stack<Integer> stack) {
		Stack<Integer> temp = new Stack<Integer>();

        temp.push(stack.pop());

        while(!stack.isEmpty()) {
            if(temp.peek() > stack.peek()) {
                temp.push(stack.pop());
            }
            else {
                placeItems(temp, stack.pop());
            }
        }

        while(!temp.isEmpty()) {
            stack.push(temp.pop());
        }
	}

    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<Integer>();
        stack.push(5);
        stack.push(-2);
        stack.push(9);
        stack.push(-7);
        stack.push(3);

        System.out.println("Before Sorting: " + stack);
        sortStack(stack);
        System.out.println("After Sorting: " + stack);
    }
}
