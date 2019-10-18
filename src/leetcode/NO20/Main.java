package leetcode.NO20;

public class Main {
    public static boolean isValid(String s) {
        if(s == null) return false;
        int n = s.length();
        String[] stack = new String[n];
        int count = 0;

        for (int i = 0; i < n; i++) {
            String c = String.valueOf(s.charAt(i));
            if(c.equals("(") || c.equals("{") || c.equals("[")){
                stack[count++] = c;
            }else{
                if(count == 0) return false;
                String pop = stack[--count];
                if(pop.equals("(") && c.equals(")")) continue;
                if(pop.equals("{") && c.equals("}")) continue;
                if(pop.equals("[") && c.equals("]")) continue;
                return false;
            }
        }

        if(count > 0) return false;

        return true;

    }

    public static void main(String[] args) {
        String tmp = "{()}";

        System.out.println(Main.isValid(tmp));
    }
}
