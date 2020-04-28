package leetcode.NO263;

public class Solution {
    public static boolean isUgly(int num) {
        if(num <= 0)return false;
        while (true){
            int temp = num;
            if(num % 2 == 0){
                num /= 2;
            }
            if(num % 3 == 0){
                num /= 3;
            }
            if(num % 5 == 0){
                num /= 5;
            }
            if(num == 1) return true;
            if(temp == num) return false;
        }
    }

    public static void main(String[] args) {
        int num = 0;

        System.out.println(Solution.isUgly(num));
    }
}
