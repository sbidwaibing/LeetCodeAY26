/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode middleNode(ListNode head) {
        if(head == null){
            return null;
        }

        if(head.next == null){
            return head;
        }

        ListNode temp = head;
        int n = 0;

        while(temp != null){
            temp = temp.next;
            n++;
        }

        int mid = (n / 2);
        temp = head;

        while(mid-- > 0){
            temp = temp.next;
        }
        return temp;
    }
}