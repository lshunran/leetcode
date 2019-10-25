package leetcode.NO704;

public class Main {
    public static int search(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;
        while (low <= high){

            int mid = high - ((high - low) >> 1);

            if(nums[mid] == target){
                return mid;
            }else if(nums[mid] > target){
                high = mid - 1;
            }else{
                low = mid + 1;
            }
        }

        return -1;
    }

    public static void main(String[] args) {

    }
}
