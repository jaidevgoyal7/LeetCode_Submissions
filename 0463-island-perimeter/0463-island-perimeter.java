class Solution {
    
    public int islandPerimeter(int[][] grid) {
        boolean[][] visited = new boolean[grid.length][grid[0].length];

        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                if(grid[i][j] == 1){
                    return dfs(grid, visited, i, j);
                }
            }
        }

        return 0;
    }

    public int dfs(int[][] grid, boolean[][] visited, int row, int col){
        if(row >= grid.length || row < 0 || col >= grid[0].length || col < 0){
            return 1;
        }
        if(grid[row][col] == 0){
            return 1;
        }
        if(visited[row][col]){
            return 0;
        }

        visited[row][col] = true;

        int[] rowdir = {-1, 1, 0, 0};
        int[] coldir = {0, 0, -1, 1};
        int perimeter = 0;

        for(int d = 0; d < 4; d++){
            int newrow = row + rowdir[d];
            int newcol = col + coldir[d];
            perimeter += dfs(grid, visited, newrow, newcol);
        }
        return perimeter;
    }
}