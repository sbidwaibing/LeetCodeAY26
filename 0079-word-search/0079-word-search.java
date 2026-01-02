class Solution {
    
    boolean visited[][];

    public boolean exist(char[][] board, String word) {
        int rows = board.length;
        int columns = board[0].length;

        visited = new boolean[rows][columns];

        for(int i=0; i<rows; i++){
            for(int j=0; j<columns; j++){
                if(word.charAt(0) == board[i][j] && wordSearch(i, j, 0, word, board)) return true;
            }
        }
        return false;
    }

    private static final int[][] DIRS = {
        {0, 1},   // right
        {1, 0},   // down
        {0, -1},  // left
        {-1, 0}   // up
    };

    private boolean wordSearch(int i, int j, int index, String word, char[][] board){

        if(index == word.length()) return true;
        if(
            i < 0 || j < 0 || 
            i>= board.length || 
            j>= board[0].length || 
            word.charAt(index) != board[i][j] || 
            visited[i][j]){
            return false;
        }

        visited[i][j] = true;
        
        for(int[] dir : DIRS){
            int newRow = i + dir[0];
            int newColumn = j + dir[1];

            if(wordSearch(newRow, newColumn, index + 1, word, board)){
                return true;
            }
        }
        
        visited[i][j] = false;
        return false;
    }
}