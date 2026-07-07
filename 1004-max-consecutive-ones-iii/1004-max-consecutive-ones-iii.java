class Solution {
    public int longestOnes(int[] nums, int k) {
        int high =0 ;
        int low = 0;
        int zero = 0;
        int maxlen =0 ;
        int n = nums.length;
        while(high<n){
            if(nums[high]==0){
                zero++;
            }
            while(zero>k){
              if(nums[low]==0){
                zero--;
              }  
              low++;
            }
            int len = high-low+1;
            maxlen = Math.max(maxlen,len);
            high++;
        }
        return maxlen;
    }
}