package leetcode.NO7;

public class Main {
    public static int reverse(int x) {
        int MAX = (1 << 31) - 1;
        int MIN = -1 << 31;

        long y = 0;

        Boolean pos = true;

        if(x/10 == 0) return x;
        if(x > MAX || x < MIN) return 0;
        if(x < 0){
            pos = false;
            x = Math.abs(x);
        }

        while (x > 0){
            y *= 10;

            if(y > MAX || y < MIN) return 0;

            y += x % 10;

            x /= 10;
        }

        if(!pos){
            y = -y;
        }
        return (int)y;

    }

    public static void main(String[] args) {
        System.out.println(Main.reverse(1534236129));
    }
}
