package leetcode.NO599;

import java.util.ArrayList;
import java.util.HashMap;

public class Main {
    public static String[] findRestaurant(String[] list1, String[] list2) {
        if(list1.length == 0 || list2.length == 0) return new String[1];
        HashMap<String, Integer> m = new HashMap();
        HashMap<String, Integer> m1 = new HashMap();
        int min = 1 << 31 -1;
        int min_index = 0;
        for (int i = 0; i < list1.length; i++) {
            m.put(list1[i], i);
        }

        for (int i = 0; i < list2.length; i++) {
            if(m.containsKey(list2[i])){
                m1.put(list2[i], (int)m.get(list2[i]) + i);
                if((int)m1.get(list2[i]) < min) {
                    min = (int) m1.get(list2[i]);
                }
            }
        }
        ArrayList res = new ArrayList();
        for (String s: m1.keySet()) {
            if(m1.get(s) == min){
                res.add(s);
            }
        }
        return (String[])res.toArray(new String[0]);
    }

    public static void main(String[] args) {
        String[] a = {"Shogun","Tapioca Express","Burger King","KFC"};
        String[] b = {"KFC","Burger King","Tapioca Express","Shogun"};

        String[] res = Main.findRestaurant(a, b);

        for (int i = 0; i < res.length; i++) {
            System.out.println(res[i]);

        }

    }
}
