package leetcode.NO141;

public class Main {
    public static boolean hasCycle(ListNode head) {
        if(head == null || head.next == null) return false;

        ListNode slow = head;
        ListNode fast = slow;

        while(fast != null && fast.next != null){

            slow = slow.next;
            fast = fast.next.next;

            if(fast == slow){
                return true;
            }
        }

        return false;

    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
//        leetcode.NO206.ListNode l3 = new leetcode.NO206.ListNode(3);
//        leetcode.NO206.ListNode l4 = new leetcode.NO206.ListNode(4);
//        leetcode.NO206.ListNode l5 = new leetcode.NO206.ListNode(5);
        l1.next = l2;
        l2.next = l1;
//        l3.next = l4;
//        l4.next = l5;
//        l5.next = null;
//        System.out.println("原链表————————————————");
//        ListNode tmp = l1;
//        while(tmp != null){
//            System.out.println(tmp.val);
//            tmp = tmp.next;
//        }


        System.out.println("反转后————————————————");
        System.out.println(Main.hasCycle(l1));


    }


}
