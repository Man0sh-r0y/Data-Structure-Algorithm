public class _34_RatInMaze {

    public static void goToDest(int i, int j, int n, int path[][], String move, boolean visitedPath[][]) {
        // System.out.println("i= " + i + "j= " + j);
        if (i == n - 1 && j == n - 1) {
            System.out.println(move);
            return;
        }

        // down
        if (i + 1 < n && !visitedPath[i + 1][j] && path[i + 1][j] != 0) {
            visitedPath[i + 1][j] = true;
            goToDest(i + 1, j, n, path, move + 'D', visitedPath);
            visitedPath[i + 1][j] = false;
        }

        // left
        if (j - 1 >= 0 && !visitedPath[i][j - 1] && path[i][j - 1] != 0) {
            visitedPath[i][j - 1] = true;
            goToDest(i, j - 1, n, path, move + 'L', visitedPath);
            visitedPath[i][j - 1] = false;
        }

        // right
        if (j + 1 < n && !visitedPath[i][j + 1] && path[i][j + 1] != 0) {
            visitedPath[i][j + 1] = true;
            goToDest(i, j + 1, n, path, move + 'R', visitedPath);
            visitedPath[i][j + 1] = false;
        }

        // up
        if (i - 1 >= 0 && !visitedPath[i - 1][j] && path[i - 1][j] != 0) {
            visitedPath[i - 1][j] = true;
            goToDest(i - 1, j, n, path, move + 'U', visitedPath);
            visitedPath[i - 1][j] = false;
        }
    }

    public static void main(String[] args) {
        int path[][] = { { 1, 0, 0, 0 },
                { 1, 1, 0, 1 },
                { 1, 1, 0, 0 },
                { 0, 1, 1, 1 } };
        int n = path.length;
        int m = path[0].length;
        boolean visitedPath[][] = new boolean[n][m];
        goToDest(0, 0, n, path, new String(""), visitedPath);
    }
}
