package leetcode.NO347;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Main {
    private static void heapify(HashMap<Integer, Integer> m, int[] a, int count, int i){
        int pos = i;

        while(true){
            if(i * 2 <= count && m.get(a[i]) >= m.get(a[i*2])) pos = i*2;

            if(i * 2 + 1 <= count && m.get(a[pos]) >= m.get(a[i*2+1])) pos = i*2+1;

            if(pos == i) break;

            swap(a, pos, i);

            i = pos;

        }
    }

    public static void heapSort(HashMap<Integer, Integer> m, int[] a, int count){
        buildMinTopHeap(m, a, count);
        while(count > 1){
            swap(a,1, count);
            count--;
            heapify(m, a, count, 1);
        }
    }

    public static void buildMinTopHeap(HashMap<Integer, Integer> m, int[] a, int count){
        for (int i = count/2; i >= 1 ; --i) {
            heapify(m, a, count, i);
        }
    }


    private static void swap(int[] a, int p1, int p2){
        int temp = a[p1];
        a[p1] = a[p2];
        a[p2] = temp;
    }

    public static List<Integer> topKFrequent(int[] nums, int k) {


        HashMap<Integer, Integer> m = new HashMap();
        for (int i = 0; i < nums.length; i++) {
            if(m.containsKey(nums[i])){
                m.put(nums[i], m.get(nums[i]) + 1);
            }else{
                m.put(nums[i], 1);
            }
        }

        k = Math.min(m.keySet().size(), k);
        int[] a = new int[k+1];
        int count = 1;

        for (Integer i : m.keySet()) {
            if(count < k){
                a[count] = i;
                count++;
            }else if(count == k){
                a[count] = i;
                count++;
                buildMinTopHeap(m, a, k);
            }else{
                if(m.get(i) >= m.get(a[1])){
                    a[1] = i;
                    heapify(m, a, k,1);
                }
            }
        }

        heapSort(m, a, k);

        List<Integer> result = new ArrayList<>();

        for (int i = 1; i < a.length; i++) {
            result.add(a[i]);
        }

        return result;


    }

    public static void main(String[] args) {
        int[] nums = {6,0,1,4,9,7,-3,1,-4,-8,4,-7,-3,3,2,-3,9,5,-4,0};
        List<Integer> res = Main.topKFrequent(nums, 6);

        for (int i = 0; i < res.size(); i++) {
            System.out.println(res.get(i));
        }
    }
}
