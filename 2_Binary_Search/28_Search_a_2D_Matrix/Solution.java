public class Solution {
    /**
     * @param matrix: matrix, a list of lists of integers
     * @param target: An integer
     * @return: a boolean, indicate whether matrix contains target
     */
    public boolean searchMatrix(int[][] matrix, int target) {
        // write your code here

        if (matrix == null || matrix.length < 1) {
            return false;
        }
        if (matrix[0] == null || matrix[0].length < 1) {
            return false;
        }

        int row = binarySearchInCol(matrix, target);
        if (row == -1) {
            return false;
        }
        int col = binarySearchInRow(matrix, target, row);
        if (col == -1) {
            return false;
        }
        return true;
    }

    public int binarySearchInRow (int[][] matrix, int target, int row) {
        int start = 0;
        int end = matrix[row].length - 1;
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (matrix[row][mid] == target) {
                return mid;
            } else if (matrix[row][mid] < target) {
                start = mid;
            } else if (matrix[row][mid] > target) {
                end = mid;
            }
        }
        if (matrix[row][start] == target) {
            return start;
        }
        if (matrix[row][end] == target) {
            return end;
        }
        return -1;
    }

    public int binarySearchInCol (int[][] matrix, int target) {
        int start = 0;
        int end = matrix.length - 1;
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (matrix[mid][0] == target) {
                return mid;
            } else if (matrix[mid][0] < target) {
                start = mid;
            } else if (matrix[mid][0] > target) {
                end = mid;
            }
        }
        if (matrix[end][0] <= target) {
            return end;
        }
        if (matrix[start][0] <= target) {
            return start;
        }
        return -1;
    }
}