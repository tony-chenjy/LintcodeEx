/**
 * Definition of TreeNode:
 * public class TreeNode {
 *     public int val;
 *     public TreeNode left, right;
 *     public TreeNode(int val) {
 *         this.val = val;
 *         this.left = this.right = null;
 *     }
 * }
 */

public class Solution {
    /**
     * @param root: The root of binary tree.
     * @return: True if the binary tree is BST, or false
     */
    public boolean isValidBST(TreeNode root) {
        // write your code here

        ResultType rt = helper(root);
        return rt.isValidBST;
    }

    private ResultType helper(TreeNode root) {
        if (root == null) {
            return new ResultType(Long.MIN_VALUE, Long.MAX_VALUE, true);
        }

        // divide
        ResultType left = helper(root.left);
        ResultType right = helper(root.right);

        // conquer
        if (!left.isValidBST || !right.isValidBST) {
            return new ResultType(Long.MIN_VALUE, Long.MAX_VALUE, false);
        }
        if (left.max >= root.val || right.min <= root.val) {
            return new ResultType(Long.MIN_VALUE, Long.MAX_VALUE, false);
        }
        return new ResultType(Math.max(root.val, right.max), Math.min(root.val, left.min), true);
    }

    class ResultType {
        long max;
        long min;
        boolean isValidBST;
        ResultType(long max, long min, boolean isValidBST) {
            this.max = max;
            this.min = min;
            this.isValidBST = isValidBST;
        }
    }
}