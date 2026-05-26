class Solution {
    public boolean exist(char[][] board, String word) {
        boolean[][] visited = new boolean[board.length][board[0].length];
        for(int row = 0; row < board.length; row++){
            for(int col = 0; col < board[0].length; col++){
                if(backtrackWithDFS(0, row, col, board, word, visited)){
                    return true;
                }
            }
        }
        return false;
    }

    public boolean backtrackWithDFS(int i, int row, int col, char[][] board, String word, boolean[][] visited){
        int[] rowdir = {0, 0, 1, -1};
        int[] coldir = {1, -1, 0, 0};

        if(i == word.length()){
            return true;
        }

        if(row >= board.length || col >= board[0].length || row < 0 || col < 0 || visited[row][col] || board[row][col] != word.charAt(i)){
            return false;
        }

        visited[row][col] = true;

        for(int d = 0; d < 4; d++){
            int newrow = row + rowdir[d];
            int newcol = col + coldir[d];

            if(backtrackWithDFS(i+1, newrow, newcol, board, word, visited)){
                return true;
            }
        }
        visited[row][col] = false;
        return false;

    }
}