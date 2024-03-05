public class _08_BuyAndSellStocks {

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

    public static int maxProfit(int[] prices) {
        int buyPrice = prices[0]; // At day 0, I'll buy the stock, as I on't any
        int profit = 0; // initially profit is 0

        for(int i=1; i<prices.length; i++) {
            if(prices[i] < buyPrice) {// if current price is lesser than the price in which I previouly bought, then today again I have to buy, I can't sell as it will not make profit
                buyPrice = prices[i]; // buy prices gets updated
            } else {
                profit = Math.max(profit, prices[i] - buyPrice); // if current price is greater than the price in which I previouly bought, then today I can sell, so I'll calculate the profit
            }
        }

        return profit;
    }

    public static void main(String args[]) {
        int[] prices = new int[]{7,1,5,3,6,4};
        System.out.println(maxProfit(prices));
    }
}
