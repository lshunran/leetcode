package leetcode.NO26;

public class Main {
    public static int removeDuplicates(int[] nums) {
        if(nums.length <= 1) return nums.length;
        int j = 1, count = 1, flag = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if(nums[i] != flag){
                flag = nums[i];
                nums[j] = nums[i];
                j++;
                count++;
            }else{

            }
        }
        return count;
    }

    public static void main(String[] args) {
        int[] nums = {0,0,1,1,1,2,2,3,3,4};
        System.out.println(Main.removeDuplicates(nums));
        for (int i = 0; i < nums.length; i++) {
            System.out.println(nums[i]);
        }
    }
}
