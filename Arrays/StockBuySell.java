package Arrays;

/*
 * Input: prices = [7,1,5,3,6,4]
 * Output: 5
 */
public class StockBuySell {
    public static void main(String[] args) {
        int prices[]={7,1,5,3,6,4};
        System.out.println(bruteForceApproach(prices));
        System.out.println(optimalApproach(prices));
    }

    // TC: O(N) SC:O(1)
    private static int optimalApproach(int[] prices) {
        int maxProfit=0;
        int minPrice=Integer.MAX_VALUE;
        for(int i=0;i<prices.length;i++){
            if(prices[i]<minPrice){
                minPrice=prices[i];
            }else if(prices[i]-minPrice>maxProfit){
                maxProfit=prices[i]-minPrice;
            }
        }
        return maxProfit;
    }

    // TC: O(N^2) SC:O(1)
    private static int bruteForceApproach(int[] prices) {
        int profit=0;
        for(int i=0;i<prices.length;i++){
            for(int j=i+1;j<prices.length;j++){
                if(prices[j]>prices[i]){
                   profit=Math.max(prices[j]-prices[i], profit); 
                }
            }
        }
        return profit;
    }
}
