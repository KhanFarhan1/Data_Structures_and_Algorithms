class Solution {
    public boolean calculate(int[] nums , int k , int mid){
        int count = 0;
        for(int i = 0;i<nums.length;i++){
            if(count+nums[i] <= mid){
                count = count + nums[i];
                continue;
            }
            k--;
            count = nums[i];
            if(k == 0){
                return false;
            }
        }
        return true;
    }
    public int splitArray(int[] nums, int k) {
        int n = nums.length;
        if(n < k){
            return -1;
        }
        int si = Integer.MIN_VALUE;
        int ei = 0;
        int ans = Integer.MAX_VALUE;
        for(int i = 0;i<nums.length;i++){
            ei = ei + nums[i];
            si = Math.max(si , nums[i]);
        }
            while(si <= ei){
                int mid = si + (ei -si)/2;
                if(calculate(nums , k ,mid)){
                    ei = mid-1;
                    ans = Math.min(ans , mid);
                }else{
                    si = mid+1;
                }
            }
        return ans;
    }
}