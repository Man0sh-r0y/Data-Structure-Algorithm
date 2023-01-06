public class WordSearch {

    // This problem is solved by me (own)
    // I'm proud of myself

    public static boolean search(int i, int j, boolean map[][], int board[][], String word) {
        // System.out.println("i= " + i + "j= " + j); //for debuging the code
        if (word.length() == 0) {
            return true;
        }

        int n = board.length;
        int m = board[0].length;
        char ch = word.charAt(0);

        if (i >= n && j >= m && i < 0 && j < 0) {
            return false;
        }

        if (i + 1 < n && board[i + 1][j] == ch && !map[i + 1][j]) {// down checking
            map[i + 1][j] = true;
            boolean down = search(i + 1, j, map, board, word.substring(1));
            map[i + 1][j] = false;
            return down;
        } else if (i - 1 >= 0 && board[i - 1][j] == ch && !map[i - 1][j]) {// Up cheking
            map[i - 1][j] = true;
            boolean up = search(i - 1, j, map, board, word.substring(1));
            map[i - 1][j] = false;
            return up;
        } else if (j - 1 >= 0 && board[i][j - 1] == ch && !map[i][j - 1]) { // left cheking
            map[i][j - 1] = true;
            boolean left = search(i, j - 1, map, board, word.substring(1));
            map[i][j - 1] = false;
            return left;
        } else if (j + 1 < m && board[i][j + 1] == ch && !map[i][j + 1]) {// right cheking
            map[i][j + 1] = true;
            boolean right = search(i, j + 1, map, board, word.substring(1));
            map[i][j + 1] = false;
            return right;
        }

        return false;

    }

    public static boolean isWordExist(int board[][], boolean map[][], String word) {
        int n = board.length;
        int m = board[0].length;
        char ch = word.charAt(0);
        // searching for 1st char
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (ch == board[i][j]) {
                    if (search(i, j, map, board, word.substring(1)))
                        return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        // int board[][] = { { 'a', 'g', 'b', 'c' },
        // { 'q', 'e', 'e', 'l' },
        // { 'g', 'b', 'k', 's' } };
        // String word = "geeks";

        int board[][] = { { 'a', 'b', 'c', 'e' },
                { 's', 'f', 'c', 's' },
                { 'a', 'd', 'e', 'e' } };
        String word = "sabfs";

        int n = board.length;
        int m = board[0].length;
        boolean map[][] = new boolean[n][m];
        if (isWordExist(board, map, word)) {
            System.out.println("Word Exist");
        } else {
            System.out.println("Not Exist");
        }
    }
}
