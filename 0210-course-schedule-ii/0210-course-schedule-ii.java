class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        boolean[] visited = new boolean[numCourses];
        boolean[] pathVisited = new boolean[numCourses];

        List<Integer>[] graph = new ArrayList[numCourses];

        Deque<Integer> stack = new ArrayDeque<>();
        int[] result = new int[numCourses];

        for(int i = 0; i < numCourses; i++){
            graph[i] = new ArrayList<>();
        }
        for(int[] p : prerequisites){
            int a = p[0];
            int b = p[1];

            graph[b].add(a);
        }

        for(int i = 0; i < numCourses; i++){
            if(!visited[i]){
                if(dfs(i, graph, visited, pathVisited, stack)){
                    return new int[0];
                }
            }
        }
        for(int i = 0; i < numCourses; i++){
            result[i] = stack.pop();
        }

        return result;
    }

    public boolean dfs(int i, List<Integer>[] graph, boolean[] visited, boolean[] pathVisited, Deque<Integer> stack){
        if(pathVisited[i]){
            return true;
        }
        if(visited[i]){
            return false;
        }

        visited[i] = true;
        pathVisited[i] = true;

        for(int neighbour : graph[i]){
            if(dfs(neighbour, graph, visited, pathVisited, stack)){
                return true;
            }
        }

        pathVisited[i] = false;
        stack.push(i);
        return false;
    }
}