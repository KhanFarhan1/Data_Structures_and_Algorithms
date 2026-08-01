class Solution {
    public int maxSubarraySumCircular(int[] nums) {
        //for max
        int best_ending = nums[0];
        int ans = nums[0];
        //for min
        int min_best_ending = nums[0];
        int min_ans = nums[0];
        //total
        int total_sum = nums[0];
        //loop
        for(int i = 1;i<nums.length;i++){
            //for max
            best_ending = Math.max(best_ending+nums[i],nums[i]);
            ans = Math.max(best_ending,ans);
            //for min
            min_best_ending = Math.min(min_best_ending+nums[i],nums[i]);
            min_ans = Math.min(min_ans,min_best_ending);
            //total
            total_sum += nums[i];
        }
        
        if(total_sum-min_ans==0){
            return ans;
        }else{
        return Math.max(ans,total_sum-min_ans);
        }
    }
}