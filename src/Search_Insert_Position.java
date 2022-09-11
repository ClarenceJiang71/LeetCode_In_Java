public class Search_Insert_Position {

    public static int searchInsert(int [] nums, int target){
        int result = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > target || nums[i] == target){
                result = i;
                break;
            }
        }
        result = nums.length;
        return result;
    }

    public static void main(String[] args) {

    }
}
