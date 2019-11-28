package leetcode.NO692;

import leetcode.NO912.Sort;

import java.util.*;

public class Solution {

    public List<String> topKFrequent(String[] words, int k) {
        Map<String, Integer> frequency = new HashMap();
        //计算频数
        for (int i = 0; i < words.length; i++) {
            if(frequency.containsKey(words[i])){
                frequency.put(words[i], frequency.get(words[i]) + 1);
            }else{
                frequency.put(words[i], 1);
            }
        }

        PriorityQueue<String> q = new PriorityQueue<>(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if(frequency.get(o1) == frequency.get(o2)){
                    return o2.compareTo(o1);
                }
                return frequency.get(o1) - frequency.get(o2);
            }
        });


        for (String key: frequency.keySet()) {
            if(q.size() < k){
                q.add(key);
            }else{
                if(q.comparator().compare(key, q.peek()) > 0){
                    q.poll();
                    q.add(key);
                }
            }
        }

        String[] ss = new String[k];

        for (int i = k -1; i >=0; i--) {
            ss[i] = q.poll();
        }

        return Arrays.asList(ss);
    }


        public List<String> topKFrequent1(String[] words, int k) {
        Map<String, Integer> frequency = new HashMap();
        //计算频数
        for (int i = 0; i < words.length; i++) {
            if(frequency.containsKey(words[i])){
                frequency.put(words[i], frequency.get(words[i]) + 1);
            }else{
                frequency.put(words[i], 1);
            }
        }

        String[] a = new String[k+1];
        int count = 1;

        for (String key: frequency.keySet()) {
            if(count < k){
                a[count++] = key;
            }else if(count == k){
                a[count++] = key;
                buildMinTopHeap(a, k, frequency);
            }else{
                if(frequency.get(key) >= frequency.get(a[1])){
                    a[1] = key;
                    heapifyFromTop(a, k, 1, frequency);
                }
            }
        }
        List<String> list = new ArrayList<>();
        for (int i = 1; i <= k; i++) {
            list.add(a[i]);
        }

        Collections.sort(list, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return frequency.get(o2) - frequency.get(o1);
            }
        });

        return list;

    }

    private void buildMinTopHeap(String[] a, int count, Map frequency){
        for(int i = count/2; i > 0; i--){
            heapifyFromTop(a, count, i, frequency);
        }
    }

    private static void swap(String[] a, int p1, int p2){
        String temp = a[p1];
        a[p1] = a[p2];
        a[p2] = temp;
    }

    private void heapifyFromTop(String[] a, int count, int i, Map<String, Integer> frequency){
        int minPos = i;

        while(true){
            if(i*2 <= count && frequency.get(a[i*2]) < frequency.get(a[i])) minPos = i*2;
            if(i*2+1 <= count && frequency.get(a[i*2+1]) < frequency.get(a[minPos])) minPos = i*2+1;
            if(minPos == i) break;
            swap(a, minPos, i);
            i = minPos;
        }
    }

}
