package leetcode.NO15;

import java.util.*;

public class Solution {
    public static List<List<Integer>> threeSum(int[] nums) {
        
        if(nums.length < 3) return new ArrayList<>();
        
        Arrays.sort(nums);

        List<List<Integer>> results = new ArrayList<>();

        for (int k = 0; k < nums.length - 2; k++) {
            int i = k + 1, j = nums.length - 1;

            if(nums[k] > 0) break;

            if(k > 0 && nums[k] == nums[k - 1]) continue;;

            while(i < j) {

                if (nums[i] + nums[j] + nums[k] == 0) {
                    List<Integer> result = new ArrayList<>(Arrays.asList(nums[i], nums[j], nums[k]));
                    result.sort(new Comparator<Integer>() {
                        @Override
                        public int compare(Integer o1, Integer o2) {
                            return o1 - o2;
                        }
                    });
                    results.add(result);
                    do{i++;}while ((nums[i] == nums[i - 1]) && i < j);
                    do{j--;}while ((nums[j] == nums[j + 1]) && i < j);
                }

                if (nums[i] + nums[j] + nums[k] > 0) {
                    j--;
                }

                if (nums[i] + nums[j] + nums[k] < 0) {
                    i++;
                }
            }
        }

        return results;

    }

    public static void main(String[] args) {
        Solution.threeSum(new int[]{0,0,0});
    }
}
