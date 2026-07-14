class Solution {
    public int longestOnes(int[] nums, int k) {
        int high = 0;
        int low = 0;
        int count = 0;
        int maxlen = Integer.MIN_VALUE;
        while(high<nums.length){
            if(nums[high] == 0){
                count++;
            }
            while(count>k){
                if(nums[low]==0){
                    count--;
                }
                low++;
            }
            maxlen = Math.max(maxlen,high-low+1);
            high++;
        }
        return maxlen;
    }
}