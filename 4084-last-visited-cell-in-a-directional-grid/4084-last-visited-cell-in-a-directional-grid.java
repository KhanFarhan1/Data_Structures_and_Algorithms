class Solution {
    public int[] wrap(char[][] grid,int c_row , int c_col ,int p_row , int p_col){
        if(c_row<0||c_col<0||c_row >=grid.length||c_col >=grid[0].length){
            int[] ans = {p_row,p_col};
            return ans;
        }
        if(grid[c_row][c_col] == 'V'){
            int[] ans = {p_row , p_col};
            return ans;
        }
        int n_row = 0;
        int n_col = 0;
        if(grid[c_row][c_col] == 'L'){
            n_col = c_col-1;
            n_row = c_row;
        }
        if(grid[c_row][c_col] == 'R'){
            n_col = c_col+1;
            n_row = c_row;
        }
        if(grid[c_row][c_col] == 'U'){
            n_col = c_col;
            n_row = c_row-1;
        }
        if(grid[c_row][c_col] == 'D'){
            n_col = c_col;
            n_row = c_row+1;
        }
        grid[c_row][c_col]= 'V';
        return wrap(grid , n_row , n_col ,c_row ,c_col);
    }
    public int[] lastVisitedCell(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        if(grid[0][0] == 'L'){
            int [] ans ={0,0};
            return ans;
        }
        return wrap(grid,0,0,0,0);
    }
}