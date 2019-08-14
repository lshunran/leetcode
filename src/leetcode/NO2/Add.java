package leetcode.NO2;

public class Add {
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        ListNode result = new ListNode(-1);
        ListNode temp = result;
        if(l1 == null){
            return l2;
        }
        if(l2 == null){
            return l1;
        }
        int count = 1;
        int self = 0;
        int parent = 0;
        while(l2 != null){
            if(l1 != null){
                self =  (int)((l2.val + l1.val + parent) % 10);

                parent = (int)((l2.val + l1.val + parent) / 10);

                ListNode node = new ListNode(self);
                if(temp.val == -1){
                    result = node;
                    temp = result;
                }else{
                    temp.next = node;
                    temp = temp.next;
                }
                l1 = l1.next;
            }else{
                self = (int)((l2.val + parent) % 10);
                parent = (int)((l2.val + parent) / 10);
                ListNode node = new ListNode(self);
                temp.next = node;
                temp = temp.next;
            }
            // count++;
            l2 = l2.next;
        }
        if(l1 != null){
            while(l1 != null){
                self = (int)((l1.val + parent) % 10);
                parent = (int)((l1.val + parent) / 10);
                ListNode node = new ListNode(self);
                temp.next = node;
                temp = temp.next;
                l1 = l1.next;
            }

        }
        if(parent > 0){
            ListNode node = new ListNode(parent);
            temp.next = node;
        }


        return result;

    }
}
