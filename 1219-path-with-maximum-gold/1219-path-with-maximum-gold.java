class Solution {
    public int getMaximumGold(int[][] grid) {
        int maxGold = 0;

        boolean[][] visited = new boolean[grid.length][grid[0].length];
        
        for(int row = 0; row < grid.length; row++){
            for(int col = 0; col < grid[row].length; col++){
                maxGold = Math.max(backtrack(row, col, grid, visited), maxGold);
            }
        }
        return maxGold;
    }

    public int backtrack(int row, int col, int[][] grid, boolean[][] visited){
        if(row >= grid.length || 
        col >= grid[0].length || 
        row < 0 || col < 0 || 
        visited[row][col] == true || 
        grid[row][col] == 0){ 
            return 0; 
        }

        int[] rowDir = {0, 0, 1, -1};
        int[] colDir = {1, -1, 0, 0};

        visited[row][col] = true;
        int maxNeighbourGold = 0;

        for(int d = 0; d < 4; d++){
            int newrow = row + rowDir[d];
            int newcol = col + colDir[d];
            maxNeighbourGold = Math.max(maxNeighbourGold, backtrack(newrow, newcol, grid, visited));
        }
        visited[row][col] = false;
        return grid[row][col] + maxNeighbourGold;
    }
}