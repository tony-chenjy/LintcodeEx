/**
 * Definition for Doubly-ListNode.
 * public class DoublyListNode {
 *     int val;
 *     DoublyListNode next, prev;
 *     DoublyListNode(int val) {
 *         this.val = val;
 *         this.next = this.prev = null;
 *     }
 * } * Definition of TreeNode:
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
     * @param root: The root of tree
     * @return: the head of doubly list node
     */
    public DoublyListNode bstToDoublyList(TreeNode root) {
        // write your code here

        return helper(root).head;
    }

    private ResultType helper(TreeNode root) {
        if (root == null) {
            return new ResultType(null, null);
        }

        // divide
        ResultType left = helper(root.left);
        ResultType right = helper(root.right);

        // conquer
        DoublyListNode node = new DoublyListNode(root.val);
        if (left.tail == null && right.head == null) {
            return new ResultType(node, node);
        }
        if (left.tail == null) {
            node.next = right.head;
            right.head.prev = node;
            return new ResultType(node, right.tail);
        }
        if (right.head == null) {
            left.tail.next = node;
            node.prev = left.tail;
            return new ResultType(left.head, node);
        }

        left.tail.next = node;
        node.prev = left.tail;
        right.head.prev = node;
        node.next = right.head;
        return new ResultType(left.head, right.tail);
    }

    class ResultType {
        DoublyListNode head;
        DoublyListNode tail;
        public ResultType(DoublyListNode head, DoublyListNode tail) {
            this.head = head;
            this.tail = tail;
        }
    }
}