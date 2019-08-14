package leetcode.NO2;

public class Test {
    public static void main(String[] args) {
        ListNode l1 = new ListNode(9);
        ListNode l2 = new ListNode(9);


        ListNode temp1 = new ListNode(9);
        l1.next = temp1;
//        temp1 = new ListNode(3);
//        l1.next.next = temp1;

//        ListNode temp2 = new ListNode(9);
//        l2.next = temp2;
//        temp2 = new ListNode(4);
//        l2.next.next = temp2;

        ListNode result = Add.addTwoNumbers(l1, l2);

        return;
    }
}
