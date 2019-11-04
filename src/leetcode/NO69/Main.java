package leetcode.NO69;

public class Main {
    public static int mySqrt(int x) {
        if(x < 0) return -1;
        if(x == 0) return 0;
        if(x < 4) return 1;

        int half = x >> 1;

        int low = 2;
        int high = half;

        int mid = 0;
        while(low <= high){
            mid = high - ((high - low) >> 1);

            long product = (long)mid * (long)mid; //一定要加强制类型转化，不然int*int还是受int32位的限制，最后并不是long

            if(product < x){
                low = mid + 1;
            }else if(product > x){
                high = mid - 1;
            }else{
                return mid;
            }
        }

        if(low > mid){
            return mid;
        }else{
            return high;
        }

    }

    public static void main(String[] args) {

        System.out.println(Main.mySqrt(2147395599));
    }

}
