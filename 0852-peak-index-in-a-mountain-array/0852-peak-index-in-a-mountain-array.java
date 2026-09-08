class Solution {
    public int peakIndexInMountainArray(int[] arr) {
        int si  = 0;
        int ei = arr.length-1;
        int mid;
        while(si < ei){
            mid = si + ((ei - si)/2);
            
            if(arr[mid] < arr[mid +1]){
                si = mid+1;
            }else {
                ei = mid;
            }
        }
        return ei;
    }
}