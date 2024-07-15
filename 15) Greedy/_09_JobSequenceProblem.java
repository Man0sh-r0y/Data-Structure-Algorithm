import java.util.*;

public class _09_JobSequenceProblem {

    static class Job {
        int id, deadline, profit;

        Job(int x, int y, int z) {
            this.id = x;
            this.deadline = y;
            this.profit = z;
        }

        @Override
        public String toString() {
            return "Job [id=" + id + ", deadline=" + deadline + ", profit=" + profit + "]";
        }
    }

    public static int[] JobScheduling(Job arr[], int n) {
        Arrays.sort(arr, new Comparator<Job>() {
            @Override
            public int compare(Job a, Job b) {
                return b.profit - a.profit; // sorted in decreasing order
            }
        });

        int maxDeadline = 0;

        for (int i = 0; i < n; i++)
            maxDeadline = Math.max(maxDeadline, arr[i].deadline);

        int[] deadline = new int[maxDeadline + 1]; // as I willnot conside 0th index. Days will start from 1
        Arrays.fill(deadline, -1); // fill all the days with -1 (initially)

        int jobDn = 0; // job done
        int maxProfit = 0; // max profit

        for (int i = 0; i < n; i++) {
            int indx = arr[i].deadline;
            while (indx-- > 0) { // if deadline is 3, then I will check from 3 to 1
                // Job can be done on that deadline day or any previous days
                if (deadline[indx] == -1) {
                    deadline[indx] = arr[i].id;
                    jobDn++;
                    maxProfit += arr[i].profit;
                    break;
                }
            }

        }

        return new int[] { jobDn, maxProfit };
    }

    public static void main(String[] args) {
        Job[] arr = { new Job(1, 4, 20), new Job(2, 1, 10), new Job(3, 1, 40), new Job(4, 1, 30) };

        int[] ans = JobScheduling(arr, arr.length);

        System.out.println("Job done = " + ans[0]);
        System.out.println("Max Profit = " + ans[1]);
    }
}
