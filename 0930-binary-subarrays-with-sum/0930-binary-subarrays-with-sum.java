class Solution {
    public int minfun(int[] nums,int goal){
        if(goal<0){
            return 0;
        }
        int high =0;
        int low = 0;
        int sum =0;
        int count =0;
        while(high<nums.length){
            sum = sum + nums[high];
            while(sum>goal){
                sum = sum - nums[low];
                low++;
            }
            count = count + high-low+1;
            high++;
        }
        return count;
    }
    public int numSubarraysWithSum(int[] nums, int goal) {
       return minfun(nums,goal)-minfun(nums,goal-1);
    }
}