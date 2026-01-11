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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        
        if(head == null){
            return null;
        }
        
        ListNode temp = head;
        int length = 0;

        while(temp != null){
            temp = temp.next;
            length++;
        }

        if(n == length){
            return head.next;
        }

        temp = head;
        int point = length - n;

        while(point > 1){
            temp = temp.next;
            point--;
        }
        temp.next = temp.next.next;

        return head;
    }
}