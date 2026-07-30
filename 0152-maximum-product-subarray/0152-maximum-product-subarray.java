class Solution {
    public int maxProduct(int[] nums) {
       int res = nums[0];
       int min_bestending = nums[0];
       int max_bestending = nums[0];
       for(int i = 1;i<nums.length;i++){
        int v1 = nums[i];
        int v2 = nums[i] * max_bestending;
        int v3 = nums[i] * min_bestending;
        min_bestending = Math.min(v1,Math.min(v2,v3));
        max_bestending = Math.max(v1,Math.max(v2,v3));
        res = Math.max(res,Math.max(min_bestending,max_bestending));
       }
       return res;
    }
}