class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int m = nums2.length;
        if(n>m){
            return findMedianSortedArrays(nums2 , nums1);
        }
        if((n+m)%2 == 0){//even case
            int low = 0;
            int high = n;
            int size = (n+m) /2;
            while(low <= high){
                int mid1 = low + (high - low)/2;
                //total element required from l1,l2,r1,r2
                int l1;
                if(mid1-1 >= 0){
                    l1 = nums1[mid1 -1];
                }else{
                    l1 = Integer.MIN_VALUE;
                }
                int l2;
                if(size - mid1 -1 >= 0){
                    l2 = nums2[size-mid1-1];
                }else{
                    l2 = Integer.MIN_VALUE;
                }
                int r1;
                if(mid1 < n){
                    r1 = nums1[mid1];
                }else{
                    r1 = Integer.MAX_VALUE;
                }
                int r2;
                if(size - mid1 < m){
                    r2 = nums2[size - mid1];
                }else{
                    r2 = Integer.MAX_VALUE;
                }
                if(l1 <= r2 && l2 <= r1){
                    //symmetric
                    return (Math.max(l1,l2)+Math.min(r1,r2))/2.0;
                }
                if(l1>r2){
                    high = mid1-1;
                }else{
                    low = mid1+1;
                }
            }
        }else{//odd case
            int low = 0;
            int high = n;
            int size = (n+m)/2+1;
            while(low <= high){
                int mid = (low+high)/2;
                int l1;
                if(mid-1 >= 0){
                    l1 = nums1[mid-1];
                }else{
                    l1 = Integer.MIN_VALUE;
                }
                int l2;
                if(size-mid-1 >= 0){
                    l2 = nums2[size-mid-1];
                }else{
                    l2 = Integer.MIN_VALUE;
                }
                int r1;
                if(mid < n){
                    r1 = nums1[mid];
                }else{
                    r1 = Integer.MAX_VALUE;
                }
                int r2;
                if(size-mid < m){
                    r2 = nums2[size - mid];
                }else{
                    r2 = Integer.MAX_VALUE;
                }
                if(l1 <= r2 && l2 <= r1){
                    return Math.max(l1 , l2);
                }
                if(l1 > r2){
                    high = mid-1;
                }else{
                    low = mid+1;
                }
            }
        }
        return 0;
    }
}  