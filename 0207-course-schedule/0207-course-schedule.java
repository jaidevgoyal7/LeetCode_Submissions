class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        boolean[] visited = new boolean[numCourses];
        boolean[] pathvisited = new boolean[numCourses];
        List<Integer>[] graph = new ArrayList[numCourses];
        for (int i = 0; i < numCourses; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int[] p : prerequisites) {
            int course = p[0];
            int prerequisite = p[1];

            graph[prerequisite].add(course);
        }
        for (int i = 0; i < numCourses; i++) {
            if (!visited[i]) {
                if (dfs(i, graph, visited, pathvisited)) {
                    return false;
                }
            }
        }
        return true;
    }

    public boolean dfs(int i, List<Integer>[] graph, boolean[] visited, boolean[] pathvisited) {
        if (pathvisited[i]) {
            return true;
        }
        if (visited[i]) {
            return false;
        }
        visited[i] = true;
        pathvisited[i] = true;
        for (int neighbour : graph[i]) {
            if (dfs(neighbour, graph, visited, pathvisited)) {
                return true;
            }
        }
        pathvisited[i] = false;
        return false;
    }
}