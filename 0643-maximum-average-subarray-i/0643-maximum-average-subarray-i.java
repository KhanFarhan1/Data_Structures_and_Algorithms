class Solution {
    public double findMaxAverage(int[] nums, int k) {
        int low = 0;
        int high = k-1;
        int maxSum = Integer.MIN_VALUE;
        int sum = 0;
        for(int i = 0;i<k;i++){
            sum = sum + nums[i];
        }
        while(high<nums.length){
            maxSum = Math.max(sum,maxSum);
            
            high++;
            if(high == nums.length){
                continue;
            }
            
            sum = sum+nums[high]-nums[low];
            
            low++;
        }
        return (double)maxSum/k;
    }
}