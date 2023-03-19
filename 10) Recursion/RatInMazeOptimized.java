public class RatInMazeOptimized {

    public static void goToDest(int i, int j, int di[], int dj[], int n, int path[][], String move,
            boolean visitedPath[][]) {

        if (i == n - 1 && j == n - 1) {
            System.out.println(move);
            return;
        }

        for (int indx = 0; indx < n; indx++) {
            String str = "DLRU";
            int nexti = i + di[indx];
            int nextj = j + dj[indx];
            if (nexti >= 0 && nextj >= 0 && nexti < n && nextj < n && !visitedPath[nexti][nextj]
                    && path[nexti][nextj] != 0) {
                visitedPath[nexti][nextj] = true;
                goToDest(nexti, nextj, di, dj, n, path, move + str.charAt(indx), visitedPath);
                visitedPath[nexti][nextj] = false;
            }
        }

    }

    public static void main(String[] args) {
        int path[][] = { { 1, 0, 0, 0 },
                { 1, 1, 0, 1 },
                { 1, 1, 0, 0 },
                { 0, 1, 1, 1 } };
        int n = path.length;
        int m = path[0].length;
        int di[] = { 1, 0, 0, -1 };
        int dj[] = { 0, -1, +1, 0 };
        boolean visitedPath[][] = new boolean[n][m];
        goToDest(0, 0, di, dj, n, path, new String(""), visitedPath);
    }
}
