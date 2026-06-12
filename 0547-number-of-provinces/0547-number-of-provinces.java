class Solution {
    int result = 0;
    public int findCircleNum(int[][] isConnected) {
        boolean[] visited = new boolean[isConnected.length];
        // int result = 0;
        for(int city = 0; city < isConnected.length; city++){
            if(!visited[city]){
                result++;
                dfs(isConnected, visited, city);
            }
            
        }
        return result;
    }

    public void dfs(int[][] isConnected, boolean[] visited, int city){
        visited[city] = true;
        for(int neighbour = 0; neighbour < isConnected[0].length; neighbour++){
            if(isConnected[city][neighbour] == 1 && !visited[neighbour]){
                dfs(isConnected, visited, neighbour);
            }
        }
    }
}