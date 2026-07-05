class Solution {
    public boolean isValidSudoku(char[][] board) {
        HashSet<Character>[] rowSeen = new HashSet[9];
        HashSet<Character>[] colSeen = new HashSet[9];
        HashSet<Character>[] boxSeen = new HashSet[9];

        for (int i = 0; i < 9; i++) {
            rowSeen[i] = new HashSet<>();
            colSeen[i] = new HashSet<>();
            boxSeen[i] = new HashSet<>();
        }
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                char val = board[i][j];
                if (val == '.')
                    continue;

                if (rowSeen[i].contains(val))
                    return false;
                rowSeen[i].add(val);

                if (colSeen[j].contains(val))
                    return false;
                colSeen[j].add(val);

                int idx = (i / 3) * 3 + (j / 3);

                if (boxSeen[idx].contains(val))
                    return false;
                boxSeen[idx].add(val);
            }
        }
        return true;

    }
}