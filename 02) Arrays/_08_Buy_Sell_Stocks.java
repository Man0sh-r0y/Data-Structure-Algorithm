public class _08_Buy_Sell_Stocks {

    // LOGIC:
    // The goal is to find the maximum profit that can be obtained by buying and selling a stock given its daily prices.
    // I will buy the stock when price is low
    // I will sell the stock when price is high
    // So I can earn max profit
    // I will be given the price array
    // at the 1st day, I have to buy the stock as this is the 1st day
    // For each day, compare the current stock price with the buyPrice:
    // If the current stock price is lower than the buyPrice, update the buyPrice to the current day's price, representing a potential buying opportunity.
    // If the current stock price is higher than the buyPrice, calculate the profit that could be obtained by selling at the current price (price[i] - buyPrice).
    // Update the maxProfit if the calculated profit is greater than the current maximum profit.

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
