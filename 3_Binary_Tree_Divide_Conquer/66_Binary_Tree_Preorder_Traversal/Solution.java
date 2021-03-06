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
     * @return: Preorder in ArrayList which contains node values.
     */
    public List<Integer> preorderTraversal(TreeNode root) {
        // 1.
        /* 
        List<Integer> list = new ArrayList<>();
        traverse(root, list);
        return list;
        */
        
        // 2.
        /*
        return helper(root);
        */
        
        // 3.
        return iterative(root);
    }
    
    // 1.traverse
    private void traverse(TreeNode root, List<Integer> list) {
        if (root == null) {
            return;
        }
        
        list.add(root.val);
        traverse(root.left, list);
        traverse(root.right, list);
    }
    
    // 2.divide and conquer
    private List<Integer> helper(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if (root == null) {
            return list;
        }
        
        // divide
        List<Integer> left = helper(root.left);
        List<Integer> right = helper(root.right);
        
        // conquer
        list.add(root.val);
        list.addAll(left);
        list.addAll(right);
        return list;
    }
    
    // challenge: 3.iteratively
    private List<Integer> iterative(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        
        if (root != null) {
            stack.push(root);
        }
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            if (node.right != null) {
                stack.push(node.right);
            }
            if (node.left != null) {
                stack.push(node.left);
            }
            list.add(node.val);
        }
        return list;
    }
}
