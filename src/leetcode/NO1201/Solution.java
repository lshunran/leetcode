package leetcode.NO1201;

public class Solution {
    public static int nthUglyNumber(int n, int a, int b, int c) {
        int[] res = new int[n + 1];
        res[0] = 1;
        int pa = 0;
        int pb = 0;
        int pc = 0;

        for (int i = 1; i <= n ; i++) {
            int min = Math.min(res[pa]*a, Math.min(res[pb]*b, res[pc]*c));

            if(min == res[pa]*a) pa++;
            if(min == res[pb]*b) pb++;
            if(min == res[pc]*c) pc++;
            res[i] = min;
        }

        return res[n];
    }

    public static void main(String[] args) {
        System.out.println(Solution.nthUglyNumber(5,2,11,13));
    }
}
