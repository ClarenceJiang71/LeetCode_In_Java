import java.util.Arrays;

public class Merge_Sorted_Array {
    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        // Deal with the case that nums1 is empty
        if (m == 0){
            for (int i = 0; i < nums1.length; i++) {
                nums1[i] = nums2[i];
            }
        }

        //  Deal with the normal case, going from backward 
        int pointer1 = m-1;
        int pointer2 = n-1;
        int pointerPut = nums1.length-1;

        while (pointer2 >= 0){
            if (pointer1 == -1){
                nums1[pointerPut] = nums2[pointer2];
                pointerPut--;
                pointer2--;
                continue;
            }

            if (nums1[pointer1] >= nums2[pointer2]) {
                nums1[pointerPut] = nums1[pointer1];
                pointer1--;
                pointerPut--;
            }
            // Only greater case leads to an insert
            else {
                nums1[pointerPut] = nums2[pointer2];
                pointer2--;
                pointerPut--;
            }
        }

    }

    public static void main(String[] args) {
        int [] nums1 = new int []{5,6,7,0,0,0};
        int [] nums2 = new int []{1,2,9};
        merge(nums1,3,nums2, 3);
        System.out.println(Arrays.toString(nums1));
    }
}
