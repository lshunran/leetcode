package leetcode.NO876;

public class Main {
    public static  ListNode middleNode(ListNode head) {
        if(head == null) return null;
        if(head.next == null) return head;

        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }

//        if(fast == null){
//            return slow.next;
//        }
//
//        if(fast.next == null){
//            return slow;
//        }

        return slow;
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


        System.out.println("中点————————————————");
        ListNode after = Main.middleNode(l1);
        while(after != null){
            System.out.println(after.val);
            after = after.next;
        }
    }
}
