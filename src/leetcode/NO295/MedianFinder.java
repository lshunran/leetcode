package leetcode.NO295;

import java.util.ArrayList;
import java.util.List;

public class MedianFinder {
    private int[] max;
    private int[] min;
    private int count;
    private int maxCount;
    private int minCount;


    /** initialize your data structure here. */
    public MedianFinder() {
        max = new int[9999];
        min = new int[9999];
        count = 0;
        maxCount = 0;
        minCount = 0;
    }

    public void addNum(int num) {
        if(count == 0){
            max[1] = num;
            count++;
            maxCount++;
            return;
        }

        if(num <= max[1]){
            max[++maxCount] = num;
            count++;
            maxHeapify();
        }else{
            min[++minCount] = num;
            count++;
            minHeapify();
        }

        balance();
    }

    public double findMedian() {
        if(count % 2 == 0){
            double m = ((double) max[1] + (double)min[1])/2;
            return m;
        }else{
            return max[1];
        }
    }

    private void balance(){
        if(maxCount - minCount > 1){
            int temp = max[1];
            max[1] = max[maxCount];
            maxCount--;
            maxHeapifyFromTop(1);
            min[++minCount] = temp;
            minHeapify();
        }else if(minCount - maxCount > 0){
            int temp = min[1];
            min[1] = min[minCount];
            minCount--;
            minHeapifyFromTop(1);
            max[++maxCount] = temp;
            maxHeapify();
        }
    }

    private static void swap(int[] a, int p1, int p2){
        int temp = a[p1];
        a[p1] = a[p2];
        a[p2] = temp;
    }

    /**
     * 大顶堆堆化
     */
    private void maxHeapify(){
        int i = maxCount;
        while (i/2 > 0){
            if(max[i] > max[i/2]){
                swap(max, i, i/2);
                i = i/2;
            }else{
                break;
            }
        }
    }

    /**
     * 小顶堆堆化
     */
    private void minHeapify(){
        int i = minCount;
        while (i/2 > 0){
            if(min[i] < min[i/2]){
                swap(min, i, i/2);
                i = i/2;
            }else{
                break;
            }
        }
    }

    private void maxHeapifyFromTop(int i) { // 自上往下堆化
        while (true) {
            int maxPos = i;
            if (i*2 <= maxCount && max[i] < max[i*2]) maxPos = i*2;
            if (i*2+1 <= maxCount && max[maxPos] < max[i*2+1]) maxPos = i*2+1;
            if (maxPos == i) break;
            swap(max, i, maxPos);
            i = maxPos;
        }
    }

    private void minHeapifyFromTop(int i) { // 自上往下堆化
        while (true) {
            int minPos = i;
            if (i*2 <= maxCount && min[i] > min[i*2]) minPos = i*2;
            if (i*2+1 <= maxCount && min[minPos] > min[i*2+1]) minPos = i*2+1;
            if (minPos == i) break;
            swap(min, i, minPos);
            i = minPos;
        }
    }
    public void print(){

    }
}
