package leetcode.NO313;

public class Solution {
    public static int nthSuperUglyNumber(int n, int[] primes) {
        int[] res = new int[n];
        int[] p = new int[primes.length];

        res[0] = 1;

        for (int i = 1; i < n; i++) {
            int min = res[p[0]]*primes[0];
            for (int j = 1; j < primes.length; j++) {
                min = Math.min(min, res[p[j]]*primes[j]);
            }
            for (int j = 0; j < primes.length; j++) {
                if(min == res[p[j]]*primes[j]) p[j]++;
            }
            res[i] = min;
        }

        return res[n - 1];

    }

    public static void main(String[] args) {
        System.out.println(Solution.nthSuperUglyNumber(12, new int[]{2,7,13,19}));
    }
}
