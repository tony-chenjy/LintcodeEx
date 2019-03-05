/**
 * Definition of ParentTreeNode:
 *
 * class ParentTreeNode {
 *     public ParentTreeNode parent, left, right;
 * }
 */


public class Solution {
    /*
     * @param root: The root of the tree
     * @param A: node in the tree
     * @param B: node in the tree
     * @return: The lowest common ancestor of A and B
     */
    public ParentTreeNode lowestCommonAncestorII(ParentTreeNode root, ParentTreeNode A, ParentTreeNode B) {
        // write your code here

        return lca(root, A, B);
    }

    private ParentTreeNode lca(ParentTreeNode root, ParentTreeNode A, ParentTreeNode B) {
        if (root == null) {
            return root;
        }

        Stack<ParentTreeNode> stackA = new Stack();
        Stack<ParentTreeNode> stackB = new Stack();

        ParentTreeNode nodeA = A;
        while (nodeA != null) {
            stackA.push(nodeA);
            nodeA = nodeA.parent;
        }

        ParentTreeNode nodeB = B;
        while (nodeB != null) {
            stackB.push(nodeB);
            nodeB = nodeB.parent;
        }

        ParentTreeNode result = null;
        while (!stackA.isEmpty() && !stackB.isEmpty()) {
            if (stackA.peek() == stackB.peek()) {
                result = stackA.peek();
                stackA.pop();
                stackB.pop();
            } else {
                break;
            }
        }
        return result;
    }
}