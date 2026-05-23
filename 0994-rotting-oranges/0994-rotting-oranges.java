class Solution {
    public int orangesRotting(int[][] grid) {
        Queue<int[]> queue = new LinkedList<int[]>();
        int fresh = 0;

        for(int row = 0; row < grid.length; row++){
            for(int col = 0; col < grid[row].length; col++){
                if(grid[row][col] == 1){
                    fresh++;
                }
                if(grid[row][col] == 2){
                    queue.add(new int[] {row,col});
                }
            }
        }

        int time = 0;
        int[] rowdir = {0, 0, 1, -1};
        int[] coldir = {1, -1, 0, 0};
        while (fresh > 0 && !queue.isEmpty()){
            int size = queue.size();
            for(int i = 0; i < size; i++){
                int[] cell = queue.poll();
                int row = cell[0];
                int col = cell[1];
                for(int d = 0; d<4; d++){
                    int newrow = row + rowdir[d];
                    int newcol = col + coldir[d];
                    if(newrow < grid.length && newcol < grid[0].length && newrow >=0 && newcol >= 0 && grid[newrow][newcol] == 1){
                        grid[newrow][newcol] = 2;
                        queue.add(new int[] {newrow, newcol});
                        fresh--;
                    }
                }
                
            }
            time++;
        }
        return (fresh == 0) ? time : -1;
    }
}