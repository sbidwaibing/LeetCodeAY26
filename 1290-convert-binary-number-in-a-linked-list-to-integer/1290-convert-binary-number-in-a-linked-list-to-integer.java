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
    public int getDecimalValue(ListNode head) {
        
        ListNode itr = head;
        int num = 0;
        
        while(itr != null){
            num *= 2;
            num += itr.val;
            itr = itr.next;
        }

        return num;
    }
}