package leetcode.NO153;

public class Main {
    public static int findMin(int[] nums) {
        if(nums.length == 0) return -1;
        quick_sort(nums, 0, nums.length - 1);
        return nums[0];
    }

    private static void quick_sort(int[] nums, int p, int r){

        if(p >= r) return;

        int q = partition(nums, p, r);
        quick_sort(nums, p, q - 1);
        quick_sort(nums, q + 1, r);

    }

    private static int partition(int[] nums, int p, int r){
        int pivot = nums[r];
        int i = p;
        for (int j = p; j < r; j++) {
            if(nums[j] <= pivot){
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
                i++;
            }
        }

        nums[r] = nums[i];
        nums[i] = pivot;

        return i;

    }

    private static int findMin2(int[] nums){
        if(nums.length == 0) return -1;
        if(nums.length == 1) return nums[0];

        int low = 0;
        int high = nums.length - 1;

        int mid = 0;
        while (low <= high){
             mid = (low + high) >> 1;

            if(nums[low] <= nums[mid]){
                if(nums[mid] < nums[high]) return nums[low];
                if(nums[mid] > nums[mid + 1]) return nums[mid + 1];
                low = mid + 1;
            }else if(nums[low] > nums[mid]){
                if(mid == 0 || nums[mid - 1] > nums[mid]) return nums[mid];
                high = mid - 1;
            }
        }
        return nums[mid];

    }

    public static void main(String[] args) {
        int[] nums = {3,2,1};
        System.out.println(findMin2(nums));
    }
}
