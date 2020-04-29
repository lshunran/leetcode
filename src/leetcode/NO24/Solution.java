package leetcode.NO24;

public class Solution {
    public ListNode swapPairs(ListNode head) {
        if(head == null || head.next == null) return head;

        ListNode slow = head;
        ListNode fast = head.next;


        slow.next = fast.next;
        fast.next = slow;

        head = fast;



        while(slow.next != null && slow.next.next != null){
            ListNode prev = slow;

            fast = slow.next.next;
            slow = slow.next;

            slow.next = fast.next;
            fast.next = slow;
            prev.next = fast;
        }

        return head;

    }
}
