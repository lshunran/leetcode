package leetcode.NO622;

public class Main {
    public static void main(String[] args) {
        MyCircularQueue obj = new MyCircularQueue(3);
        boolean param_1 = obj.enQueue(1);
        boolean param_12 = obj.enQueue(2);
        boolean param_13 = obj.enQueue(3);
        boolean param_14 = obj.enQueue(4);



        int param_3 = obj.Front();
        int param_4 = obj.Rear();
        boolean param_6 = obj.isFull();


        boolean param_7 = obj.deQueue();
        boolean param_8 = obj.enQueue(4);
        int param_9 = obj.Rear();

        System.out.println(param_1);
        System.out.println(param_12);
        System.out.println(param_13);
        System.out.println(param_14);
        System.out.println(param_3);
        System.out.println(param_4);
        System.out.println(param_6);
        System.out.println(param_7);
        System.out.println(param_8);
        System.out.println(param_9);
        System.out.println("-------------------------");
        obj.printQ();

    }
}
