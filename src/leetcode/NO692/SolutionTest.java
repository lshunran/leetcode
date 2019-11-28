package leetcode.NO692;


import java.util.List;

class SolutionTest {

    public static void main(String[] args) {
        Solution s = new Solution();
        String[] a = { "i", "love","leetcode", "i", "love", "coding"};
        List<String> l = s.topKFrequent(a, 2);
        System.out.println(l);
    }
}