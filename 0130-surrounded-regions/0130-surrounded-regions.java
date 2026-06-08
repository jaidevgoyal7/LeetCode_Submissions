class Solution {
    public void solve(char[][] board) {
        boolean[][] visited = new boolean[board.length][board[0].length];
        int rowlen = board.length;
        int collen = board[0].length;
        for(int row = 0; row < rowlen; row++){
            if(board[row][0] == 'O'){
                dfs(row, 0, board, visited);
            }
            if(board[row][collen - 1] == 'O'){
                dfs(row, collen - 1, board, visited);
            }
        }
        for(int col = 0; col < collen; col++){
            if(board[0][col] == 'O'){
                dfs(0, col, board, visited);
            }
            if(board[rowlen - 1][col] == 'O'){
                dfs(rowlen - 1, col, board, visited);
            }
        }

        for(int i = 0; i < rowlen; i++){
            for(int j = 0; j < collen; j++){
                if(board[i][j] == 'O'){
                    board[i][j] = 'X';
                }
                if(board[i][j] == '#'){
                    board[i][j] = 'O';
                }
            }
        }

        return;
    }

    public void dfs(int row, int col, char[][] board, boolean[][] visited){
        if(row < 0 || row >= board.length || col < 0 || col >= board[0].length || visited[row][col] || board[row][col] != 'O'){
            return;
        }
        visited[row][col] = true;
        board[row][col] = '#';
        
        int[] rowdir = {1, -1, 0, 0};
        int[] coldir = {0, 0, 1, -1};

        for(int d = 0; d < 4; d++){
            int newrow = row + rowdir[d];
            int newcol = col + coldir[d];
            dfs(newrow, newcol, board, visited);
        } 
    }
}