class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        int maxland = 0;
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        for(int row = 0; row < grid.length; row++){
            for(int col = 0; col < grid[0].length; col++){
                maxland = Math.max(recursive(row, col, grid, visited), maxland);
            }
        }
        return maxland;
    }

    public int recursive(int row, int col, int[][] grid, boolean[][] visited){
        int maxneighbourLand = 0;
        
        if(row >= grid.length || col >= grid[0].length || row < 0 || col < 0 || visited[row][col] || grid[row][col] == 0){
            return 0;
        }

        visited[row][col] = true;

        int[] rowdir = {1, -1, 0, 0};
        int[] coldir = {0, 0, 1, -1};

        for(int d = 0; d < 4; d++){
            int newrow = row + rowdir[d];
            int newcol = col + coldir[d];
            maxneighbourLand = recursive(newrow, newcol, grid, visited) + maxneighbourLand;
        }
        return maxneighbourLand + grid[row][col];
    }
}