class Solution {
    public boolean canFinish(int numCourses, int[][] prereq) {
        
        List<List<Integer>> adj = new ArrayList<>();
        int[] visited = new int[numCourses];
        Arrays.fill(visited, 0);

        for(int i=0; i<numCourses; i++){
            adj.add(new ArrayList<>());
        }

        for(int i=0; i<prereq.length; i++){
            adj.get(prereq[i][0]).add(prereq[i][1]);
        }

        for(int i=0; i<adj.size(); i++){
            if(!FuncX(adj, visited, i, numCourses)){
                return false;
            }
        }

        int x  = 0;
        
        for(int i=0; i<visited.length; i++){
            if(visited[i] == 2){
                x++;
            }
        }

        return (x == numCourses);
    }

    private boolean FuncX(List<List<Integer>> adj, int[] visited, int index, int numCourses){

        if(visited[index] == 2){ 
            return true;
        }

        if(visited[index] == 1){ 
            return false;
        }

        visited[index] = 1;

        List<Integer> req = adj.get(index);

        for(int i=0; i<req.size(); i++){
            if(!FuncX(adj, visited, req.get(i), numCourses)){
                return false;
            }
        }

        // System.out.println(index);
        visited[index] = 2;
        return true;
    }
}