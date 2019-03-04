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
    /*
     * @param root: The root of the binary search tree.
     * @param A: A TreeNode in a Binary.
     * @param B: A TreeNode in a Binary.
     * @return: Return the least common ancestor(LCA) of the two nodes.
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode A, TreeNode B) {
        // write your code here

        return lca(root, A, B);
    }

    //
    private TreeNode lca(TreeNode root, TreeNode A, TreeNode B) {
        if (root == null || root.val == A.val || root.val == B.val) {
            return root;
        }

        // divide
        TreeNode left = lca(root.left, A, B);
        TreeNode right = lca(root.right, A, B);

        // conquer
        if (left != null && right != null) {
            return root;
        }
        if (left != null && right == null) {
            return left;
        }
        if (left == null && right != null) {
            return right;
        }
        return null;
    }
}