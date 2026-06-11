class Solution {
    public int[][] updateMatrix(int[][] mat) {
        int[][] dist = new int[mat.length][mat[0].length];
        Queue<int[]> q = new LinkedList<>();

        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[0].length; j++) {
                if (mat[i][j] == 0) {
                    q.add(new int[] { i, j });
                    dist[i][j] = 0;
                } else {
                    dist[i][j] = -1;
                }
            }
        }
        bfs(mat, dist, q);
        return dist;
    }

    public void bfs(int[][] mat, int[][] dist, Queue<int[]> q) {
        while (!q.isEmpty()) {
            int[] current = q.remove();
            int row = current[0];
            int col = current[1];
            int[] rowdir = {-1, 1, 0, 0};
            int[] coldir = {0, 0, -1, 1};

            for(int d = 0; d < 4; d++){
                int newrow = row + rowdir[d];
                int newcol = col + coldir[d];
                if(newrow < 0 || newrow >= mat.length || newcol < 0 || newcol >= mat[0].length){
                    continue;
                }
                if(dist[newrow][newcol] == -1){
                    dist[newrow][newcol] = dist[row][col] + 1;
                    q.add(new int[]{newrow, newcol});
                }
            }

        }
        return;
    }
}