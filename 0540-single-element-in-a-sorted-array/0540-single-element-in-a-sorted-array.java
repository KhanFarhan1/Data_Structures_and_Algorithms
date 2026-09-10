class Solution {
    public int singleNonDuplicate(int[] nums) {
        int n = nums.length;
        //if arr contain single element
        if(n == 1){
            return nums[0];
        }
        //remove edge cases
        if(nums[0] != nums[1]){
            return nums[0];
        }
        if(nums[n-1] != nums[n-2]){
            return nums[n-1];
        }
        //binary serach
        int si = 1;
        int ei = n-2;
        while(si <= ei){
            int mid = si +(ei-si)/2;
            //best-case
            if(nums[mid] != nums[mid+1] && nums[mid] != nums[mid-1]){
                return nums[mid];
            }
            //elimation(i.e. wheather we go to left or right)
            if(mid%2 == 0 && nums[mid+1] == nums[mid] || mid%2 == 1 && nums[mid] == nums[mid-1]){
                //go right
                si = mid+1;
            }else{
                //go left
                ei = mid-1;
            }
        }
        return -1;
    }
}