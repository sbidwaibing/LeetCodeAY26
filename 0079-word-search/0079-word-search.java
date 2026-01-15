class Solution {
    
    private int idx(char ch){
        if(ch >= 'A' && ch <= 'Z'){
            return ch - 'A';
        }
        else{
            return 26 + (ch - 'a');
        }
    }

    private static int[][] DIRECTIONS = {{0,1},{1,0},{0,-1},{-1,0}};

    public boolean exist(char[][] board, String word) {
        
        int rows = board.length;
        int cols = board[0].length;

        int[] gridFreq = new int[52];
        int[] wordFreq = new int[52];

        for(int i=0; i<rows; i++){
            for(int j=0; j<cols; j++){
                gridFreq[idx(board[i][j])]++;
            }
        }

        for(char ch : word.toCharArray()){
            wordFreq[idx(ch)]++;
        }

        for(int i=0; i<52; i++){
            if(wordFreq[i] > gridFreq[i]){
                return false;
            }
        }

        boolean[][] visited = new boolean[rows][cols];

        char firstSearch = word.charAt(0);

        for(int i = 0; i<rows; i++){
            for(int j = 0; j<cols; j++){
                if(board[i][j] == firstSearch){
                    if((board[i][j] == firstSearch) && (dfsFuncX(board, word, visited, i, j, 0))){
                        return true;
                    }
                }
            }
        }

        return false;
    }

    private boolean dfsFuncX(char[][] board, String word, boolean[][] visited, int row, int col, int index){
        if(index == word.length()){
            return true;
        }

        if(row < 0 || row >= board.length || 
            col < 0 || col >= board[0].length || 
            visited[row][col] || 
            board[row][col] != word.charAt(index)){
                return false;
            }

        visited[row][col] = true;
        boolean found = false;
        
        for(int[] d : DIRECTIONS){
            
            int newRow = row + d[0];
            int newCol = col + d[1];
            
            if(dfsFuncX(board, word, visited, newRow, newCol, index + 1)){
                found = true;
                break;
            }
        }

        visited[row][col] = false;;
        return found;
    }
}