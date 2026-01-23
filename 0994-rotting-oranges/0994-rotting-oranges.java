// import java.util.Queue;
// import java.util.LinkedList;

class Solution {
    public int orangesRotting(int[][] grid) {
        
        int rows = grid.length;
        int cols = grid[0].length;
        int fresh = 0;

        Queue<int[]> q = new LinkedList<>();

        for(int i=0; i<rows; i++){
            for(int j=0; j<cols; j++){
                if(grid[i][j] == 2){
                    q.offer(new int[]{i, j});
                }
                else if(grid[i][j] == 1){
                    fresh++;
                }
            }
        }

        if(fresh == 0){
            return 0;
        }

        int minutes = -1;

        int[][] direction = {
            {-1,0},
            {1,0},
            {0,-1},
            {0,1}
        };

        while(!q.isEmpty()){
            
            int size = q.size();
            minutes++;

            for(int i=0; i<size; i++){
                
                int[] cell = q.poll();
               
                for(int[] d : direction){
                    int x = cell[0] + d[0];
                    int y = cell[1] + d[1];

                    if(x >= 0 && x < rows && y >= 0 && y < cols && grid[x][y] == 1){
                        grid[x][y] = 2;
                        fresh--;
                        q.offer(new int[]{x, y});
                    }
                }
            }
        }

        if(fresh == 0){
            return minutes;
        }
        else{
            return -1;
        }

    }
}