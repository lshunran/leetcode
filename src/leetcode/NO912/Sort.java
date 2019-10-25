package leetcode.NO912;

public class Sort {
    public static int[] bubbling(int[] nums) {
        if(nums.length <= 1) return nums;
        for (int i = 0; i < nums.length ; i++) {

            boolean bubble_flag = false;

            for (int j = 0; j < nums.length - i - 1; j++) {
                if(nums[j] > nums[j+1]){
                    int tmp = nums[j];
                    nums[j] = nums[j+1];
                    nums[j+1] = tmp;
                    bubble_flag = true;
                }
            }

            if(!bubble_flag) return nums;

        }
        return nums;
    }

    public static int[] insert(int[] nums) {
        if(nums.length <= 1) return nums;
        for (int i = 1; i < nums.length; i++) {
            int value = nums[i];
            int j = i - 1; //记录最后位置
            for (; j >= 0; j--) {
                if(value < nums[j]){
                    nums[j+1] = nums[j];
                }else{
                    break;
                }
            }
            nums[j+1] = value; //j+1是为了抵消j--

        }
        return nums;
    }

    public static int[] select(int[] nums) {//归并排序
        Sort.select_sort(nums, 0, nums.length - 1);

        return nums;
    }

    private static void select_sort(int[] nums, int p, int r) {//归并排序
        if(p >= r) return;
        int q = (p + r) / 2;
        select_sort(nums, p, q);
        select_sort(nums, q + 1, r);

        merge(nums, p, q, r);
        return;
    }

    private static void merge(int[] nums, int p, int q, int r) {
        int i = p, j = q + 1, k = 0 ;
        int[] tmp = new int[r - p + 1];
        while (i <= q && j <= r){
            if(nums[i] <= nums[j]){
                tmp[k++] = nums[i++];
            }else {
                tmp[k++] = nums[j++];
            }
        }
        if(i > q){
            while (j <= r){
                tmp[k++] = nums[j++];
            }
        }else{
            while (i <= q){
                tmp[k++] = nums[i++];
            }
        }
        int t = 0;
        for(int s = p; s <= r; s++){
            nums[s] = tmp[t++];
        }

        return;
    }


    public static int[] quick(int[] nums) {
        Sort.quick_sort(nums, 0, nums.length - 1);

        return nums;
    }

    private static void quick_sort(int[] nums, int p, int r) {
        if(p >= r) return;
        int q = partition(nums, p, r);
        quick_sort(nums, p, q - 1);
        quick_sort(nums, q + 1, r);

        return;
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

    public static int[] couuntingSort(int[] nums) {
        int n = nums.length;
        int max = nums[0];
        for (int i = 0; i < n; i++) {
            if(nums[i] > max){
                max = nums[i];
            }
        }

        int[] c = new int[max + 1];
        for (int i = 0; i < max; i++) {
            c[i] = 0;
        }

        for (int i = 0; i < n; i++) {
            c[nums[i]]++;
        }

        for (int i = 1; i <= max; i++) {
            c[i] = c[i] + c[i-1];
        }

        int[] tmp = new int[n];
        for (int i = n - 1; i >= 0; i--) {
            tmp[--c[nums[i]]] = nums[i];
        }

        for (int i = 0; i < n; i++) {
            nums[i] = tmp[i];
        }
        return nums;
    }

    public static void main(String[] args) {
        int[] nums = {5,1,1,2,0,4,4,2,5};
        nums = Sort.couuntingSort(nums);
        for (int i = 0; i < nums.length; i++) {
            System.out.println(nums[i]);

        }
    }
}
