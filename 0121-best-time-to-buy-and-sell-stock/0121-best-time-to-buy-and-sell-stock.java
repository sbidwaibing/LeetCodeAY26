class Solution {
    public int maxProfit(int[] prices) {
       
        int[] dp = new int[prices.length];
        int best = 0;

        for(int i=1; i<prices.length; i++){
            
            int diff = prices[i] - prices[i-1];
            dp[i] = Math.max(0, dp[i-1] + diff);

            if(dp[i] > best){
                best = dp[i];
            }
        }

        return best;
    }
}