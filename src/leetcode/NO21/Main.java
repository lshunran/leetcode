package leetcode.NO21;

public class Main {
    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(l1 == null) return l2;
        if(l2 == null) return l1;

        ListNode guard = new ListNode(-1);
        ListNode cur = guard;


        while (l1 != null && l2 != null){
            if(l1.val <= l2.val){
                while (l1 != null && l1.val <= l2.val){
                    cur.next = l1;
                    cur = cur.next;
                    l1 = l1.next;
                }
            }else{
                while (l2 != null && l1.val > l2.val){
                    cur.next = l2;
                    cur = cur.next;
                    l2 = l2.next;
                }
            }
        }

        if(l1 == null){
            cur.next = l2;
        }

        if(l2 == null){
            cur.next = l1;
        }

        return guard.next;

    }

    public static void main(String[] args) {

    }
}
