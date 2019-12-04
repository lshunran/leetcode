package leetcode.NO239;


class SolutionTest {

    public static void main(String[] args) {
        int[] nums = {1,3,-1,-3,5,3,6,7};
        Solution s = new Solution();
        int[] res = s.maxSlidingWindow(nums, 3);
        System.out.println(res);
    }
}