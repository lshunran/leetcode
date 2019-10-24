package leetcode.NO215;

import java.util.HashMap;

public class Main {
    public static int findKthLargest(int[] nums, int k) {
        int m = nums.length - k + 1;

        return Main.quick(nums,0, nums.length - 1, m);

    }

    private static int quick(int[] nums, int p, int r, int k) {


        int q = partition(nums, p, r);
        if(q + 1 == k) return nums[k - 1];
        if(q + 1 < k) quick(nums, q + 1, r, k);
        if(q + 1 > k) quick(nums, p, q - 1, k);
        return nums[k - 1];
    }


    private static int partition(int[] nums, int p, int r) {
        int pivot = nums[r];
        int i = p;
        for (int j = p; j < r; j++) {
            if(nums[j] <= pivot){
                int tmp = nums[j];
                nums[j] = nums[i];
                nums[i] = tmp;
                i++;
            }
        }

        nums[r] = nums[i];
        nums[i] = pivot;
        return i;
    }

    public static void main(String[] args) {
        int[] nums = {3,2,3,1,2,4,5,5,6};
        System.out.println(Main.findKthLargest(nums, 4));
    }
}
