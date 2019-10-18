package leetcode.NO4;

import java.util.HashMap;

public class Main {

    public static double findCenter(int[] nums1, int[] nums2){
        double result = 0;
        int i = 0, j = 0, k = 0;
        int[] arrays = new int[nums1.length + nums2.length];
        while (i < nums1.length && j < nums2.length) {

            //谁比较小，谁将元素放入大数组中,移动指针，继续比较下一个
            if (nums1[i] < nums2[j]) {
                arrays[k] = nums1[i];

                i++;
                k++;
            } else {
                arrays[k] = nums2[j];
                j++;
                k++;
            }
        }

        //如果左边的数组还没比较完，右边的数都已经完了，那么将左边的数抄到大数组中(剩下的都是大数字)
        while (i < nums1.length) {
            arrays[k] = nums1[i];

            i++;
            k++;
        }
        //如果右边的数组还没比较完，左边的数都已经完了，那么将右边的数抄到大数组中(剩下的都是大数字)
        while (j < nums2.length) {
            arrays[k] = nums2[j];

            k++;
            j++;
        }

        int ans = arrays.length;
        if(ans%2 == 0){
            int no1 = arrays[ans/2];
            int no2 = arrays[ans/2 - 1];
            result = (no1 + no2) / 2.0;
        }else{
            int no1 = ans/2;
            result = arrays[no1];
        }

        return result;
    }

    public static void main(String[] args) {
//        int[] a = new int[2];
//        int[] b = new int[2];
//
//        a[0] = 1;
//        a[1] = 2;
//        b[0] = 3;
//        b[1] = 4;
//        double n = leetcode.NO4.Main.findCenter(a, b);
        long x = System.currentTimeMillis();
        System.out.println(x);
        return;
    }
}
