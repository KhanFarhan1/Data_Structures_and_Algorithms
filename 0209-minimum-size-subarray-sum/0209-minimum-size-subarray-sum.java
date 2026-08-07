class Solution {
    public int minSubArrayLen(int target, int[] nums) {
      int high = 0;
      int low = 0;
      int res = Integer.MAX_VALUE;
      int sum = 0;
      while(high < nums.length){
        sum += nums[high];
        while(sum >= target){
            sum = sum - nums[low];
            res = Math.min(res,high-low+1);
            low++;
        } 
        high++;
      }
      if(res != Integer.MAX_VALUE){
        return res;
      }
      return 0;
    }
}