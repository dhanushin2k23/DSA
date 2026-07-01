class Solution {
    public int maxProfit(int[] prices) {

        int left = 0;
        int right = 1;
        int max = 0;
        int count = 0;

        if (prices.length == 1)
            return max = 0;

        while (right <= prices.length - 1) {
            if (prices[left] > prices[right]) {
                left = right;
                right++;
            }else if (prices[left] < prices[right] ) {
                count = prices[right] - prices[left];
                right++;
            }else{
                right++;
            }

            if (count > max) {
                max = count;
            }
        }
        return max;
    }
}