package leetcode.NO35;

public class Main {
    public static int searchInsert(int[] nums, int target) {
        int n = nums.length;

        if(n == 0) return 0;

        int low = 0;
        int high = n - 1;

        int mid = 0;
        while(low <= high){
             mid = high - ((high - low) >> 1);

            if(nums[mid] < target){
                low = mid + 1;
            }else if(nums[mid] > target){
                high = mid - 1;
            }else{
                return mid;
            }
        }

        if(low > mid){
            return low;
        }else {
            return mid;
        }

    }

    public static void main(String[] args) {
        int[] nums = {1,3,4,6};

        int target = 5;
        System.out.println(Main.searchInsert(nums, target));
    }
}
