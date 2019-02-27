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
     * @return: Postorder in ArrayList which contains node values.
     */
    public List<Integer> postorderTraversal(TreeNode root) {
        // write your code here

        // 1.traverse
        // List<Integer> list = new ArrayList();
        // traverse(root, list);
        // return list;

        // 2.divide and conquer
        // return helper(root);

        // 3.iteratively
        return iterative1(root);
    }

    // 1.traverse
    private void traverse(TreeNode root, List<Integer> list) {
        if (root == null) {
            return;
        }
        traverse(root.left, list);
        traverse(root.right, list);
        list.add(root.val);
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
        list.addAll(right);
        list.add(root.val);
        return list;
    }

    // 3.iteratively
    private List<Integer> iterative1(TreeNode root) {
        List<Integer> list = new ArrayList();
        if (root == null) {
            return list;
        }

        Stack<TreeNode> stack = new Stack();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            list.add(node.val);
            if (node.left != null) {
                stack.push(node.left);
            }
            if (node.right != null) {
                stack.push(node.right);
            }
        }
        // reverse
        for (int i = 0, j = list.size() - 1; i < j; i++, j--) {
            int temp = list.get(i);
            list.set(i, list.get(j));
            list.set(j, temp);
        }
        return list;
    }
}