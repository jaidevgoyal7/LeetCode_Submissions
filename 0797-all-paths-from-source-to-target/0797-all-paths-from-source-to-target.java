class Solution {
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> result = new ArrayList<>();
        int source = 0;
        List<Integer> current = new ArrayList<>();
        current.add(source);
        dfs(result, current, graph, source);
        return result;
    }

    public void dfs(List<List<Integer>> result, List<Integer> current, int[][] graph, int source){
        int target = graph.length - 1;
        if(source == target){
            result.add(new ArrayList<>(current));
        }
        for(int neighbour : graph[source]){
            current.add(neighbour);
            dfs(result, current, graph,neighbour);
            current.remove(current.size() - 1);
        }
    }
}