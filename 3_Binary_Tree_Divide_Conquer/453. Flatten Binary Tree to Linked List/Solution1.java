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
     * @param root: a TreeNode, the root of the binary tree
     * @return: nothing
     */
    public void flatten(TreeNode root) {
        // write your code here

        // 1.divide and conquer
        // helper(root);

        // 2.divide and conquer
        helper2(root);
    }

    // 2.divide and conquer
    private TreeNode helper2(TreeNode root) {
        if (root == null) {
            return null;
        }

        // divide
        TreeNode leftLast = helper2(root.left);
        TreeNode rightLast = helper2(root.right);

        // conquer
        if (leftLast != null) {
            leftLast.right = root.right;
            root.right = root.left;
            root.left = null;
        }

        if (rightLast != null) {
            return rightLast;
        }

        if (leftLast != null) {
            return leftLast;
        }

        return root;
    }

    // 1.divide and conquer
    private ResultType helper(TreeNode root) {
        if (root == null) {
            return null;
        }

        // divide
        ResultType left = helper(root.left);
        ResultType right = helper(root.right);

        // conquer
        if (left != null && right != null) {
            left.tail.right = right.head;
            root.right = left.head;
            root.left = null;
            return new ResultType(root, right.tail);
        }
        if (left != null) {
            left.tail.right = root.right;
            root.right = left.head;
            root.left = null;
            return new ResultType(root, left.tail);
        }
        if (right != null) {
            return new ResultType(root, right.tail);
        }
        return new ResultType(root, root);
    }

    class ResultType {
        TreeNode head;
        TreeNode tail;

        ResultType(TreeNode head, TreeNode tail) {
            this.head = head;
            this.tail = tail;
        }
    }
}