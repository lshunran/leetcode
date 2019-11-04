package leetcode.NO81;

public class Main {
    public static boolean search(int[] nums, int target) {
        if(nums.length == 0) return false;

        int low = 0;
        int high = nums.length - 1;

        while (low <= high){
            int mid = ((high + low) >> 1);

            if(nums[mid] == target) return true;

            if(nums[low] < nums[mid]){
                if(target >= nums[low] && target < nums[mid]){
                    high = mid - 1;
                }else{
                    low = mid + 1;
                }
            }else if(nums[low] > nums[mid]){
                if(target > nums[mid] && target <= nums[high]){
                    low = mid + 1;
                }else{
                    high = mid - 1;
                }
            }else if(nums[low] == nums[mid]){
                low++;

            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[] nums = {3,1};
        System.out.println(Main.search(nums, 1));
    }
}
