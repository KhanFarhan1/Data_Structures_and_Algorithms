class Solution {
    public int findMin(int[] arr) {
        int si = 0;
        int ei = arr.length-1;
        int mid;
        int res = Integer.MAX_VALUE;
        while(si<=ei){
            mid = si + (ei - si)/2;
            if(arr[mid] > arr[arr.length-1]){
                //part-1
                si = mid+1;
            }else{
                //part-2
                res = Math.min(res,arr[mid]);
                ei = mid-1;
            }
        }
        return res;
    }
}