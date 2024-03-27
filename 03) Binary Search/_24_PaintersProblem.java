public class _24_PaintersProblem {

    public static int paintBoards(int[] boards, int timeLimit) {
        int painters = 1; // Start with the 1st painter
        int time = 0; // initially he didn't started painting, so time is 0

        for(int i=0; i<boards.length; i++) {
            if(time + boards[i] <= timeLimit) {
                time += boards[i];
            }
            else {
                painters++;
                time = boards[i];
            }
        }

        return painters;
    }

    public static int minTimeToPaintAll(int[] boards, int painters) {
        int low = 0, high = 0;

        for(int i=0; i<boards.length; i++) {
            low = Math.max(low, boards[i]);
            high += boards[i];
        }

        // Suppose there are 2 boards and 2 painters. So 1st painter will paint the 1st board and the 2nd painter will paint the 2nd one.
        // So, overall time will be taken by the painter who is painting the larger board.
        // because the painter who is painting small board, he will finish earlier
        // but who is painting large board, he will finish later. So we can say at least this much time is required to finish painting of all the boards
        // so our Range is : [max(boards), sum(boards)]
        // If there are only 1 painters and multiple boards, then at least he will paint all the boards. So time taken: sum of all the element in boards array

        int time = low; // starting of the range (at least the painter will take this much time to finish all the tasks)

        while(low <= high) {
            int mid = low + (high - low) / 2; // least time to finish all the paintings 
            
            int requiredPainters = paintBoards(boards, mid); // in this least time how many painters are painting the boards

            if(requiredPainters <= painters) {
                time = mid;
                high = mid - 1; // reduce the time limit (least time when all the painters will finish painting)
                // if required painters < painters, why did it happen? => the reason is I have set the time limit (least time to finish all the paintings) so high that the less number of painters also can finish all the paintings in this timelimit
                // if required painters == painters, then for this time limit painters were able to finish all the paintings. But still, I want the lesser value of time limit (least time to finish all the paintings)
            }
            else {
                low = mid + 1; // increase the time limit (least time when all the painters will finish painting)
                // if required painters > painters, why did it happen? => the reason is I have set the time limit (least time to finish all the paintings) so less that all the painters can not finish all the paintings in this timelimit (that's why more painters were required)
            }
        }

        return time;
    }

    public static void main(String[] args) {
        int[] boards = new int[]{2, 1, 5, 6, 2, 3};
        int painters = 2;
        System.out.println(minTimeToPaintAll(boards, painters));
    }
}
