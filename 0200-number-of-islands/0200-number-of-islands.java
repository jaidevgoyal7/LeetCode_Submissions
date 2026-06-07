class Solution {
    int count = 0;

    public int numIslands(char[][] grid) {
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        for (int row = 0; row < grid.length; row++) {
            for (int col = 0; col < grid[0].length; col++) {

                if (grid[row][col] == '1' && !visited[row][col]) {
                    count++;
                    dfs(row, col, grid, visited);
                }
            }
        }
        return count;
    }

    public void dfs(int row, int col, char[][] grid, boolean[][] visited) {
        if (row < 0 || row >= grid.length || col < 0 || col >= grid[0].length) {
            return;
        }

        if (grid[row][col] == '0') {
            return;
        }

        if (visited[row][col]) {
            return;
        }
        visited[row][col] = true;

        int[] rowDir = { 0, 0, 1, -1 };
        int[] colDir = { 1, -1, 0, 0 };

        for (int i = 0; i < 4; i++) {
            int newrow = row + rowDir[i];
            int newcol = col + colDir[i];

            dfs(newrow, newcol, grid, visited);
        }

    }
}