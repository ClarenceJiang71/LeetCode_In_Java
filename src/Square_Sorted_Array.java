import java.util.Arrays;

public class Square_Sorted_Array {
    public static int[] sortedSquares(int[] nums) {
        int[] result = new int[nums.length];
        if (nums[0] >= 0){
            for (int i = 0; i<result.length; i++){
                result[i] = nums[i] * nums[i];
            }
        }
        else{
            for (int i=0; i<nums.length; i++){
                result[i] = nums[i] * nums[i];
            }
            Arrays.sort(result);
        }
        return result;
    }
}
