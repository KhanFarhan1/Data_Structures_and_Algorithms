class Solution {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int maxDiff = Integer.MAX_VALUE;
        int diff;
        int result =0;
        for(int i = 0 ;i<nums.length-2;i++){
            if(i>0 && nums[i] == nums[i-1]){
                continue;
            }
            int left =i+1 ;
            int right = nums.length-1;
            while(left<right){
                int sum  = nums[left] + nums[right] + nums[i];
                diff = Math.abs(sum - target);
                if(diff < maxDiff){
                    maxDiff = diff;
                    result = sum;
                }
            if(sum == target){
                left++;
                right--;
                 while(left<right && nums[left] == nums[left-1]){
                left++;
            }
            while(left<right && nums[right] == nums[right+1]){
                right--;
            }
            }else if(sum > target){
                right--;
            }else{
                left++;
            }
           
            }
        }
        return result;
    }
}