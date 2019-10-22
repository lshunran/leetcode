package leetcode.NO258;

public class Main {
    public static void main(String[] args) {
        System.out.println(Main.addDigits2(129));
    }

    public static int addDigits(int num) {
        String s = String.valueOf(num);
        int sum = 0;
        for (int i = 0; i < s.length(); i++) {
            sum += Integer.parseInt(String.valueOf(s.charAt(i)));
        }
        if(sum < 10) return sum;
        return addDigits(sum);

    }

    public static int addDigits2(int num) {
        if(num < 10) return num;
        int sum = num % 9;
        if(sum == 0){
            return 9;
        }else{
            return sum;
        }

    }
}
