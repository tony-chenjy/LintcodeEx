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
     * @param root: A Tree
     * @return: Inorder in ArrayList which contains node values.
     */
    public List<Integer> inorderTraversal(TreeNode root) {
        // write your code here

        // 1.traverse
        // List<Integer> list = new ArrayList();
        // traverse(root, list);
        // return list;

        // 2.divide and conquer
        // return helper(root);

        // 3.iteratively
        return iterative(root);
    }

    // 1.traverse
    private void traverse(TreeNode root, List<Integer> list) {
        if (root == null) {
            return;
        }
        traverse(root.left, list);
        list.add(root.val);
        traverse(root.right, list);
    }

    // 2.divide and conquer
    private List<Integer> helper(TreeNode root) {
        List<Integer> list = new ArrayList();
        if (root == null) {
            return list;
        }

        // divide
        List<Integer> left = helper(root.left);
        List<Integer> right = helper(root.right);

        // conquer
        list.addAll(left);
        list.add(root.val);
        list.addAll(right);
        return list;
    }

    // 3.iteratively
    private List<Integer> iterative(TreeNode root) {
        List<Integer> list = new ArrayList();
        if (root == null) {
            return list;
        }

        Stack<TreeNode> stack = new Stack();
        TreeNode node = root;
        while (node != null || !stack.isEmpty()) {
            while (node != null) {
                stack.push(node);
                node = node.left;
            }
            node = stack.pop();
            list.add(node.val);
            node = node.right;
        }
        return list;
    }
}