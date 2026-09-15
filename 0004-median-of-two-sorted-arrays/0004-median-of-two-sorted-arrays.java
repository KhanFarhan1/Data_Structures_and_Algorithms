class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
       float[] new_arr = new float[nums1.length + nums2.length];
       int i = 0;
       int j = 0;
       int k = 0;
       while(i < nums1.length && j < nums2.length){
        if(nums1[i] < nums2[j]){
            new_arr[k] = nums1[i];
            i++;
            k++;
        }else{
            new_arr[k] = nums2[j];
            j++;
            k++;
        }
       }
       while(i<nums1.length){
        new_arr[k] = nums1[i];
        i++;
        k++;
       }
       while(j<nums2.length){
        new_arr[k] = nums2[j];
        j++;
        k++;
       }
       if(new_arr.length%2 == 0){
        float mid1 = new_arr[new_arr.length/2 - 1];
        float mid2 = new_arr[new_arr.length/2];
        return (mid1+mid2)/2;
       }else{
        int mid = new_arr.length/2;
        return new_arr[mid];
       }
       
    }
}  