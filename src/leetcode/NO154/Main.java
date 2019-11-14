package leetcode.NO154;

public class Main {
    public static int findMin(int[] nums) {
        if(nums.length == 0) return -1;
        if(nums.length == 1) return nums[0];

        int low = 0;
        int high = nums.length - 1;

        int mid = 0;
        while (low < high){
            mid = (low + high) >> 1;

            if(nums[low] < nums[mid]){
                if(nums[mid] <= nums[high]) return nums[low];
                if(mid == nums.length - 1) return nums[mid];
                if(nums[mid] > nums[mid + 1]) return nums[mid + 1];
                low = mid + 1;
            }else if(nums[low] >= nums[mid]){
                if(nums[mid] > nums[high]){
                    low = mid + 1;
                    continue;
                }
                if(nums[mid] == nums[high]) {
                    low++;
                    continue;
                }
                if(mid == 0 || nums[mid - 1] > nums[mid]) return nums[mid];
                high = mid - 1;
            }
        }
        return nums[mid];
    }

    public static void main(String[] args) {
        int[] nums = {3,1};
        System.out.println(findMin(nums));
    }
}
