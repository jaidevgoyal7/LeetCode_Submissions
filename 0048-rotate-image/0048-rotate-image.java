class Solution {
    public void rotate(int[][] matrix) {
        int n = matrix.length;
        for(int i = 0; i < n/2; i++){
            int first = i;
            int last = n - 1 - i;

            for(int j = first; j < last; j++){
                int offset = j - first;
                int top = matrix[first][first+offset];
                int right = matrix[first + offset][last];
                int bottom = matrix[last][last - offset];
                int left = matrix[last - offset][first];

                int tmp = top;
                matrix[first][first+offset] = left;
                matrix[last - offset][first] = bottom;
                matrix[last][last - offset] = right;
                matrix[first + offset][last] = tmp;
            }

        }
        return;
    }
}