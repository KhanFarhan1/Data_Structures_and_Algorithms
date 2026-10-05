class Solution {
    public boolean isSafe(char [][] chess , int row , int col){
        for(int i = row ; i>= 0 ;i--){
            if(chess[i][col] == 'Q'){
                return false;
            }
        }
        for(int i = row,j=col;i>=0&&j>=0 ; i--,j--){
            if(chess[i][j] == 'Q'){
                return false;
            }
        }
        for(int i = row,j=col ; i>=0&&j<chess.length ; i--,j++){
            if(chess[i][j] == 'Q'){
                return false;
            }
        }
        return true;
    }
    public int wrap(int n , char [][] chess , int count , int row){
        if(n == row){
            count = count+1;
            return count;
        }
        for(int col = 0;col<n;col++){
            if(isSafe(chess , row , col)){
            chess[row][col] = 'Q';
            count = wrap(n,chess,count,row+1);
            chess[row][col] = '.';
            }
        }
        return count;
    }
    public int totalNQueens(int n) {
        char [][] chess = new char[n][n];
        for(int i = 0;i<n;i++){
            for(int j = 0;j<n;j++){
                chess[i][j] = '.';
            }
        }
        return wrap(n , chess , 0 , 0);
    }
}