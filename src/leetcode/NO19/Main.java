package leetcode.NO19;

public class Main {
    public static  ListNode removeNthFromEnd(ListNode head, int n) {
        if(head == null || head.next == null || n ==0) return null;
        ListNode guard = new ListNode(-1);
        guard.next = head;
        head = guard;
        ListNode slow = head;
        ListNode tmp = head;
        ListNode fast = head;

        for (int i = 0; i < n - 1; i++) {
            fast = fast.next;
        }

        while(fast.next != null){
            tmp = slow;
            slow = slow.next;
            fast = fast.next;
        }
        tmp.next = slow.next;

        return guard.next;

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
        System.out.println("原链表————————————————");
        ListNode tmp = l1;
        while(tmp != null){
            System.out.println(tmp.val);
            tmp = tmp.next;
        }


        System.out.println("删除后————————————————");
        ListNode after =Main.removeNthFromEnd(l1, 2);
        while(after != null){
            System.out.println(after.val);
            after = after.next;
        }
    }
}
