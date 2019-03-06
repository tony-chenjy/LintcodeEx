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
        helper(root);
    }

    private ResultType helper(TreeNode root) {
        if (root == null) {
            return null;
        }

        // divide
        ResultType left = helper(root.left);
        ResultType right = helper(root.right);

        // conquer
        if (left == null && right == null) {
            return new ResultType(root, root);
        }
        if (left == null) {
            return new ResultType(root, right.tail);
        }
        if (right == null) {
            root.right = left.head;
            root.left = null;
            return new ResultType(root, left.tail);
        }
        left.tail.right = right.head;
        root.right = left.head;
        root.left = null;
        return new ResultType(root, right.tail);
    }

    class ResultType {
        TreeNode head;
        TreeNode tail;
        public ResultType(TreeNode head, TreeNode tail) {
            this.head = head;
            this.tail = tail;
        }
    }
}