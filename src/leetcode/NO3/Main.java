package leetcode.NO3;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class Main {

    public static int findLongest(String s){
        int result = 0, n = s.length();
        HashMap map = new HashMap();
        for (int i = 0, j = 0; j < n; ) {
            char a = s.charAt(j);

            if(!map.containsKey(a)){

                map.put(a, j++);
                result = Math.max(result, j - i);

            }else{
                i = Math.max(((int)map.get(a) + 1), i);
                map.remove(a);
            }
        }

        return result;
    }


    public static int lengthOfLongestSubstring(String s) {
        int n = s.length();
        Set<Character> set = new HashSet<>();
        int ans = 0, i = 0, j = 0;
        while (i < n && j < n) {
            // try to extend the range [i, j]
            if (!set.contains(s.charAt(j))){
                set.add(s.charAt(j++));
                ans = Math.max(ans, j - i);
            }
            else {
                set.remove(s.charAt(i++));
            }
        }
        return ans;
    }


    public static void main(String[] args) {
        int n = Main.findLongest("tmmzuxt");
        int n1 = Main.lengthOfLongestSubstring("tmmzuxt");

        return;
    }
}
