package bd;

/**
 * 股票交易，只能买一次
 */
public class NC7 {
    public int maxProfit (int[] prices) {
        // write code here
        if(prices.length <= 1) return 0;
        int hasTick = 0 - prices[0];
        int maxProf = 0;

        for(int it : prices) {
            maxProf = Math.max(maxProf, hasTick + it);
            hasTick = Math.max(hasTick, 0 - it);
        }
        return maxProf;
    }
}
