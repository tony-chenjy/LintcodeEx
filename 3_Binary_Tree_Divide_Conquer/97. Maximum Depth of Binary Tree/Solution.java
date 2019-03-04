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

    private int maxDepth = 0;

    /**
     * @param root: The root of binary tree.
     * @return: An integer
     */
    public int maxDepth(TreeNode root) {
        // write your code here

        // 1.divide and conquer
        // return helper(root);

        // 2.traverse
        traverse(root, 1);
        return maxDepth;
    }

    // 1.divide and conquer
    private int helper(TreeNode root) {
        if (root == null) {
            return 0;
        }

        // divide
        int left = helper(root.left);
        // conquer
        int right = helper(root.right);
        return (left > right ? left : right) + 1;
    }

    // 2.traverse
    private void traverse(TreeNode root, int depth) {
        if (root == null) {
            return;
        }

        if (depth > maxDepth) {
            maxDepth = depth;
        }
        traverse(root.left, depth + 1);
        traverse(root.right, depth + 1);
    }
}