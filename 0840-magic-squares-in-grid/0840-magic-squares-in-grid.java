class Solution {
    
    public int numMagicSquaresInside(int[][] grid) {
        
        int row = grid.length;
        int col = grid[0].length;
        int count = 0;

        for(int i=0; i+2<row; i++){
            for(int j=0; j+2<col; j++){
                if(isMagic(grid, i, j)){
                    count++;
                }
            }
        }
        return count;
    }

    private boolean isMagic(int[][] grid, int row, int col){
        boolean[] seenElement = new boolean[10];

        for(int i = row; i < row + 3; i++){
            for(int j = col; j < col + 3; j++){
                int val = grid[i][j];

                if(val < 1 || val > 9 || seenElement[val]){
                    return false;
                }
                else{
                    seenElement[val] = true;
                }
            }
        }

        //Row Calculations
        for(int i = row; i < row + 3; i++){
            int sum = 0;
            for(int j = col; j < col + 3; j++){
                sum += grid[i][j];
            }

            if(sum != 15){
                return false;
            }
        }

        for(int j = col; j < col + 3; j++){
            int sum = 0;
            for(int i = row; i < row + 3; i++){
                sum += grid[i][j];
            }

            if(sum != 15){
                return false;
            }
        }

        int diag1 = grid[row][col] + grid[row+1][col+1] + grid[row+2][col+2];
        int diag2 = grid[row][col + 2] + grid[row+1][col+1] + grid[row+2][col];

        if(diag1 != 15 || diag2 != 15){
            return false;
        } 

        return true;
    }
}