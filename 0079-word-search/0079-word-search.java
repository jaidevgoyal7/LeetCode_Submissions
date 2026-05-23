class Solution {
    public boolean exist(char[][] board, String word) {
        boolean[][] visited = new boolean[board.length][board[0].length];
        for(int row = 0; row < board.length; row++){
            for(int col = 0; col < board[row].length; col++){
                if(backtrack( 0, row, col, visited, board, word)){
                    return true;
                }
            }
        }
        return false;
        
    }

    public boolean backtrack(int i, int row, int col, boolean[][] visited, char[][] board, String word){

        int[] rowdir = {0, 0, 1, -1};
        int[] coldir = {1, -1, 0, 0};

        if(i == word.length()){
            return true;
        }

        if(row < 0 || col < 0 || row >= board.length || col >= board[0].length || visited[row][col] || board[row][col] != word.charAt(i)){
            return false;
        }

        visited[row][col] = true;

        if(row < board.length && col < board[0].length && row >= 0 && col >= 0 && board[row][col] == word.charAt(i)){
            
            for(int d = 0; d < 4; d++){
                int newrow = row + rowdir[d];
                int newcol = col + coldir[d];
                if(backtrack(i+1, newrow, newcol, visited, board, word)){
                    return true;
                }
            }
            
        }

        visited[row][col] = false;
        return false;

    }
}