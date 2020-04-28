package leetcode.NO264;

public class Solution {
    public static int nthUglyNumber(int n) {
        int[] res = new int[n];
        res[0] = 1;
        int p2 = 0;
        int p3 = 0;
        int p5 = 0;
        for (int i = 1; i < n; i++) {
            int min = Math.min(res[p2]*2, Math.min(res[p3]*3, res[p5]*5));
            if(min == res[p2]*2) p2++;
            if(min == res[p3]*3) p3++;
            if(min == res[p5]*5) p5++;
            res[i] = min;
        }

        return res[n - 1];
    }

    public static void main(String[] args) {
        System.out.println(Solution.nthUglyNumber(100));
    }
}
