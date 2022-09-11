import java.util.Arrays;

public class Remove_Duplicates_From_Sorted {

//    //Brutal Force, only faster than 5%, it runs in O(n^2)
//    public static int removeDuplicates(int [] nums) {
//
//
//        int finalLength = nums.length;
//        int prev = nums[0];
//        for (int i = 1; i < finalLength; i++) {
//            if (nums[i] == prev) {
//                for (int j = i + 1; j < nums.length; j++) {
//                    nums[j - 1] = nums[j];
//                }
//                finalLength--;
//                i--;
//            } else {
//                prev = nums[i];
//            }
//        }
//        return finalLength;
//    }


    public static int removeDuplicates(int [] nums) {

        // Think about the hidden Math relationship, faster than 100%
        int finalLength = nums.length;
        int countRemove = 0;
        int prev = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == prev) {
                nums[i-1-countRemove] = nums[i];
                countRemove++;
                finalLength--;
            } else {
                nums[i-countRemove] = nums[i];
                prev = nums[i];
            }
        }
        return finalLength;
    }

    public static void main(String[] args) {
        int [] array = new int[] {1,1,2,3,5,5,6,6,6,7};
        System.out.println(removeDuplicates(array));
        System.out.println(Arrays.toString(array));
    }
}
