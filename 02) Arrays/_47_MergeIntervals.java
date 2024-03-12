import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
public class _47_MergeIntervals {

    // Brute Force Solution
    public static int[][] merge(int[][] intervals) {
        int n = intervals.length;
        List<List<Integer>> ansList = new ArrayList<>();
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);

        for(int i=0; i<n; i++) {
            int start = intervals[i][0]; // start of the interval
            int end = intervals[i][1]; // end of the interval

            if(!ansList.isEmpty() && ansList.get(ansList.size() - 1).get(1) >= start) {
                continue;
            }

            for(int j=i+1; j<n; j++) {
                if(end < intervals[j][0])
                    break;
                end = Math.max(end, intervals[j][1]);
            }
            ansList.add(Arrays.asList(start, end));
        }

        int[][] ans = new int[ansList.size()][2];

        for(int i=0; i<ansList.size(); i++) {
            ans[i][0] = ansList.get(i).get(0);
            ans[i][1] = ansList.get(i).get(1);
        }

        return ans;
    }

    // Optimal Solution
    public static int[][] merge2(int[][] intervals) {
        int n = intervals.length;
        List<List<Integer>> ansList = new ArrayList<>();
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);

        ansList.add(Arrays.asList(intervals[0][0], intervals[0][1]));

        for(int i=1; i<n; i++) {
            int start = intervals[i][0]; // start of the interval
            int end = intervals[i][1]; // end of the interval
            List<Integer> prevList = ansList.get(ansList.size() - 1);

            if(prevList.get(1) >= start){
                end = Math.max(end, prevList.get(1));
                prevList.set(1, end);
            } else {
                ansList.add(Arrays.asList(start, end));
            }
        }

        int[][] ans = new int[ansList.size()][2];

        for(int i=0; i<ansList.size(); i++) {
            ans[i][0] = ansList.get(i).get(0);
            ans[i][1] = ansList.get(i).get(1);
        }

        return ans;
    }

    public static void main(String[] args) {
        //int[][] intervals = {{1, 3}, {2, 6}, {8, 10}, {15, 18}};
        //int[][] intervals = {{1, 4}, {4, 5}};
        int[][] intervals = {{1, 5}, {3, 5}, {6, 10}, {7, 9}, {2, 4}};
        int[][] result = merge2(intervals);
        System.out.println(Arrays.deepToString(result));
    }
}
