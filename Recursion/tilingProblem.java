import java.util.*;

public class tilingProblem {

    public static int organiseTiles(int n) {
        if (n == 0 || n == 1) {
            return 1;
        }
        int fnm1 = organiseTiles(n - 1);// Horizontally
        int fnm2 = organiseTiles(n - 2);// vertically
        int totWays = fnm1 + fnm2;
        return totWays;
    }

    public static void main(String[] args) {
        /*
         * we have been given 2 X n board
         * where we have to organise 2 X 1 size tiles
         * In how many ways can we do it?
         */
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the length of the Board? ");
        int n = sc.nextInt();
        System.out.println(organiseTiles(n));
        sc.close();
    }
}
