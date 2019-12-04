package leetcode.NO239;

import java.util.ArrayDeque;
import java.util.Deque;

public class DecreasingQueue {
    private Deque<Integer> q;

    public DecreasingQueue() {
        q = new ArrayDeque<>();
    }

    public void push(int n){
        while(!q.isEmpty() && q.getLast() < n){
            q.removeLast();
        }
        q.addLast(n);
    }

    public int max(){
        return q.getFirst();
    }

    public void pop(int n){
        if(!q.isEmpty() && q.getFirst() == n){
            q.removeFirst();
        }
    }
}
