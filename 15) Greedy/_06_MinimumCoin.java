import java.util.ArrayList;

public class _06_MinimumCoin {

    public static ArrayList<Integer> findMinCoins(int rupees, int[] coins) {
        ArrayList<Integer> coinList = new ArrayList<>();
        for (int i = coins.length - 1; i >= 0; i--) {
            while (rupees >= coins[i]) {
                rupees -= coins[i];
                coinList.add(coins[i]);
            }
        }
        return coinList;
    }

    public static void main(String[] args) {
        int[] coins = { 1, 2, 5, 10, 20, 50, 100, 500, 1000 };
        int rupees = 49;// Rupees is given. I have to find how can I represent this amount of Rupees
        // with this given coins. I have to take minimum number of coins from the Array
        // 49 = 20+20+5+2+2 (So this much coin is required)
        // each coin can be taken multiple times
        System.out.println(findMinCoins(rupees, coins));// [20, 20, 5, 2, 2]
    }
}
