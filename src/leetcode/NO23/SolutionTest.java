package leetcode.NO23;


class SolutionTest {
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
    void mergeKLists() {

        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(4);
        l1.next.next = new ListNode(5);

        ListNode l2 = new ListNode(1);
        l2.next = new ListNode(3);
        l2.next.next = new ListNode(4);

        ListNode l3 = new ListNode(2);
        l3.next = new ListNode(6);

        ListNode[] l = new ListNode[3];


        l[0] = l1;
        l[1] = l2;
        l[2] = l3;

        Solution s = new Solution();

    }
}