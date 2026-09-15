class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;//row
        int n = matrix[0].length;//col
        if(m ==1 && n == 1){
            if(matrix[0][0] == target){
                return true;
            }else{
                return false;
            }
        }
        int i = m-1;//row
        int j = 0;//col
        while(j < n && i >= 0){
            //best case
            if(matrix[i][j]==target){
                return true;
            }
            //element is greater than target
            if(matrix[i][j] > target){
                i--;
            }else{
                j++;
            }

        }
        return false;
    }
}