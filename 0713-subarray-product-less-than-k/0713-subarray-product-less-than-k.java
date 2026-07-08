class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        int high = 0 ;
        int low = 0 ;
        int count = 0;
        int n = nums.length;
        int product = 1;
        while(high<n){
            product = product * nums[high];
            while(product >= k){
               product = product/nums[low];
               low++; 
            }
            count = count + high-low+1;
            high++;
        }
        return count;
    }
}