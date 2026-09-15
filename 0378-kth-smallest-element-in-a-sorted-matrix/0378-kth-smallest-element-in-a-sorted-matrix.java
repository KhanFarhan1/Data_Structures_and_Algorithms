class Solution {
    public int guessSmallestOrEqual(int[][] matrix , int guess){
        int m = matrix.length;//row
        int n = matrix[0].length;//col
        int i = m-1;//row
        int j = 0;//col
        int count = 0;
        while(i>=0 && j < n){
            if(matrix[i][j] <= guess){
                count = count + i + 1;
                j++;
                continue;
            }
            if(matrix[i][j] > guess){
                i--;
            }
        }
        return count;
    }
    public int kthSmallest(int[][] matrix, int k) {
        int m = matrix.length;//row
        int n = matrix[0].length;//col
        int si = matrix[0][0];//smallest in matrix
        int ei = matrix[m-1][n-1];
        int ans = Integer.MAX_VALUE;
        while(si <= ei){
            int mid = si + (ei -si)/2;
            int total_predict_sum = guessSmallestOrEqual(matrix , mid);
            if(total_predict_sum < k){
                si = mid+1;
            }else{
                ans = Math.min(ans , mid);
                ei = mid-1;
            }
        }
        return ans;
    }
}