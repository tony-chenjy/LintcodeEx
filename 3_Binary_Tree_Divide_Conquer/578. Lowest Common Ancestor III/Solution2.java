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
     * @param root: The root of the binary tree.
     * @param A: A TreeNode
     * @param B: A TreeNode
     * @return: Return the LCA of the two nodes.
     */
    public TreeNode lowestCommonAncestor3(TreeNode root, TreeNode A, TreeNode B) {
        // write your code here

        ResultType rt = lca(root, A, B);
        if (rt.existA && rt.existB) {
            return rt.lca;
        } else {
            return null;
        }
    }

    private ResultType lca(TreeNode root, TreeNode A, TreeNode B) {
        if (root == null) {
            return new ResultType(root, false, false);
        }

        // divide
        ResultType left = lca(root.left, A, B);
        ResultType right = lca(root.right, A, B);

        // conquer
        if (left.lca != null && right.lca != null) {
            return new ResultType(root, true, true);
        }
        if (left.lca != null) {
            if (!left.existB && root == B) {
                return new ResultType(root, true, true);
            }
            if (!left.existA && root == A) {
                return new ResultType(root, true, true);
            }
            return left;
        }
        if (right.lca != null) {
            if (!right.existB && root == B) {
                return new ResultType(root, true, true);
            }
            if (!right.existA && root == A) {
                return new ResultType(root, true, true);
            }
            return right;
        }

        if (root == A || root == B) {
            return new ResultType(root, root == A, root == B);
        }
        return new ResultType(null, false, false);

    }

    class ResultType {
        TreeNode lca;
        boolean existA;
        boolean existB;

        ResultType(TreeNode lca, boolean existA, boolean existB) {
            this.lca = lca;
            this.existA = existA;
            this.existB = existB;
        }
    }
}