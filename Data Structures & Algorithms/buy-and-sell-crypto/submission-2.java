class Solution {
    public int maxProfit(int[] prices) {
        int buyprice = Integer.MAX_VALUE;
        int profit = 0 ;
        for(int i = 0;i<prices.length;i++){
            if(buyprice>prices[i]){
                buyprice= prices[i];
            }else{
                profit = Math.max(profit , prices[i]-buyprice);
            }
        }
        return profit;
    }
}
