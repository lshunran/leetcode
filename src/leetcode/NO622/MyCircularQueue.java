package leetcode.NO622;

class MyCircularQueue {

    private int[] items;
    private int n;
    private int head = 0;
    private int tail = 0;

    /** Initialize your data structure here. Set the size of the queue to be k. */
    public MyCircularQueue(int k) {
        this.items = new int[k + 1];//注意
        this.n = k + 1;//注意
    }

    /** Insert an element into the circular queue. Return true if the operation is successful. */
    public boolean enQueue(int value) {
        int next = (this.tail + 1) % this.n;
        if(next == this.head) return false; //队列满
        this.items[this.tail] = value;
        this.tail = next;
        return true;
    }

    /** Delete an element from the circular queue. Return true if the operation is successful. */
    public boolean deQueue() {//注意从头出队列
        if(this.tail == this.head) return false;//队列为空

        this.head = (this.head + 1) % this.n;
        return true;
    }

    /** Get the front item from the queue. */
    public int Front() {
        if(this.tail == this.head) return -1;//队列为空
        return this.items[this.head];
    }

    /** Get the last item from the queue. */
    public int Rear() {
        if(this.tail == this.head) return -1;//队列为空
        return this.items[(this.tail + this.n - 1) % this.n]; //注意

    }

    /** Checks whether the circular queue is empty or not. */
    public boolean isEmpty() {
        if(this.tail == this.head) return true;//队列为空
        return false;
    }

    /** Checks whether the circular queue is full or not. */
    public boolean isFull() {
        int next = (this.tail + 1) % this.n;
        if(next == head) return true; //队列满
        return false;
    }

    public void printQ(){
        for (int i = 0; i < this.n; i++) {
            System.out.println(this.items[i]);
        }
        System.out.println("head:");
        System.out.println(this.head);
        System.out.println("tail:");
        System.out.println(this.tail);
    }
}