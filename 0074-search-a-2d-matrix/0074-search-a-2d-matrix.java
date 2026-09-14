class Solution {
    public boolean binary_serach(int[] arr , int target){
        int si = 0;
        int ei = arr.length-1;
        while(si<=ei){
            int mid = si +(ei -si) /2;
            if(arr[mid] == target){
                return true;
            }
            if(arr[mid] > target){
                ei = mid-1;
            }else{
                si = mid+1;
            }
        }
        return false;
    }
    // public boolean searchMatrix(int[][] matrix, int target) {
    //    int m = matrix.length;
    //    int n = matrix[0].length;
    //    int si = 0;
    //    int ei = m-1;
    //    if(m == 1){
    //     return  binary_serach(matrix[0] , target);
    //    }
    //    while(si <= ei){
    //     int mid = si + (ei-si)/2;
    //     if(matrix[mid][0]== target){
    //         return true;
    //     }
    //     if((matrix[mid][0] <= target) && (target <= matrix[mid][n-1])){
    //         return binary_serach(matrix[mid] , target);
    //     }
    //     if((matrix[mid][0] <target)&& (target >matrix[mid][n-1])){
    //         si = mid+1;
    //     }else{
    //         ei = mid-1;
    //     }
    //    }
    //    return false;
    // }
    public boolean searchMatrix(int[][] matrix, int target) {
        int n = matrix[0].length;
        int si = 0;
        int ei = matrix.length-1;
        int predicted_row = -1;
        if(ei == 0){
            return binary_serach(matrix[0] , target);
        }
        while(si <= ei ){
            int mid = si + (ei -si)/2;
            if(matrix[mid][n-1] >= target){
                predicted_row =mid;
                ei = mid-1;
            }else{
                si = mid+1;
            }
        }
        if(predicted_row == -1){
            return false;
        }
        return binary_serach(matrix[predicted_row] , target);
    }
}