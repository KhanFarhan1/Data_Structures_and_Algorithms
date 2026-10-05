class Solution {
    static int[] r ={2,2,-2,-2,1,1,-1,-1};
    static int[] c ={1,-1,1,-1,2,-2,2,-2};
    public boolean wrap( int[][] grid , int row , int col , int count ){
        if(count == grid.length * grid.length -1){
            return true;
        }
        for(int i = 0;i<r.length;i++){
            int newRow = row+r[i];
            int newCol = col+c[i];
            if(newRow >= 0 && newRow<grid.length && newCol>=0 && newCol<grid.length){
            if(grid[newRow][newCol] == count+1){
                return wrap(grid , newRow , newCol , count+1);
            }
            }
        }
        return false;
    }
    public boolean checkValidGrid(int[][] grid) {
        if(grid[0][0]!=0){
            return false;
        }
        return wrap(grid , 0 , 0 , 0);
    }
}