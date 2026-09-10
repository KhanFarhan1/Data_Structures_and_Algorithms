class Solution {
    public int peakIndexInMountainArray(int[] nums) {
        // int si = 0;
        // int ei = arr.length-1;
        // while(si < ei){
        //     int mid = si +((ei - si)/2);
        //     if(arr[mid] < arr[mid+1]){
        //         si = mid+1;
        //     }else{
        //         ei = mid;
        //     }
        // }
        // return ei;
        int n = nums.length;
        if(n == 1){
            return 0;
        }
        if(nums[0] > nums[1]){
        return 0;
        } 
        if(nums[n-1] > nums[n-2]){
        return n-1;
        }
       int i = 1;
       int j = n-2;
       while(i<=j){
        int mid = (i+j)/2;
        //best-case 
        if(nums[mid] > nums[mid+1] && nums[mid] > nums[mid-1]){
            return mid;
        }else if(nums[mid] < nums[mid+1]){
            i = mid+1;
        }else{
            j=mid-1;
        }
       } 
       return -1;
    }
}