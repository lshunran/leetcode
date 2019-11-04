package leetcode.NO33;

public class Main {
    public static int search(int[] nums, int target) {
        if(nums.length == 0) return -1;

        int low = 0;
        int high = nums.length - 1;

        while (low <= high){
            int mid = high - ((high - low) >> 1);

            if(nums[mid] == target) return mid;

            if(nums[low] <= nums[mid]){
                if(target >= nums[low] && target < nums[mid]){
                    high = mid - 1;
                }else{
                    low = mid + 1;
                }
            }else{
                if(target > nums[mid] && target <= nums[high]){
                    low = mid + 1;
                }else{
                    high = mid - 1;
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] nums = {4,5,6,7,0,1,2};
        System.out.println(Main.search(nums, 44));
    }
}
