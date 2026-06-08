class Solution {
    int original = 0;
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        // int[][] result = new int[image.length][image[0].length];
        original = image[sr][sc];
        if(original == color){
            return image;
        }
        dfs(sr, sc, image, color);

        return image;
    }

    public void dfs(int row, int col, int[][] image, int color){
        if(row < 0 || col < 0 || row >= image.length || col >= image[0].length){
            return;
        }
        if(original != image[row][col]){
            return;
        }
        
        image[row][col] = color;

        int[] rowdir = {1, -1, 0, 0};
        int[] coldir = {0, 0, 1, -1};

        for(int d = 0; d < 4; d++){
            int newrow = row + rowdir[d];
            int newcol = col + coldir[d];
            dfs(newrow, newcol, image, color);
        }
    }
}