import java.util.Arrays;
import java.util.HashSet;
import java.util.stream.Collectors;


public class Remove_Element {
    public static int removeElement(int[] nums, int val){

        // remove all occurrences of val in-place. The relative order may be changed

        /*
        *  Apply a similar method as remove duplicates from sorted array
        *
        * */
        int finalLength = nums.length;
        int countRemove = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == val) {
                countRemove++;
                finalLength--;
            } else {
                nums[i-countRemove] = nums[i];
            }
        }
        return finalLength;

    }

    public static void main(String[] args) {
        int [] array = new int[]{7,7, 5, 6, 3};
        System.out.println(removeElement(array, 7));
        System.out.println(Arrays.toString(array));
    }

}
