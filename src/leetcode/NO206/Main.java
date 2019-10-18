package leetcode.NO206;

public class Main {

    public static ListNode reverseList(ListNode head) {
        if(head == null || head.next == null) return head;
        ListNode slow = head;
        ListNode fast = slow.next;
        slow.next = null;
        while(fast.next != null){
            ListNode tmp = fast.next;
            fast.next = slow;
            slow = fast;
            fast = tmp;
        }
        if(fast.next == null){
            fast.next = slow;
        }

        return fast;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(3);
        ListNode l4 = new ListNode(4);
        ListNode l5 = new ListNode(5);
        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        l4.next = l5;
        l5.next = null;
        System.out.println("反转前————————————————");
        ListNode tmp = l1;
        while(tmp != null){
            System.out.println(tmp.val);
            tmp = tmp.next;
        }


        System.out.println("反转后————————————————");
        ListNode after = Main.reverseList(l4);
        while(after != null){
            System.out.println(after.val);
            after = after.next;
        }


    }
}
