package leetcode.NO23;

public class Solution {

    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }


    public ListNode mergeKLists(ListNode[] lists) {
        int count = 0;

        for (int i = 0; i < lists.length; i++) {
            if(lists[i] != null){
                lists[count++] = lists[i];
            }
        }

        if(count == 0) return null;


        buildHeap(lists, count);

        ListNode head = lists[0];
        ListNode temp = head;

        while (count > 0){
            if(lists[0].next != null){
                lists[0] = lists[0].next;
                heapify(lists, count, 0);
            }else{
                if(count == 1) break;
                lists[0] = lists[count - 1];
                count--;
                heapify(lists, count, 0);
            }
            temp.next = lists[0];
            temp = temp.next;
        }

        return head;


    }

    private void buildHeap(ListNode[] a, int count){
        for (int i = (count - 2)/2; i >= 0 ; i--) {
            heapify(a, count, i);
        }
    }

    private void heapify(ListNode[] a, int count, int i){
        int minPos = i;
        while(true){
            if(i*2+1 <= count - 1 && a[i*2+1].val < a[i].val) minPos = i*2+1;
            if(i*2+2 <= count - 1 && a[i*2+2].val < a[minPos].val) minPos = i*2+2;

            if(minPos == i) break;
            swap(a, i, minPos);
            i = minPos;
        }

    }

    private void swap(ListNode[] a, int p1, int p2){
        ListNode temp = a[p1];
        a[p1] = a[p2];
        a[p2] = temp;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(4);
        l1.next.next = new ListNode(5);

        ListNode l2 = new ListNode(1);
        l2.next = new ListNode(3);
        l2.next.next = new ListNode(4);

        ListNode l3 = new ListNode(2);
        l3.next = new ListNode(6);

        ListNode[] l = new ListNode[3];
        ListNode[] ll = new ListNode[4];



        l[0] = l1;
        l[1] = null;
        l[2] = l3;
        ll[0] = null;
        ll[1] = null;
        ll[2] = null;
        ll[3] = l3;


        Solution s = new Solution();
        ListNode head = s.mergeKLists(ll);
        System.out.println(head);
    }
}
