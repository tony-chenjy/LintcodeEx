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
        ResultType resultType = helper(root, A, B);
        return (resultType.aExist && resultType.bExist) ? resultType.lca : null;
    }

    public ResultType helper(TreeNode root, TreeNode A, TreeNode B) {
        if (root == null) {
            return new ResultType(false, false, null);
        }

        // divide
        ResultType left = helper(root.left, A, B);
        ResultType right = helper(root.right, A, B);

        // conquer
        // 1. A and B exist in one side
        // 2. A and B exist in two side
        // 3. A or B does not exist
        if (left.aExist && left.bExist) {
            return left;
        }
        if (right.aExist && right.bExist) {
            return right;
        }
        if ((left.aExist && right.bExist) || (left.bExist && right.aExist)) {
            return new ResultType(true, true, root);
        }

        if (root == A) {
            return new ResultType(true, left.bExist || right.bExist, A);
        }
        if (root == B) {
            return new ResultType(left.aExist || right.aExist, true, B);
        }
        return new ResultType(left.aExist || right.aExist, left.bExist || right.bExist, null);
    }

    class ResultType {
        boolean aExist;
        boolean bExist;
        TreeNode lca;
        public ResultType(boolean aExist, boolean bExist, TreeNode lca) {
            this.aExist = aExist;
            this.bExist = bExist;
            this.lca = lca;
        }
    }
}