class Solution {
    public int maxAbsoluteSum(int[] nums) {
        int max_best_ending = nums[0];
        int min_best_ending = nums[0];

        int max_ans=nums[0];
        int min_ans=nums[0];
        for(int i =1;i<nums.length;i++){
            max_best_ending = Math.max(max_best_ending+nums[i],nums[i]);
            max_ans = Math.max(max_best_ending,max_ans);
            min_best_ending = Math.min(min_best_ending+nums[i] , nums[i]);
            min_ans = Math.min(min_best_ending,min_ans);
        }
        min_ans = Math.abs(min_ans);
        int ans = Math.max(min_ans,max_ans);
        return ans;
    }
}