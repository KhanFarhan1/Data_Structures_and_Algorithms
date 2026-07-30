class Solution {
    public int maxSubArray(int[] nums) {
    int best_ending = nums[0];
    int max_subarray = nums[0];
    for(int i =1;i< nums.length;i++){
        if(nums[i]+best_ending < nums[i]){
            best_ending = nums[i];
        }else{
            best_ending = nums[i]+best_ending;
        }
        max_subarray = Math.max(max_subarray,best_ending);
    }
    return max_subarray;
    }
}