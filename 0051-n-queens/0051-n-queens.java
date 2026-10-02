class Solution {
    public boolean isSafe(char [][] chess , int row , int col){
        for(int i = row ;i>=0;i--){
            if(chess[i][col] == 'Q'){
                return false;
            }
        }
        for(int i = row, j= col ; i>=0&&j>=0 ; i--,j--){
            if(chess[i][j] == 'Q'){
                return false;
            }
        }
        for(int i = row, j= col ; i>=0&&j<chess.length; i--,j++){
            if(chess[i][j] == 'Q'){
                return false;
            }
        }
        return true;
    }
    public List<List<String>> wrap(char [][] chess , int n , int row ,List<List<String>> ans){
        if(row == n){
            List<String> str = new ArrayList<>();
            for(int i = 0;i<n;i++){
                str.add(new String(chess[i]));
            }
            ans.add(new ArrayList<>(str));
            return ans;
        }
        for(int j = 0;j<chess.length;j++){
            if(isSafe(chess , row , j)){
                chess[row][j] = 'Q';
                wrap(chess , n , row+1,ans);
                chess[row][j] = '.';
            }
        }
        return ans;
    }
    public List<List<String>> solveNQueens(int n) {
        char [][] chess = new char[n][n];
        for(int i = 0;i<n;i++){
            for(int j = 0;j<n;j++){
                chess[i][j] ='.';
            }
        }
        List<List<String>> ans = new ArrayList<>();
        return wrap(chess , n , 0 ,ans);
    }
}