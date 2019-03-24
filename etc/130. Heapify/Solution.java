public class Solution {
    /*
     * @param A: Given an integer array
     * @return: nothing
     */
    public void heapify(int[] A) {
        // write your code here
        for (int i = A.length / 2 - 1; i >= 0; i--) {
            swap(A, i);
        }
    }

    private void swap (int[] A, int i) {
        int left = i * 2 + 1;
        int right = i * 2 + 2;
        if (left >= A.length) {
            return;
        }
        if (right >= A.length) {
            if (A[i] > A[left]) {
                int temp = A[left];
                A[left] = A[i];
                A[i] = temp;
            }
            return;
        }

        if (A[i] > A[left] || A[i] > A[right]) {
            if (A[left] <= A[right]) {
                int temp = A[left];
                A[left] = A[i];
                A[i] = temp;
                swap(A, left);
            } else {
                int temp = A[right];
                A[right] = A[i];
                A[i] = temp;
                swap(A, right);
            }
        }
    }
}