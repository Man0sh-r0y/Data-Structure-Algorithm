public class towerOfHanoi {
    public static void TowerOfHanoi(int n, char src, char helper, char dest) {
        if (n == 1) {
            System.out.println("Move disk " + n + " from " + src + " to " + dest);
            return;
        }
        TowerOfHanoi(n - 1, src, dest, helper);
        System.out.println("Move disk " + n + " from " + src + " to " + dest);
        TowerOfHanoi(n - 1, helper, src, dest);
    }

    public static void main(String[] args) {
        int n = 4;

        TowerOfHanoi(n, 'A', 'B', 'C');
    }
}
