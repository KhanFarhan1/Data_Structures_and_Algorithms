class Solution {
    
    public int[] twoSum(int[] nums, int target) {
         HashMap<Integer , Integer> freq = new HashMap<>();
         for(int i = 0;i<nums.length;i++){
            int diff = target - nums[i];
            if(freq.containsKey(diff)){
                int [] ans = new int[]{i , freq.get(diff)};
                return ans;
            }
            freq.put(nums[i] , i);
            }
         return new int[]{};
    }
}