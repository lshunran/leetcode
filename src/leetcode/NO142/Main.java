package leetcode.NO142;

public class Main {
    public static ListNode detectCycle(ListNode head) {
        if(head == null || head.next == null) return null;

        ListNode slow = head;
        ListNode fast = head;

        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;

            if(slow == fast){
                break;
            }
        }

        if(fast == null || fast.next == null){
            return null;
        }

        slow = head;
        while(slow != fast){
            slow = slow.next;
            fast = fast.next;
        }

        return slow;

    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(3);
        ListNode l4 = new ListNode(4);
//        leetcode.NO206.ListNode l5 = new leetcode.NO206.ListNode(5);
        l1.next = l2;
        l2.next = l1;
//        l3.next = l4;
//        l4.next = l3;
//        l5.next = null;
//        System.out.println("原链表————————————————");
//        ListNode tmp = l1;
//        while(tmp != null){
//            System.out.println(tmp.val);
//            tmp = tmp.next;
//        }


        System.out.println("环入口————————————————");
        System.out.println(Main.detectCycle(l1).val);
    }
}
