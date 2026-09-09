class Solution {
    public int findMin(int[] nums) {
        int si = 0,ei = nums.length-1;
        int res = Integer.MAX_VALUE;
        while(si <= ei){
            int mid =(si +ei)/2;
            if(nums[mid] > nums[nums.length-1]){
                si = mid+1;
            }else{
                res = Math.min(res, mid);
                ei = mid-1;
            }
        }
        return nums[res];
    }
}
