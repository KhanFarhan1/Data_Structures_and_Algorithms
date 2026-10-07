class Solution {
    static int r[]={-1,0,0,1};
    static int c[]={0,-1,1,0};
    public boolean wrap(char[][] board,char[][] visted, String word , int i , int j , int k){
        if(k == word.length()){
            return true;
        }
        if(i < 0 || i >= board.length || j< 0 || j>= board[0].length || board[i][j] != word.charAt(k) || visted[i][j] != 'f'){
            return false;
        }
            visted[i][j] = 't';
            for(int l=0;l<4;l++){
                int newRow = i+r[l];
                int newCol = j+c[l];
                if(wrap(board , visted ,word, newRow , newCol , k+1)){
                   return true;
                }
        }
        visted[i][j]='f';
        return false;
    }
    public boolean exist(char[][] board, String word) {
        char[][] visted = new char[board.length][board[0].length];
        for(int i = 0;i<board.length;i++){
            for(int j = 0;j<board[0].length;j++){
                visted[i][j] = 'f';
            }
        }
        for(int i = 0;i<board.length ;i++){
            for(int j = 0;j<board[0].length ;j++){
                if(wrap(board , visted , word, i , j , 0)){
                    return true;
                }
            }
        }
        return false;
    }
}