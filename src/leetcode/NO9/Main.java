package leetcode.NO9;

public class Main {
    public static boolean isPalindrome(int x) {
        String s = String.valueOf(x);

        int slow = 0;
        int fast = 1;
        int n = s.length() - 1;

        while(fast < n){
            slow++;
            fast+=2;
        }

        int i = 0, j = n;

        while (i <= slow){
            if(s.charAt(i) == s.charAt(j)){
                i++;
                j--;
            }else{
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int t = 1;
        System.out.println(Main.isPalindrome(t));
    }
}
