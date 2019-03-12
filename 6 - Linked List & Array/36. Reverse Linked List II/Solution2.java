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

        if (head == null) {
            return head;
        }

        ListNode dummyNode = new ListNode(0);
        dummyNode.next = head;

        ListNode prevTail = dummyNode;
        ListNode tail = head;
        for (int i = 1; i < m; i++) {
            prevTail = tail;
            tail = tail.next;
        }

        ListNode prevHead = prevTail;
        head = tail;
        for (int i = m; i < n; i++) {
            ListNode temp = head.next;
            head.next = prevHead;
            prevHead = head;
            head = temp;
        }
        ListNode temp = head.next;
        head.next = prevHead;

        prevTail.next = head;
        tail.next = temp;

        return dummyNode.next;
    }
}