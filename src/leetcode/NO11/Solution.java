package leetcode.NO11;

public class Solution {
    public int maxArea(int[] height) {
        int max = (height.length - 1) * Math.min(height[0], height[height.length - 1]);

        for (int i = 0, j = height.length - 1; i < j; ) {
            if(height[i] < height[j]){
                i++;
            }else{
                j--;
            }
            max = Math.max(max, (j - i) * Math.min(height[i], height[j]));
        }

        return max;
    }
}
