package leetcode.NO88;

public class Main {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int[] tmp = new int[m+n];
        int i = 0, j = 0, k = 0;
        while (i < m && j < n){
            if(nums1[i] <= nums2[j]){
                tmp[k++] = nums1[i++];
            }else{
                tmp[k++] = nums2[j++];
            }
        }

        if(i >= m){
            while (j < n){
                tmp[k++] = nums2[j++];
            }
        }
        if(j >= n){
            while (i < m){
                tmp[k++] = nums1[i++];
            }
        }
        for (int l = 0; l < tmp.length; l++) {
            nums1[l] = tmp[l];
        }
    }

    public static void main(String[] args) {

    }
}
