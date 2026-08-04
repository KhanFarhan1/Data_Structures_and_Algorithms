class Solution {
    public int pivotIndex(int[] nums) {
        int total_sum = nums[0];
        for(int i = 1;i<nums.length;i++){
            total_sum += nums[i];
        }
        int prefix=0;
        for(int i = 0;i<nums.length;i++){
            if(i == 0){
                prefix = 0;
            }else{
            prefix = nums[i-1] + prefix;
            }
            int suffix = total_sum - prefix - nums[i];
            if(prefix == suffix){
                return i;
            }
        }
        return -1;
    }
}