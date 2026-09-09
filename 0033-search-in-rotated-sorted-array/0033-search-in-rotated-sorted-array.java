class Solution {
    public int search(int[] arr, int target) {

        // int n = arr.length;
        // int si = 0;
        // int ei = n - 1;

        // int idx = Integer.MAX_VALUE;

        // // Find pivot / minimum element index
        // while (si <= ei) {
        //     int mid = si + (ei - si) / 2;

        //     if (arr[mid] > arr[n - 1]) {
        //         si = mid + 1;
        //     } else {
        //         idx = Math.min(idx, mid);
        //         ei = mid - 1;
        //     }
        // }

        // // Search in left sorted part
        // int low1 = 0;
        // int high1 = idx - 1;

        // while (low1 <= high1) {
        //     int mid1 = low1 + (high1 - low1) / 2;

        //     if (arr[mid1] == target) {
        //         return mid1;
        //     } else if (arr[mid1] < target) {
        //         low1 = mid1 + 1;
        //     } else {
        //         high1 = mid1 - 1;
        //     }
        // }

        // // Search in right sorted part
        // int low2 = idx;
        // int high2 = n - 1;

        // while (low2 <= high2) {
        //     int mid2 = low2 + (high2 - low2) / 2;

        //     if (arr[mid2] == target) {
        //         return mid2;
        //     } else if (arr[mid2] < target) {
        //         low2 = mid2 + 1;
        //     } else {
        //         high2 = mid2 - 1;
        //     }
        // }

        // return -1;

        // int n = arr.length;
        // int si = 0;
        // int ei = n-1;
        // int mid;
        // while(si<=ei){
        //     mid = si + (ei - ei)/2;
        //     //best case
        //     if(arr[mid] == target){
        //         return mid;
        //     }
        //     //check mid 
        //     if(arr[mid] < target){
        //         si = mid+1;
        //     }else{
        //         if(arr[0] > target){
        //             //go right
        //             si = mid+1;
        //         }else{
        //             //go left
        //             ei = mid-1;
        //         }
                
        //     }
        // }
        // return -1;

        int n = arr.length;
        int si = 0;
        int ei = n-1;
        int mid;
        while(si<=ei){
            mid = ei + (ei-ei)/2;
            if(arr[mid] == target){
                return mid;
            }
            if(arr[mid]>target){
                ei = mid-1;
            }else{
                if(target > arr[n-1]){
                    ei = mid-1;
                }else{
                    si = mid+1;
                }
            }
        }  
        return -1; 
    }
}