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
    public ListNode reverseList(ListNode head) {
        ListNode copy=head;
        ListNode temp=null;
        ListNode next1;
        while(copy!=null){
            next1=copy.next;
            copy.next=temp;
            temp=copy;
            copy=next1;
        }
        return temp;
    }
}