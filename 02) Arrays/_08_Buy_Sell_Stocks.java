public class _08_Buy_Sell_Stocks {

    // I will buy the stock when price is low
    // I will sell the stock when price is high
    // So I can earn max profit
    // I will be given the price array
    // at the 1st day, I have to buy the stock as this is the 1st day
    // after that day, I will comapare the previous buying price with the current price
    // if the current price is less than the previous buying price, I will buy the stock
    // if the current price is greater than the previous buying price, I will sell the stock
    // that's how I will evaluate the max profit from the given price array
    // With this algo, I can tell when max profit can be generated

    public static int buy_sell_Stocks(int price[]) {
        int buyPrice = Integer.MAX_VALUE, maxProfit = 0;
        
        for (int i = 0; i < price.length; i++) {
            if (buyPrice < price[i]) {
                int profit = price[i] - buyPrice;
                maxProfit = Math.max(maxProfit, profit);
            } else {
                buyPrice = price[i];
            }
        }
        return maxProfit;
    }

    public static void main(String args[]) {
        int price[] = { 7, 1, 5, 3, 6, 4 };
        System.out.println("Max Profit is " + buy_sell_Stocks(price));
    }
}
