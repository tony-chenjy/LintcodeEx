public class Solution {
    /**
     * @param matrix: A list of lists of integers
     * @param target: An integer you want to search in matrix
     * @return: An integer indicate the total occurrence of target in the given matrix
     */
    public int searchMatrix(int[][] matrix, int target) {
        // write your code here
        if (matrix == null || matrix.length < 1) {
            return 0;
        }
        if (matrix[0] == null || matrix[0].length < 1) {
            return 0;
        }

        int count = 0;
        for (int r = matrix.length - 1, c = 0; r >= 0 && c < matrix[0].length; ) {
            if (matrix[r][c] == target) {
                count++;
                r--;
            } else if (matrix[r][c] > target) {
                r--;
            } else if (matrix[r][c] < target) {
                c++;
            }
        }
        return count;
    }
}