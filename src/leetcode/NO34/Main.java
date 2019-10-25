package leetcode.NO34;

public class Main {
    public static int[] searchRange(int[] nums, int target) {

        int[] res = new int[2];

        res[0] = findFirstAppear(nums, target);
        res[1] = findLastAppear(nums, target);


        return res;

    }

    private static int findFirstAppear(int[] nums, int target){
        int low = 0;
        int high = nums.length - 1;
        while (low <= high){
            int mid = high - ((high - low) >> 1);

            if(nums[mid] == target){
                if(mid == 0 || nums[mid - 1] != target) return mid;
                high = mid - 1;
            }else if(nums[mid] > target){
                high = mid - 1;
            }else{
                low = mid + 1;
            }
        }
        return -1;
    }

    private static int findLastAppear(int[] nums, int target){
        int low = 0;
        int high = nums.length - 1;
        while (low <= high){
            int mid = high - ((high - low) >> 1);

            if(nums[mid] == target){
                if (mid == nums.length - 1 || nums[mid + 1] != target) return mid;
                low = mid + 1;
            }else if(nums[mid] > target){
                high = mid - 1;
            }else {
                low = mid + 1;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        int[] test = {5,7,7,8,8,10};
        int[] res = Main.searchRange(test, 7);

        for (int i = 0; i < res.length; i++) {
            System.out.println(res[i]);
        }
    }
}
