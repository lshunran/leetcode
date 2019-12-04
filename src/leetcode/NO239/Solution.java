package leetcode.NO239;

import java.util.ArrayDeque;
import java.util.Deque;

public class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if(nums.length == 0 || k == 0) return new int[0];
        int[] res = new int[nums.length - k + 1];
        DecreasingQueue decreasingQueue = new DecreasingQueue();
        for (int i = 0; i < nums.length; i++) {
            if(i < k){
                decreasingQueue.push(nums[i]);
            }else{
                res[i - k] = decreasingQueue.max();
                decreasingQueue.pop(nums[i - k]);
                decreasingQueue.push(nums[i]);
            }
        }
        res[nums.length - k] = decreasingQueue.max();
        return res;

    }

    class DecreasingQueue {
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
}
