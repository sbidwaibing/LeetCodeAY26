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
    public ListNode[] splitListToParts(ListNode head, int k) {
        
        ListNode[] ans = new ListNode[k];
        ListNode temp = head;
        
        int n = 0;

        while(temp != null){
            temp = temp.next;
            n++;
        }
        
        int diff = n % k;
        int point = n / k;
        
        temp = head;
        
        int index = 0;
        ListNode newHead;
        
        while(temp != null){
            
            int count = point;
            
            if(diff > 0){
                count += 1;
            }
            
            ans[index] = temp;

            while(count-- > 1){
                temp = temp.next;
            }
            
            newHead = temp.next;
            temp.next = null;
            temp = newHead;

            diff--;
            index++;
        } 

        return ans;      
    }
}