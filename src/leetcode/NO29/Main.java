package leetcode.NO29;

public class Main {
    public static int divide(int dividend, int divisor) {
        int MAX = (1 << 31) - 1;
        int MIN = -1 << 31;
        if(divisor == 0) return 0;
        if(divisor == 1) return dividend;
        if(divisor == -1 && dividend == MIN) return MAX;

        if(divisor == -1) return -dividend;



        Boolean minus = (dividend > 0) ^ (divisor > 0);
        int temp_dividend = dividend > 0? -dividend: dividend;
        int temp_divisor = divisor > 0? -divisor:divisor;
        long count = 0;
        int result = 0;
        while (temp_dividend <= temp_divisor){
            temp_dividend = temp_dividend - temp_divisor;
            count++;
        }
        if(minus){
            count = -count;
        }
        if(count < MIN || count > MAX){
            return MAX;
        }
        result = (int)count;
        return result;
    }

    public static void main(String[] args) {
        int MAX = (1 << 31) - 1;
        int MIN = -1 << 31;
        System.out.println(MAX);
        System.out.println(MIN);
        System.out.println(Main.divide(-2,-2));
    }
}
