package leetcode.NO3;

import java.util.HashMap;

public class Main {

    public static int findLongest(String s){
        int result = 0;
        HashMap map = new HashMap();
        for (int i = 0; i < s.length(); i++) {
            char a = s.charAt(i);
            if(!map.containsKey(a)){
                map.put(a, i);
            }else{
                int length = map.size();
                if(length > result){
                    result = length;
                }
                map = new HashMap();
                map.put(a, i);

            }
        }
        int length = map.size();
        if(length > result){
            result = length;
        }
        return result;
    }

    public static void main(String[] args) {
        int n = Main.findLongest("dvdf");
        return;
    }
}
