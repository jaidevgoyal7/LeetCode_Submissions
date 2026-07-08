class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<>();

        int top = 0, left = 0, right = matrix[0].length - 1, bottom = matrix.length - 1, i = 0;

        while (top <= bottom && left <= right) {
            for (i = left; i <= right; i++) {
                result.add(matrix[top][i]);
            }
            top++;
            for (i = top; i <= bottom; i++) {
                result.add(matrix[i][right]);
            }
            right--;
            if (top <= bottom) {
                for (i = right; i >= left; i--) {
                    result.add(matrix[bottom][i]);
                }
                bottom--;
            }
            if (left <= right) {
                for (i = bottom; i >= top; i--) {
                    result.add(matrix[i][left]);
                }
                left++;
            }
        }
        return result;
    }
}