class Solution {
    public int search(int[] arr, int target) {
        int n = arr.length;
        int si = 0;
        int ei = n-1;
        int mid;
        while(si <= ei){
            mid = si + (ei - si)/2;
            if(arr[mid] == target){
                return mid;
            }
            if(arr[mid] > arr[n-1]){
                if(arr[mid]< target){
                    si = mid+1;
                }else{
                    if(arr[0] > target){
                        si = mid+1;
                    }else{
                        ei = mid-1;
                    }
                }
                continue;
            }else{
                if(arr[mid] > target){
                    ei = mid-1;
                }else{
                    if(arr[n-1]<target){
                        ei = mid-1;
                    }else{
                        si = mid+1;
                    }
                }
                continue;
            }
        }
        return -1;
    }
}
