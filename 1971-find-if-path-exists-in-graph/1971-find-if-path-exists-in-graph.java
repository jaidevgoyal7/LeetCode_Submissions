class Solution {
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        Map<Integer, List<Integer>> graph = new HashMap<>();

        for (int i = 0; i < n; i++) {
            graph.put(i, new ArrayList<>());
        }
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];

            graph.get(u).add(v);
            graph.get(v).add(u);
        }
        boolean[] visited = new boolean[n];

        return dfs(graph, visited, source, destination);
    }

    public boolean dfs(Map<Integer, List<Integer>> graph, boolean[] visited, int source, int destination){
        if(visited[source]){
            return false;
        }
        if(source == destination){
            return true;
        }

        visited[source] = true;

        for(int neighbour : graph.get(source)){
            if(!visited[neighbour] && dfs(graph, visited, neighbour, destination)){
                return true;
            }
        }
        return false;
    }
}