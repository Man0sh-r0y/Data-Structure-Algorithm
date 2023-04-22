import java.util.*;

public class _07_StockSpanProblem {

    public static void StockSpan(Stack<Integer> s, int stocks[], int span[]) {
        // we have to store the previous high index into the array
        span[0] = 1; // for 1st stack no preivious stock avalaible so it's only the stock
        // so consecutive days for that is = 1
        s.push(0); // pushing the index of 1st stock
        for (int i = 1; i <= stocks.length - 1; i++) {
            int currPrice = stocks[i];
            // while pushing we will check if our current pushing element is greater than or
            // equal to stack top then. we will pop from stack
            while (!s.isEmpty() && currPrice >= stocks[s.peek()]) {
                s.pop();
            }
            // calculate span for each stock
            if (s.isEmpty()) {
                // if stack is empty then we can say all the preious i elements are having
                // lesser price than current stock price
                // and we have to calculate the price of itself also.
                span[i] = i + 1; // that's why we did i+1
            } else {
                int prevHigh = s.peek(); // it is having the index of previous high stock price
                span[i] = i - prevHigh;
            }
            s.push(i);
        }

    }

    public static void main(String[] args) {
        // we have to find max no. of consecutive days for that price < = today's price
        int stocks[] = { 100, 80, 60, 70, 60, 85, 100 };
        int span[] = new int[stocks.length];
        // this span array will store the number of consecutive days for each stock
        StockSpan(new Stack<>(), stocks, span);
        for (int i = 0; i < stocks.length; i++) {
            System.out.print(span[i] + " ");
        }
    }
}
