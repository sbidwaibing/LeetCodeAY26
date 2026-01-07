class Solution {
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        double[] result = new double[queries.size()];
        Map<String, Map<String, Double>> graph = new HashMap<>();

        for(int i=0; i<equations.size(); i++){
            String a = equations.get(i).get(0);
            String b = equations.get(i).get(1);
            double k = values[i];

            if(!graph.containsKey(a)){
                graph.put(a, new HashMap<>());
            }
            
            if(!graph.containsKey(b)){
                graph.put(b, new HashMap<>());
            }

            graph.get(a).put(b, k);
            graph.get(b).put(a, 1.00 / k);
        }

        for(int i=0; i<queries.size(); i++){
            String src = queries.get(i).get(0);
            String dst = queries.get(i).get(1);

            if(!graph.containsKey(src) || !graph.containsKey(dst)){
                result[i] = -1.0;
                continue;
            }

            if(src.equals(dst)){
                result[i] = 1.0;
                continue;
            }

            Set<String> visited = new HashSet<>();
            result[i] = dfs(src, dst, graph, visited);
        }
        return result;
    }

    public double dfs(String src, String dst, Map<String, Map<String, Double>> graph, Set<String> visited){
        if(src.equals(dst)){
            return 1.0;
        }

        visited.add(src);
        
        Map<String, Double> neighbors = graph.get(src);

        for(String next : neighbors.keySet()){
            if(visited.contains(next)){
                continue;
            }

            double weight = neighbors.get(next);
            double sub = dfs(next, dst, graph, visited);

            if(sub != -1){
                return weight * sub;
            }
        }

        return -1.0;
    }
}