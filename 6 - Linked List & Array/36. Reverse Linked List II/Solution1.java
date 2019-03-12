/**
 * Definition for ListNode
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */

public class Solution {
    /**
     * @param head: ListNode head is the head of the linked list
     * @param m: An integer
     * @param n: An integer
     * @return: The head of the reversed ListNode
     */
    public ListNode reverseBetween(ListNode head, int m, int n) {
        // write your code here

        ListNode dummyNode = new ListNode(0);
        ListNode prev = null;
        dummyNode.next = head;
        prev = dummyNode;

        for (int i = 1; i < m; i++) {
            prev = head;
            head = head.next;
        }

        for (int i = m; i < n; i++) {
            ListNode next = head.next;
            head.next = next.next;
            next.next = prev.next;
            prev.next = next;
        }

        return dummyNode.next;
    }
}