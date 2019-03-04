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
     * @param root: the root of the binary tree
     * @return: all root-to-leaf paths
     */
    public List<String> binaryTreePaths(TreeNode root) {
        // write your code here

        // divide and conquer
        return helper(root);
    }

    // divide and conquer
    private List<String> helper(TreeNode root) {
        List<String> paths = new ArrayList();
        if (root == null) {
            return paths;
        }

        // divide
        List<String> left = helper(root.left);
        List<String> right = helper(root.right);

        // conquer
        if (left.isEmpty() && right.isEmpty()) {
            paths.add(root.val + "");
        }
        for (String path : left) {
            paths.add(root.val + "->" + path);
        }
        for (String path : right) {
            paths.add(root.val + "->" + path);
        }
        return paths;
    }
}